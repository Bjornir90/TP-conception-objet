package customer;

import discount.DiscountLevel;

public class Member extends Client {

	private static Member instance;
	public static Member getInstance() {
		return instance == null ? instance = new Member() : instance;
	}

	private Member(){
		super();
		addDiscountLevel(DiscountLevel.GUEST);
		addDiscountLevel(DiscountLevel.MEMBER);
		hasLoyaltyCard = true;
	}
}
