package com.mckinsey.billing.domain;

import java.util.Date;

/**
 * Domain object encapsulating the Purchased Item details
 * 
 * @author sunil
 * 
 */
public class Item {
	
	public Item(String name, ItemType itemType, double price) {
		this.name = name;
		this.itemType = itemType;
		this.price = price;
	}
	
	private String name;

	private Date manufacturingDate;

	private Date expiryDate;

	private ItemType itemType;

	private double price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getManufacturingDate() {
		return manufacturingDate;
	}

	public void setManufacturingDate(Date manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public ItemType getItemType() {
		return itemType;
	}

	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
