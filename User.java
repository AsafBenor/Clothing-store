package Softwareengeeniring_finalproject;
public class User implements UserInterface{
	private String username;
	private String password;
	private String email;
	private String address;
	private boolean manager;
	
	//Constructor:
	public User()
	{}
	
	
	public User(String username, String password, String email, String address, boolean manager) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
		this.manager = manager;
	}
	
	//Setters:
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setAddress(String address) {
		this.address =address;
	}
	
	public void setManager() {
		this.manager = true;
	}
	
	
	//Getters:
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public boolean IsManager() {
		return this.manager;
	}
	
	
	//ToString override:
	public String toString() {
		return "Username: " + this.username + "\tPassword: " + this.password + "\tEmail: " + this.email+ "\tAddress: " + this.address;
	}
	
	//Compare users
	public boolean CompareTo(Object other) {
		if (!(other instanceof User))
			return false;
		User u = (User)other;
		return this.username.equals(u.getUsername()) 
				&& this.password.equals(u.getPassword())
					&& this.email.equals(u.getEmail())
						&& this.address.equals(u.getAddress());
	}
	
	
	
	
}