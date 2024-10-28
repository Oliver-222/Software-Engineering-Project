import factorapi.CoordinatorImpl;
import factorapi.GetFactorRequestImpl;
import factorapi.ComputeRequest;

import java.io.File;
import java.io.FileNotFoundException;


public class TestUser {

	// (DONE) 3: change the type of this variable to the name you're using for your
	// User <-> ComputeEngine API; also update the parameter passed to the constructor
	private final CoordinatorImpl coordinator;

	public TestUser(CoordinatorImpl coordinator) {
		this.coordinator = coordinator;
	}

	public void run(String outputPath) throws FileNotFoundException {
		String delimiter = ";";
		String inputPath = "test" + File.separatorChar + "testInputFile.test";
		GetFactorRequestImpl factorRequest = new GetFactorRequestImpl(delimiter, inputPath, outputPath);
		ComputeRequest computeRequest = new ComputeRequest(factorRequest);

		coordinator.compute(computeRequest);

		// (DONE) 4: Call the appropriate method(s) on the coordinator to get it to
		// run the compute job specified by inputPath, outputPath, and delimiter
	}

}
