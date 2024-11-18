import factorapi.ComputeRequest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class ComputeEngineBenchmarkTest{
    //TEST FOR executeJob METHOD, OLD vs NEW
@Test
    public static void main(String[] args){
        ArrayList<Integer> factorNumbers = new ArrayList<>();
        factorNumbers.add(6);
        factorNumbers.add(8);
        factorNumbers.add(6345);
        factorNumbers.add(1);
        factorNumbers.add(16);
        factorNumbers.add(81);
        factorNumbers.add(654798);
        factorNumbers.add(768957);
        factorNumbers.add(999999999);
        factorNumbers.add(768957753);

        ComputeRequest computeRequest = new ComputeRequest(factorNumbers, ":", "source", "destination");
        oldExecuteJob(computeRequest);
        newExecuteJob(computeRequest);
    }
   public static void oldExecuteJob(ComputeRequest request) {
        long start1 = System.currentTimeMillis();
        List<Integer> factorList = request.getFactors();
        StringBuilder result = new StringBuilder();

        // Check for null request
        if (request == null) {
            throw new IllegalArgumentException("ComputeRequest cannot be null.");
        }
        // Check for null factors list
        if (factorList == null) {
            throw new IllegalArgumentException("Factors list cannot be null.");
        }
        for (int index = 0; index < factorList.size(); index++) {
            Integer number = factorList.get(index);
            result.append(number).append(":");

            ArrayList<Integer> factors = new ArrayList<>();

            // Find factors
            for (int i = 1; i <= number; i++) {
                if (number % i == 0) {
                    factors.add(i);
                }
            }

            // Convert factors to a comma-separated string
            result.append(factors.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(",")));

            // Separate factors with user given delimiter
            if (index < factorList.size() - 1) {
                result.append(request.getDelimiter());
            }
        }
        System.out.println("Numbers Factored: "+request.getFactors());
        System.out.println(System.currentTimeMillis() - start1 + "ms (old)");

    }
    public static void newExecuteJob(ComputeRequest request) {
        long start2 = System.currentTimeMillis();
        if(request == null){
            throw new IllegalArgumentException("ComputeRequest cannot be null.");
        }
        List<Integer> factorList = request.getFactors();

        if(factorList == null){
            throw new IllegalArgumentException("Factors list cannot be null.");
        }
        StringBuilder result = new StringBuilder();

        int listSize = factorList.size();
        for(int index = 0; index < listSize; index++){
            Integer number = factorList.get(index);
            result.append(number).append(":");

            boolean firstFactor = true; //handle delimiter without extra commas
            //factors up to the square root of the number
            for(int i = 1; i * i <= number; i++){
                if(number % i == 0){
                    if(!firstFactor){
                        result.append(",");
                    }
                    result.append(i);
                    firstFactor = false;

                    //avoid adding the square root twice (perfect squares)
                    if(i != number / i){
                        result.append(",");
                        result.append(number / i);
                    }
                }
            }
            if(index < listSize - 1){
                result.append(request.getDelimiter());
            }
        }
        System.out.println("Numbers Factored: "+request.getFactors());
        System.out.println(System.currentTimeMillis() - start2 + "ms (new)");
    }
}
