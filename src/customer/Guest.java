package customer;

import discount.DiscountLevel;

public final class Guest extends Client {

	private Guest(){
		super();
		addDiscountLevel(DiscountLevel.GUEST);
	}

	

}
