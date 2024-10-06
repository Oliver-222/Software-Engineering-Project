package factorapi;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FactorAPI{
    public GetFactorResponse processRequest(GetFactorRequest factorRequest) throws FileNotFoundException, IOException;
}
