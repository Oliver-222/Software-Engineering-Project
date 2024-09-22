import factorapi.GetFactorRequest;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

public class TestGetFactorRequest {
    @Test
    public void testGetSource(){
        GetFactorRequest req = Mockito.mock(GetFactorRequest.class);
        when(req.getSource()).thenReturn("Source");

        //other things to test if wanted

//        when(req.getDestination()).thenReturn("Dest");
//        when(req.getFactors()).thenReturn(new int[]{1,2,3,6});
//        when(req.getDelimiter()).thenReturn(",");

        if(!"Source".equals(req.getSource())){
            fail();
        }
    }

// Was messing around with another test, no need to delete or uncomment

//    @Test
//    public void testBadRequest() {
//        FactorAPI mockApi = Mockito.mock(FactorAPI.class);
//        GetFactorResponse mockResp = Mockito.mock(GetFactorResponse.class);
//
//        when(mockResp.getStatus()).thenReturn(GetFactorResponse.GetFactorStatus.FAILURE);
//        when(mockApi.processRequest(Mockito.isNull())).thenReturn(mockResp);
//
//        GetFactorResponse respSuccess = mockApi.processRequest(null);
//        if (!respSuccess.getStatus().equals(GetFactorResponse.GetFactorStatus.SUCCESS)) {
//            fail();
//        }
//    }
}
