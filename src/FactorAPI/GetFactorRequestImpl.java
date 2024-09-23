package factorapi;
public class GetFactorRequestImpl implements GetFactorRequest {
    int[] factors;
    String delimiter;
    String source;
    String destination;

    public GetFactorRequestImpl(int[] factors, String delimiter, String source, String destination) {
        this.factors = factors;
        this.delimiter = delimiter;
        this.source = source;
        this.destination = destination;
    }
    public int[] getFactors() {
        return factors;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }
}