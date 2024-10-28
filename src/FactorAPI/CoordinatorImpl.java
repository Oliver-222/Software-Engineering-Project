package factorapi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors; 
import java.util.concurrent.Callable; 

public class CoordinatorImpl implements ComputationCoordinator {

    private final DataStorage ds;
    private final ComputeEngine ce;
    int nthreads = 4; 

    public CoordinatorImpl(DataStorage ds, ComputeEngine ce) {
        this.ds = ds;
        this.ce = ce;
    }

    @Override
    public ComputeResult compute(ComputeRequest request) {
        if (request == null || (request.getFactors() == null && request.getSource() == null) ||request.getDelimiter() == null || request.getDestination() == null) {
            return new ComputeResult(ComputeResult.ComputeResultStatus.INVALID_REQUEST, "Provided request: " + request);
        }
        try {
            // Sentinal value note: one of the drawbacks of a sentinal value is that the caller might
            // forget to check the value. In this particular case, we're doing something that walks
            // the line between 'clever' and 'gross hack' - if the result of ds.read is null (sentinal value),
            // we'll immediately generate a NullPointerException in the for loop, then catch that and return 'failure'
            List<Integer> integers = request.getFactors() != null ? request.getFactors() : ds.read(new ReadRequest(request)).getData();
            ComputeRequest computeRequest = new ComputeRequest((ArrayList<Integer>) integers, request.getDelimiter(), request.source, request.destination);

            Callable<ComputeResult> user = () -> {
                String factors = ce.executeJob(request);
                ds.write(new WriteRequest(request, factors));
                return new ComputeResult(ComputeResult.ComputeResultStatus.SUCCESS, "Success!");
            };
            ExecutorService threadPool = Executors.newFixedThreadPool(nthreads);
            for(int i = 0; i < nthreads; i++){
                threadPool.submit(user); 
            }

        } catch (Exception e) {
            return new ComputeResult(ComputeResult.ComputeResultStatus.FAILURE, "Unexpected failure: " + e.getMessage());
        }
    }

}
