package Softwareengeeniring_finalproject;

public interface UserInterface {
	// Setters
    void setUsername(String username);
    void setPassword(String password);
    void setEmail(String email);
    void setAddress(String address);
    void setManager();

    // Getters
    String getUsername();
    String getPassword();
    String getEmail();
    String getAddress();
    boolean IsManager();

    // Additional Methods
    boolean CompareTo(Object other);
}
