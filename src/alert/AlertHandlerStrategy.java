package alert;

import product.Basket;

public interface AlertHandlerStrategy {
    boolean checkAlertConditions(Basket basket);
}
