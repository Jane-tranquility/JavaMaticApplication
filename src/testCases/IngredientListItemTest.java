package testCases;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import ingredient.Ingredient;
import ingredient.IngredientListItem;

class IngredientListItemTest {

	@Test
	void testConstructorUnitsException(){
		Assertions.assertThrows(IllegalArgumentException.class, new Executable() {

	        @Override
	        public void execute() throws Throwable {

	        	Ingredient ingredient=new Ingredient("Coffee", new BigDecimal("0.90"));
				@SuppressWarnings("unused")
				IngredientListItem ingredientListItem=new IngredientListItem(ingredient, -1);

	        }
	    });
	}
	
	@Test
	void testConstructorIngredientException(){
		Assertions.assertThrows(IllegalArgumentException.class, new Executable() {

	        @Override
	        public void execute() throws Throwable {
				@SuppressWarnings("unused")
				IngredientListItem ingredientListItem=new IngredientListItem(null, 4);

	        }
	    });
	}
	
	@Test
	void testGetIngredient() {
		Ingredient ingredient=new Ingredient("Coffee", new BigDecimal("0.90"));
		IngredientListItem ingredientListItem=new IngredientListItem(ingredient, 2);
		Ingredient in=ingredientListItem.getIngredient();
		Assertions.assertEquals(in,ingredient);
	}
	
	@Test
	void testGetUnit() {
		Ingredient ingredient=new Ingredient("Coffee", new BigDecimal("0.90"));
		IngredientListItem ingredientListItem=new IngredientListItem(ingredient, 2);
		int unit=ingredientListItem.getUnits();
		Assertions.assertSame(unit,2);
	}

}
