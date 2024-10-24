package factorapi;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ComputeEngineImpl implements ComputeEngine {

    public String executeJob(ComputeRequest request) {
        ArrayList<Integer> factorList = request.factors;
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
                result.append(request.delimiter);
            }
        }
        return result.toString();
    }
}
