package factorapi;

public interface GetFactorRequest {
    public String getSource();
    public String getDestination();
    public String getDelimiter();
    public int[] getFactors();
}
