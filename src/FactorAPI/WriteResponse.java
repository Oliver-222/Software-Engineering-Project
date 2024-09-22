package factorapi;

public interface WriteResponse {
    public static enum WriteResponseStatus {
        SUCCESS,
        FAILURE;
    }
    WriteResponseStatus getStatus();
}
