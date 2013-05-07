package com.mckinsey.billing.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mckinsey.billing.domain.Bill;
import com.mckinsey.billing.domain.ItemType;
import com.mckinsey.billing.domain.UserType;
import com.mckinsey.test.util.DataMother;

public class BillingServiceImplTest {

	private BillingService billingService = new BillingServiceImpl();
	
	@Test
	public void testShouldCalculateTotalBillAmountForStoreEmployeeAndDontDiscountForGroceries() {
		Bill bill = DataMother.createBill(UserType.STORE_EMPLOYEE);
		DataMother.addItemToBill("rice", ItemType.GROCERIES, 90, bill);
		assertEquals(90.0 , billingService.calculateNetPayableAmount(bill), 0.0001);
	}
	
	@Test
	public void testShouldCalculateTotalBillAmountForStoreEmployeeAndDontDiscountForGroceriesButApply5Dollar() {
		Bill bill = DataMother.createBill(UserType.STORE_EMPLOYEE);
		DataMother.addItemToBill("rice", ItemType.GROCERIES, 100, bill);
		assertEquals(95.0 , billingService.calculateNetPayableAmount(bill), 0.0001);
	}
	
	@Test
	public void testShouldCalculateTotalBillAmountForAffiliateAndDontDiscountForGroceries() {
		Bill bill = DataMother.createBill(UserType.STORE_AFFILIATE);
		DataMother.addItemToBill("rice", ItemType.GROCERIES, 90, bill);
		assertEquals(90.0 , billingService.calculateNetPayableAmount(bill), 0.0001);
	}
	
	@Test
	public void testShouldCalculateTotalBillAmountForOthersAndDontDiscountForGroceries() {
		Bill bill = DataMother.createBill(UserType.OTHER);
		DataMother.addItemToBill("rice", ItemType.GROCERIES, 90, bill);
		assertEquals(90.0 , billingService.calculateNetPayableAmount(bill), 0.0001);
	}
	
	@Test
	public void testShouldCalculateTotalBillAmountForAffiliateAndDontDiscountForGroceriesAndApply5Dollar() {
		Bill bill = DataMother.createBill(UserType.STORE_AFFILIATE);
		DataMother.addItemToBill("rice", ItemType.GROCERIES, 100, bill);
		assertEquals(95.0 , billingService.calculateNetPayableAmount(bill), 0.0001);
	}
	
	@Test
	public void testShouldCalculateTotalBillAmountForStoreEmployeeAndDiscountForToysAndApply5DollarRule() {
		Bill bill = DataMother.createBill(UserType.STORE_EMPLOYEE);
		DataMother.addItemToBill("toy1", ItemType.MISC, 100, bill);
		DataMother.addItemToBill("toy2", ItemType.MISC, 200, bill);
		assertEquals(200.0 , billingService.calculateNetPayableAmount(bill), 0.0001);
	}

	@Test
	public void testShouldCalculateTotalBillAmountForAffiliateAndDiscountForToysApply5DollarRule() {
		Bill bill = DataMother.createBill(UserType.STORE_AFFILIATE);
		DataMother.addItemToBill("toy1", ItemType.MISC, 100, bill);
		DataMother.addItemToBill("toy2", ItemType.MISC, 200, bill);
		assertEquals(260.0 , billingService.calculateNetPayableAmount(bill), 0.0001);
	}
	
	@Test
	public void testShouldCalculateTotalBillAmountForOtherAndDiscountForToysApply5DollarRule() {
		Bill bill = DataMother.createBill(UserType.OTHER);
		DataMother.addItemToBill("toy1", ItemType.MISC, 100, bill);
		DataMother.addItemToBill("toy2", ItemType.MISC, 200, bill);
		assertEquals(285.0 , billingService.calculateNetPayableAmount(bill), 0.0001);
	}
	
	@Test
	public void testShouldCalculateTotalBillAmountForStoreEmployeeAndDiscountForToysButNoDiscountForGroceriesAndDontApply5DollarRule() {
		Bill bill = DataMother.createBill(UserType.STORE_EMPLOYEE);
		DataMother.addItemToBill("toy1", ItemType.MISC, 10, bill);
		DataMother.addItemToBill("rice", ItemType.GROCERIES, 20, bill);
		assertEquals(27.0 , billingService.calculateNetPayableAmount(bill), 0.0001);
	}
	
	@Test
	public void testShouldCalculateTotalBillAmountForAffiliateAndDiscountForToysButNoDiscountForGroceriesAndApply5DollarRule() {
		Bill bill = DataMother.createBill(UserType.STORE_AFFILIATE);
		DataMother.addItemToBill("toy1", ItemType.MISC, 100, bill);
		DataMother.addItemToBill("rice", ItemType.GROCERIES, 200, bill);
		assertEquals(280.0 , billingService.calculateNetPayableAmount(bill), 0.0001);
	}

	@Test
	public void testShouldCalculateTotalBillAmountForOtherAndDiscountForToysButNoDiscountForGroceriesAndApply5DollarRule() {
		Bill bill = DataMother.createBill(UserType.OTHER);
		DataMother.addItemToBill("toy1", ItemType.MISC, 100, bill);
		DataMother.addItemToBill("rice", ItemType.GROCERIES, 200, bill);
		assertEquals(285.0 , billingService.calculateNetPayableAmount(bill), 0.0001);
	}
}
