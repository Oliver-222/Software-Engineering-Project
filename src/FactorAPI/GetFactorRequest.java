package factorapi;

import java.util.ArrayList;

public interface GetFactorRequest {
    public String getSource();
    public String getDestination();
    public String getDelimiter();
    public ArrayList<Integer> getFactors();
}
