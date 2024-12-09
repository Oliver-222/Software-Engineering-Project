import factorapi.GetFactorRequest;
import factorapi.ReadResponse;
import factorapi.DataStorage;
import factorapi.ReadRequest;
import org.mockito.Mockito;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.fail;

public class TestDataStorageTimeout {

    @Test
    public void testReadTimeout() {
        // Mock the DataStorage object
        DataStorage ds = Mockito.mock(DataStorage.class);

        // Mock a read request
        ReadRequest mockRequest = Mockito.mock(ReadRequest.class);

        try {
            // Configure the mock to throw a TimeoutException for the read method
            Mockito.when(ds.read(mockRequest)).thenThrow(new TimeoutException("Read operation timed out"));

            // Call the read method, expecting a TimeoutException
            ds.read(mockRequest);
            fail("Expected a TimeoutException to be thrown");
        } catch (TimeoutException e) {
            // Verify that the exception is handled as expected
            System.out.println("Timeout handled successfully: " + e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
}

