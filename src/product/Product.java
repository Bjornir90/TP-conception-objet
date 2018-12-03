package product;

public class Product {
    private float basePrice;
    private String name;

    public Product(float basePrice, String name) {
        this.basePrice = basePrice;
        this.name = name;
    }

    public float getBasePrice() {
        return basePrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "basePrice=" + basePrice +
                ", name='" + name + '\'' +
                '}';
    }
}
