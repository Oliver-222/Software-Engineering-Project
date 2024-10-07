import factorapi.FactorAPI;
import factorapi.GetFactorRequestImpl;
import factorapi.GetFactorResponse;
import factorapi.GetFactorResponseImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.io.FileNotFoundExeption;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class TestFactorAPI {
    @Test
    public void testProcessRequestReturnsSuccess() throws FileNotFoundException, IOException{
        ArrayList<Integer> factors = new ArrayList<>();
        factors.add(4);
        factors.add(6);
        String delimiter = ":";
        String source = "source";
        String destination = "destination";


        FactorAPI factorAPI = new FactorAPI();
        GetFactorRequestImpl request = new GetFactorRequestImpl(factors,delimiter,source,destination);

        GetFactorResponse response = factorAPI.processRequest(request);

        assertEquals(GetFactorResponse.GetFactorStatus.SUCCESS, response.getStatus());
    }
}
