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

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import main.Contact;
import main.ContactService;

class ContactServiceTest {
	
	// Creates a contact and test values using a unique ID via ContactService's addContact method
	@Test
	void testAddContactService() {
		ContactService.addContact("Corey", "Sampson", "5555555555", "123 Main Street");
		assertTrue(ContactService.contactList.get(0).getId().equals("1000000002"));
		assertTrue(ContactService.contactList.get(0).getFirstName().equals("Corey"));
		assertTrue(ContactService.contactList.get(0).getLastName().equals("Sampson"));
		assertTrue(ContactService.contactList.get(0).getPhone().equals("5555555555"));
		assertTrue(ContactService.contactList.get(0).getAddress().equals("123 Main Street"));
	}
	
	// Test for deletion of contact
	@Test
	void testDeleteContactService() {
		ContactService.addContact("Corey", "Sampson", "5555555555", "123 Main Street");
		ContactService.deleteContact("1000000003");
		assertTrue(ContactService.searchContacts("1000000003") == 2);
	}
	
	// Tests for ability to update First Name
	@Test
	void testContactServiceUpdateFirstName() {
		ContactService.addContact("Nick", "Chubb", "5556667777", "123 Cleveland Blvd");
		int size = ContactService.contactList.size();
		ContactService.updateFirstName("1000000002", "Corey");
		assertTrue(ContactService.contactList.get(size - 1).getFirstName().equals("Corey"));
	}
	
	// Test for ability to update Last Name (Following tests use ID "1000000002" for testing
	@Test
	void testContactServiceUpdateLastName() {
		int size = ContactService.contactList.size();
		ContactService.updateLastName("1000000002", "Sampson");
		assertTrue(ContactService.contactList.get(size - 1).getLastName().equals("Sampson"));
	}
	
	// Test for ability to update Phone Number
	@Test
	void testContactServiceUpdatePhone() {
		int target = 0;
		target = ContactService.findIndex("1000000002");
		ContactService.updatePhone("1000000002", "5555555555");
		assertTrue(ContactService.contactList.get(target).getPhone().equals("5555555555"));
	}
	
	// Test for ability to update Address
	@Test
	void testContactServiceUpdateAddress() {
		int target = 0;
		target = ContactService.findIndex("1000000002");
		ContactService.updateAddress("1000000002", "123 Main Street");
		assertTrue(ContactService.contactList.get(target).getAddress().equals("123 Main Street"));
	}
	
	// Test confirming unique ID generation
	@Test
	void testContactServiceUniqueId() {
		Contact newContact = new Contact("0987654321", "Yeroc", "Nospmas", "7776665555", "321 Front Street");
		ContactService.addContact(newContact);
		Contact dupeId = new Contact("0987654321", "Yeroc", "Nospmas", "7776665555", "123 Front Street");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService.addContact(dupeId);
		});
	}
}