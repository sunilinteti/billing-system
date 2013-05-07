package com.mckinsey.billing.service;

import com.mckinsey.billing.domain.Bill;

public class BillingServiceImpl implements BillingService {

	private BillingServiceHelper billingServiceHelper = new BillingServiceHelper();
	/**
	 * Service method to calculate the Net Payable amount by the user.
	 */
	@Override
	public double calculateNetPayableAmount(Bill bill) {
		double totalBillAmount = billingServiceHelper.calculateTotalBillAmountApplyingDiscount(bill);
		//assumption by me : 5$ discount is applied after applying the percentage discount
		int fiveDollarDiscount = billingServiceHelper.calculateFiveDollarDiscountIfApplicable(totalBillAmount);
		double netPayableAmount = totalBillAmount - fiveDollarDiscount;
		
		return netPayableAmount;
	}
}
