package factorapi;

public class WriteRequest {

	//Will contain the result from the compute engine and the desired output location 

	String destination; 
	
	public WriteRequest(LoginRequest loginRequest) {
		this.destination = loginRequest.destination;
	}
	
	
}
