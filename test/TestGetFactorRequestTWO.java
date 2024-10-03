import factorapi.GetFactorRequest;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

public class TestGetFactorRequestTWO {
    public void testGetDestnation(){
        GetFactorRequest req = Mockito.mock(GetFactorRequest.class);
        when(req.getDestination()).thenReturn("Destination");
        if(!"Destination".equals(req.getDestination())){
            fail();
        }
    }
}
