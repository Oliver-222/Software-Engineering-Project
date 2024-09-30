import factorapi.ReadResponse;
import factorapi.ReadRequest;
import factorapi.WriteRequest;
import factorapi.WriteResponse;

import java.util.List;

public class StorageMemoryTest{
	public InputTest input;
	public OutputTest output;
	

	//Constructor will initialize its input/output, and set the input List
	public StorageMemoryTest(List<Integer> input){
		input = (List<Integer>) new InputTest(input);
		// this.input.setData(input); 
		output = new OutputTest();
	}
	
	//returns the response which contains the data in a List
	//readRequest doens't need any information in this case, since we're reading from test classes
	public ReadResponse read(ReadRequest readRequest) {
		//TODO Auto-generated method stub
		return input;
	}
	
	
	//Returns the response which contains the output data 
	//writeRequest will contain a List<String>
	public WriteResponse write(WriteRequest writeRequest) {
		//TODO Auto-generated method stub
		return (WriteResponse) output;
	}

	public WriteResponse write(List<String> result){
		output.setData(result);
		return (WriteResponse) output;
	}

}
