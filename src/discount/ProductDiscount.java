package discount;

import product.Item;
import product.Product;

public class ProductDiscount extends ItemDiscount {

    private Product product;
    private float flatDiscount;

    public ProductDiscount(DiscountLevel lvl, Product product, float flatDiscount) {
        this.discountLevel = lvl;
        this.product = product;
        this.flatDiscount = flatDiscount;
    }

    @Override
    protected boolean isApplicableToProduct(Product p) {
        return product.equals(p);
    }

    @Override
    void applyDiscount(Item i) {
        i.applyFlatDiscount(flatDiscount);
    }

}
