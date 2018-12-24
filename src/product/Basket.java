package product;

import alert.AlertManager;
import customer.User;
import discount.SaleManager;

import java.util.ArrayList;
import java.util.Iterator;

public class Basket {
    private ArrayList<Item> items;
    private float applicablePrice;
    public User user;

    public Basket() {
        items = new ArrayList<>();
    }

    public Basket(User user) {
        this();
        this.user = user;
    }

    public float calculateBasePrice(){
        float total = 0.0f;
        for(Item item : items){
            total += item.getTotalPrice();
        }
        return total;
    }

    public float calculateFinalPrice(){
        SaleManager sm = SaleManager.getInstance();
        for(Item i : items) i.resetApplicablePrice();
        sm.applyAllItemsDiscounts(this);
        applicablePrice = calculateBasePrice();
        sm.applyAllBasketDiscounts(this);
        return applicablePrice;
    }


    public void applyPercentageOnTotal(float percentage){
        applicablePrice -= applicablePrice*percentage;
    }

    public void applyFlatReductionOnTotal(float discount){
        applicablePrice -= discount;
    }

    public void addItem(Item i){
        items.add(i);
        AlertManager alertManager = AlertManager.getInstance();
        alertManager.notifyChange(this);
    }

    public Iterator<Item> getItemIterator(){
        return items.iterator();
    }

    @Override
    public String toString() {
        return "Basket{" +
                items + ", \n" +
                "basePrice=" + calculateBasePrice() + ", \n" +
                "finalPrice=" + calculateFinalPrice() + ", \n" +
                '}';
    }

    public Item getItem(Product p) {
        for(Item item : items)
            if(item.getProduct().equals(p)) return item;

        return null;
    }

    public boolean has(Product p) {
        return getItem(p) != null;
    }
}
