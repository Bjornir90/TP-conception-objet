package alert;

import product.Basket;
import product.Item;
import product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ProductAlert implements AlertHandlerStrategy {
	private HashMap<Product, Integer> productRequirements;

	public ProductAlert(){
		productRequirements = new HashMap<>();
	}

	public void addProductRequirement(Product p, int quantity){
		if(productRequirements.containsKey(p)){
			int previousQuantity = productRequirements.get(p);
			productRequirements.replace(p, previousQuantity+quantity);
		} else {
			productRequirements.put(p, quantity);
		}
	}

	public void addProductRequirements(ArrayList<Product> products, ArrayList<Integer> quantities){
		if(products.size() != quantities.size()){
			throw new IllegalArgumentException("Products and quantities list aren't the same size");
		}
		for (int i = 0; i < products.size(); i++) {
			addProductRequirement(products.get(i), quantities.get(i));
		}
	}

	@Override
	public boolean isMeetingAlertRequirements(Basket basket) {
		Iterator<Item> it = basket.getItemIterator();
		ArrayList<Product> productsMeetingRequirements = new ArrayList<>();

		while(it.hasNext()){
			Item currentItem = it.next();
			Product currentProduct = currentItem.getProduct();

			if(productRequirements.containsKey(currentProduct)){
				if(productRequirements.get(currentProduct) <= currentItem.getQuantity()){
					productsMeetingRequirements.add(currentProduct);
				}
			}
		}

		if(productsMeetingRequirements.containsAll(productRequirements.keySet())){
			return true;
		}
		return false;
	}
}
