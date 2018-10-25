package drink;

import java.util.TreeMap;
import ingredient.Espresso;
import ingredient.Ingredient;

public class CaffeAmericano extends Drink{
	@SuppressWarnings("serial")
	CaffeAmericano(){
		super("Caffe Americano", new TreeMap<Ingredient, Integer>(){
		{
			put(new Espresso(),3);
		}});
	}
}
