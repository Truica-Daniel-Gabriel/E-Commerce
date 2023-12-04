package ro.devdepot.model;


public enum UserRole {
    ADMIN("admin"),
    USER("user");

    private final String name;
    UserRole(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
}
