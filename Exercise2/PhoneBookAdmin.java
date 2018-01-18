//PhoneBookAdmin that inherits from User and implements from interface admin
public class PhoneBookAdmin extends User implements admin{
	//emailAddress variable is declared
	public String emailAddress;
	
	//constructor
	public PhoneBookAdmin(String a, String b, PhoneBookDirectory directory, String d) {
		super(a,b,directory);
		this.emailAddress=d;
	}

	//overriden method to print all attributes of admin
	@Override 
	public void PrintUserInfo() {
		System.out.println("Username: " + username + " Password: " + password + " Email: " + emailAddress);
	}
	
	
	//method to add a PhoneBookEntry from directory (object instantiated from PhoneBookDirectory)
	public void Add(int a, String b, String c, String d, int e, String f) {
		PhoneBookEntry newEntry = new PhoneBookEntry(a,b,c,d,e,f);
		System.out.println(directory.addEntry(newEntry));

	}
	
	//method to edit a PhoneBookEntry from directory (object instantiated from PhoneBookDirectory)
	public void EditEntry (String a, String b) {
		System.out.println(directory.Edit(a,b));

	}
	
	//method to Delete a PhoneBookEntry from directory (object instantiated from PhoneBookDirectory)
	public void Delete(int i) {
		System.out.println(directory.DeleteEntry(i));

	}
	
	//method to sort directory (object instantiated from PhoneBookDirectory)
	public void Sort() {
		directory.SelectionSort();	
	}
	
	//method to linearly search through directory (object instantiated from PhoneBookDirectory)
	public void Linear(String a) {
		System.out.println(directory.LinearSearchByPhoneNumber(a));

	}
	
	//method to search using binary sort through directory (object instantiated from PhoneBookDirectory)
	public void Binary(int a) {
		System.out.println(directory.searchbyIdBinarySearch(a));
	}
	
	//method to print all entries from directory
	public void print() {
		directory.printEntries();
	}
}
