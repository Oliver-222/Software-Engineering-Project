package factorapi;

import java.util.List;

/*
 * Implementation of the ReadResponse interface to be used in the DataStoreImpl.
 * 
 */
public class DataReadResponse implements ReadResponse {

	public List<Integer> data; 
	
	public DataReadResponse(List<Integer> data) {
		this.data = data; 
	}

	@Override
	public List<Integer> getData() {
		// TODO Auto-generated method stub
		return this.data;
	}

	
}
