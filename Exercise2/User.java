//User class
public class User {
	//create variables that are shared by PhoneBookAdmin and NormalUser
	public String username;
	public String password;
	PhoneBookDirectory directory;
	
	
	//constructors
	//default
	public User() {
		
	}
	//constructor that takes username and password
	public User (String u, String p) {
		this.username = u;
		this.password = p;
	}
	
	//constructor that takes username, password and directory
	public User(String u, String p, PhoneBookDirectory a) {
		this.username = u;
		this.password = p;
		this.directory = a;
	}
	
	
	//PrintUserInfo 
	public void PrintUserInfo() {
		System.out.println("Username: " + username + " Password: " + password);
	}
	
	//getter for password
	public String getPassword() {
		return password;
	}
	
	//setter for password
	public void SetPassword(String p) {
		this.password = p;
	}
	
	//getter for username
	public String getUsername() {
		return username;
	}
	
	//setter for username
	public void SetUsername(String U) {
		this.username = U;
	}
	//prints entries
	public void print() {
		directory.printEntries();
	}
}
