package alert;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import product.Basket;
import product.Item;
import product.Product;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class AlertManagerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private BasketAlert ba1, ba2;
    private Basket basket;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        basket = new Basket();
    }

    @Test
    void notifyChange() {
        ba1 = new BasketAlert(26);
        ba2 = new BasketAlert(85);
        AlertManager am = AlertManager.getInstance();
        am.addAlertHandler(ba1);
        am.addAlertHandler(ba2);
        Product p1 = new Product(10, "Cahier", 5);
        Item i1 = new Item(p1);
        i1.setQuantity(5);
        basket.addItem(i1);
        assertEquals("Le client a acheté pour au moins 26.0euros de produits\r\n", outContent.toString());
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }
}