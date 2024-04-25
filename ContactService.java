/* *************************
 * CS 320 Project One      *
 * 						   *
 * Name: Corey Sampson	   *
 * 						   *
 * Professor: Dr. Kraya	   *
 * 						   *
 * Date: April 8th, 2024   *
 * 						   *
 * ************************* */

package main;

import java.util.ArrayList;	// Used for storing contact data in an arraylist

public class ContactService {
	
	// Variables for object creation in ContactService Class
	public static String contactId;
	public String contactFirstName;
	public String contactLastName;
	public String contactPhone;
	public String contactAddress;
	
	// ArrayList creation to store contact data
	public static ArrayList<Contact> contactList = new ArrayList<Contact>(0);
	
	// Creates unique ID per contact
	public static String newUniqueId() {
		// Placeholder
		String uniqueId;
		// Starts with 10 digit ID if list is empty
		if (contactList.isEmpty()) {
			contactId = "1000000001";
		// Get highest/newest value in ArrayList if not empty
		} else {
			int arraySize = contactList.size();
			contactId = contactList.get(arraySize - 1).getId();
		}
		// Converts string to int for creation of next value
		int temp = Integer.valueOf(contactId);
		// Add 1 to next value to determine uniqueness 
		temp += 1;
		// Convert back from int to string for storing
		uniqueId = Integer.toString(temp);
		return uniqueId;
	}
	
	// Creation of a Contact object to add to ArrayList
	public static void addContact(String fName, String lName, String phone, String address) {
		String ID = newUniqueId();
		Contact Contact1 = new Contact(ID, fName, lName, phone, address);
		contactList.add(Contact1);
	}
	
	// Add a contact for testing
	public static void addContact(Contact newContact) {
		String tempId = newContact.getId();
		for (int i = 0; i < contactList.size(); i++) {
			if (tempId.equals(contactList.get(i).getId())) {
				throw new IllegalArgumentException("The contact ID must be unique.");
			}
		}
		contactList.add(newContact);
	}
	
	// Updater method for First Name
	public static void updateFirstName(String uniqueId, String contactFirstName) {
		for (int i = 0; i < contactList.size(); i++) {
			if (uniqueId.compareTo(contactList.get(i).getId()) == 0) {
				contactList.get(i).setFirstName(contactFirstName);
			}
		}
	}
	
	// Updater method for Last Name
	public static void updateLastName(String uniqueId, String contactLastName) {
		for (int i = 0; i < contactList.size(); i++) {
			if (uniqueId.compareTo(contactList.get(i).getId()) == 0) {
				contactList.get(i).setLastName(contactLastName);
			}
		}
	}
	
	// Updater method for Phone Number
	public static void updatePhone(String uniqueId, String contactPhone) {
		for (int i = 0; i < contactList.size(); i++) {
			if (uniqueId.compareTo(contactList.get(i).getId()) == 0) {
				contactList.get(i).setPhone(contactPhone);
			}
		}
	}
	
	// Updater method for Address
	public static void updateAddress(String uniqueId, String contactAddress) {
		for (int i = 0; i < contactList.size(); i++) {
			if (uniqueId.compareTo(contactList.get(i).getId()) == 0) {
				contactList.get(i).setAddress(contactAddress);
			}
		}
	}
	
	// Delete method for deleting a contact via ID
	public static void deleteContact(String uniqueId) {
		for (int i = 0; i < contactList.size(); i++) {
			if (uniqueId.compareTo(contactList.get(i).getId()) == 0) {
				int pos = i;
				// Removes/deletes contact from List
				contactList.remove(pos);
			}
		}
	}
	
	// Search function for testing
	public static int searchContacts(String uniqueId) {
		int result = 0;
		for (int i = 0; i < contactList.size(); ++i) {
			if (uniqueId.compareTo(contactList.get(i).getId()) == 0) {
				result = 1;
			} else {
				result = 2;
			}
		}
		 return result;
	}
	
	// Indexing method for testing
	public static int findIndex(String uniqueId) {
		int result = 0;
		for (int i = 0; i < contactList.size(); i++) {
			if (uniqueId.compareTo(contactList.get(i).getId()) == 0) {
				result = i;
			}
		}
		return result;
	}
}