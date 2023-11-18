package ro.devdepot.model;


public enum UserRole {
    ADMIN("admin","url"),
    USER("user","url");

    private String name;
    private String roleImageUrl;

    UserRole(String name, String roleImageUrl) {
        this.name = name;
        this.roleImageUrl = roleImageUrl;
    }
    public String getName() {
        return this.name;
    }
    public String getRoleImageUrl() {
        return this.roleImageUrl;
    }
}
