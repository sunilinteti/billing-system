package com.mckinsey.billing.service;

import com.mckinsey.billing.domain.Bill;
/**
 * Service class that calculates the discount amount and net amount
 * @author sunil
 *
 */
public interface BillingService {
	/**
	 * Calculates the Total amount user has to pay
	 * @param bill
	 * @return
	 */
	public double calculateNetPayableAmount(Bill bill);
}
