package alert;

import product.Basket;

import java.util.ArrayList;
import java.util.HashMap;

public class AlertManager {
    private ArrayList<AlertHandlerStrategy> alertHandlerStrategies;
    private HashMap<Basket, ArrayList<AlertHandlerStrategy>> alertsAlreadyFired;
    private static AlertManager instance;

    public static AlertManager getInstance() {
        if(instance == null){
            instance = new AlertManager();
        }
        return instance;
    }

    private AlertManager() {
        alertHandlerStrategies = new ArrayList<>();
        alertsAlreadyFired = new HashMap<>();
    }

    public void addAlertHandler(AlertHandlerStrategy alertHandlerStrategy){
        alertHandlerStrategies.add(alertHandlerStrategy);
    }

    public void notifyChange(Basket basket){
        //Prevent repetition of alerts already fired for every items added
        if(!alertsAlreadyFired.containsKey(basket)){
            alertsAlreadyFired.put(basket, new ArrayList<>());
        }
        ArrayList<AlertHandlerStrategy> strategiesAlreadyFired = alertsAlreadyFired.get(basket);
        for(AlertHandlerStrategy handler : alertHandlerStrategies){
            if(!strategiesAlreadyFired.contains(handler)) {
                if(handler.checkAlertConditions(basket)){
                    strategiesAlreadyFired.add(handler);
                    handler.fireAlert();
                }
            }
        }
    }
}
