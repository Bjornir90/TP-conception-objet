package alert;

import product.Basket;

public class BasketAlert implements AlertHandlerStrategy {
    private float threshold;

    public BasketAlert(float threshold) {
        this.threshold = threshold;
    }

    @Override
    public boolean checkAlertConditions(Basket basket) {
        return (basket.calculateFinalPrice() >= threshold);
    }
}
