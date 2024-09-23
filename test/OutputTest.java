import java.util.List;

public class OutputTest implements WriteResponse{

	public List<String> data = null;
	
	@Override
	public WriteStatus getWriteStatus() {
		return null;
	}

	public void setData(List<String> data) {
		this.data = data;
		
	}
	
	public List<String> getData(){
		return this.data; 
	}
	
}
