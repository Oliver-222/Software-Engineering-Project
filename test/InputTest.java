

import java.util.List;

public class InputTest implements ReadResponse{
	//Test-only input implementation
	public List<Integer> getData() {
		return this.data; 
	}
	
	public void setData(List<Integer> data) {
		this.data = data; 
	}
	
	
}
