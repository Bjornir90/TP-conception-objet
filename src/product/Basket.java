package product;

import alert.AlertManager;
import discount.SaleManager;

import java.util.ArrayList;
import java.util.Iterator;

public class Basket {
    private ArrayList<Item> items;
    private float applicablePrice;

    public Basket() {
        items = new ArrayList<>();
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
                "items=" + items +
                '}';
    }
}
