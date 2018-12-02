package alert;

import product.Basket;

public interface AlertHandler {
    public boolean applyDiscount(Basket basket);
}
