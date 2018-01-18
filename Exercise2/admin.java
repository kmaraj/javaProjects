//interface for PhoneBookAdmin
//contains all method signatures instatiated by PhoneBookAdmin
public interface admin {
	public void Binary(int a);
	public void Linear(String a);
	public void Sort();
	public void Delete(int i);
	public void EditEntry (String a, String b);
	public void Add(int a, String b, String c, String d, int e, String f);
	public void PrintUserInfo();
	public String getPassword();
	public void SetPassword(String p);
	public String getUsername();
	public void SetUsername(String U);

	
}
