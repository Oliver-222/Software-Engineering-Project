package factorapi;

import java.io.FileNotFoundException;
import java.io.IOException;


public class FactorAPI {
    public GetFactorResponse processRequest(GetFactorRequest factorRequest) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
	    	//I think this is all that's necessary since GetFactorRequest has validation for each of its parameters.
	    	if(factorRequest == null){
			throw new IllegalArgumentException("Cannot have null factor request.");
		}
			DataStoreImpl dataStore = new DataStoreImpl();
			ComputeRequest computeRequest = new ComputeRequest(factorRequest);
			ComputeEngineImpl computeEngine = new ComputeEngineImpl();
			CoordinatorImpl coordinator = new CoordinatorImpl(dataStore, computeEngine);
			ComputeResult result = coordinator.compute(computeRequest);
			if(!result.isSuccess()){
				return new GetFactorResponseImpl(GetFactorResponse.GetFactorStatus.FAILURE);
			}
			return new GetFactorResponseImpl(GetFactorResponse.GetFactorStatus.SUCCESS);
	}
}
