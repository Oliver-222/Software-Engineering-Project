package factorapi;

import java.util.Base64;

public class LoginControllerImpl implements LoginController{
    //Following Line is an example for now and for testing
    private static final String[] USERS = new String[] {"Oliver;password", "John;purple"};

    /**
     * Takes a LoginRequest of a username and encrypted password, and returns a LoginResponse
     *
     * @param loginRequest - contains the info needed to log a user in
     * @return LoginResponse
     */
    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        try{
            for(String user : USERS){
                String[] credentials = user.split(";");
                String username = credentials[0];
                String password = credentials[1];
                if(username.equals(loginRequest.username)){
                    if(new String(Base64.getDecoder().decode(loginRequest.encryptedPwd)).equals(password)){
                        return new LoginResponse(LoginResponseCode.SUCCESS);
                    }else{
                        return new LoginResponse(LoginResponseCode.WRONG_PASSWORD);
                    }
                }
            }
            return new LoginResponse(LoginResponseCode.UNKNOWN_USER);
        } catch (Exception e){
            return new LoginResponse(LoginResponseCode.FAILURE);
        }
    }
}