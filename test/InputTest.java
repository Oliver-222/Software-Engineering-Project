

import factorapi.ReadResponse;

import java.util.List;

public class InputTest implements ReadResponse {
	private List<Integer> data;

	//Test-only input implementation
	public InputTest(List<Integers> input){
		this(null);
	}
	public InputTest(List<Integers> data){
		this.data = data; 
	}
	
	public List<Integer> getData() {
		return this.data; 
	}
	
	public void setData(List<Integer> data) {
		this.data = data; 
	}
	
	
}
