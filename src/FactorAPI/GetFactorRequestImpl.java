package factorapi;

import java.util.ArrayList;

public class GetFactorRequestImpl implements GetFactorRequest {
    ArrayList<Integer> factors;
    String delimiter;
    String source;
    String destination;

    public GetFactorRequestImpl(ArrayList<Integer> factors, String delimiter, String source, String destination) {
        this.factors = factors;
        this.delimiter = delimiter;
        this.source = source;
        this.destination = destination;
    }
    public ArrayList<Integer> getFactors() {
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