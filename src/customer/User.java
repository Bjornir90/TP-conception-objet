package customer;

import discount.DiscountLevel;
import product.Basket;

import java.util.ArrayList;

public class User {
	private Client typeOfClient;
	Basket basket;

	public User(Client typeOfClient) {
		this.typeOfClient = typeOfClient;
	}

	public boolean isEligibleForDiscountLevel(DiscountLevel lvl) {
		return typeOfClient.isEligibleForDiscountLevel(lvl);
	}
	
}
