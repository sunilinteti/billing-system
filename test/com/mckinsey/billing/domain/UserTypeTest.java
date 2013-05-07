package com.mckinsey.billing.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserTypeTest {

	@Test
	public void testShouldCheckThePercentageCorrectly() {
		assertEquals(30, UserType.STORE_EMPLOYEE.getDiscountPercentage());
		assertEquals(10, UserType.STORE_AFFILIATE.getDiscountPercentage());
		assertEquals(5, UserType.CUSTOMER_OVER_TWO_YEARS.getDiscountPercentage());
		assertEquals(0, UserType.OTHER.getDiscountPercentage());
	}

}
