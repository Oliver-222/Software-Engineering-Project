package factorapi;

import java.util.Base64;


/**
 * Interface for the compute engine operations.
 */
public interface ComputeEngine {

    /**
     * Initializes a computation job.
     * @param request Compute job request.
     * @return Status of initialization.
     */
    String initializeJob(ComputeJobRequest request);

    /**
     * Executes the computation.
     * @param request Compute job request.
     * @return Result of the computation.
     */
    String executeJob(ComputeJobRequest request);
}
