import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import factorapi.CoordinatorImpl;
import factorapi.DataStoreImpl;
import factorapi.ComputeEngineImpl;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestMultiUser {

	// (DONE) 1: change the type of this variable to the name you're using for your
	// User <-> ComputeEngine API
	private CoordinatorImpl coordinator;
	@BeforeEach
	public void initializeComputeEngine() throws FileNotFoundException {
		// (DONE) 2: create an instance of your coordinator component; this is the component
		// that the user will make requests to
		// Store it in the 'coordinator' instance variable

		DataStoreImpl dataStore = new DataStoreImpl();
		ComputeEngineImpl computeEngine = new ComputeEngineImpl();
		coordinator = new CoordinatorImpl(dataStore, computeEngine);
	}

	@Test
	public void compareMultiAndSingleThreaded() throws Exception {
		int nthreads = 4;
		List<TestUser> testUsers = new ArrayList<>();
		for (int i = 0; i < nthreads; i++) {
			testUsers.add(new TestUser(coordinator));
		}

		// Run single threaded
		String singleThreadFilePrefix = "testMultiUser.compareMultiAndSingleThreaded.test.singleThreadOut.tmp";
		for (int i = 0; i < nthreads; i++) {
			File singleThreadedOut =
					new File(singleThreadFilePrefix + i);
			singleThreadedOut.deleteOnExit();
			testUsers.get(i).run(singleThreadedOut.getCanonicalPath());
		}

		// Run multi threaded
		ExecutorService threadPool = Executors.newCachedThreadPool();
		List<Future<?>> results = new ArrayList<>();
		String multiThreadFilePrefix = "testMultiUser.compareMultiAndSingleThreaded.test.multiThreadOut.tmp";
		for (int i = 0; i < nthreads; i++) {
			File multiThreadedOut =
					new File(multiThreadFilePrefix + i);
			multiThreadedOut.deleteOnExit();
			String multiThreadOutputPath = multiThreadedOut.getCanonicalPath();
			TestUser testUser = testUsers.get(i);
			results.add(threadPool.submit(() -> {
				try {
					testUser.run(multiThreadOutputPath);
				} catch (FileNotFoundException e) {
					throw new RuntimeException(e);
				}
			}));
		}

		results.forEach(future -> {
			try {
				future.get();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		});


		// Check that the output is the same for multi-threaded and single-threaded
		List<String> singleThreaded = loadAllOutput(singleThreadFilePrefix, nthreads);
		List<String> multiThreaded = loadAllOutput(multiThreadFilePrefix, nthreads);
		Assert.assertEquals(singleThreaded, multiThreaded);
	}

	private List<String> loadAllOutput(String prefix, int nthreads) throws IOException {
		List<String> result = new ArrayList<>();
		for (int i = 0; i < nthreads; i++) {
			File multiThreadedOut =
					new File(prefix + i);
			result.addAll(Files.readAllLines(multiThreadedOut.toPath()));
		}
		return result;
	}
}
