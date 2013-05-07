package com.mckinsey.billing.service;

import java.util.logging.Logger;

import com.mckinsey.billing.domain.Bill;

public class BillingServiceImpl implements BillingService {
	
	private Logger logger = Logger.getLogger(BillingServiceImpl.class.getName());

	private BillingServiceHelper billingServiceHelper = new BillingServiceHelper();
	/**
	 * Service method to calculate the Net Payable amount by the user.
	 */
	@Override
	public double calculateNetPayableAmount(Bill bill) {
		logger.info("Calculating bill amount for bill id : "+ bill.getBillId() + ", User with Id : "+ bill.getUser().getUserId());
		double totalBillAmount = billingServiceHelper.calculateTotalBillAmountApplyingDiscount(bill);
		//assumption by me : 5$ discount is applied after applying the percentage discount
		int fiveDollarDiscount = billingServiceHelper.calculateFiveDollarDiscountIfApplicable(totalBillAmount);
		double netPayableAmount = totalBillAmount - fiveDollarDiscount;
		logger.info("Bill amount for bill id : "+ bill.getBillId() + ", User with Id : "+ bill.getUser().getUserId() + " is : "+ netPayableAmount);
		return netPayableAmount;
	}
}
