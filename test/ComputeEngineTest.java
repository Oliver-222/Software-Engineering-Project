import factorapi.ComputeEngine;
import factorapi.ComputeEngineImpl;
import factorapi.ComputeRequest;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComputeEngineTest {
    @Test
    void testExecuteJob() {
        ComputeRequest mockRequest = mock(ComputeRequest.class);
        ComputeEngine computeEngine = new ComputeEngineImpl(mockRequest);

        String response = computeEngine.executeJob(mockRequest);
        assertEquals("", response); // Test should fail since the method returns an empty string
    }
}
