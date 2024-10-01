package factorapi;
public enum ComputeResult {
    SUCCESS(true), FAILURE(false);
    private boolean isSuccess;

    private ComputeResult(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public boolean isSuccess() {
        return isSuccess;
    }
}

