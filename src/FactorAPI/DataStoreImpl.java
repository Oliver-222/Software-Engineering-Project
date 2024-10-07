package factorapi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DataStoreImpl implements DataStorage{

	
	@Override
	public ReadResponse read(ReadRequest readRequest) throws FileNotFoundException {
		
		//File object for the specified source file name. Throws exception if the file doesn't exist.
		File readFile = new File(readRequest.source);
		
		//To read the file, implements Iterable, so can handle arbitrarily large inputs
		Scanner sc = new Scanner(readFile);
		
		//The actual integers being read from the file. This will be given to the ReadResponse as its data field
		ArrayList<Integer> readData = new ArrayList<>();
		
		
		//While the scanner still finds integers in the source file, read them into the data List
		while(sc.hasNextInt()) {
			readData.add(sc.nextInt());
		}
		
		//Lets us return the ReadResponse. Only contains the data List
		DataReadResponse dataReadResponse = new DataReadResponse(readData);
		
		return dataReadResponse;

	}

	@Override
	public WriteResponse write(WriteRequest writeRequest) throws IOException {
		WriteResponse writeResponse;

		//Make a new file instance to be called by next line
		File writeFile = new File(writeRequest.destination);
		//If the file exists, does nothing. if not, creates a new file with the specified name. 
		//Returns a boolean that I don't care about, at least for right now. 
		writeFile.createNewFile();
		
		//Writes things to the specified file and automatically closes FileWriter
		try(FileWriter fw = new FileWriter(writeFile);){
			fw.write(writeRequest.writeData);

			writeResponse = new DataWriteResponse();
		}
		
		return writeResponse;
	}

}
