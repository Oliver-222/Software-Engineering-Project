import factorapi.DataStorage;
import factorapi.WriteRequest;
import factorapi.WriteResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestDataStorageWrite {

    @Test
    public void testWriteOperation() {
        // Mock the DataStorage and WriteResponse objects
        DataStorage ds = Mockito.mock(DataStorage.class);
        WriteResponse successResponse = new WriteResponse(WriteResponse.WriteResponseStatus.SUCCESS);
        WriteResponse failureResponse = new WriteResponse(WriteResponse.WriteResponseStatus.FAILURE);

        // Mock a write request
        WriteRequest mockWriteRequest = Mockito.mock(WriteRequest.class);

        try {
            // Simulate a successful write operation
            Mockito.when(ds.write(mockWriteRequest)).thenReturn(successResponse);

            // Call the write method and verify success
            WriteResponse response = ds.write(mockWriteRequest);
            assertEquals(WriteResponse.WriteResponseStatus.SUCCESS, response.getStatus(), "Write operation should succeed");

            // Simulate a failed write operation
            Mockito.when(ds.write(mockWriteRequest)).thenReturn(failureResponse);

            // Call the write method and verify failure
            response = ds.write(mockWriteRequest);
            assertEquals(WriteResponse.WriteResponseStatus.FAILURE, response.getStatus(), "Write operation should fail");
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
}
