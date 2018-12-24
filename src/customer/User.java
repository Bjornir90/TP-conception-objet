package customer;

import discount.DiscountLevel;
import product.Basket;

public class User {
	private Client typeOfClient;
	public final Basket basket;

	public User(Client typeOfClient) {
		this.typeOfClient = typeOfClient;
		basket = new Basket(this);
	}

	public boolean isEligibleForDiscountLevel(DiscountLevel lvl) {
		return typeOfClient.isEligibleForDiscountLevel(lvl);
	}
	
}
