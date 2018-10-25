package drink;

import java.util.TreeMap;
import ingredient.Espresso;
import ingredient.SteamedMilk;
import ingredient.Ingredient;

public class CaffeLatte extends Drink{
	@SuppressWarnings("serial")
	CaffeLatte(){
		super("Caffe Latte", new TreeMap<Ingredient, Integer>(){
		{
			put(new Espresso(),2);
			put(new SteamedMilk(),1);
		}});
	}
}
