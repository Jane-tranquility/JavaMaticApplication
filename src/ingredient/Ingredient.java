package ingredient;

import java.math.BigDecimal;

/*
 * Ingredient class
 *  name-- Ingredient's name
 *  unitCost-- cost of one unit of the ingredient in BigDecimal representation
 */
public class Ingredient implements Comparable<Ingredient>{
	private final String name;
	private final BigDecimal unitCost;

	public Ingredient(String name, BigDecimal unitCost){
		if (name==null) {
			throw new IllegalArgumentException("name can not be null during Ingredient construction.");
		}
		if (unitCost==null) {
			throw new IllegalArgumentException("unitCost can not be null during Ingredient construction.");
		}
		this.name=name;
		this.unitCost=unitCost;
	}

	public String getName(){
		return this.name;
	}

	public BigDecimal getUnitCost(){
		return this.unitCost;
	}
	
	/*
	 * Compare by name
	 */
	@Override
	public int compareTo(Ingredient other){
		if (other==null) {
			throw new IllegalArgumentException("Can not compare an Ingredient object "+this+" with a null object");
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
	 * 	Two ingredients are considered to be equal when their names are equal.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingredient other = (Ingredient) obj;
		if (!name.equals(other.name)) {
			return false;
		}else {
			return true;
		}
		
	}

	/*
	 * String representation of the class is the name attribute.
	 */
	@Override
	public String toString(){
		return this.name;
	}

}