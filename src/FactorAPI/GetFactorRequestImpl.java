package factorapi;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class GetFactorRequestImpl implements GetFactorRequest {
    private static final String DEFAULT_DELIMITER = ";";
    ArrayList<Integer> factors;
    String delimiter;
    String source;
    String destination;
    public GetFactorRequestImpl(ArrayList<Integer> factors, String delimiter, String source, String destination) {
        this.factors = factors;
        this.delimiter = delimiter;
        this.source = source;
        this.destination = destination;
    }
    public GetFactorRequestImpl(ArrayList<Integer> factors, String source, String destination) {
        this.factors = factors;
        this.delimiter = DEFAULT_DELIMITER;
        this.source = source;
        this.destination = destination;
    }
    public GetFactorRequestImpl(String delimiter, String source, String destination) throws FileNotFoundException {
        this.factors = readIntegersFromFile(source);
        this.delimiter = delimiter;
        this.source = source;
        this.destination = destination;
    }
    public ArrayList<Integer> getFactors() {
        if (factors == null) {
            throw new IllegalArgumentException("Factors cannot be null.");
        }
        return factors;
    }

    public String getDelimiter() {
        if (delimiter == null) {
            throw new IllegalArgumentException("Delimiter cannot be null.");
        }
        return delimiter;
    }

    public String getSource() {
        if (source == null) {
            throw new IllegalArgumentException("Source cannot be null.");
        }
        return source;
    }

    public String getDestination() {
        if (destination == null) {
            throw new IllegalArgumentException("Destination cannot be null.");
        }
        return destination;
    }
    private static ArrayList<Integer> readIntegersFromFile(String source) {
        ArrayList<Integer> factors = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(source))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                for (String part : parts) {
                    try {
                        factors.add(Integer.parseInt(part.trim()));
                    } catch (NumberFormatException e) {
                        //Handles the case where there is a non-integer
                        System.out.println("Skipping non-integer part: " + part);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle file reading errors
        }
        return factors;
    }
}