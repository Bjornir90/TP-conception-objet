package product;

import java.util.ArrayList;

public class Category implements Alertable {
	private ArrayList<Product> products;

	public Category(){
		products = new ArrayList<>();
	}

	public void addProductToCategory(Product p){
		products.add(p);
	}

	public boolean contains(Product p){
		return products.contains(p);
	}

	@Override
	public boolean isAlertedBy(Product p) {
		return contains(p);
	}
}
