import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;

import drink.*;
import ingredient.*;



public class JavaMaticMachine {
	private static int INGREDIENT_CAPACITY=10;
	private List<Drink> drinkList=new ArrayList<Drink>();
	private Map<Ingredient, Integer> ingredientStock=new TreeMap<Ingredient, Integer>();
	
	public JavaMaticMachine() {
		initializeDrinkList();
		initializeIngredients();
	}
	
	private void initializeDrinkList() {
		drinkList.add(new CaffeAmericano());
		drinkList.add(new CaffeLatte());
		drinkList.add(new CaffeMocha());
		drinkList.add(new Cappuccino());
		drinkList.add(new CoffeeDrink());
		drinkList.add(new DecafCoffeeDrink());
	}
	
	private void initializeIngredients() {
		ingredientStock.put(new Coffee(),INGREDIENT_CAPACITY);
		ingredientStock.put(new Cocoa(),INGREDIENT_CAPACITY);
		ingredientStock.put(new Cream(),INGREDIENT_CAPACITY);
		ingredientStock.put(new DecafCoffee(),INGREDIENT_CAPACITY);
		ingredientStock.put(new Espresso(),INGREDIENT_CAPACITY);
		ingredientStock.put(new FoamedMilk(),INGREDIENT_CAPACITY);
		ingredientStock.put(new SteamedMilk(),INGREDIENT_CAPACITY);
		ingredientStock.put(new Sugar(),INGREDIENT_CAPACITY);
		ingredientStock.put(new WhippedCream(),INGREDIENT_CAPACITY);
	}
	public void start() {
		displayInventory();
		displayMenu();
	}
	
	private void displayInventory() {
		System.out.println("Inventory:");
		for (Map.Entry<Ingredient, Integer> entry:ingredientStock.entrySet()) {
			System.out.println("\t"+entry.getKey()+","+entry.getValue());
		}
	}
	
	private void displayMenu() {
		System.out.println("Menu:");
		for (int i=0;i<drinkList.size();i++) {
			System.out.println("\t"+(i+1)+","+drinkList.get(i)+","+isDrinkOutOfStock(drinkList.get(i)));
		}
	}
	
	private boolean isDrinkOutOfStock(Drink drink) {
		if (drink==null) {
			throw new NullPointerException("Drink object is null");
		}
		for (Map.Entry<Ingredient, Integer> entry: drink.getIngredients().entrySet()) {
			Ingredient in=entry.getKey();
			int stock=ingredientStock.get(in);
			if(stock<entry.getValue()) {
				return false;
			}
		}
		return true;
	}
}
