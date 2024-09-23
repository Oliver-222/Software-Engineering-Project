import factorapi.FactorAPI;
import factorapi.GetFactorRequest;
import factorapi.GetFactorResponse;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
public class TestGetFactorResponse {
      @Test
      public void testSuccessfulResponse(){
        FactorAPI mockApi = Mockito.mock(FactorAPI.class);
        GetFactorRequest mockReq = Mockito.mock(GetFactorRequest.class);
        GetFactorResponse mockResp = Mockito.mock(GetFactorResponse.class);

        when(mockResp.getStatus()).thenReturn(GetFactorResponse.GetFactorStatus.SUCCESS);
        when(mockApi.processRequest(Mockito.any(GetFactorRequest.class))).thenReturn(mockResp);

        GetFactorResponse respSuccess = mockApi.processRequest(mockReq);
        if(! respSuccess.getStatus().equals(GetFactorResponse.GetFactorStatus.SUCCESS)){
            fail();
        }
    }
}
