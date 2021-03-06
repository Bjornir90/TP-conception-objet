package customer;

import discount.DiscountLevel;

import java.util.ArrayList;

public abstract class Client {
	private ArrayList<DiscountLevel> eligibleDiscountLevel;
	protected boolean hasLoyaltyCard;

	protected Client(){
		eligibleDiscountLevel = new ArrayList<>();
	}

	public boolean isEligibleForDiscountLevel(DiscountLevel lvl) {
		return eligibleDiscountLevel.contains(lvl);
	}

	protected void addDiscountLevel(DiscountLevel level){
		eligibleDiscountLevel.add(level);
	}

	public boolean getHasLoyaltyCard(){
		return hasLoyaltyCard;
	}
}
