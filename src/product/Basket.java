package product;

import alert.AlertManager;

import java.util.ArrayList;

public class Basket {
    private ArrayList<Item> items;

    public Basket() {
        items = new ArrayList<>();
    }

    public float calculatePrice(){
        float total = 0.0f;
        for(Item item : items){
            total += item.getTotalPrice();
        }
        return total;
    }

    public void addItem(Item i){
        items.add(i);
    }

    @Override
    public String toString() {
        return "Basket{" +
                "items=" + items +
                '}';
    }
}
