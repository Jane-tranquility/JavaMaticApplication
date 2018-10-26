package valueInitialization;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import exceptions.NoMatchItemFoundException;
import ingredient.Ingredient;

public final class DefaultIngredients {
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
			throw new NullPointerException("name is null, can not be searchable in ingredient list");
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
			throw new NullPointerException("searchByName method searched by a null name, which is illegal");
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
}
