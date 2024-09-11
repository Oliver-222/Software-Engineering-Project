package FactorAPI;
//Gets response code from LoginResponseCode
public class LoginResponse{
    private LoginResponseCode responseCode;

    public LoginResponse(LoginResponseCode responseCode){
        this.responseCode = responseCode;
    }
    public LoginResponseCode getResponseCode(){
        return responseCode;
    }

}
