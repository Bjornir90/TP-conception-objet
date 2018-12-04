package customer;

import discount.DiscountLevel;

public class Member extends Client {

	private Member(){
		super();
		addDiscountLevel(DiscountLevel.GUEST);
		addDiscountLevel(DiscountLevel.MEMBER);
	}
}
