package factorapi;

public class DataStoragePrototype {

	public void prototype(DataStorage ds) {
		
		LoginRequest loginRequest = new LoginRequest(null,null,null,null,null,null);
		
		//Will send the DataStorage a read request with the required information. Will receive a response with the input data. 
		ReadResponse readResponse = ds.read(new ReadRequest(loginRequest));
		
		//Will send a write request with the factor result and the destination. Will receive some kind of confirmation. 
		WriteResponse writeResponse = ds.write(new WriteRequest(loginRequest));
		
	}
	
}
