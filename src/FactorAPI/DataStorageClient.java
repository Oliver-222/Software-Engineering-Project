package factorapi; 

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import datastore.DataStorageGrpc;
import datastore.DataStorageGrpc.DataStorageBlockingStub;
import datastore.DatastoreService;
import io.grpc.Channel;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;

public class DataStorageClient implements DataStorage { // Boilerplate TODO: change to <servicename>Client
    private final DataStorageBlockingStub blockingStub; // Boilerplate TODO: update to appropriate blocking stub

    public DataStorageClient(Channel channel) {
        blockingStub = DataStorageGrpc.newBlockingStub(channel);  // Boilerplate TODO: update to appropriate blocking stub
    }

    // Boilerplate TODO: replace this method with actual client call/response logic
	@Override
	public ReadResponse read(ReadRequest readRequest) throws FileNotFoundException {
		// TODO Auto-generated method stub
//		DataStoreImpl ds = new DataStoreImpl();
//		DataReadResponse dataReadResponse = (DataReadResponse) ds.read(readRequest);
//		
//		DatastoreService.ReadResponse readResponse = DatastoreService.ReadResponse.newBuilder().addAllData(dataReadResponse.data).build();
//		return readResponse; 
		DatastoreService.ReadRequest serviceRequest = DatastoreService.ReadRequest.newBuilder().setSource(readRequest.source).build();
		DatastoreService.ReadResponse readResponse;
		readResponse = blockingStub.read(serviceRequest);
		DataReadResponse dataReadResponse = new DataReadResponse(readResponse.getDataList());
		return dataReadResponse; 
		
	}

	@Override
	public WriteResponse write(WriteRequest writeRequest) throws IOException {
		// TODO Auto-generated method stub
		
		DatastoreService.WriteRequest serviceRequest = DatastoreService.WriteRequest.newBuilder().setDestination(writeRequest.destination).build();
		DatastoreService.WriteResponse writeResponse;
		writeResponse = blockingStub.write(serviceRequest);
		WriteResponse returnResponse = new WriteResponse();
		return returnResponse; 
	}

    public static void main(String[] args) throws Exception {
        String target = "localhost:50056";  // Boilerplate TODO: make sure the server/port match the server/port you want to connect to

        ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create())
                .build();
        try {
            DataStorageClient client = new DataStorageClient(channel); // Boilerplate TODO: update to this class name
            //client.order();
        } finally {
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        }
    }


}
