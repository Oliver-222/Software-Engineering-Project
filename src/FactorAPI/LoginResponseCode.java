package factorapi;
public enum LoginResponseCode {
    SUCCESS(1, true),
    WRONG_PASSWORD(3, false),
    UNKNOWN_USER(4, false),
    FAILURE(2, false);

    private final int id;
    private final boolean success;

    private LoginResponseCode(int id, boolean success) {
        this.id = id;
        this.success = success;
    }

    public int getId() {
        return id;
    }

    public boolean success() {
        return success;
    }
}