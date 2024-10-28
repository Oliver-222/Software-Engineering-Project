package factorapi;

public class WriteResponse {

    private WriteResponseStatus status;

    public WriteResponse(){
        this(WriteResponseStatus.SUCCESS);
    }
    
    public WriteResponse(WriteResponseStatus status){
        this.status = status; 
    }    
    
    public static enum WriteResponseStatus {
        SUCCESS,
        FAILURE;
    }
    
}
