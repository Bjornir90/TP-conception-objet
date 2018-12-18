package discount;

import product.Product;

public class FidelityCard {
	int fidelityPoints;

	public FidelityCard(){

	}

	public void addPoints(Product p){
		fidelityPoints += p.getFidelityPoints();
	}


}
