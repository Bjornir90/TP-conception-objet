package alert;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import product.Basket;
import product.Item;
import product.Product;

import static org.junit.jupiter.api.Assertions.*;

class BasketAlertTest {

    private BasketAlert ba1, ba2;
    private Basket basket;

    @BeforeEach
    void setUp() {
        basket = new Basket();
        Product p1 = new Product(10, "Cahier", 5);
        Product p2 = new Product(1.5f, "Stylo", 1);
        Item i1 = new Item(p1);
        i1.setQuantity(5);
        Item i2 = new Item(p2);
        i2.setQuantity(3);
        basket.addItem(i1);
        basket.addItem(i2);
    }

    @Test
    void checkAlertConditions() {
        ba1 = new BasketAlert(26);
        ba2 = new BasketAlert(85);
        assertTrue(ba1.checkAlertConditions(basket));
        assertFalse(ba2.checkAlertConditions(basket));
    }
}