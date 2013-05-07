package com.mckinsey.billing.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class ItemTypeTest {

	@Test
	public void testShouldCheckItemAndTheirDiscountability() {
		assertEquals(true, ItemType.KIDS_STUFF.isDiscountable());
		assertEquals(true, ItemType.MISC.isDiscountable());
		assertEquals(true, ItemType.UTENSILS.isDiscountable());
		assertEquals(false, ItemType.GROCERIES.isDiscountable());
	
	}

}
