package drink;

import java.util.TreeMap;
import ingredient.DecafCoffee;
import ingredient.Cream;
import ingredient.Ingredient;
import ingredient.Sugar;

public class DecafCoffeeDrink extends Drink{
	@SuppressWarnings("serial")
	public DecafCoffeeDrink(){
		super("Decaf Coffee", new TreeMap<Ingredient, Integer>(){
		{
			put(new DecafCoffee(),3);
			put(new Sugar(),1);
			put(new Cream(),1);
		}});
	}
}
