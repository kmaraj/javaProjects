//NormalUser that inherits from User and implements from interface regular
public class NormalUser extends User implements regular{
	//id variable is declared
	public int id;
	
	//constructor
	public NormalUser(int a, String b, String c,PhoneBookDirectory d) {
		super(b,c,d);
		this.id=a;
	}
	
	//overriden method to print all attributes of NormalUser
	@Override 
	public void PrintUserInfo() {
		System.out.println("Username: " + username + " Password: " + password + " ID: " + id);
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
	
	//method to sort directory (object instantiated from PhoneBookDirectory)
	public void Sort() {
		directory.SelectionSort();	
	}
	
	//method to linearly search through directory (object instantiated from PhoneBookDirectory)
	public void Linear(String a) {
		System.out.println(directory.LinearSearchByPhoneNumber(a));
	}
		
	
}
