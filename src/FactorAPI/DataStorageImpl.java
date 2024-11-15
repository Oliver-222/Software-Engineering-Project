package factorapi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import datastore.DataStorageGrpc.DataStorageImplBase;

public class DataStorageImpl extends DataStorageImplBase {

	private DataStoreImpl dataStore; 
	
	public DataStorageImpl(DataStoreImpl dataStore) {
		this.dataStore = dataStore; 
	}
	
	public ReadResponse read(ReadRequest readRequest) {

		try {
			return dataStore.read(readRequest);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error in DS Server read");
		}
		
		return null; 
		
	}
	
	public WriteResponse write(WriteRequest writeRequest) {
		try {
			return dataStore.write(writeRequest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error in DS Server write");
		}
		
		return null; 
	}

	
}
			
