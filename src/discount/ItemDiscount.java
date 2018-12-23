package discount;

import product.Basket;
import product.Item;
import product.Product;

import java.util.Iterator;

public abstract class ItemDiscount extends Sale {

    protected abstract boolean isApplicableToProduct(Product p);

    @Override
    public void applyDiscount(Basket b) {
        if(!isApplicableToBasket(b)) return;

        Iterator<Item> itr = b.getItemIterator();
        while(itr.hasNext()) {
            Item item = itr.next();
            if(isApplicableToProduct(item.getProduct()))
                applyDiscount(item);
        }
    }

    abstract void applyDiscount(Item i);
}
