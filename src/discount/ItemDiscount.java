package discount;

import product.Basket;

public class ItemDiscount extends Sale {
    @Override
    public void applyDiscount(Basket b) {
        if(!isUserEligible(b.user)) return;

    }
}
