import java.util.Map;
import java.util.TreeMap;
import java.util.List;

import drink.Drink;
import ingredient.Ingredient;
import valueInitialization.Default;



public class JavaMaticMachine {
	private final static int INGREDIENT_CAPACITY=10;
	private final List<Drink> drinkList=Default.getDefaultDrinks();
	private Map<Ingredient, Integer> ingredientStock=new TreeMap<Ingredient, Integer>();
	
	public JavaMaticMachine() {
		restockIngredients();
	}
	
	private void restockIngredients(){
		for (Ingredient in: Default.getDefaultIngredients()) {
			ingredientStock.put(in, INGREDIENT_CAPACITY);
		}
	}
	
	public void start() {
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
			System.out.println((i+1)+","+drinkList.get(i)+","+isDrinkOutOfStock(drinkList.get(i)));
		}
	}
	
	public void reStock() {
		restockIngredients();
		displayInventory();
		displayMenu();
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
	
	public int getMenuSize() {
		return drinkList.size();
	}
}
