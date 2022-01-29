package com.luv2code;

import javax.validation.constraints.*;

public class Customer {

	private String firstName;
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String lastName;


	@Min(value = 0,message = "wartosc powyzej 0")
	@Max(value = 10,message = "wartosc ponizej 10")
	private int freePases;


	@Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "nie pasuje do wzoru")
	private String postalCode;

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public int getFreePases() {
		return freePases;
	}

	public void setFreePases(int freePases) {
		this.freePases = freePases;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
}








