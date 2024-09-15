package factorapi;
public class FactorAPI {
    private static final LoginController authentication = new LoginControllerImpl();

    public FactorAPIResponse getFactors(LoginRequest loginRequest) {
        // log in the user
        LoginResponse loginResponse = authentication.login(loginRequest);

        // if successful login, get factor
        if (loginResponse.getResponseCode().success()){
            // System.out.println("SUCCESS"); - test message

            GetFactorRequest getFactorRequest = new GetFactorRequest(loginRequest);

            // These are part of API 2 and need to be created
			/* FactorControllerImpl should do the factor and connect to APU 3 then return a GetFactorReponse
			   of success or failure, like LoginResponse
			*/
            
            //GetFactorReponse resp = new FactorControllerImpl(getFactorRequest); ---> Make in API2

            //This Success will change once API 2 is made
            return new FactorAPIResponse("Success", "Successful Login");
        }else{
            return new FactorAPIResponse("Failure", loginResponse.getResponseCode().name());
        }
    }
}