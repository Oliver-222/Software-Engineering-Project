package factorapi;

import java.util.Base64;

public class ComputeJobRequestImpl implements ComputeJobRequest {

    private String source;
    private String delimiter;
    private String destination;
    private String computationType;

    public ComputeJobRequestImpl(String source, String delimiter, String destination, String computationType) {
        this.source = source;
        this.delimiter = delimiter;
        this.destination = destination;
        this.computationType = computationType;
    }

    @Override
    public String getSource() {
        return source;
    }

    @Override
    public String getDelimiter() {
        return delimiter;
    }

    @Override
    public String getDestination() {
        return destination;
    }

    @Override
    public String getComputationType() {
        return computationType;
    }

    @Override
    public String toString() {
        return "ComputeJobRequestImpl{" +
                "source='" + source + '\'' +
                ", delimiter='" + delimiter + '\'' +
                ", destination='" + destination + '\'' +
                ", computationType='" + computationType + '\'' +
                '}';
    }
}
