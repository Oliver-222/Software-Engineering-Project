package factorapi;
//What a user needs to login and submit their request
public class LoginRequest {
    String username;
    String encryptedPwd;
    int[] factors;
    String delimiter;
    String source;
    String destination;

    public LoginRequest(String username, String encryptedPwd, int[] factors, String delimiter, String source, String destination) {
        this.username = username;
        this.encryptedPwd = encryptedPwd;
        this.factors = factors;
        this.delimiter = delimiter;
        this.source = source;
        this.destination = destination;
    }
}