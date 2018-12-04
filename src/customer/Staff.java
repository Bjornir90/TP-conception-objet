package customer;

import discount.DiscountLevel;

public class Staff extends Client {

	private Staff(){
		super();
		addDiscountLevel(DiscountLevel.STAFF);
		addDiscountLevel(DiscountLevel.GUEST);
	}
}
