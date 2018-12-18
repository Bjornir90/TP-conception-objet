package product;

import static org.junit.jupiter.api.Assertions.*;

class BasketTest {

	Basket basket;
	Product p1, p2, p3;
	Item i1, i2, i3;

	@org.junit.jupiter.api.BeforeEach
	void setUp() {
		basket = new Basket();
		p1 = new Product(10, "Cahier", 5);
		p2 = new Product(1.5f, "Stylo", 1);
		p3 = new Product(249.99f, "Mémoire", 60);
		i1 = new Item(p1);
		i1.setQuantity(4);
		i2 = new Item(p2);
		i2.setQuantity(10);
		i3 = new Item(p3);
		i3.setQuantity(1);
	}

	@org.junit.jupiter.api.Test
	void calculatePrice() {
		assertEquals(0.0f, basket.calculateBasePrice());
		basket.addItem(i1);
		assertEquals(10*4, basket.calculateBasePrice());
		basket.addItem(i2);
		assertEquals(10*4+1.5f*10, basket.calculateBasePrice());
		basket.addItem(i3);
		assertEquals(10*4+1.5f*10+249.99f, basket.calculateBasePrice());
	}
}