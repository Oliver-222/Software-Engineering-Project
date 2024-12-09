import factorapi.GetFactorRequest;
import factorapi.ReadResponse;
import factorapi.DataStorage;
import factorapi.ReadRequest;
import org.mockito.Mockito;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeoutException;

import static org.junit.Assert.fail;

public class TestDataStorageTimeout {

    @Test
    public void testReadTimeout() {
        DataStorage ds = Mockito.mock(DataStorage.class);

        // Mock a read request
        ReadRequest mockRequest = Mockito.mock(ReadRequest.class);

        // Simulate a timeout exception during the read operation
        try {
            Mockito.when(ds.read(mockRequest))
                    .thenThrow(new TimeoutException("Read operation timed out"));

            ds.read(mockRequest);
            fail("Expected a TimeoutException to be thrown");
        } catch (TimeoutException e) {
            System.out.println("Timeout handled successfully: " + e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
}

