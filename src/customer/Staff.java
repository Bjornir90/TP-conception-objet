package customer;

import discount.DiscountLevel;

public class Staff extends Client {

	private static Staff instance;
	public static Staff getInstance() {
		return instance == null ? instance = new Staff() : instance;
	}

	private Staff(){
		super();
		addDiscountLevel(DiscountLevel.STAFF);
		addDiscountLevel(DiscountLevel.GUEST);
	}
}
