package Softwareengeeniring_finalproject;
import java.util.ArrayList; // Import the ArrayList class
import java.util.Iterator; // Import  the Iterator class

public class Users{
	private static ArrayList<User> accList;
	
	//Constructor:
	public Users() {
		this.accList = new ArrayList<User>();
	}
	
	//Setters:
	public void setAccList(ArrayList<User> accList) {
		this.accList = accList;
	}
	
	//Getters:
	public ArrayList<User> getAccList() {
		return accList;
	}
	
	//Add User:
	public void addUser(User u) {
		//Iterator<User> itr = accList.iterator();
	//	while(itr.hasNext()) {
		//	if(itr.next().getUsername().equals(u.getUsername()) || itr.next().getEmail().equals(u.getEmail())) {
			//	System.out.println("Cant add user, Username or Email already exists");
			//	return;
			//}
		//}
		accList.add(u);
	}
	
	public boolean isPasswordCorrect(String userName, String thePassword) {
	    User user = searchUser(userName);
	        return user.getPassword().equals(thePassword);
	    }

	
	//Remove User:
	public void removeUser(String username) {
		Iterator<User> itr = this.accList.iterator();
		while (itr.hasNext()) {
			if (itr.next().getUsername().equals(username)) {
				itr.remove();
				System.out.println("User " + username + " has been deleted");
				return;
			}
		}
		System.out.println("User was not found");
	}
	
	//Print all users:
	public void printAllUsers() {
		Iterator<User> itr = this.accList.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next().toString());
		}
		System.out.println();
	}
	
	//Print user by Username:
	public void printUserByUsername(String username) {
		Iterator<User> itr = this.accList.iterator();
		boolean b = true;
		while (itr.hasNext()) {
			User u = itr.next();
			if (u.getUsername().equals(username)) {
				System.out.println(u.toString());
				b = false;
			}
		}
		if (b) {
			System.out.println("User was not found");
		}
	}
	
	//Search user by name:
	public  User searchUser(String username) {
		Iterator<User> itr = accList.iterator();
		String theUserName;
		User u = new User();
	    while (itr.hasNext()) {
			u = itr.next();
			theUserName=u.getUsername();
			if (username.trim().equals(theUserName.trim())) {
			    return u;
			}
		}
		return null;
	}

	//Is Email already Exists:
	public boolean IsEmailExists(String email) {
		Iterator<User> itr = this.accList.iterator();
		while (itr.hasNext()) {
			if (itr.next().getEmail().equals(email)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean IsUsernameExists(String username) {
		Iterator<User> itr = this.accList.iterator();
		while (itr.hasNext()) {
			if (itr.next().getUsername().equals(username)) {
				return true;
			}
		}
		return false;
	}
}	

