package factorapi;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComputeEngineIntegrationTest {
    @Test
    void testComputeEngineIntegration() {
        List<Integer> inputList = List.of(1, 10, 25);
        List<String> outputList = new ArrayList<>();

        InMemoryInputConfig inputConfig = new InMemoryInputConfig(inputList);
        InMemoryOutputConfig outputConfig = new InMemoryOutputConfig(outputList);
        InMemoryDataStore dataStore = new InMemoryDataStore(inputConfig, outputConfig);
        
        ComputeJobRequest request = new ComputeJobRequestImpl("source", ",", "destination", "type");
        ComputeEngine computeEngine = new ComputeEngineImpl();

        computeEngine.initializeJob(request);
        computeEngine.executeJob(request);

        dataStore.processData(); // Simulate processing

        assertEquals("Processed: [1, 10, 25]", outputList.get(0)); // Test should fail since the method returns an empty string
    }
}
