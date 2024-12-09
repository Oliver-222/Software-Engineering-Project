import factorapi.DataStorage;
import factorapi.WriteResponse;
import factorapi.WriteRequest;
import org.mockito.Mockito;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestDataStorageWrite {

    @Test
    public void testWriteResponseStatus() {
        DataStorage ds = Mockito.mock(DataStorage.class);
        
        // Simulate WriteResponse with success status
        WriteResponse successResponse = Mockito.mock(WriteResponse.class);
        Mockito.when(successResponse.getStatus()).thenReturn(WriteResponse.WriteResponseStatus.SUCCESS);
        WriteRequest mockWriteRequest = Mockito.mock(WriteRequest.class);

        // Simulate a successful write operation
        try {
            WriteResponse response = ds.write(mockWriteRequest);
            assertEquals(WriteResponse.WriteResponseStatus.SUCCESS, response.getStatus(), "Write operation should succeed");
        } catch (Exception e) {
            fail("Exception occurred during write operation: " + e.getMessage());
        }

        // Simulate WriteResponse with failure status
        WriteResponse failureResponse = Mockito.mock(WriteResponse.class);
        Mockito.when(failureResponse.getStatus()).thenReturn(WriteResponse.WriteResponseStatus.FAILURE);

        // Simulate a failed write operation
        try {
            WriteResponse response = ds.write(mockWriteRequest);
            assertEquals(WriteResponse.WriteResponseStatus.FAILURE, response.getStatus(), "Write operation should fail");
        } catch (Exception e) {
            fail("Exception occurred during write operation: " + e.getMessage());
        }
    }
}
