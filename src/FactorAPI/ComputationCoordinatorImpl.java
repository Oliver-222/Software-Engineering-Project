package factorapi;

import coordinator.ComputationCoordinatorGrpc;
import service.CoordinatorService;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ComputationCoordinatorImpl extends ComputationCoordinatorGrpc.ComputationCoordinatorImplBase {
    private final DataStorageImpl ds;
    private final ComputeEngine ce;
    int nthreads = 4;

    public ComputationCoordinatorImpl(DataStorageImpl ds, ComputeEngine ce) {
        this.ds = ds;
        this.ce = ce;
    }
    @Override
    public void compute(CoordinatorService.ComputeRequest request, io.grpc.stub.StreamObserver<CoordinatorService.ComputeResult> responseObserver) {
       //TODO actual compute implementation
        if (request == null || (request.getFactorsList() == null && request.getSource() == null) ||request.getDelimiter() == null || request.getDestination() == null) {
            CoordinatorService.ComputeResult result = CoordinatorService.ComputeResult.newBuilder().setStatus(CoordinatorService.ComputeResultStatus.INVALID_REQUEST).setMessage("Provide Request").build();
            //result = new ComputeResult(ComputeResult.ComputeResultStatus.INVALID_REQUEST, "Provided request: " + request);
        }
        CoordinatorService.ComputeResult result;
        CoordinatorService.ComputeRequest.Builder computeRequestBuilder = CoordinatorService.ComputeRequest.newBuilder();
        try {
            List<Integer> integers = (request.getFactorsList() != null && ! request.getFactorsList().isEmpty()) ? request.getFactorsList() : ds.read(new ReadRequest(request.getSource())).getData();
            for(int i = 0; i<integers.size(); i++){
                computeRequestBuilder.setFactors(i,integers.get(i));
            }
            final CoordinatorService.ComputeRequest computeRequest = computeRequestBuilder.setDelimiter(request.getDelimiter()).setSource(request.getSource()).setDestination(request.getDestination()).build();
            Callable<Void> user = () -> {
                String factors = ce.executeJob(computeRequest);
                ds.write(new WriteRequest(computeRequest, factors));
                return null;
            };
            ExecutorService threadPool = Executors.newFixedThreadPool(nthreads);
            for(int i = 0; i < nthreads; i++){
                threadPool.submit(user);
            }
           result = CoordinatorService.ComputeResult.newBuilder().setStatus(CoordinatorService.ComputeResultStatus.SUCCESS).setMessage("Success!").build();
            //result = new ComputeResult(ComputeResult.ComputeResultStatus.SUCCESS, "Success!");
        } catch (Exception e) {
           result = CoordinatorService.ComputeResult.newBuilder().setStatus(CoordinatorService.ComputeResultStatus.FAILURE).setMessage("Unexpected Failure " + e.toString()).build();
            //result = new ComputeResult(ComputeResult.ComputeResultStatus.FAILURE, "Unexpected failure: " + e.getMessage());
        }
        responseObserver.onNext(result);
        responseObserver.onCompleted();
    }
}
