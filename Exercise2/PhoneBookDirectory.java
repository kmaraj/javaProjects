//import scanner
import java.util.Scanner;
//create public class called PhoneBookDirectory
//this class and the PhoneBookEntry class have an object composition relationship
public class PhoneBookDirectory {
	//create an array of type PhoneBookEntry of size 6
	PhoneBookEntry [] numbers = new PhoneBookEntry[6];
	//counter variable to keep track of how many entries are defined in numbers array
	public int count = 0;


		
	//default constructor
	public PhoneBookDirectory() {

	}

	//method to return how many entries were defined "added"
	public int getLength() {
		return count;
	}

	//return the array
	public PhoneBookEntry[] getArray() {
		return numbers;
	}

	//method to add an entry
	public int addEntry(PhoneBookEntry entry) {
		
		//will not add an entry if 6 have already been defined, meaning array is full
		if (count < 6) {
			numbers[count] = entry;
			//increment count by 1
			count += 1;
			return 1;
		}
		//will return 0 if array is full
		else {
			return 0;
		}



	}

	//method to print attributes of every entry in PhoneBookDirectory
	public void printEntries() {
		for (int i = 0; i < count; i++) {
			System.out.println(i +": " + " Name:" + numbers[i].getFName() + " " + numbers[i].getLName() + " ID:" + numbers[i].getId()  + " Phone Number:" + numbers[i].getNumber());
		}
	}

	//LinearSearch method by phoneNumber
	public int LinearSearchByPhoneNumber(String PhoneNumber) {
		//if entered PhoneNumber matches any of the phoneNumber attributes in array
		for (int i = 0; i < count; i++) {	
			if (PhoneNumber.equals(numbers[i].getNumber())) {
				System.out.println("contact found");
				return 1;
			}
		}
		//else will return 
		System.out.println("contact not found");
		return 0;
	}

	//method to search the array by id through BinarySearch
	public PhoneBookEntry searchbyIdBinarySearch (int id) {
		PhoneBookEntry a = new PhoneBookEntry(0, null, null, null, 0, null);

		int min = 0;
		int max = count-1;

		while(max>=min) {

			int mid = (max+min)/2;

			if(id < numbers[mid].getId()) {
				max=mid-1;
			}
			else if (id == numbers[mid].getId()) {
				//if id is found will return that instance of PhoneBook Entry
				return numbers[mid];
			}
			else {
				min = mid +1;
			}	
		}


		//otherwise will return null PhoneBookEntry
		return a;

	}

	//SelectionSort to sort array
	public void SelectionSort () {
		//finds smallest element by their id attribute and swaps all attributes with the leftmost unsorted element
		for (int i = 0; i <count-1; i++) {
			int currentMin = numbers[i].getId();
			int currentMinIndex = i;
			String currentMinEmail = numbers[i].getFName() ;
			String currentMinLastName = numbers[i].getLName();
			String currentMinFirstName = numbers[i].getFName();
			int currentZipCode = numbers[i].getZipCode();
			String currentPhoneNumber = numbers[i].getNumber();
			for (int j = i + 1; j < count; j++) {
				if (currentMin > numbers[j].getId()) {
					currentMin = numbers[j].getId();
					currentMinFirstName = numbers[j].getFName();
					currentMinLastName = numbers[j].getLName();
					currentMinEmail = numbers[j].getEmail();
					currentZipCode = numbers[j].getZipCode();
					currentPhoneNumber = numbers[j].getNumber();
					currentMinIndex = j;

				}
			}

			if (currentMinIndex != i) { 
				//changing each attribute, to create effect of swapping
				numbers[currentMinIndex].setID(numbers[i].getId());
				numbers[currentMinIndex].setFName(numbers[i].getFName());
				numbers[currentMinIndex].setLName(numbers[i].getLName());
				numbers[currentMinIndex].setEmail(numbers[i].getEmail());
				numbers[currentMinIndex].setZipCode(numbers[i].getZipCode());
				numbers[currentMinIndex].setNumber(numbers[i].getNumber());
				numbers[i].setID(currentMin);
				numbers[i].setFName(currentMinFirstName);
				numbers[i].setID(currentMin);
				numbers[i].setFName(currentMinFirstName);
				numbers[i].setNumber(currentPhoneNumber);
				numbers[i].setLName(currentMinLastName);
				numbers[i].setZipCode(currentZipCode);
				numbers[i].setEmail(currentMinEmail);
			}
		}
		//will return new sorted directory
		//by calling printEntries method which is defined above
		printEntries();
	}	




	//initialize scanner
	Scanner input = new Scanner(System.in);
	//Edit method that takes a first and last name as parameters
	public int Edit (String firstName, String lastName) {
		//will sort through array to find the entry with the same first and last name
		for (int i = 0; i < count; i++) {
			if (numbers[i].getFName().equalsIgnoreCase(firstName) && numbers[i].getLName().equalsIgnoreCase(lastName)) {
				//if it finds entry will ask which field you want to change and then changes it using scanner
				System.out.println("Which field would you like to edit? ");
				String field = input.nextLine();
				if(field.equalsIgnoreCase("First Name")) {
					System.out.println("What do you want to edit it to? ");
					String newFirstName = input.nextLine();
					numbers[i].setFName(newFirstName);					
				}				
				if(field.equalsIgnoreCase("Last Name")) {
					System.out.println("What do you want to edit it to? ");
					String newLastName = input.nextLine();
					numbers[i].setLName(newLastName);					
				}				
				if(field.equalsIgnoreCase("Email")) {
					System.out.println("What do you want to edit it to? ");
					String newEmail = input.nextLine();
					numbers[i].setEmail(newEmail);					
				}				
				if(field.equalsIgnoreCase("Zip Code")) {
					System.out.println("What do you want to edit it to? ");
					int newZipCode = input.nextInt();
					input.nextLine();
					numbers[i].setZipCode(newZipCode);					
				}				
				if(field.equalsIgnoreCase("Phone Number")) {
					System.out.println("What do you want to edit it to? ");
					String newNumber = input.nextLine();
					numbers[i].setNumber(newNumber);				
				}
				//return statements if it was able to edit
				System.out.println("Success");
				return 1;					
			}

		}
		//otherwise will print this
		System.out.println("Unable to edit");
		return 0;

	}
	//method to delete an entry taking id as a parameter
	public int DeleteEntry(int id) {
		//will change all attributes to null values if the id corresponds
		for (int i = 0; i<count; i++) {
			if (numbers[i].getId() == id) {				
				numbers[i].setFName(null);
				numbers[i].setEmail(null);
				numbers[i].setLName(null);
				numbers[i].setID(0);
				numbers[i].setNumber(null);
				count -= 1;
				//then shift elements of array to give effect of deleting
				for (int j = i; j<numbers.length; j++) {	
					numbers[i] = numbers[i+1];
				}
				//if success then will return
				System.out.println("Contact deleted");
				return 1;
			}
		}
		//otherwise returns
		System.out.println("Unable to delete");
		return 0;
	}




}

