package drink;

import java.util.TreeMap;
import ingredient.Espresso;
import ingredient.SteamedMilk;
import ingredient.Ingredient;
import ingredient.FoamedMilk;

public class Cappuccino extends Drink{
	@SuppressWarnings("serial")
	public Cappuccino(){
		super("Cappuccino", new TreeMap<Ingredient, Integer>(){
		{
			put(new Espresso(),2);
			put(new SteamedMilk(),1);
			put(new FoamedMilk(),1);
		}});
	}
}
