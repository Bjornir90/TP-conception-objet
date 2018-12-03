package customer;

import discount.DiscountLevel;

import java.util.ArrayList;

public abstract class Client {
	private ArrayList<DiscountLevel> eligibleDiscountLevel;

	public abstract ArrayList<DiscountLevel> getEligibleDiscount();
}
