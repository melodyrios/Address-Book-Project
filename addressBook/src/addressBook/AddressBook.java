package addressBook;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class AddressBook {
	
	private static List<Entry> entries;
	
	public AddressBook() {
		AddressBook.entries = new ArrayList<>();
	}

	
	public void addEntry(Entry entry) {
		entries.add(entry);
		System.out.println(entries);
		System.out.println("Entry added successfully!");
	}
	
	public boolean removeEntry(String email) {
		int index = getEntryIndexByEmail(email);
	
		if(index == -1) {
			System.out.println("No entry found with given email");
			return false;
		}
	
		System.out.println(entries.remove(index));
		System.out.println("Entry removed successfully!");
		return true;
	}
	
	
	
	public int getEntryIndexByEmail(String email) {
		for(int i = 0; i < entries.size(); i++) {
			if(entries.get(i).getEmail().equals(email)) {
				return i;
			}
		}
		return -1;
	}
	
	
	//search for entry
	//search options
	public void searchByFirstName(String firstName) {
		for(Entry entry : entries) {
			if(entry.getFirstName().contains(firstName)) {
				System.out.println(entry);
			}
		}
	}
	
	public void searchByLastName(String lastName) {
		for(Entry entry : entries) {
			if(entry.getLastName().contains(lastName)) {
				System.out.println(entry);
			}
		}
	}
	
	public void searchByPhoneNumber(String phoneNumber) {
		for(Entry entry : entries) {
			if(entry.getPhoneNumber().contains(phoneNumber)) {
				System.out.println(entry);
			}
		}
	}
	
	public void searchByEmail(String email) {
		for(Entry entry : entries) {
			if(entry.getEmail().contains(email)) {
				System.out.println(entry);
			}
		}
	}
	
	
	//print address book
	public void printAddressBook() {
		if(entries.size() == 0)
			System.out.println("Address book is empty.");
		else {
			System.out.println("Printing entries in Address Book:");
			System.out.println(this.toString());
		}
		System.out.println();
	}
	
	
	//delete address book
	public void deleteAddressBook() {
		entries.clear();
		System.out.println("Address book deleted.");
	}

	
	@Override
	public String toString() {
		StringJoiner sj = new StringJoiner("\n");
		for(Entry entry : entries) {
			sj.add(entry.toString());
		}
		return sj.toString();
	}
	
}
