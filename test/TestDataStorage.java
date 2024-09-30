import factorapi.GetFactorRequest;
import factorapi.ReadResponse;
import factorapi.WriteResponse; 
import factorapi.DataStorage; 
import org.mockito.Mockito;
import org.junit.api.Assertions.fail;
import org.mockito.Mockito.when;
import org.junit.jupiter.api.Test; 
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDataStorage {

	
	@Test
	public void testDataStorage(DataStorage ds) {
		
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
		
		if(!mockWrite.getWriteStatus() ) {
			fail();
		}
		
	}
	
	
	
}
