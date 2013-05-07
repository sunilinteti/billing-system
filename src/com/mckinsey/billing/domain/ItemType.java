package com.mckinsey.billing.domain;

/**
 * Enum representing the type of Purchase Item
 * 
 * @author sunil
 * 
 */
public enum ItemType {

	GROCERIES(false), UTENSILS(true), KIDS_STUFF(true), MISC(true);
	
	private ItemType(boolean discountable) {
		this.discountable = discountable;
	}
	
	private boolean discountable;
	
	public boolean isDiscountable() {
		return discountable;
	}
}
