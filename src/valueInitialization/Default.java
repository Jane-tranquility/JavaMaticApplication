package valueInitialization;
import java.util.List;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.TreeMap;

import drink.Drink;
import ingredient.Ingredient;
import exceptions.NoMatchItemFoundException;

@SuppressWarnings("serial")
public final class Default {
	
	private static final List<Ingredient> defaultIngredients=new ArrayList<Ingredient>();
	static {
		defaultIngredients.add(new Ingredient("Cocoa", new BigDecimal("0.90")));
		defaultIngredients.add(new Ingredient("Coffee", new BigDecimal("0.75")));
		defaultIngredients.add(new Ingredient("Cream", new BigDecimal("0.25")));
		defaultIngredients.add(new Ingredient("Decaf Coffee", new BigDecimal("0.75")));
		defaultIngredients.add(new Ingredient("Espresso", new BigDecimal("1.10")));
		defaultIngredients.add(new Ingredient("Foamed Milk", new BigDecimal("0.35")));
		defaultIngredients.add(new Ingredient("Steamed Milk", new BigDecimal("0.35")));
		defaultIngredients.add(new Ingredient("Sugar", new BigDecimal("0.25")));
		defaultIngredients.add(new Ingredient("Whipped Cream", new BigDecimal("1.00")));
	}
	
	public static List<Ingredient> getDefaultIngredients(){
		return defaultIngredients;
	}
	
	private static boolean containsIngredientByName(String name) {
		if (name==null) {
			throw new NullPointerException("name is null");
		}
		List<String> temp=new ArrayList<String>();
		for (Ingredient in: defaultIngredients) {
			temp.add(in.getName());
		}
		if (temp.contains(name)) {
			return true;
		}else {
			return false;
		}
	}
	
	public static Ingredient searchIngredientByName(String name) throws NoMatchItemFoundException{
		if (name==null) {
			throw new NullPointerException("searchByName method searched by a null name");
		}
		
		if (!containsIngredientByName(name)) {
			throw new NoMatchItemFoundException("No item in Ingredients list that match the name");
		}else {
			for (Ingredient in: defaultIngredients) {
				if (in.getName().equals(name)) {
					return in;
				}
			}
		}
		return null;
		
		
	}
	
	private static final List<Drink> defaultDrinks=new ArrayList<Drink>();
	static{
		try {
			defaultDrinks.add(new Drink("Caffe Americano", new TreeMap<Ingredient, Integer>() {{
				put(searchIngredientByName("Espresso"),3);
			}}));
			defaultDrinks.add(new Drink("Caffe Latte", new TreeMap<Ingredient, Integer>() {{
				put(searchIngredientByName("Espresso"),2);
				put(searchIngredientByName("Steamed Milk"),1);
			}}));
			defaultDrinks.add(new Drink("Caffe Mocha", new TreeMap<Ingredient, Integer>() {{
				put(searchIngredientByName("Espresso"),1);
				put(searchIngredientByName("Cocoa"),1);
				put(searchIngredientByName("Steamed Milk"),1);
				put(searchIngredientByName("Whipped Cream"),1);
			}}));
			defaultDrinks.add(new Drink("Cappuccino", new TreeMap<Ingredient, Integer>() {{
				put(searchIngredientByName("Espresso"),2);
				put(searchIngredientByName("Steamed Milk"),1);
				put(searchIngredientByName("Foamed Milk"),1);
			}}));
			defaultDrinks.add(new Drink("Coffee", new TreeMap<Ingredient, Integer>() {{
				put(searchIngredientByName("Coffee"),3);
				put(searchIngredientByName("Sugar"),1);
				put(searchIngredientByName("Cream"),1);
			}}));
			defaultDrinks.add(new Drink("Decaf Coffee", new TreeMap<Ingredient, Integer>() {{
				put(searchIngredientByName("Decaf Coffee"),3);
				put(searchIngredientByName("Sugar"),1);
				put(searchIngredientByName("Cream"),1);
			}}));
		}catch(NoMatchItemFoundException e) {
			System.out.print("default drink list failed, because of ingredient name not searchable");
		}
		
	};
	public static List<Drink> getDefaultDrinks() {
		return defaultDrinks;
	}
}
