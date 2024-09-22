package factorapi;
public class FactorAPI {
    public GetFactorResponse processRequest(GetFactorRequest factorRequest) {
        return new GetFactorResponseImpl(GetFactorResponse.GetFactorStatus.SUCCESS);
    }
}