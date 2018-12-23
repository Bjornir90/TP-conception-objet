package customer;

import discount.DiscountLevel;

public final class Guest extends Client {

	private static Guest instance;
	public static Guest getInstance() {
		return instance == null ? instance = new Guest() : instance;
	}

	private Guest(){
		super();
		addDiscountLevel(DiscountLevel.GUEST);
	}




}
