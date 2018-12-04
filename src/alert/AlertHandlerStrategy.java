package alert;

import product.Basket;

public interface AlertHandlerStrategy {
    boolean isMeetingAlertRequirements(Basket basket);
}
