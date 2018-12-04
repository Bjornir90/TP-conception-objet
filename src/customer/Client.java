package customer;

import discount.DiscountLevel;

import java.util.ArrayList;

public abstract class Client {
	private ArrayList<DiscountLevel> eligibleDiscountLevel;

	protected Client(){
		eligibleDiscountLevel = new ArrayList<>();
	}

	public ArrayList<DiscountLevel> getEligibleDiscount(){
		return (ArrayList<DiscountLevel>) eligibleDiscountLevel.clone();
	}

	protected void addDiscountLevel(DiscountLevel level){
		eligibleDiscountLevel.add(level);
	}
}
