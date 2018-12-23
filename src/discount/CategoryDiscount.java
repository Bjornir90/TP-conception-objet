package discount;

import product.Category;
import product.Item;
import product.Product;

public class CategoryDiscount extends ItemDiscount {

    private Category category;
    private float percentageDiscount;

    public CategoryDiscount(DiscountLevel lvl, Category category, float percentageDiscount) {
        this.discountLevel = lvl;
        this.category = category;
        this.percentageDiscount = percentageDiscount;
    }

    @Override
    protected boolean isApplicableToProduct(Product p) {
        return category.contains(p);
    }

    @Override
    void applyDiscount(Item i) {
        i.applyPercentageDiscount(percentageDiscount);
    }
}
