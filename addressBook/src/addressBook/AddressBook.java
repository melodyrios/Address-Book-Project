package addressBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class AddressBook {
	
	private List<Entry> entries;
	
	public AddressBook() {
		this.entries = new ArrayList<>();
	}

	public boolean addEntry(Entry entry) {
		if(this.entries.contains(entry)) {
			System.out.println("Another entry already present with same email address");
			return false;
		}
		this.entries.add(entry);
		System.out.println("Entry added successfully");
		return true;
	}
	
	public boolean removeEntry(String email) {
		int index = getEntryIndexByEmail(email);
		
		if(index == -1) {
			System.out.println("No entry found with given email");
			return false;
		}
		this.entries.remove(index);
		System.out.println("Entry deleted successfully");
		return true;
	}
	
	public int getEntryIndexByEmail(String email) {
		for(int i = 0; i < this.entries.size(); i++) {
			if(this.entries.get(i).getEmail().equals(email)) {
				return i;
			}
		}
		return -1;
	}
	
	public List<Entry> searchForEntry(String searchType, String searchQuery) {
		searchQuery = searchQuery.strip();
		if(searchType.equals("firstName")) {
			return searchByFirstName(searchQuery);
		} else if(searchType.equals("lastName")) {
			return searchByLastName(searchQuery);
		} else if(searchType.equals("phoneNumber")) {
			return searchByPhoneNumber(searchQuery);
		} else {
			return searchByEmail(searchQuery);
		}
	}

	private List<Entry> searchByFirstName(String firstName) {
		List<Entry> fname = new ArrayList<>();
		for(Entry entry : this.entries) {
			if(entry.getFirstName().contains(firstName)) {
				fname.add(entry);
			}
		}
		return fname;
	}
	
	private List<Entry> searchByLastName(String lastName) {
		List<Entry> lname = new ArrayList<>();
		for(Entry entry : this.entries) {
			if(entry.getLastName().contains(lastName)) {
				lname.add(entry);
			}
		}
		return lname;
	}
	
	private List<Entry> searchByPhoneNumber(String phoneNumber) {
		List<Entry> pNumber = new ArrayList<>();
		for(Entry entry : this.entries) {
			if(entry.getPhoneNumber().contains(phoneNumber)) {
				pNumber.add(entry);
			}
		}
		return pNumber;
	}
	
	private List<Entry> searchByEmail(String email) {
		for(Entry entry : this.entries) {
			if(entry.getEmail().contains(email)) {
				return Arrays.asList(entry);
			}
		}
		return new ArrayList<>();
	}
	
	public void printAddressBook() {
		if(this.entries.size() == 0)
			System.out.println("Address book is empty.");
		else {
			System.out.println("Printing entries in Address Book:");
			System.out.println(this.toString());
		}
		System.out.println();
	}
	
	public void deleteAddressBook() {
		this.entries.clear();
		System.out.println("Address book deleted.");
	}
	
	@Override
	public String toString() {
		StringJoiner sj = new StringJoiner("\n");
		for(Entry entry : this.entries) {
			sj.add(entry.toString());
		}
		return sj.toString();
	}
	
	
}
