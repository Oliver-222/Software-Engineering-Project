package factorapi;

public interface LoginController {

    /** Logs the user in
     * @param loginRequest - contains the info needed to log a user in
     * */
    LoginResponse login(LoginRequest loginRequest);

}