package addressBook;

import java.util.List;
import java.util.Scanner;

public class Program {
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		AddressBook addressBook = new AddressBook();
		
		boolean programRunning = true;
		
		while(programRunning) {
			System.out.println("\nPlease choose what you'd like to do with the database:");
			System.out.println("1) Add an entry");
			System.out.println("2) Remove an entry");
			System.out.println("3) Search for an entry");
			System.out.println("4) Print address book");
			System.out.println("5) Delete book");
			System.out.println("6) Quit");
			
			String choice = scanner.nextLine();
			
			switch(choice) {
			case "1":
				Entry newEntry = new Entry();
				System.out.println("Enter first Name: ");
				String firstName = scanner.nextLine();
				newEntry.setFirstName(firstName);
				
				System.out.println("Enter last name: ");
				String lastName = scanner.nextLine();
				newEntry.setLastName(lastName);
				
				System.out.println("Enter phone number: ");
				String phoneNumber = scanner.nextLine();
				newEntry.setPhoneNumber(phoneNumber);
				
				System.out.println("Enter email address: ");
				String email = scanner.nextLine();
				newEntry.setEmail(email);
				
				addressBook.addEntry(newEntry);
				break;
			case "2":
				System.out.println("Enter contact email address to remove from address book.");
				String searchByEmail = scanner.nextLine();
				addressBook.removeEntry(searchByEmail);
				break;
			case "3":
				System.out.println("How do you want to search for an entry? (Choose number)");
				System.out.println("1) First Name");
				System.out.println("2) Last Name");
				System.out.println("3) Phone Number");
				System.out.println("4) Email Address");
				String search = scanner.nextLine();
					switch(search) {
					case "1":
						System.out.println("Enter first name: ");
						String searchFirstName = scanner.nextLine();
						addressBook.searchByFirstName(searchFirstName);
						break;
					case "2":
						System.out.println("Enter last name: ");
						String searchLastName = scanner.nextLine();
						addressBook.searchByLastName(searchLastName);
						break;
					case "3":
						System.out.println("Enter phone number: ");
						String searchPhoneNumber = scanner.nextLine();
						addressBook.searchByPhoneNumber(searchPhoneNumber);
						break;
					case "4":
						System.out.println("Enter email address: ");
						String searchEmail = scanner.nextLine();
						addressBook.searchByEmail(searchEmail);
						break;
					default:
						System.out.println("Invalid selection");
					}

				break;
			case "4":
				addressBook.printAddressBook();
				break;
			case "5":
				addressBook.deleteAddressBook();
				break;
			case "6":
				System.out.println("Exiting program.");
				programRunning = false;
				break;
			}

		}
		
	}




}
