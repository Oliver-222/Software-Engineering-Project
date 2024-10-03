package factorapi;
//public interface ComputeJobRequest {
//    String getSource();
//    String getDelimiter();
//    String getDestination();
//    String getComputationType();
//}

import java.util.ArrayList;

public class ComputeRequest {

    private static final String DEFAULT_DELIMITER = ";";
    ArrayList<Integer> factors;
    String delimiter;
    String source;
    String destination;


    public ComputeRequest(ArrayList<Integer> factors, String delimiter, String source, String destination){
        this.factors = factors;
        this.delimiter = delimiter;
        this.source = source;
        this.destination = destination;
    }

    public ComputeRequest(ArrayList<Integer> factors, String source, String destination){
        this.factors = factors;
        this.delimiter = DEFAULT_DELIMITER;
        this.source = source;
        this.destination = destination;
    }
    public String getDelimiter() {
        return delimiter;
    }

    public ArrayList<Integer> getFactors() {
        return factors;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }
}

  
