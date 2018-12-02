package product;

import alert.AlertManager;

import java.util.ArrayList;

public class Basket {
    private ArrayList<Item> items;

    public float calculatePrice(){
        AlertManager.getInstance().alerts(this);
        float total = 0.0f;
        for(Item item : items){
            total += item.getTotalPrice();
        }
        return total;
    }
}
