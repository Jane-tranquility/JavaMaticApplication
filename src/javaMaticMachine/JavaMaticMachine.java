package javaMaticMachine;
import java.util.Map;
import java.util.TreeMap;
import java.util.List;

import drink.Drink;
import ingredient.Ingredient;
import valueInitialization.DefaultDrinks;
import valueInitialization.DefaultIngredients;


public class JavaMaticMachine {
	private final static int INGREDIENT_CAPACITY=10;
	private final List<Drink> drinkList=DefaultDrinks.getDefaultDrinks();
	private Map<Ingredient, Integer> ingredientStock=new TreeMap<Ingredient, Integer>();
	
	public JavaMaticMachine() {
		restockIngredients();
	}
	
	private void restockIngredients(){
		for (Ingredient in: DefaultIngredients.getDefaultIngredients()) {
			ingredientStock.put(in, INGREDIENT_CAPACITY);
		}
	}
	
	public void reStock() {
		restockIngredients();
	}
	
	public void display() {
		displayInventory();
		displayMenu();
	}
	
	private void displayInventory() {
		System.out.println("Inventory:");
		for (Map.Entry<Ingredient, Integer> entry:ingredientStock.entrySet()) {
			System.out.println(entry.getKey()+","+entry.getValue());
		}
	}
	
	private void displayMenu() {
		System.out.println("Menu:");
		for (int i=0;i<drinkList.size();i++) {
			System.out.println((i+1)+","+drinkList.get(i)+","+!isDrinkOutOfStock(drinkList.get(i)));
		}
	}
	
	public void makeDrink(int index) {
		if(index<1 || index>getMenuSize()) {
			System.out.println("Invalid Selection:"+index);
		}else {
			Drink drink=drinkList.get(index-1);
			if (isDrinkOutOfStock(drink)) {
				System.out.println("Out of stock:"+drink.getName());
			}else {
				System.out.println("Dispensing:"+drink.getName());
				updateStock(drink);
			}
		}
		
	}
	
	private void updateStock(Drink drink) {
		if (drink==null) {
			throw new NullPointerException("Drink object is null");
		}
		for (Map.Entry<Ingredient, Integer> recipe: drink.getIngredients().entrySet()) {
			Ingredient in=recipe.getKey();
			int stock=ingredientStock.get(in);
			ingredientStock.put(in, stock-recipe.getValue());
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
				return true;
			}
		}
		return false;
	}
	
	private int getMenuSize() {
		return drinkList.size();
	}
}
