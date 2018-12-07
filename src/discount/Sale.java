package discount;

import product.Basket;

public abstract class Sale {
	private DiscountLevel discountLevel;

	public abstract void applyDiscount(Basket b);
}
