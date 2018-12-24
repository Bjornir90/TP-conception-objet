package customer;

import discount.DiscountLevel;
import discount.LoyaltyCard;
import product.Basket;
import product.Item;
import product.Product;

public class User {
	private Client typeOfClient;
	public final Basket basket;
	private LoyaltyCard card;

	public User(Client typeOfClient) {
		this.typeOfClient = typeOfClient;
		basket = new Basket(this);
	}

	public boolean isEligibleForDiscountLevel(DiscountLevel lvl) {
		return typeOfClient.isEligibleForDiscountLevel(lvl);
	}

	public void applyLoyaltyDiscount(){
		if(typeOfClient.getHasLoyaltyCard()){
			card.applyDiscount(basket);
		}
	}

	//Take a status for demonstration purposes
	public void login(Client status){
		typeOfClient = status;
		if(status.getHasLoyaltyCard()){
			card = new LoyaltyCard();
		}
	}

	public void addLoyaltyPoints(Product product){
		if(typeOfClient.getHasLoyaltyCard()){
			card.addPoints(product);
		}
	}

	public void addToBasket(Product p, int quantity){
		Item item = new Item(p, quantity);
		basket.addItem(item);
	}
	
}
