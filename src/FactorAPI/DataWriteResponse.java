package factorapi;

public class DataWriteResponse implements WriteResponse{

	public DataWriteResponse() {
		
	}

	@Override
	public WriteStatus getWriteStatus() {
		// TODO Auto-generated method stub
		
		//Can always be success, would throw exception otherwise 
		return WriteStatus.SUCCESS;
	}
	
	

}
