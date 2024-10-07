package factorapi;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class FactorAPI {
    public GetFactorResponse processRequest(GetFactorRequest factorRequest) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
		//Holds the source information
		ReadRequest readRequest = new ReadRequest(factorRequest);
		
		//Make a DataStorage object to read the desired input data
		DataStorage ds = new DataStoreImpl();
		DataReadResponse readResponse = (DataReadResponse) ds.read(readRequest);
		
		//Necessary objects before the computation
		ComputeRequest computeRequest = new ComputeRequest((ArrayList<Integer>) readResponse.getData(), factorRequest.getSource(), factorRequest.getDestination());
		ComputeEngine computeEngine = new ComputeEngineImpl(computeRequest);
		
		//Make the engine find the result of our input
		String data = computeEngine.executeJob(computeRequest);
		
		//Object the DataStore can use
		WriteRequest writeRequest = new WriteRequest(factorRequest, data);
		//Make the DataStore write the result to the desired destination 
		WriteResponse writeResponse = ds.write(writeRequest);
		
		//Tell the user that it wrote successfully 
		return new GetFactorResponseImpl(GetFactorResponse.GetFactorStatus.SUCCESS);
		
	}
}
