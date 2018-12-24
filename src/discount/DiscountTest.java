package discount;

import static org.junit.jupiter.api.Assertions.*;

import customer.*;
import product.*;

import java.util.Arrays;

public class DiscountTest {

    User u1, u2, u3;
    Product p1, p2;
    Category cat1;
    BasketDiscount bd1;
    ProductDiscount pd1;
    CategoryDiscount cd1;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {

        // Users
        u1 = new User(Guest.getInstance());
        u2 = new User(Member.getInstance());
        u3 = new User(Staff.getInstance());

        // Products
        p1 = new Product(10, "Cahier", 5);
        p2 = new Product(2f, "Stylo", 1);

        // Categories
        cat1 = new Category("Fournitures scolaires");
        cat1.addProductToCategory(p1);
        cat1.addProductToCategory(p2);

        // Discounts
        bd1 = new BasketDiscount(DiscountLevel.GUEST, Arrays.asList(p1, p2), 1.0f);
        pd1 = new ProductDiscount(DiscountLevel.MEMBER, p1, 2.0f);
        cd1 = new CategoryDiscount(DiscountLevel.STAFF, cat1, 0.15f);
        SaleManager.getInstance().addBasketSale(bd1);
        SaleManager.getInstance().addItemSale(cd1);
        SaleManager.getInstance().addItemSale(pd1);

        // Add to basket
        u1.basket.addItem(new Item(p1, 2));
        u1.basket.addItem(new Item(p2, 2));

        u2.basket.addItem(new Item(p1, 2));
        u2.basket.addItem(new Item(p2, 2));

        u3.basket.addItem(new Item(p1, 2));
        u3.basket.addItem(new Item(p2, 2));
    }

    @org.junit.jupiter.api.Test
    void test() {
        // System.out.println(u1.basket.toString()+'\n');
        // System.out.println(u2.basket.toString()+'\n');
        // System.out.println(u3.basket.toString()+'\n');

        //u1 (Guest) has access to GUEST, so has only discount on basket
        assertEquals(24f - 2 * 1f, u1.basket.calculateFinalPrice());

        // u2 (Member) has access to GUEST and MEMBER, so has discount on p1 and basket
        assertEquals(24f - 2 * (1f + 2f), u2.basket.calculateFinalPrice());

        // u3 (Staff) has access to GUEST and STAFF, so has discount on category and on basket
        assertEquals(24f * (1.0f - 0.15f) - 2 * 1f, u3.basket.calculateFinalPrice());
        // almost works ;)
    }
}
