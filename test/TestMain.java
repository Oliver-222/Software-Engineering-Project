import java.util.ArrayList;
import java.util.Scanner;
import factorapi.ComputeEngineImpl;
import factorapi.ComputeRequest;
import factorapi.GetFactorRequestImpl;

public class TestMain {
    public static void main(String[] args){
        ArrayList<Integer> testFactorList = new ArrayList<>();
        System.out.println("Enter your numbers to factor (When finished, enter 000): ");
        Scanner sc = new Scanner(System.in);
        int tempValue = -1;
        // Check to make sure the input is an integer
        while (true) {
            try {
                tempValue = sc.nextInt();
                if (tempValue == 000) {
                    break;
                }
                    if(tempValue < 0) {
                        throw new IllegalArgumentException("nvalid input. Please enter a positive integer.");
                    }
                testFactorList.add(tempValue);
                System.out.println(testFactorList);
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a positive integer.");
                sc.next(); // Clear the invalid input
            }
            if (testFactorList.isEmpty()) {
                System.out.println("No factors provided. Exiting.");
                return;
            }
        }

        //inputs via scanner for now, for test.
        //can be changed to read from a file in the future

        System.out.println("Numbers to be factored: "+testFactorList);

        System.out.println("Enter your delimiter: ");
        String testDelimiter = sc.next();

        System.out.println("Enter your source: ");
        String testSource = sc.next();

        System.out.println("Enter your destination: ");
        String testDestination = sc.next();

        GetFactorRequestImpl testFactorRequest = new GetFactorRequestImpl(testFactorList,testDelimiter,testSource,testDestination);
        ComputeRequest testComputeRequest = new ComputeRequest(testFactorRequest.getFactors(), testFactorRequest.getDelimiter(), testFactorRequest.getSource(), testFactorRequest.getDestination());
        ComputeEngineImpl testComputeEngine = new ComputeEngineImpl(testComputeRequest);

        try {
            String finalResult = testComputeEngine.executeJob(testComputeRequest);
            System.out.println("Final Result: " + finalResult);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
