package discount;

import product.Basket;
import product.Product;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;


public class BasketDiscount extends Sale {

    private Collection<Product> hasProducts;
    private float flatDiscount;

    public BasketDiscount(DiscountLevel lvl, Collection<Product> hasProducts, float flatDiscount) {
        this.discountLevel = lvl;
        this.hasProducts = hasProducts;
        this.flatDiscount = flatDiscount;
    }

    @Override
    public void applyDiscount(Basket b) {
        if(!isApplicableToBasket(b)) return;

        Collection<Integer> quantitiesOfNeededProducts = hasProducts.stream()
                .map(b::getItem)
                .map(item-> item != null ? item.getQuantity() : 0)
                .collect(Collectors.toSet());

        int timesApplied = Collections.min(quantitiesOfNeededProducts);

        b.applyFlatReductionOnTotal(timesApplied * flatDiscount);
    }
}
