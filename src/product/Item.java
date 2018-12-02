package product;

public class Item {
    private Product product;
    private int quantity;
    private float applicablePrice;

    public Item (Product p){
        product = p;
        applicablePrice = p.getBasePrice();
    }

    public Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        applicablePrice = product.getBasePrice();
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getTotalPrice(){
        return quantity*applicablePrice;
    }

    public void applyPercentageDiscount(float percentage){
        applicablePrice -= applicablePrice*percentage;
    }

    public void applyFlatDiscount(float discount){
        applicablePrice -= discount;
    }
}
