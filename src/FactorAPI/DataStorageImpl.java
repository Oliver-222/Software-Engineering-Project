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

	public DataStorageImpl() {
		this(new DataStoreImpl());
	}
	
	public DataStorageImpl(DataStoreImpl dataStore) {
		this.dataStore = dataStore; 
	}
	
	public ReadResponse read(ReadRequest readRequest) {

		return dataStore.read(readRequest);
		
	}
	
	public WriteResponse write(WriteRequest writeRequest) {
		return dataStore.write(writeRequest);
	}

	
}
			
