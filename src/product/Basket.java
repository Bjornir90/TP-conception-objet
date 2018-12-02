package product;

import alert.AlertManager;

import java.util.ArrayList;

public class Basket {
    private ArrayList<Item> products;

    public float calculatePrice(){
        AlertManager.getInstance().applyDiscounts(this);
        float total = 0.0f;
        for(Item item : products){
            total += item.getTotalPrice();
        }
        return total;
    }
}
