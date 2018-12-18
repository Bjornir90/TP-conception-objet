package product;

public class Product implements Alertable{
    private float basePrice;
    private String name;
    private int fidelityPoints;

    public Product(float basePrice, String name, int fidelityPoints) {
        this.basePrice = basePrice;
        this.name = name;
        this.fidelityPoints = fidelityPoints;
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

    @Override
    public boolean isAlertedBy(Product p) {
        if(p.equals(this)){
            return true;
        }
        return false;
    }

    @Override
    public String printableName() {
        return name;
    }

    public int getFidelityPoints() {
        return fidelityPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Product) ) return false;

        Product product = (Product) o;

        if (product.basePrice == basePrice) return false;
        return name != null ? name.equals(product.name) : product.name == null;
    }

    @Override
    public int hashCode() {
        int result = (basePrice != +0.0f ? Float.floatToIntBits(basePrice) : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
