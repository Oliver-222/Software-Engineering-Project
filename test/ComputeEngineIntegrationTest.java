//import factorapi.ComputeEngine;
//import factorapi.ComputeJobRequest;
//import org.junit.jupiter.api.Test;
//import java.util.ArrayList;
//import java.util.List;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class ComputeEngineIntegrationTest {
//    @Test
//    void testComputeEngineIntegration() {
//        List<Integer> inputList = List.of(1, 10, 25);
//        List<String> outputList = new ArrayList<>();
//
//        InMemoryInputConfig inputConfig = new InMemoryInputConfig(inputList);
//        InMemoryOutputConfig outputConfig = new InMemoryOutputConfig(outputList);
//        InMemoryDataStore dataStore = new InMemoryDataStore(inputConfig, outputConfig);
//
//        ComputeJobRequest request = new ComputeJobRequestImpl("source", ",", "destination", "type");
//        ComputeEngine computeEngine = new ComputeEngineImpl();
//
//        computeEngine.initializeJob(request);
//        List<String> result = computeEngine.executeJob(request); // Modify to return a result
//
//        dataStore.write(result); // Write result to the data store
//        dataStore.processData(); // Simulate processing, if needed
//
//        List<String> finalOutput = dataStore.getOutputConfig().getOutputList();
//        assertEquals("Processed: [1, 10, 25]", finalOutput.get(0)); // Check final output
//    }
//}
