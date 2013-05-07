package com.mckinsey.test.util;

import com.mckinsey.billing.domain.Bill;
import com.mckinsey.billing.domain.Item;
import com.mckinsey.billing.domain.ItemType;
import com.mckinsey.billing.domain.User;
import com.mckinsey.billing.domain.UserType;

/**
 * Simple class to get some test data to be used from Test classes
 * @author sunil
 *
 */
public class DataMother {
	
	public static Bill createBill(UserType userType) {
		User user = createUser(userType);
		Bill bill =  new Bill(1001l, user);
		return bill;
	}

	public static User createUser(UserType userType) {
		User user = new User(1001l, "Sunil", "Inteti", userType);
		return user;
		
	}
	
	public static void addItemToBill(String itemName, ItemType itemType, double price, Bill bill) {
		bill.getItemList().add(createItem(itemName, itemType, price));
	}

	private static Item createItem(String itemName, ItemType itemType, double price) {
		return new Item(itemName, itemType, price);
	}
	
}
