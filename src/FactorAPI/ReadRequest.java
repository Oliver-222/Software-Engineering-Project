package factorapi;

public class ReadRequest {
	
	//Will contain the necessary information for the data storage to find the desired input data
	//String for now, but later can change to loginRequest, since this will contain the necessary information
	String source;
	
	public ReadRequest(GetFactorRequest factorRequest) {
		this.source = factorRequest.getSource();
	}
	
}
