package factorapi;
public class GetFactorRequest {
    int[] factors;
    String delimiter;
    String source;
    String destination;

    public GetFactorRequest(LoginRequest loginRequest) {
        this(loginRequest.factors, loginRequest.delimiter, loginRequest.source, loginRequest.destination);
    }

    private GetFactorRequest(int[] factors, String delimiter, String source, String destination) {
        this.factors = factors;
        this.delimiter = delimiter;
        this.source = source;
        this.destination = destination;
    }
}