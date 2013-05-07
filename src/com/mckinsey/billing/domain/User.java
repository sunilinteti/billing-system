package com.mckinsey.billing.domain;

import java.util.Date;

/**
 * Domain object encapsulating the User information
 * @author sunil
 *
 */
public class User {
	
	public User(long userId, String firstName, String lastName, UserType userType) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userType = userType;
		this.customerSince = new Date();
	}
	
	private long userId;
	
	private String firstName;
	
	private String lastName;

	private Date customerSince;
	
	private UserType userType;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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

	public Date getCustomerSince() {
		return customerSince;
	}

	public void setCustomerSince(Date customerSince) {
		this.customerSince = customerSince;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}
}
