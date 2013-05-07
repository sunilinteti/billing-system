package com.mckinsey.billing.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mckinsey.billing.domain.Bill;
import com.mckinsey.billing.domain.ItemType;
import com.mckinsey.billing.domain.UserType;
import com.mckinsey.test.util.DataMother;

public class BillingServiceHelperTest {

	private BillingServiceHelper billingServiceHelper = new BillingServiceHelper();
	
	@Test
	public void testShouldCalculate5DollarDiscountCorrectly() {
		int discount = billingServiceHelper.calculateFiveDollarDiscountIfApplicable(990);
		assertEquals(45, discount);
	
		discount = billingServiceHelper.calculateFiveDollarDiscountIfApplicable(1000);
		assertEquals(50, discount);
	
		discount = billingServiceHelper.calculateFiveDollarDiscountIfApplicable(1001);
		assertEquals(50, discount);
		
		discount = billingServiceHelper.calculateFiveDollarDiscountIfApplicable(999);
		assertEquals(45, discount);
	}
	
	@Test
	public void testShouldCalculateTotalAmountAfterApplyingDiscountPercentage() {
		double amountAfterDiscount = billingServiceHelper.calculateTotalAmountAfterDiscount(UserType.STORE_EMPLOYEE.getDiscountPercentage(), 1000);
		assertEquals(700.0, amountAfterDiscount, 0.0001);
		
		amountAfterDiscount = billingServiceHelper.calculateTotalAmountAfterDiscount(UserType.STORE_EMPLOYEE.getDiscountPercentage(), 2100);
		assertEquals(1470.0, amountAfterDiscount, 0.0001);
	}
	
	@Test
	public void testShouldCalculateTotalBillAmountForStoreEmployeeAndDontDiscountForGroceries() {
		Bill bill = DataMother.createBill(UserType.STORE_EMPLOYEE);
		DataMother.addItemToBill("rice", ItemType.GROCERIES, 90, bill);
		assertEquals(90.0 , billingServiceHelper.calculateTotalBillAmountApplyingDiscount(bill), 0.0001);
	}
	
	@Test
	public void testShouldCalculateTotalBillAmountForAffiliateAndDontDiscountForGroceries() {
		Bill bill = DataMother.createBill(UserType.STORE_AFFILIATE);
		DataMother.addItemToBill("rice", ItemType.GROCERIES, 90, bill);
		assertEquals(90.0 , billingServiceHelper.calculateTotalBillAmountApplyingDiscount(bill), 0.0001);
	}
	
	@Test
	public void testShouldCalculateTotalBillAmountForCustomerOver2YearsAndDontDiscountForGroceries() {
		Bill bill = DataMother.createBill(UserType.CUSTOMER_OVER_TWO_YEARS);
		DataMother.addItemToBill("rice", ItemType.GROCERIES, 90, bill);
		assertEquals(90.0 , billingServiceHelper.calculateTotalBillAmountApplyingDiscount(bill), 0.0001);
	}
	
	@Test
	public void testShouldCalculateTotalBillAmountForStoreEmployeeAndDiscountForToys() {
		Bill bill = DataMother.createBill(UserType.STORE_EMPLOYEE);
		DataMother.addItemToBill("toy1", ItemType.MISC, 100, bill);
		DataMother.addItemToBill("toy2", ItemType.MISC, 200, bill);
		assertEquals(210.0 , billingServiceHelper.calculateTotalBillAmountApplyingDiscount(bill), 0.0001);
	}

	@Test
	public void testShouldCalculateTotalBillAmountForAffiliateAndDiscountForToys() {
		Bill bill = DataMother.createBill(UserType.STORE_AFFILIATE);
		DataMother.addItemToBill("toy1", ItemType.MISC, 100, bill);
		DataMother.addItemToBill("toy2", ItemType.MISC, 200, bill);
		assertEquals(270.0 , billingServiceHelper.calculateTotalBillAmountApplyingDiscount(bill), 0.0001);
	}
	
	@Test
	public void testShouldCalculateTotalBillAmountForCustomerOver2YearsAndDiscountForToys() {
		Bill bill = DataMother.createBill(UserType.CUSTOMER_OVER_TWO_YEARS);
		DataMother.addItemToBill("toy1", ItemType.MISC, 100, bill);
		DataMother.addItemToBill("toy2", ItemType.MISC, 200, bill);
		assertEquals(285.0 , billingServiceHelper.calculateTotalBillAmountApplyingDiscount(bill), 0.0001);
	}
	
	@Test
	public void testShouldCalculateTotalBillAmountForOthersAndDiscountForToys() {
		Bill bill = DataMother.createBill(UserType.OTHER);
		DataMother.addItemToBill("toy1", ItemType.MISC, 100, bill);
		DataMother.addItemToBill("toy2", ItemType.MISC, 200, bill);
		assertEquals(300.0 , billingServiceHelper.calculateTotalBillAmountApplyingDiscount(bill), 0.0001);
	}
	
	@Test
	public void testShouldCalculateTotalBillAmountForStoreEmployeeAndDiscountForToysButNoDiscountForGroceries() {
		Bill bill = DataMother.createBill(UserType.STORE_EMPLOYEE);
		DataMother.addItemToBill("toy1", ItemType.MISC, 100, bill);
		DataMother.addItemToBill("rice", ItemType.GROCERIES, 200, bill);
		assertEquals(270.0 , billingServiceHelper.calculateTotalBillAmountApplyingDiscount(bill), 0.0001);
	}
	
	@Test
	public void testShouldCalculateTotalBillAmountForAffiliateAndDiscountForToysButNoDiscountForGroceries() {
		Bill bill = DataMother.createBill(UserType.STORE_AFFILIATE);
		DataMother.addItemToBill("toy1", ItemType.MISC, 100, bill);
		DataMother.addItemToBill("rice", ItemType.GROCERIES, 200, bill);
		assertEquals(290.0 , billingServiceHelper.calculateTotalBillAmountApplyingDiscount(bill), 0.0001);
	}
}
