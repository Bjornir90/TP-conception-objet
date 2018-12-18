package alert;

import product.Alertable;
import product.Basket;
import product.Item;
import product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ContentAlert <T extends Alertable> implements AlertHandlerStrategy {
	private HashMap<T, Integer> contentRequirements;

	public ContentAlert(){
		contentRequirements = new HashMap<>();
	}

	public void addContentRequirement(T content, int quantity){
		if(contentRequirements.containsKey(content)){
			int previousQuantity = contentRequirements.get(content);
			contentRequirements.replace(content, previousQuantity+quantity);
		} else {
			contentRequirements.put(content, quantity);
		}
	}

	public void addContentRequirements(ArrayList<T> content, ArrayList<Integer> quantities){
		if(content.size() != quantities.size()){
			throw new IllegalArgumentException("Products and quantities list aren't the same size");
		}
		for (int i = 0; i < content.size(); i++) {
			addContentRequirement(content.get(i), quantities.get(i));
		}
	}

	@Override
	public boolean checkAlertConditions(Basket basket) {
		Iterator<Item> it = basket.getItemIterator();
		HashMap<T, Integer> contentMeetingRequirements = new HashMap<>();

		while(it.hasNext()){
			Item currentItem = it.next();
			Product currentProduct = currentItem.getProduct();

			for(T currentRequirement : contentRequirements.keySet()) {
				if (currentRequirement.isAlertedBy(currentProduct)) {
					if (contentMeetingRequirements.containsKey(currentRequirement)) {
						int oldQuantity = contentMeetingRequirements.get(currentRequirement);
						System.out.println("oldQuantity = " + oldQuantity);
						contentMeetingRequirements.replace(currentRequirement, oldQuantity+currentItem.getQuantity());
					} else {
						contentMeetingRequirements.put(currentRequirement, currentItem.getQuantity());
					}
				}
			}
		}

		System.out.println("contentRequirements = " + contentRequirements);
		System.out.println("contentMeetingRequirements = " + contentMeetingRequirements);

		for(T currentRequirement : contentRequirements.keySet()){
			if(contentMeetingRequirements.containsKey(currentRequirement)){
				if(contentMeetingRequirements.get(currentRequirement) < contentRequirements.get(currentRequirement)){
					return false;
				}
			} else {
				return false;
			}
		}
		return true;
	}
}
