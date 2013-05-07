package com.mckinsey.billing.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Domain object encapsulating the contents of the bill 
 * @author sunil
 *
 */
public class Bill {
	
	public Bill(long billId, User user) {
		this.user = user;
		this.billingDate = new Date();
	}
	
	private long billId;
	
	private User user;
	
	private Date billingDate;
	
	private List<Item> itemList = new ArrayList<Item>();

	public long getBillId() {
		return billId;
	}

	public void setBillId(long billId) {
		this.billId = billId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(Date billingDate) {
		this.billingDate = billingDate;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}
}
