package discount;

import customer.User;
import product.Basket;

public abstract class Sale {
	protected DiscountLevel discountLevel;

	public abstract void applyDiscount(Basket b);

	boolean isUserEligible(User user) {
		return user.isEligibleForDiscountLevel(discountLevel);
	}
}
