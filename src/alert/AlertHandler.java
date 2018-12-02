package alert;

import product.Basket;

public interface AlertHandler {
    public boolean isMeetingAlertRequirements(Basket basket);
}
