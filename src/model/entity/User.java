package model.entity;

// SRP: User class only handles guest/user data
public class User {
    private String userId;
    private String name;
    private String email;
    private String password;
    private String phone;

    public User(String userId, String name, String email, String password, String phone) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public String getUserId() { return userId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getPhone() { return phone; }

    @Override
    public String toString() {
        return "Guest[" + userId + "] " + name + " (" + email + ")";
    }
}
