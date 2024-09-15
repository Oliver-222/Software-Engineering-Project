package factorapi;

public interface DataStorage {

	/**
	 * Reads data from user-specified location.
	 * @param source - general key to find where the data is
	 * @return ReadResponse - will contain the input data 
	 */
	ReadResponse read(ReadRequest readRequest);
	
	WriteResponse write(WriteRequest writeRequest);
	
}
