package factorapi;

public interface GetFactorResponse {
    public static enum GetFactorStatus {
        SUCCESS,
        FAILURE;
    }
    GetFactorStatus getStatus();
}
