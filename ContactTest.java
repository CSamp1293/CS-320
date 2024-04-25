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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.Contact;

class ContactTest {
    
	/* Test for contact creation using less than max boundary
	 * ID = "12345" meets the requirement of less than 10 characters
	 * firstName = "Corey" meets the requirement of less than 10 characters
	 * lastName = "Sampson" meets the requirement of less than 10 characters
	 * phone = "5555555555" meets the requirement of being exactly 10 digits
	 * address = "123 Main Street" meets the requirement of being less than 30 characters
	 */
	@Test
	void testContactLessThanMax() {
		Contact newContact = new Contact("12345", "Corey", "Sampson", "5555555555", "123 Main Street");
		assertTrue(newContact.getId().equals("12345"));
		assertTrue(newContact.getFirstName().equals("Corey"));
		assertTrue(newContact.getLastName().equals("Sampson"));
		assertTrue(newContact.getPhone().equals("5555555555"));
		assertTrue(newContact.getAddress().equals("123 Main Street"));
	}
	
	/* Test for contact creation using max boundary
	 * ID = "1234567890" meets the requirement of equal to 10 characters
	 * firstName = "Coreeeeeey" meets the requirement of equal to 10 characters
	 * lastName = "Saaaampson" meets the requirement of equal to 10 characters
	 * phone = "5555555555" meets the requirement of being exactly 10 digits
	 * address = "ABC123 Cleveland Street, Akron" meets the requirement of being equal to 30 characters
	 */
	@Test
	void testContactMaxBoundary() {
		Contact newContact = new Contact("1234567890", "Coreeeeeey", "Saaaampson", "5555555555", "ABC123 Cleveland Street, Akron");
		assertTrue(newContact.getId().equals("1234567890"));
		assertTrue(newContact.getFirstName().equals("Coreeeeeey"));
		assertTrue(newContact.getLastName().equals("Saaaampson"));
		assertTrue(newContact.getPhone().equals("5555555555"));
		assertTrue(newContact.getAddress().equals("ABC123 Cleveland Street, Akron"));
	}
	
	// Test for contact ID exceeding 10 characters
	@Test
	void testContactIdLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678910", "Corey", "Sampson", "5555555555", "123 Main Street");
		});
	}
	
	// Test for contact ID being empty
	@Test 
	void testContactIdIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Corey", "Sampson", "5555555555", "123 Main Street");
		});
	}
	
	// Test for First Name exceeding 10 characters
	@Test
	void testContactFirstNameLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Corey Michael", "Sampson", "5555555555", "123 Main Street");
		});
	}
	
	// Test for First Name being empty
	@Test
	void testContactFirstNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", null, "Sampson", "5555555555", "123 Main Street");
		});
	}
	
	//Test for Last Name exceeding 10 characters
	@Test
	void testContactLastNameLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Corey", "Michael Sampson", "5555555555", "123 Main Street");
		});
	}
	
	// Test for Last Name being empty
	@Test
	void testContactLastNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Corey", null, "5555555555", "123 Main Street");
		});
	}
	
	// Test for Phone Number exceeding 10 characters (Phone Number must be exactly 10 digits)
	@Test
	void testContactPhoneLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Corey", "Sampson", "55555555555", "123 Main Street");
		});
	}
	
	// Test for Phone Number preceding 10 characters (Phone Number must be exactly 10 digits)
	@Test
	void testContactPhoneShort() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Corey", "Sampson", "555555555", "123 Main Street");
		});
	}
	
	// Test for Phone Number being empty
	@Test
	void testContactPhoneIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Corey", "Sampson", null, "123 Main Street");
		});
	}
	
	// Test for Address exceeding 30 characters
	@Test
	void testContactAddressLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Corey", "Sampson", "5555555555", "123 Main Street, Akron OH, 44332");
		});
	}
	
	// Test for Address being empty
	@Test
	void testContactAddressIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Corey", "Sampson", "5555555555", null);
		});
	}
	
	// Tests for First Name setter method
	@Test
	void testContactSetFirstName() {
		Contact contact = new Contact("12345", "Corey", "Sampson", "5555555555", "123 Main Street");
		contact.setFirstName("Coreeey");
		assertTrue(contact.getFirstName().equals("Coreeey"));
	}
	
	@Test
	void testContactSetFirstNameLong() {
		Contact contact = new Contact("12345", "Corey", "Sampson", "5555555555", "123 Main Street");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName("Coreeeeeeey");
		});
	}
	
	@Test
	void testContactSetFirstNameIsNull() {
		Contact contact = new Contact("12345", "Corey", "Sampson", "5555555555", "123 Main Street");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName(null);
		});
	}
	
	// Tests for Last Name setter method
	@Test
	void testContactSetLastName() {
		Contact contact = new Contact("12345", "Corey", "Sampson", "5555555555", "123 Main Street");
		contact.setLastName("Saaampson");
		assertTrue(contact.getLastName().equals("Saaampson"));
	}
	
	@Test
	void testContactSetLastNameLong() {
		Contact contact = new Contact("12345", "Corey", "Sampson", "5555555555", "123 Main Street");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setLastName("Saaaaampson");
		});
	}
	
	@Test
	void testContactSetLastNameIsNull() {
		Contact contact = new Contact("12345", "Corey", "Sampson", "5555555555", "123 Main Street");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setLastName(null);
		});
	}
	
	// Tests for Phone Number setter method
	@Test
	void testContactSetPhone() {
		Contact contact = new Contact("12345", "Corey", "Sampson", "5555555555", "123 Main Street");
		contact.setPhone("5556667777");
		assertTrue(contact.getPhone().equals("5556667777"));
	}
	
	@Test
	void testContactSetPhoneLong() {
		Contact contact = new Contact("12345", "Corey", "Sampson", "5555555555", "123 Main Street");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhone("555666777888");
		});
	}
	
	@Test
	void testContactSetPhoneShort() {
		Contact contact = new Contact("12345", "Corey", "Sampson", "5555555555", "123 Main Street");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhone("556677");
		});
	}
	
	@Test
	void testContactSetPhoneIsNull() {
		Contact contact = new Contact("12345", "Corey", "Sampson", "5555555555", "123 Main Street");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhone(null);
		});
	}
	
	// Tests for Address setter method
	@Test
	void testContactSetAddress() {
		Contact contact = new Contact("12345", "Corey", "Sampson", "5555555555", "123 Main Street");
		contact.setAddress("ABC123 Main Street");
		assertTrue(contact.getAddress().equals("ABC123 Main Street"));
	}
	
	@Test
	void testContactSetAddressLong() {
		Contact contact = new Contact("12345", "Corey", "Sampson", "5555555555", "123 Main Street");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setAddress("ABCDEF 123456 Main Street, Akron OH, 44334");
		});
	}
	
	@Test
	void testContactSetAddressIsNull() {
		Contact contact = new Contact("12345", "Corey", "Sampson", "5555555555", "123 Main Street");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setAddress(null);
		});
	}
}