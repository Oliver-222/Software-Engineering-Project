package com.example.computeapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for handling compute job requests.
 */
@RestController
@RequestMapping("/api/compute-job")
public class ComputeJobController {

    /**
     * Handles the compute job request based on the action specified in the request.
     *
     * @param request The request containing job details including the action to be performed.
     * @return Response with the result of the computation or initialization.
     */
    @PostMapping
    public ResponseEntity<ComputeJobResponse> handleComputeJob(@RequestBody ComputeJobRequest request) {
        if ("initialize".equalsIgnoreCase(request.getAction())) {
            // TODO: Implement logic to initialize the job.
            return ResponseEntity.ok(new ComputeJobResponse("initialized", null));
        } else if ("compute".equalsIgnoreCase(request.getAction())) {
            // TODO: Implement logic to perform computation.
            String result = "computed result"; // Replace with actual computed result.
            return ResponseEntity.ok(new ComputeJobResponse("success", result));
        } else {
            return ResponseEntity.badRequest().body(new ComputeJobResponse("error", "Invalid action"));
        }
    }

    /**
     * Request object for a compute job.
     */
    public static class ComputeJobRequest {
        private String jobId;
        private String action;
        private String inputData;

        // Getters and setters

        public String getJobId() {
            return jobId;
        }

        public void setJobId(String jobId) {
            this.jobId = jobId;
        }

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

        public String getInputData() {
            return inputData;
        }

        public void setInputData(String inputData) {
            this.inputData = inputData;
        }
    }

    /**
     * Response object for a compute job.
     */
    public static class ComputeJobResponse {
        private String status;
        private String result;

        public ComputeJobResponse(String status, String result) {
            this.status = status;
            this.result = result;
        }

        // Getters and setters

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }
    }
}


        public String getResult() { return result; }
        public void setResult(String result) { this.result = result; }
    }
}
