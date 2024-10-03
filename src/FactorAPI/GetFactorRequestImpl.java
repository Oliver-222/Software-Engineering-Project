package factorapi;

import java.util.ArrayList;

public class GetFactorRequestImpl implements GetFactorRequest {
    ArrayList<Integer> factors;
    String delimiter;
    String source;
    String destination;
    String DEFAULT_DELIMITER = ":";

    public GetFactorRequestImpl(ArrayList<Integer> factors, String delimiter, String source, String destination) {
        this.factors = factors;
        this.delimiter = delimiter;
        this.source = source;
        this.destination = destination;
    }
    public GetFactorRequestImpl(ArrayList<Integer> factors, String source, String destination) {
        this.factors = factors;
        this.delimiter = DEFAULT_DELIMITER;
        this.source = source;
        this.destination = destination;
    }
    public ArrayList<Integer> getFactors() {
        if (factors == null) {
            throw new IllegalArgumentException("Factors cannot be null.");
        }
        return factors;
    }

    public String getDelimiter() {
        if (delimiter == null) {
            throw new IllegalArgumentException("Delimiter cannot be null.");
        }
        return delimiter;
    }

    public String getSource() {
        if (source == null) {
            throw new IllegalArgumentException("Source cannot be null.");
        }
        return source;
    }

    public String getDestination() {
        if (destination == null) {
            throw new IllegalArgumentException("Destination cannot be null.");
        }
        return destination;
    }
}