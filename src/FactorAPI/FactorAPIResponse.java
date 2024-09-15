package factorAPI;

public class FactorAPIResponse{
    private String responseCode;
    private String responseMessage;

    public FactorAPIResponse(String responseCode, String responseMessage) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }
    public String getResponseCode() {
        return responseCode;
    }
    public String getResponseMessage() {
        return responseMessage;
    }
}