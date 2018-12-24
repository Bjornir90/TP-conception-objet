package customer;

import discount.DiscountLevel;
import discount.LoyaltyCard;
import product.Basket;

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
	
}
