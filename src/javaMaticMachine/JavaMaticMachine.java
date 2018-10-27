package javaMaticMachine;
import java.util.SortedMap;
import java.util.TreeMap;

import exceptions.DrinkOutOfStockException;

import java.util.List;

import ingredient.Drink;
import ingredient.Ingredient;
import ingredient.IngredientListItem;
import valueInitialization.DefaultDrinks;
import valueInitialization.DefaultIngredients;


/*
 * JavaMaticMachine class--deals with the main business logic of the coffee machine
 * -reStock the ingredients
 * -makeDrink if the choice is valid
 * -check whether a drink is out of stock
 */
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
	
	/*
	 * reStock method:
	 * to assign 10 units to each ingredient of the machine
	 */
	public void reStock() {
		for (SortedMap.Entry<Ingredient, Integer> entry: ingredientStock.entrySet()) {
			ingredientStock.put(entry.getKey(), INGREDIENT_CAPACITY);
		}
	}
	
	private int getMenuSize() {
		return drinkList.size();
	}
	
	/*
	 * make the drink if the index is valid:
	 * -check index is in range of 1 to size of the menu
	 * -if a number is valid, check whether a drink is out of stock
	 *  	-if out of stock, throw the out of stock exception
	 *      -if not out of stock, dispensing the drink and update the stock
	 */
	public void makeDrink(int index) throws DrinkOutOfStockException{
		if(index<1 || index>getMenuSize()) {
			throw new IllegalArgumentException("Invalid Selection:"+index);
		}else {
			Drink drink=drinkList.get(index-1);
			if (isDrinkOutOfStock(drink)) {
				throw new DrinkOutOfStockException("Out of stock:"+drink.getName());
			}else {
				System.out.println("Dispensing:"+drink.getName());
				updateStock(drink);
			}
		}
		
	}
	
	/*
	 * Update the stock by stock of an ingredient - the units of the ingredient a drink needs
	 */
	private void updateStock(Drink drink) {
		if (drink==null) {
			throw new IllegalArgumentException("Drink object is null");
		}
		for (IngredientListItem recipe: drink.getRecipe()) {
			Ingredient in=recipe.getIngredient();
			int stock=ingredientStock.get(in);
			ingredientStock.put(in, stock-recipe.getUnits());
		}
	}
	
	/*
	 * to check whether s drink is out of stock by comparing number stock of an ingredient and drink recipe
	 * if the stock >= recipe needs, not out of stock, return false
	 * if  stock < recipe needs, return true
	 * @return boolean
	 */
	public boolean isDrinkOutOfStock(Drink drink) {
		if (drink==null) {
			throw new IllegalArgumentException("Drink object is null");
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
