package discount;

import customer.User;
import product.Basket;

public abstract class Sale {
	protected DiscountLevel discountLevel;

	public boolean isUserEligible(User user) {
		return discountLevel == DiscountLevel.ALLUSERS
				|| user.isEligibleForDiscountLevel(discountLevel);
	}

	public boolean isApplicableToBasket(Basket b) {
		return isUserEligible(b.user);
	}

	public abstract void applyDiscount(Basket b);
}
