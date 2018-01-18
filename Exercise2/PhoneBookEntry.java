//create public class called PhoneBookEntry 
//with variables ID, fName, lName, email, zipCode and phoneNumber
public class PhoneBookEntry {
	//setting ID to -1 by default
	public int ID = -1;
	public String fName;
	public String lName;
	public String email;
	public int zipCode;
	public String phoneNumber;
	
	//default constructor 
	public PhoneBookEntry() {
		
	}
	
	//constructor that takes just fName
	public PhoneBookEntry(String a) {
		this.fName = a;
	}
	
	
	//constructor that takes just 
	public PhoneBookEntry(int a, String b, String c, String d, int e, String f) {
		this.ID = a;
		this.fName = b;
		this.lName = c;
		this.email = d;
		this.zipCode = e;
		this.phoneNumber = f;
	}
	
	
	//constructor that take fName and phoneNumber
	public PhoneBookEntry(String name, String number) {
		this.fName = name;
		this.phoneNumber = number;
	}
	
	
	//setter for ID
	public void setID (int id) {
		this.ID = id;
	}
	
	
	//getter for ID
	public int getId() {
		return this.ID;
	}
	
	//setter for fName
	public void setFName (String name) {
		this.fName = name;
	}
	
	//getter for fName
	public String getFName() {
		return this.fName;
	}
	
	//setter for lName
	public void setLName (String name) {
		this.lName = name;
	}
	
	//getter for lName
	public String getLName() {
		return this.lName;
	}
	
	
	//setter for email
	public void setEmail (String name) {
		this.email = name;
	}
	
	
	//getter for email
	public String getEmail() {
		return this.email;
	}
	
	
	//setter for zipCode
	public void setZipCode (int zipCode) {
		this.zipCode = zipCode;
	}
	
	//getter for zipCode
	public int getZipCode() {
		return this.zipCode;
	}
	
	//setter for phoneNumber
	public void setNumber (String number) {
		this.phoneNumber = number;
	}
	
	
	//getter for phoneNumber
	public String getNumber() {
		return this.phoneNumber;
	}
	
	
	//method to return parameters of instances of object
	public void printBookEntry () {
		System.out.println(fName + " " + lName +" " + email + " "+ phoneNumber + " " + ID); 
	}
	//method to return instances of object in string format
	public String toString() {
		return fName + " " + lName +" " + email + " " + phoneNumber + " " + ID;
	}
}
