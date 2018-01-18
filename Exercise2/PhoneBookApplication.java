//imported to read from a file
import java.io.*;
//import scanner
import java.util.Scanner;
//public class PhoneBookApplication
public class PhoneBookApplication {
	//main method
	public static void main (String[] args) {
		
		//READING FROM ADMINCREDENTIALS file to get attributes for PhoneBookAdmin object
		String fileName = "adminCredentials.txt";
		
		
		String line = null;
		
		//create array adminParameters that will store attributes for PhoneBookAdmin Object
		String [] adminParameters = new String[3];
		try {
			
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			while((line = bufferedReader.readLine())!=null)
			{
				//will split the file by commas and store each string as an element in adminParameters array
				adminParameters = line.split(",");
				
//				System.out.println(line);
				
			}
			
			bufferedReader.close();
		}
		catch(FileNotFoundException ex){
			
			System.out.println("file not found");
		}
		catch(IOException ex)
		{
			
			System.out.println("IO Exception");
			ex.printStackTrace();
			
		}
		
		
		
		
		//READING FROM userCredentials file to get attributes for PhoneBookAdmin object
		String fileName2 = "userCredentials.txt";
		
		
		String line2 = null;
		
		//create array userParameters that will store attributes for NormalUser Object
		String [] userParameters = new String[3];
		try {
			
			FileReader fileReader = new FileReader(fileName2);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			while((line2 = bufferedReader.readLine())!=null)
			{
				//will split the file by commas and store each string as an element in userParameters array
				userParameters = line2.split(",");
				
//				System.out.println(line);
				
			}
			
			bufferedReader.close();
		}
		catch(FileNotFoundException ex){
			
			System.out.println("file not found");
		}
		catch(IOException ex)
		{
			
			System.out.println("IO Exception");
			ex.printStackTrace();
			
		}
		
		
		
		
		//int counter to give users multiple tries if they enter credentials in incorrectly 
		//counter will count their tries
		int counter = 0;
		//int option will be used to determine the menu item the user collects
		int option = 0;
		//PhoneBookDirectory created will be used as parameter for object a which is instantiated from PhoneBookAdmin
		PhoneBookDirectory adminDirectory = new PhoneBookDirectory();
		//username and password come from file
		String adminUsername = adminParameters[0];
		String adminPassword = adminParameters[1];
		//PhoneBookAdmin a is instatiated
		PhoneBookAdmin a = new PhoneBookAdmin(adminUsername, adminPassword, adminDirectory, adminParameters[2] );
		//PhoneBookDirectory created will be used as parameter for object a which is instantiated from NormalUser
		PhoneBookDirectory regularUserDirectory = new PhoneBookDirectory();
		//username and password come from file
		String normalUserUsername = userParameters[1];
		String normalUserPassword = userParameters[2];
		//NormalUser b is instatiated
		NormalUser b = new NormalUser(1, normalUserUsername, normalUserPassword,  regularUserDirectory );
		
		
		//scanner initialized
		Scanner input = new Scanner(System.in);
		
		//while loop to ensure a person cant login with wrong credentials more than 3 times
		while (counter < 3) {
			//ask what kind of user and for username and password
		System.out.println("Login");
		
		
		System.out.println("Are you an admin or a regular user? ");
		String typeOfUser = input.nextLine();
		System.out.println("Enter username ");
		String username = input.nextLine();
		System.out.println("Enter password ");
		String password = input.nextLine();
		
		//logic if user is admin and their credentials are correct
		if (typeOfUser.equalsIgnoreCase("admin") && username.equalsIgnoreCase(adminUsername) && password.equalsIgnoreCase(adminPassword)) {
			System.out.println("Welcome");
			//to keep track of how many entries a user adds
			int directoryLength = 1;	
			//print options
		while (option != 10) {
				System.out.println("Enter the Appropriate number to continue");
				System.out.println("1.Add Phone Entry \n "
						+ "2. Edit a phone entry of a given first name"
						+ "\n 3. Delete a phone entry of a given first name"
						+ "\n 4. Sort the PhoneBookDirectory"
						+ "\n 5. Search using Linear Search"
						+ "\n 6. Search using Binary Search"
						+ "\n 7. Print your information"
						+ "\n 8. Change password"
						+ "\n 9. Change Username"
						+ "\n 10. Exit");
				option = input.nextInt();
				input.nextLine();  
				
				
				//will ask for parameters of the entry then declare method "Add" if the amount of entries added has
				//not exceeded 6
				if (option == 1) {
					if (directoryLength <= 6) {
						System.out.println("Enter id");
						int ID = input.nextInt();
						input.nextLine();  
						System.out.println("Enter a first name ");
						String firstName = input.nextLine();
						System.out.println("Enter a zipcode ");
						int zipcode = input.nextInt();
						System.out.println("Enter an email ");
						String email = input.nextLine();
						input.nextLine();  
						System.out.println("Enter a phone number ");
						String number = input.nextLine();
						System.out.println("Enter a last name ");
						String lastName = input.nextLine();
						
						a.Add(ID,firstName, lastName, email,zipcode, number); 
						directoryLength += 1;
						System.out.println("Contact added");
					}
					else {
						System.out.println("already max amount of entires in directory");
					}
				}
				
				//will ask for first and last name then use those as parameters for methods declared
				//declare method EditEntry
				else if (option == 2) {
					System.out.println("Enter a first name ");
					String firstName = input.nextLine();
					System.out.println("Enter a last name ");
					String lastName = input.nextLine();
					a.EditEntry(firstName, lastName);					
				}	
				//will ask for id
				//will declare Delete method using id as a parameter
				else if (option == 3) {
					System.out.println("Enter id ");
					int ID = input.nextInt();
					input.nextLine(); 
					a.Delete(ID);
				}
				//sort entries
				else if (option ==4) {
					a.Sort();
				}
				//ask for phone number then declare method Linear to linearly search for it
				else if (option == 5) {
					System.out.println("Enter a phone number you would like to search for ");
					String number = input.nextLine();
					System.out.println(number);
					a.Linear(number);
				}
				//use binary search when declaring method Binary using
				//entered ID as a parameter
				else if (option == 6) {
					System.out.println("Enter the id you would like to search for");
					int ID = input.nextInt();
					input.nextLine(); 
					a.Binary(ID);
				}
				
				//print admins credentials
				else if (option == 7) {
					a.PrintUserInfo();
				}
				
				//change password
				else if (option == 8) {
					System.out.println("what do you want to change your password to");
					String newPassword = input.nextLine();
					a.SetPassword(newPassword);
				}
				//change username
				else if (option == 9) {
					System.out.println("what do you want to change your username to");
					String newUsername = input.nextLine(); 
					a.SetUsername(newUsername);
				}
				
//				else if (option == 11) {
//					a.print();
//				}
//				
//				else if (option == 12) {
//					System.out.println(a.getPassword());
//					System.out.println(a.getUsername());
//				}
				
				//if exit is selected this will print
				else if (option == 10) {
					System.out.println("Goodbye");
				}
				
				//invalid option will print is user enters something besides 1-10
				else {
					System.out.println("invalid option");
				}
				

		}
		
		
	}	
		
		//logic if user is a regular user and has the right credentials
		else if (typeOfUser.equalsIgnoreCase("regular user") && username.equalsIgnoreCase(normalUserUsername) && password.equalsIgnoreCase(normalUserPassword)) {
			int directoryLength = 1;
			while (option != 6) {	
				System.out.println("Enter the Appropriate number to continue");
				System.out.println("1.Add Phone Entry \n "
						+ "2. Edit a phone entry of a given first name"
						+ "\n 3. Sort the PhoneBookDirectory"
						+ "\n 4. Search using Linear Search"
						+ "\n 5. Print your information"
						+ "\n 6. Exit");
				option = input.nextInt();	
				input.nextLine();
				//will ask for parameters of the entry then declare method "Add" if the amount of entries added has
				//not exceeded 6
				if (option == 1) {
					if (directoryLength <= 6) {
						System.out.println("Enter id");
						int ID = input.nextInt();
						input.nextLine();  
						System.out.println("Enter a first name ");
						String firstName = input.nextLine();
						System.out.println("Enter a zipcode ");
						int zipcode = input.nextInt();
						System.out.println("Enter an email ");
						String email = input.nextLine();
						input.nextLine();  
						System.out.println("Enter a phone number ");
						String number = input.nextLine();
						System.out.println("Enter a last name ");
						String lastName = input.nextLine();
						
						b.Add(ID,firstName, lastName, email,zipcode, number); 
						System.out.println("contact added");
						directoryLength += 1;
					}
					else {
						System.out.println("already max amount of entires in directory");
					}
				}
				
				
				//Edit entry based on first and last name entered
				else if (option == 2) {
					System.out.println("Enter a first name ");
					String firstName = input.nextLine();
					System.out.println("Enter a last name ");
					String lastName = input.nextLine();
					b.EditEntry(firstName, lastName);					

				}		
				
				//sort array
				else if (option == 3) {
					b.Sort();
				}
				
				//ask for phone number then declare method Linear to linearly search for it
				else if (option == 4) {
					System.out.println("Enter a phone number you would like to search for ");
					String number = input.nextLine();
					System.out.println(number);
					b.Linear(number);
				}
				
				//print admins credentials
				else if (option == 5) {
					b.PrintUserInfo();
				}
				
//				else if (option == 11) {
//					b.print();
//				}
//				
//				else if (option == 12) {
//					System.out.println(a.getPassword());
//					System.out.println(a.getUsername());
//				}
//				
				else if (option == 6) {
					System.out.println("Goodbye");
				}
				else {
					System.out.println("invalid option");
				}
				
			}
		}
		
		//if user has wrong credentials this will print
		else {
			System.out.println("Wrong credentials");
			//counter increases to lock them out after three tries
			counter += 1;
		}
		}
		
		
		
		
		
		
		
		
		//close scanner
		input.close();
	}
		
}
