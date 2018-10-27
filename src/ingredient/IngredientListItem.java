package ingredient;
import java.math.BigDecimal;

/*
 *  IngredientListItem class--a pair of Ingredient and units needed for a drink
 */
public class IngredientListItem {
	private final Ingredient ingredient;
	private int units;
	
	public IngredientListItem(Ingredient ingredient, int units) {
		if (ingredient==null) {
			throw new IllegalArgumentException("ingredient can not be null during RecipeItem construction.");
		}
		if (units<1) {
			throw new IllegalArgumentException("can not have 0 or less than 0 units of ingredient for a recipeItem.");
		}
		this.ingredient=ingredient;
		this.units=units;
	}
	
	public Ingredient getIngredient() {
		return this.ingredient;
	}
	
	public int getUnits() {
		return this.units;
	}
	
	/*
	 * return the price for each ingredient in a drink
	 * by unit price* units
	 */
	public BigDecimal getItemPrice() {
		return ingredient.getUnitCost().multiply(new BigDecimal(units));
	}
}
