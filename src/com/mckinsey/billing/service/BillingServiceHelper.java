package com.mckinsey.billing.service;

import java.util.List;

import com.mckinsey.billing.domain.Bill;
import com.mckinsey.billing.domain.Item;
import com.mckinsey.billing.domain.UserType;

public class BillingServiceHelper {

	/**
	 * Applies discount on discountable items and calculates the total bill
	 * @param bill
	 * @return
	 */
	public double calculateTotalBillAmountApplyingDiscount(Bill bill) {
		UserType userType = bill.getUser().getUserType();
		int discountPercentage = 0;
		if(userType != null) {
			discountPercentage = userType.getDiscountPercentage();
		}
		
		List<Item> billItems = bill.getItemList();
		
		double totalAmountDiscountable = 0;
		double totalAmountNotDiscountable = 0;
		
		for (Item item : billItems) {
			if(item.getItemType().isDiscountable()) {
				totalAmountDiscountable += item.getPrice();
			} else {
				totalAmountNotDiscountable += item.getPrice();
			}
		}
		
		double totalAmount = calculateTotalAmountAfterDiscount(discountPercentage, totalAmountDiscountable) + totalAmountNotDiscountable;
		
		return totalAmount;
	}

	/**
	 * helper method to subtract discount from totalDiscountable amount
	 * @param discountPercentage
	 * @param totalAmountDiscountable
	 * @return
	 */
	public double calculateTotalAmountAfterDiscount(int discountPercentage, double totalAmountDiscountable) {
		return totalAmountDiscountable - ((totalAmountDiscountable * discountPercentage)/100);
	}
	
	/**
	 * Helper method to calculate the Five dollar discount amount 
	 * @param totalAmount
	 * @return
	 */
	public int calculateFiveDollarDiscountIfApplicable(double totalAmount) {
		return Double.valueOf(totalAmount/100).intValue() * 5; 
	}
	
}

