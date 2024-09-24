import factorapi.ComputeEngine;
import factorapi.ComputeJobRequest;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComputeEngineTest {
    @Test
    void testInitializeJob() {
        ComputeJobRequest mockRequest = mock(ComputeJobRequest.class);
        ComputeEngine computeEngine = new ComputeEngineImpl();

        String response = computeEngine.initializeJob(mockRequest);
        assertEquals("", response); // Test should fail since the method returns an empty string
    }

    @Test
    void testExecuteJob() {
        ComputeJobRequest mockRequest = mock(ComputeJobRequest.class);
        ComputeEngine computeEngine = new ComputeEngineImpl();

        String response = computeEngine.executeJob(mockRequest);
        assertEquals("", response); // Test should fail since the method returns an empty string
    }
}
