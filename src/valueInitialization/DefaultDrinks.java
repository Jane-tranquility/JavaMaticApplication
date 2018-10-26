package valueInitialization;

import java.util.ArrayList;
import java.util.List;
//import java.util.TreeMap;

import drink.Drink;
import exceptions.NoMatchItemFoundException;
//import ingredient.Ingredient;
import recipes.Recipe;
import recipes.RecipeItem;

@SuppressWarnings("serial")
public class DefaultDrinks {
	private static final List<Drink> defaultDrinks=new ArrayList<Drink>();
	static{
		try {
//			defaultDrinks.add(new Drink("Caffe Americano", new TreeMap<Ingredient, Integer>() {{
//				put(DefaultIngredients.searchIngredientByName("Espresso"),3);
//			}}));
//			defaultDrinks.add(new Drink("Caffe Latte", new TreeMap<Ingredient, Integer>() {{
//				put(DefaultIngredients.searchIngredientByName("Espresso"),2);
//				put(DefaultIngredients.searchIngredientByName("Steamed Milk"),1);
//			}}));
//			defaultDrinks.add(new Drink("Caffe Mocha", new TreeMap<Ingredient, Integer>() {{
//				put(DefaultIngredients.searchIngredientByName("Espresso"),1);
//				put(DefaultIngredients.searchIngredientByName("Cocoa"),1);
//				put(DefaultIngredients.searchIngredientByName("Steamed Milk"),1);
//				put(DefaultIngredients.searchIngredientByName("Whipped Cream"),1);
//			}}));
//			defaultDrinks.add(new Drink("Cappuccino", new TreeMap<Ingredient, Integer>() {{
//				put(DefaultIngredients.searchIngredientByName("Espresso"),2);
//				put(DefaultIngredients.searchIngredientByName("Steamed Milk"),1);
//				put(DefaultIngredients.searchIngredientByName("Foamed Milk"),1);
//			}}));
//			defaultDrinks.add(new Drink("Coffee", new TreeMap<Ingredient, Integer>() {{
//				put(DefaultIngredients.searchIngredientByName("Coffee"),3);
//				put(DefaultIngredients.searchIngredientByName("Sugar"),1);
//				put(DefaultIngredients.searchIngredientByName("Cream"),1);
//			}}));
//			defaultDrinks.add(new Drink("Decaf Coffee", new TreeMap<Ingredient, Integer>() {{
//				put(DefaultIngredients.searchIngredientByName("Decaf Coffee"),3);
//				put(DefaultIngredients.searchIngredientByName("Sugar"),1);
//				put(DefaultIngredients.searchIngredientByName("Cream"),1);
//			}}));
			defaultDrinks.add(new Drink("Caffe Americano",new Recipe(new ArrayList<RecipeItem>() {{
				add(new RecipeItem(DefaultIngredients.searchIngredientByName("Espresso"),3));
			}})));
			defaultDrinks.add(new Drink("Caffe Latte",new Recipe(new ArrayList<RecipeItem>() {{
				add(new RecipeItem(DefaultIngredients.searchIngredientByName("Espresso"),2));
				add(new RecipeItem(DefaultIngredients.searchIngredientByName("Steamed Milk"),1));
			}})));
			defaultDrinks.add(new Drink("Caffe Mocha",new Recipe(new ArrayList<RecipeItem>() {{
				add(new RecipeItem(DefaultIngredients.searchIngredientByName("Espresso"),1));
				add(new RecipeItem(DefaultIngredients.searchIngredientByName("Cocoa"),1));
				add(new RecipeItem(DefaultIngredients.searchIngredientByName("Steamed Milk"),1));
				add(new RecipeItem(DefaultIngredients.searchIngredientByName("Whipped Cream"),1));
			}})));
			defaultDrinks.add(new Drink("Cappuccino",new Recipe(new ArrayList<RecipeItem>() {{
				add(new RecipeItem(DefaultIngredients.searchIngredientByName("Espresso"),2));
				add(new RecipeItem(DefaultIngredients.searchIngredientByName("Steamed Milk"),1));
				add(new RecipeItem(DefaultIngredients.searchIngredientByName("Foamed Milk"),1));
			}})));
			defaultDrinks.add(new Drink("Coffee",new Recipe(new ArrayList<RecipeItem>() {{
				add(new RecipeItem(DefaultIngredients.searchIngredientByName("Coffee"),3));
				add(new RecipeItem(DefaultIngredients.searchIngredientByName("Sugar"),1));
				add(new RecipeItem(DefaultIngredients.searchIngredientByName("Cream"),1));
			}})));
			defaultDrinks.add(new Drink("Decaf Coffee",new Recipe(new ArrayList<RecipeItem>() {{
				add(new RecipeItem(DefaultIngredients.searchIngredientByName("Decaf Coffee"),3));
				add(new RecipeItem(DefaultIngredients.searchIngredientByName("Sugar"),1));
				add(new RecipeItem(DefaultIngredients.searchIngredientByName("Cream"),1));
			}})));
		}catch(NoMatchItemFoundException e) {
			System.out.print("default drink list addition failed, because of ingredient name not searchable");
		}
		
	};
	public static List<Drink> getDefaultDrinks() {
		return defaultDrinks;
	}
}
