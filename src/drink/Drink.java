package drink;
import java.math.BigDecimal;
import java.util.Map;
import ingredient.Ingredient;

public abstract class Drink implements Comparable<Drink>{
	private final String name;
	private final Map<Ingredient, Integer> ingredientMap;
	private BigDecimal cost=new BigDecimal("0.00");
	
	Drink(String name, Map<Ingredient, Integer> ingredientMap){
		this.name=name;
		this.ingredientMap=ingredientMap;
		initializeCost();
	}
	
	
	private void initializeCost() {
		for (Map.Entry<Ingredient, Integer> entry: this.ingredientMap.entrySet()) {
			for (int i=0;i<entry.getValue();i++) {
				this.cost=this.cost.add(entry.getKey().getUnitCost());
			}
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public BigDecimal getCost() {
		return this.cost;
	}
	
	public Map<Ingredient, Integer> getIngredients(){
		return this.getIngredients();
	}
	
	public int getIngredientCount(Ingredient ingredient) {
		if (ingredient==null) {
			throw new NullPointerException("A null ingredient does not have ingredient count");
		}
		
		for (Map.Entry<Ingredient, Integer> entry: this.ingredientMap.entrySet()) {
			if (entry.getKey().equals(ingredient)) {
				return entry.getValue();
			}
		}
		return 0;
	}

	@Override
	public int compareTo(Drink other) {
		if (other==null) {
			throw new NullPointerException("Comparing Drink " + this+" with a Null Pointer.");
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Drink other = (Drink) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return name + ",$" + cost;
	}
	
	
	
	
}
