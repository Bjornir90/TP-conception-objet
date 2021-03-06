package discount;

import product.Basket;

import java.util.ArrayList;

public class SaleManager {
	private ArrayList<ItemDiscount> itemDiscounts;
	private ArrayList<BasketDiscount> basketDiscounts;
	private static SaleManager instance;

	public static SaleManager getInstance(){
		if(instance == null){
			instance = new SaleManager();
		}
		return instance;
	}

	private SaleManager() {
		itemDiscounts = new ArrayList<>();
		basketDiscounts = new ArrayList<>();
	}

	public void addItemSale(ItemDiscount sale){
		itemDiscounts.add(sale);
	}

	public void addBasketSale(BasketDiscount sale){
		basketDiscounts.add(sale);
	}

	public void applyAllDiscounts(Basket basket) {
		applyAllItemsDiscounts(basket);
		applyAllBasketDiscounts(basket);
	}

	public void applyAllItemsDiscounts(Basket basket){
		for(Sale s : itemDiscounts){
			s.applyDiscount(basket);
		}
	}

	public void applyAllBasketDiscounts(Basket basket){
		for(Sale s : basketDiscounts){
			s.applyDiscount(basket);
		}
	}
}
