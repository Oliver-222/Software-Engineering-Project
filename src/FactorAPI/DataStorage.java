package factorapi;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface DataStorage {

	/**
	 * Reads data from user-specified location.
	 * @param source - general key to find where the data is
	 * @return ReadResponse - will contain the input data 
	 */
	//Throwing exceptions for file reading
	ReadResponse read(ReadRequest readRequest) throws FileNotFoundException;

	WriteResponse write(WriteRequest writeRequest) throws IOException;
	
}
