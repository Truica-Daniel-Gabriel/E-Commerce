package ro.devdepot.model;


public enum UserRole {
    ADMIN("admin"),
    USER("user");

    private String name;
    private String roleImageUrl;

    UserRole(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
}
