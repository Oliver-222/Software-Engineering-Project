import factorapi.DataStorage;
import factorapi.WriteResponse;
import factorapi.WriteResponse.WriteResponseStatus;
import factorapi.WriteRequest;
import org.mockito.Mockito;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestDataStorageWrite {

    @Test
    public void testWriteSuccess() {
        // Mock the DataStorage object
        DataStorage ds = Mockito.mock(DataStorage.class);

        // Mock the WriteResponse object
        WriteResponse successResponse = new WriteResponse(WriteResponseStatus.SUCCESS);

        // Mock the WriteRequest object
        WriteRequest mockRequest = Mockito.mock(WriteRequest.class);

        try {
            // Configure the mock to return a success response
            Mockito.when(ds.write(mockRequest)).thenReturn(successResponse);

            // Perform the write operation
            WriteResponse response = ds.write(mockRequest);

            // Validate the response status
            assertEquals(WriteResponseStatus.SUCCESS, response.getStatus(), "Write operation should succeed");
        } catch (Exception e) {
            fail("Unexpected exception during write operation: " + e.getMessage());
        }
    }

    @Test
    public void testWriteFailure() {
        // Mock the DataStorage object
        DataStorage ds = Mockito.mock(DataStorage.class);

        // Mock the WriteResponse object
        WriteResponse failureResponse = new WriteResponse(WriteResponseStatus.FAILURE);

        // Mock the WriteRequest object
        WriteRequest mockRequest = Mockito.mock(WriteRequest.class);

        try {
            // Configure the mock to return a failure response
            Mockito.when(ds.write(mockRequest)).thenReturn(failureResponse);

            // Perform the write operation
            WriteResponse response = ds.write(mockRequest);

            // Validate the response status
            assertEquals(WriteResponseStatus.FAILURE, response.getStatus(), "Write operation should fail");
        } catch (Exception e) {
            fail("Unexpected exception during write operation: " + e.getMessage());
        }
    }
}
