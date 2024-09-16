package factorapi;


public interface ComputeEngine {
    String initializeJob(ComputeJobRequest request);
    String executeJob(ComputeJobRequest request);
}
