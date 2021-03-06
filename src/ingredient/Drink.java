package ingredient;
import java.math.BigDecimal;
import java.util.List;

/*
 *  Drink class
 *  name-- Drink's name
 *  recipe-- a list of IngredientListItem objects where defines how many units of each ingredient needed in the drink
 *  cost-- cost of the whole drink
 */
public class Drink implements Comparable<Drink>{
	private final String name;
	private final List<IngredientListItem> recipe;
	private BigDecimal cost;
	
	public Drink(String name, List<IngredientListItem> recipe){
		if (name==null) {
			throw new IllegalArgumentException("name can not be null during Drink construction.");
		}
		if (recipe==null) {
			throw new IllegalArgumentException("recipe can not be null during Drink construction.");
		}
		this.name=name;
		this.recipe=recipe;
		initializeCost();
	}
	
	
	private void initializeCost() {
		this.cost=new BigDecimal("0.00");
		for (IngredientListItem entry: this.recipe) {
			this.cost=this.cost.add(entry.getItemPrice());
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public BigDecimal getCost() {
		return this.cost;
	}
	
	public List<IngredientListItem> getRecipe() {
		return this.recipe;
	}
	
	/*
	 * Compare by name
	 */
	@Override
	public int compareTo(Drink other) {
		if (other==null) {
			throw new IllegalArgumentException("Can not compare a Drink object "+this+" with a null object");
		}
		return this.name.compareTo(other.name);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/*
	 * 	Two drinks are considered to be equal when their names are equal.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Drink other = (Drink) obj;
		if (!name.equals(other.name)) {
			return false;
		}else {
			return true;
		}
		
	}
	/*
	 * String representation of the class is the name attribute + cost .
	 */
	@Override
	public String toString() {
		return name + ",$" + cost;
	}
	
	
	
	
}
