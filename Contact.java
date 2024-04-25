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

public class Contact {
	
	// Variables for Contact Class
	private String id;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	// Contact object of Contact Class
	public Contact(String id, String firstName, String lastName, String phone, String address) {
		// Checks ID against requirements of not NULL and less than 10 characters
		if (id == null || id.length() > 10) {
			throw new IllegalArgumentException("ID cannot be more than 10 characters or empty.");
		}
		
		// Checks firstName requirements of not NULL and less than 10 characters
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("First Name cannot be more than 10 characters or empty.");
		}
		
		// Checks lastName requirements of not NULL and less than 10 characters
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Last Name cannot be more than 10 characters or empty.");
		}
		
		/* Checks phone number requirements of not NULL and exactly 10 characters
		 * Regex = "[0-9]+" ensures the phone number contains only digits 0-9
		 */
		String regex = "[0-9]+";
		if (phone == null || phone.length() != 10 || !phone.matches(regex)) {
			throw new IllegalArgumentException("Phone Number must be exactly 10 digits and not empty.");
		}
		
		// Checks address requirements of not NULL and less than 30 characters
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Address cannot be more than 30 characters or empty.");
		}
		// Handles for when no exceptions exist
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	
	// Getter methods for id, firstName, lastName, phone, and address
	public String getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getAddress() {
		return address;
	}
	
	// Setter methods for use by ContactService Class
	// There is no setter method for id since it is not able to be updated
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("First Name cannot be more than 10 characters or empty.");
		} else if (firstName.length() <= 10) {
			this.firstName = firstName;
		}
	}
	
	public void setLastName(String lastName) {
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Last Name cannot be more than 10 characters or empty.");
		} else if (lastName.length() <= 10) {
			this.lastName = lastName;
		}
	}
	
	// Regex ensures phone number only contains digits 0-9
	public void setPhone(String phone) {
		String regex = "[0-9]+";
		if (phone == null || phone.length() != 10 || !phone.matches(regex)) {
			throw new IllegalArgumentException("Phone Number must be exactly 10 digits and not empty.");
		}
		this.phone = phone;
	}
	
	public void setAddress(String address) {
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Address cannot be more than 30 characters or empty.");
		} else if (address.length() <= 30) {
			this.address = address;
		}
	}
}