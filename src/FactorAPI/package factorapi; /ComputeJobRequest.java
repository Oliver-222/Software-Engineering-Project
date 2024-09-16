package factorapi;

import java.util.Base64;

public interface ComputeJobRequest {
    String getSource();
    String getDelimiter();
    String getDestination();
    String getComputationType();
}

  
