import java.util.Map;
import java.util.TreeMap;

import drink.*;
import ingredient.*;



public class JavaMaticMachine {
	private static int INGREDIENT_CAPACITY=10;
	private Map<Drink, Boolean> drinkList=new TreeMap<Drink, Boolean>();
	private Map<Ingredient, Integer> ingredientStock=new TreeMap<Ingredient, Integer>();
	
	public JavaMaticMachine() {
		initializeDrinkList();
		initializeIngredients();
	}
	
	private void initializeDrinkList() {
		drinkList.put(new CaffeAmericano(), true);
		drinkList.put(new CaffeLatte(), true);
		drinkList.put(new CaffeMocha(), true);
		drinkList.put(new Cappuccino(), true);
		drinkList.put(new CoffeeDrink(), true);
		drinkList.put(new DecafCoffeeDrink(), true);
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
		int count=1;
		for (Map.Entry<Drink, Boolean> entry:drinkList.entrySet()) {
			System.out.println("\t"+count+","+entry.getKey()+","+entry.getValue());
			count++;
		}
	}
}
