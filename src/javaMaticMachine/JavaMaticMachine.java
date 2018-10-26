package javaMaticMachine;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.List;

import ingredient.Drink;
import ingredient.Ingredient;
import ingredient.IngredientListItem;
import valueInitialization.DefaultDrinks;
import valueInitialization.DefaultIngredients;


public class JavaMaticMachine {
	private final static int INGREDIENT_CAPACITY=10;
	private final List<Drink> drinkList=DefaultDrinks.getDefaultDrinks();
	private final List<Ingredient> ingredientList=DefaultIngredients.getDefaultIngredients();
	private SortedMap<Ingredient, Integer> ingredientStock=new TreeMap<Ingredient, Integer>();
	
	public JavaMaticMachine() {
		restockIngredients();
	}
	
	private void restockIngredients(){
		for (Ingredient in: ingredientList) {
			ingredientStock.put(in, INGREDIENT_CAPACITY);
		}
	}
	
	public SortedMap<Ingredient, Integer> getStock(){
		return this.ingredientStock;
	}
	
	public List<Drink> getDrinkMenu(){
		return this.drinkList;
	}
	
	
	public void reStock() {
		for (SortedMap.Entry<Ingredient, Integer> entry: ingredientStock.entrySet()) {
			ingredientStock.put(entry.getKey(), INGREDIENT_CAPACITY);
		}
	}
	
	private int getMenuSize() {
		return drinkList.size();
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
		for (IngredientListItem recipe: drink.getRecipe()) {
			Ingredient in=recipe.getIngredient();
			int stock=ingredientStock.get(in);
			ingredientStock.put(in, stock-recipe.getUnits());
		}
	}
	
	public boolean isDrinkOutOfStock(Drink drink) {
		if (drink==null) {
			throw new NullPointerException("Drink object is null");
		}
		for (IngredientListItem recipe: drink.getRecipe()) {
			Ingredient in=recipe.getIngredient();
			int stock=ingredientStock.get(in);
			if(stock<recipe.getUnits()) {
				return true;
			}
		}
		return false;
	}
	
}
