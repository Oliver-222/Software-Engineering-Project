import factorapi.GetFactorRequest;
import factorapi.ReadResponse;
import factorapi.WriteResponse;
import factorapi.DataStorage;
import factorapi.ReadRequest;
import org.mockito.Mockito;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.fail;

public class TestDataStorage {

	
	@Test
	public void testDataStorage(DataStorage ds) throws FileNotFoundException {
		
		GetFactorRequest factorRequest = Mockito.mock(GetFactorRequest.class);
		
		//Will send the DataStorage a read request with the required information. Will receive a response with the input data. 
		ReadResponse readResponse = ds.read(new ReadRequest(factorRequest));
		
		//Will send a write request with the factor result and the destination. Will receive some kind of confirmation. 
		//WriteResponse writeResponse = ds.write(new WriteRequest(loginRequest));
		
		//Above was from prototype, instead will use WriteResponse mock
		WriteResponse mockWrite = Mockito.mock(WriteResponse.class);
		
		//If the data field is empty, the reading must have failed. 
		if(readResponse.data.isEmpty()) {
			fail();
		}
		
		if(!mockWrite.getStatus().equals(WriteResponse.WriteResponseStatus.SUCCESS)) {
			fail();
		}
		
	}
	
	
	
}
