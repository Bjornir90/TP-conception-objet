package discount;

import product.Basket;
import product.Product;

public class FidelityCard {
	int fidelityPoints;

	public FidelityCard(){

	}

	public void addPoints(Product p){
		fidelityPoints += p.getFidelityPoints();
	}

	public void applyDiscount(Basket basket){
		float percentage = fidelityPoints/1000*0.05f;//5% every 1000 points
		if(percentage > 0.25f){ //Limit the discount to 25%
			percentage = 0.25f;
		}
		basket.applyPercentageOnTotal(percentage);
	}
}
