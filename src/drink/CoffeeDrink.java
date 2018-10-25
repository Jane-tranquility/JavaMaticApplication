package drink;
import java.util.TreeMap;
import ingredient.Coffee;
import ingredient.Cream;
import ingredient.Ingredient;
import ingredient.Sugar;

public class CoffeeDrink extends Drink{
	@SuppressWarnings("serial")
	public CoffeeDrink(){
		super("Coffee", new TreeMap<Ingredient, Integer>(){
		{
			put(new Coffee(),3);
			put(new Sugar(),1);
			put(new Cream(),1);
		}});
	}
}
