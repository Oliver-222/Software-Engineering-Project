package factorapi;

public class WriteRequest {

	//Will contain the result from the compute engine and the desired output location 

	String destination; 
	List<Integer> writeData; 

	//Will have to be passed the List of data to write to the desired file.
	//This will be the result of the factor, probably sent by compute engine.
	public WriteRequest(GetFactorRequest factorRequest, List<Integer> writeData) {
		this.destination = factorRequest.getDestination();
		this.writeData = writeData; 
	}
	
	
}
