package alert;

import product.Basket;

import java.util.ArrayList;

public class AlertManager {
    private ArrayList<AlertHandler> alertHandlers;
    private static AlertManager instance;

    public static AlertManager getInstance() {
        if(instance == null){
            instance = new AlertManager();
        }
        return instance;
    }

    public AlertManager() {
        alertHandlers = new ArrayList<>();
    }

    public void addAlertHandler(AlertHandler alertHandler){
        alertHandlers.add(alertHandler);
    }

    public void applyDiscounts(Basket basket){
        for(AlertHandler handler : alertHandlers){
            handler.applyDiscount(basket);
        }
    }
}
