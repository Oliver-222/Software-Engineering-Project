import java.util.ArrayList;
import java.util.Scanner;

import factorapi.ComputeRequest;
import factorapi.GetFactorRequestImpl;

public class TestMain {
    public static void main(String[] args){
        ArrayList<Integer> testFactorList = new ArrayList<>();
        System.out.println("Enter your numbers to factor (When finished, enter 000): ");
        Scanner sc = new Scanner(System.in);
        int tempValue = -1;
        while (tempValue != 000 ){
            tempValue = sc.nextInt();
            if(tempValue == 000){
                break;
            }
            testFactorList.add(tempValue);
            System.out.println(testFactorList);
        }

        //inputs for now, for test.
        //can be changed to read from a file in the future

        System.out.println("Numbers to be factored: "+testFactorList);

        System.out.println("Enter your delimiter: ");
        String testDelimiter = sc.next();

        System.out.println("Enter your source: ");
        String testSource = sc.next();

        System.out.println("Enter your destination: ");
        String testDestination = sc.next();

        GetFactorRequestImpl testFactorRequest = new GetFactorRequestImpl(testFactorList,testDelimiter,testSource,testDestination);
        /* TODO: create a testComputeJobRequest using components from testFactorRequest,
                 then run it through the compute engine and data storage,
                 then return results to user.
         */

    }
}
