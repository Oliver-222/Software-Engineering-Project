package factorapi;

import jobrequests.ComputeJobRequest; 

public interface ComputeEngine {
    String initializeJob(ComputeJobRequest request);
    String executeJob(ComputeJobRequest request);
}
