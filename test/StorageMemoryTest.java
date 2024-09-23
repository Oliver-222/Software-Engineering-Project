

public class StorageMemoryTest implements DataStorage {

	public InputTest input;
	public OutputTest output; 
	

	public StorageMemoryTest(List<Integers> input){
		this.input.setData(input);
	}
	
	//returns the response which contains the data in a List
	//readRequest doens't need any information in this case, since we're reading from test classes 
	@Override
	public ReadResponse read(ReadRequest readRequest) {
		// TODO Auto-generated method stub
		return input;
	}
	
	
	//Returns the response which contains the output data 
	//writeRequest will contain a List<String>
	@Override
	public WriteResponse write(WriteRequest writeRequest) {
		// TODO Auto-generated method stub
		return output;
	}

	public WriteResponse write(List<String> result){
		output.setData(result);
		
	}
	

}
