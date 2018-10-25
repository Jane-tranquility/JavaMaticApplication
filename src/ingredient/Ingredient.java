package ingredient;
import java.math.BigDecimal;

public class Ingredient implements Comparable<Ingredient>{
	private final String name;
	private final BigDecimal unitCost;

	public Ingredient(String name, BigDecimal unitCost){
		this.name=name;
		this.unitCost=unitCost;
	}

	public String getName(){
		return this.name;
	}

	public BigDecimal getUnitCost(){
		return this.unitCost;
	}
	

	@Override
	public int compareTo(Ingredient other){
		if (other==null) {
			throw new NullPointerException("Comparing Ingredient " + this+" with a Null Pointer.");
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
		Ingredient other = (Ingredient) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString(){
		return this.name;
	}

}