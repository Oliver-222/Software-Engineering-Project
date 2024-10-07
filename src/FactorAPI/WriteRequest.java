package factorapi;

import java.util.ArrayList;
import java.util.List;

public class WriteRequest {

	//Will contain the result from the compute engine and the desired output location 

	String destination; 
	String writeData; 

	//Will have to be passed the List of data to write to the desired file.
	//This will be the result of the factor, probably sent by compute engine.
	public WriteRequest(GetFactorRequest factorRequest){
		this.destination = factorRequest.getDestination();
		this.writeData = "";
	}
	
	public WriteRequest(GetFactorRequest factorRequest, String writeData) {
		this.destination = factorRequest.getDestination();
		this.writeData = writeData; 
	}
	
	
}
