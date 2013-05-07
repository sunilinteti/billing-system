package com.mckinsey.billing.domain;

/**
 * Enum for various user types and the discount percentages they carry
 * @author sunil
 *
 */
public enum UserType {
	 
	STORE_EMPLOYEE(30), 
	STORE_AFFILIATE(10), 
	CUSTOMER_OVER_TWO_YEARS(5), 
	OTHER(0);
	
	private UserType(int discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	
	private int discountPercentage;
	
	public int getDiscountPercentage() {
		return discountPercentage;
	}

}
