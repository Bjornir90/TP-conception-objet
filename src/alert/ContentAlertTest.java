package alert;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import product.Basket;
import product.Item;
import product.Product;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ContentAlertTest {

	Basket b;
	ArrayList<Product> products;
	ArrayList<Integer> quantities;
	Item i1, i2, i3;
	ContentAlert<Product> singleProduct, multipleProduct;

	@BeforeEach
	void setUp() {
		b = new Basket();
		products = new ArrayList<>();
		quantities = new ArrayList<>();
		Product p1 = new Product(10, "Cahier");
		Product p2 = new Product(1.5f, "Stylo");
		Product p3 = new Product(249.99f, "Mémoire");
		i1 = new Item(p1);
		i1.setQuantity(4);
		i2 = new Item(p2);
		i2.setQuantity(10);
		i3 = new Item(p3);
		i3.setQuantity(1);
		products.add(p1);
		products.add(p3);
		quantities.add(4);
		quantities.add(1);
		b.addItem(i1);
		b.addItem(i3);
		singleProduct = new ContentAlert<>();
		singleProduct.addContentRequirement(p1, 3);
		multipleProduct = new ContentAlert<>();
	}

	@Test
	void addProductRequirements() {
		multipleProduct.addContentRequirements(products, quantities);
		assertTrue(multipleProduct.isMeetingAlertRequirements(b));
		multipleProduct.addContentRequirements(products, quantities);
		assertFalse(multipleProduct.isMeetingAlertRequirements(b));
	}

	@Test
	void isMeetingAlertRequirements() {
		assertTrue(singleProduct.isMeetingAlertRequirements(b));
		assertTrue(multipleProduct.isMeetingAlertRequirements(b));
		multipleProduct.addContentRequirements(products, quantities);
		assertTrue(multipleProduct.isMeetingAlertRequirements(b));
		multipleProduct.addContentRequirement(i1.getProduct(), 3);
		assertFalse(multipleProduct.isMeetingAlertRequirements(b));
		multipleProduct.addContentRequirement(i3.getProduct(), 45);
		assertFalse(multipleProduct.isMeetingAlertRequirements(b));
		ContentAlert productNotPresent = new ContentAlert();
		productNotPresent.addContentRequirement(i2.getProduct(), 1);
		assertFalse(productNotPresent.isMeetingAlertRequirements(b));
	}
}