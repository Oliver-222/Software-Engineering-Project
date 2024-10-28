package factorapi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class DataStoreImpl implements DataStorage{

	
	@Override
	public ReadResponse read(ReadRequest readRequest) {

		ArrayList<Integer> readData = (ArrayList<Integer>) readHelper(readRequest);
		
		DataReadResponse dataReadResponse = new DataReadResponse(readData);
		
		return dataReadResponse;

	}

	public Iterable<Integer> readHelper(ReadRequest input) {
	    if (input == null) {
	        return null; // Using null as a sentinal value
	    }
	    try {
	    	return new Iterable<Integer>() {
	    		@Override
	    		public Iterator<Integer> iterator() {
	    			return getFileBasedIterator(input.source);
	    		}
	    	};
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	return null; 
	    }
	    
	   
	}
	
	private Iterator<Integer> getFileBasedIterator(String fileName) {
		try {
			return new Iterator<Integer>() {
				// A Scanner is also fine to use, but has an important difference as we add threads:
				// BufferedReader is by default thread-safe, but Scanner is not (like a synchronizedList vs ArrayList)
				// BufferedReader is also slightly more efficient at large file reads (larger buffer than Scanner),
				// but by default breaks at newlines rather than all whitespace, and doesn't parse the
				// input as it goes
				BufferedReader buff = new BufferedReader(new FileReader(fileName));
				String line = buff.readLine(); // read the first line so that hasNext() correctly recognizes empty files as empty
				boolean closed = false;

				@Override
				public Integer next() {
					// this particular iterator reads the first line during the (implicit) constructor, so line is already
					// set up for the next integer
					int result = Integer.parseInt(line);
					try {
						line = buff.readLine();
						if (!hasNext()) {
							buff.close();
							closed = true;
						}
					} catch (IOException e) {
						throw new RuntimeException(e);
					}
					
					return result;
				}

				@Override
				public boolean hasNext() {
					return line != null;
				}
				
				/*
				 * finalize() is a method on Object, much like toString or equals. It's called when an object is garbage collected, and is used as
				 * a final cleanup step for resources. It's a bit fragile - it isn't guaranteed to always be called, or be called at any specific time - 
				 * but unless a cleanup is particularly critical, it's generally sufficient as a back-stop against weird circumstances. In this case,
				 * we would at worst leak a read-lock file handle, which is NBD and certainly not worth architecting a larger solution around (honestly,
				 * finalize() might even be overkill in this situation).
				 */
				@Override
				public void finalize() {
					if (!closed) {
						try {
							buff.close();
							closed = true;
						} catch (IOException e) {
							throw new RuntimeException(e);
						}
					}
				}
			};
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public WriteResponse write(WriteRequest writeRequest) {

		WriteResponse writeResponse = appendSingleResult(writeRequest);
		
		return writeResponse;
	}

	public WriteResponse appendSingleResult(WriteRequest output) {
	    try {
//	        OutputConfig.visitOutputConfig(output, config -> {
//	            writeToFile(config.getFileName(), result + delimiter);
//	        });
	        writeToFile(output.destination, output.writeData + output.delimiter);

	        /* 
	         * Using lambda syntax to create an instance of WriteResult. This is an alternative to the ComputeResult approach of providing
	         * constants for success/failure.
	         */
	        return new WriteResponse(WriteResponseStatus.SUCCESS);
	    } catch (Exception e) {
	        return new WriteResponse(WriteResponseStatus.FAILURE);
	    }
	}

	private void writeToFile(String fileName, String line) {
		// use try-with-resources syntax to automatically close the file writer
		// use the append-friendly version of the constructor
		try (FileWriter writer = new FileWriter(new File(fileName), true)) {
			writer.append(line);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	

}
