package factorapi;

public class GetFactorResponseImpl implements GetFactorResponse {
    private GetFactorStatus factorStatus;

    public GetFactorResponseImpl(GetFactorStatus factorStatus) {
        this.factorStatus = factorStatus;
    }
    public GetFactorStatus getStatus(){
        return factorStatus;
    }
}