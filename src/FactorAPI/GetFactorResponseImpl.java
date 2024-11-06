package factorapi;

public class GetFactorResponseImpl implements GetFactorResponse {
    private GetFactorStatus factorStatus;
    private String errorMessage;

    public GetFactorResponseImpl(GetFactorStatus factorStatus, String errorMessage) {
        this.factorStatus = factorStatus;
        this.errorMessage = errorMessage;
    }
    public GetFactorStatus getStatus(){
        return factorStatus;
    }
    public String getErrorMessage(){
        return errorMessage;
    }
}