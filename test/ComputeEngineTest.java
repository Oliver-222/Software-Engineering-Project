import factorapi.ComputeEngine;
import factorapi.ComputeEngineImpl;
import factorapi.ComputeRequest;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComputeEngineTest {
    @Test
    void testExecuteJob() {

        //Create ArrayList of factors (just 6 for this example)
        ArrayList<Integer> testArray = new ArrayList<>();
        testArray.add(6);

        //Create testRequest
        ComputeRequest testRequest = new ComputeRequest(testArray,":", "source", "destination");

        //Create new compute Engine using the testRequest
        ComputeEngine computeEngine = new ComputeEngineImpl(testRequest);
        String response = computeEngine.executeJob(testRequest);

        //Check if response is what is expected
        assertEquals("6:1,2,3,6", response);
    }
}
