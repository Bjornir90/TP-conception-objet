package alert;

import product.Basket;

import java.util.ArrayList;

public class AlertManager {
    private ArrayList<AlertHandlerStrategy> alertHandlerStrategies;
    private static AlertManager instance;

    public static AlertManager getInstance() {
        if(instance == null){
            instance = new AlertManager();
        }
        return instance;
    }

    public AlertManager() {
        alertHandlerStrategies = new ArrayList<>();
    }

    public void addAlertHandler(AlertHandlerStrategy alertHandlerStrategy){
        alertHandlerStrategies.add(alertHandlerStrategy);
    }

    public void notifyChange(Basket basket){
        for(AlertHandlerStrategy handler : alertHandlerStrategies){
            handler.checkAlertConditions(basket);
        }
    }
}
