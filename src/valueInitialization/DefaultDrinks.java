package valueInitialization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//import java.util.TreeMap;

import exceptions.NoMatchItemFoundException;
import ingredient.Drink;
import ingredient.IngredientListItem;


public class DefaultDrinks {
	private static final List<Drink> defaultDrinks=new ArrayList<Drink>();
	static{
		try {
			defaultDrinks.add(new Drink("Caffe Americano",Arrays.asList( 
				new IngredientListItem(DefaultIngredients.searchIngredientByName("Espresso"),3))));
			defaultDrinks.add(new Drink("Caffe Latte",Arrays.asList(
				new IngredientListItem(DefaultIngredients.searchIngredientByName("Espresso"),2),
				new IngredientListItem(DefaultIngredients.searchIngredientByName("Steamed Milk"),1))));
			defaultDrinks.add(new Drink("Caffe Mocha", Arrays.asList(
				new IngredientListItem(DefaultIngredients.searchIngredientByName("Espresso"),1),
				new IngredientListItem(DefaultIngredients.searchIngredientByName("Cocoa"),1),
				new IngredientListItem(DefaultIngredients.searchIngredientByName("Steamed Milk"),1),
				new IngredientListItem(DefaultIngredients.searchIngredientByName("Whipped Cream"),1))));
			defaultDrinks.add(new Drink("Cappuccino", Arrays.asList(
			    new IngredientListItem(DefaultIngredients.searchIngredientByName("Espresso"),2),
				new IngredientListItem(DefaultIngredients.searchIngredientByName("Steamed Milk"),1),
				new IngredientListItem(DefaultIngredients.searchIngredientByName("Foamed Milk"),1))));
			defaultDrinks.add(new Drink("Coffee", Arrays.asList(
				new IngredientListItem(DefaultIngredients.searchIngredientByName("Coffee"),3),
				new IngredientListItem(DefaultIngredients.searchIngredientByName("Sugar"),1),
				new IngredientListItem(DefaultIngredients.searchIngredientByName("Cream"),1))));
			defaultDrinks.add(new Drink("Decaf Coffee", Arrays.asList(
				new IngredientListItem(DefaultIngredients.searchIngredientByName("Decaf Coffee"),3),
				new IngredientListItem(DefaultIngredients.searchIngredientByName("Sugar"),1),
				new IngredientListItem(DefaultIngredients.searchIngredientByName("Cream"),1))));
		}catch(NoMatchItemFoundException e) {
			System.out.print("default drink list addition failed, because of ingredient name not searchable");
		}
		
	};
	public static List<Drink> getDefaultDrinks() {
		return defaultDrinks;
	}
}
