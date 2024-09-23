package factorapi;

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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getComputationType() {
        return computationType;
    }

    public void setComputationType(String computationType) {
        this.computationType = computationType;
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
