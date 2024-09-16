package factorapi;

import java.util.Base64;


/**
 * Interface for the compute engine.
 */
public interface ComputeEngine {
    /**
     * Initializes a job with the given request.
     *
     * @param request The job request.
     * @return A string indicating the status of initialization.
     */
    String initializeJob(ComputeJobRequest request);

    /**
     * Executes the job with the given request.
     *
     * @param request The job request.
     * @return A string indicating the status of execution.
     */
    String executeJob(ComputeJobRequest request);
}
