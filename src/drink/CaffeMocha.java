package drink;

import java.util.TreeMap;
import ingredient.Espresso;
import ingredient.SteamedMilk;
import ingredient.Ingredient;
import ingredient.Cocoa;
import ingredient.WhippedCream;

public class CaffeMocha extends Drink{
	@SuppressWarnings("serial")
	CaffeMocha(){
		super("Caffe Mocha", new TreeMap<Ingredient, Integer>(){
		{
			put(new Espresso(),1);
			put(new Cocoa(),1);
			put(new SteamedMilk(),1);
			put(new WhippedCream(),1);
		}});
	}
}