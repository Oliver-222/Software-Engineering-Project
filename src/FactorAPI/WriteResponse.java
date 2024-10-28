package factorapi;

public class WriteResponse {

    private WriteResponseStatus status;

    public WriteResponse(WriteResponseStatus status){
        this.status = status; 
    }    
    
    public static enum WriteResponseStatus {
        SUCCESS,
        FAILURE;
    }
    
}
