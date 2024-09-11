package FactorAPI;

public class TestFactorAPI {
    public static void main(String[] args){
        LoginRequest req = new LoginRequest("Oliver", "cGFzc3dvcmQ=", null, null, null, null);
        FactorAPI api = new FactorAPI();
        FactorAPIResponse resp = api.getFactors(req);
        System.out.println("Response code: " + resp.getResponseCode() + " Response Message: " +resp.getResponseMessage());
    }
}
