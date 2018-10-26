package testCases;


import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import ingredient.Ingredient;

class IngredientTest {

	@Test 
	void testConstructorException() {
		
		Assertions.assertThrows(IllegalArgumentException.class, new Executable() {

	        @Override
	        public void execute() throws Throwable {

	            @SuppressWarnings("unused")
				Ingredient ingredient=new Ingredient("Coffee", null);

	        }
	    });
	}
	
	@Test 
	void testGetName() {
		Ingredient ingredient=new Ingredient("Coffee", new BigDecimal("0.90"));
		Assertions.assertEquals("Coffee", ingredient.getName());
	}
	
	@Test 
	void testGetUnitCost() {
		Ingredient ingredient=new Ingredient("Coffee", new BigDecimal("0.90"));
		Assertions.assertEquals(new BigDecimal("0.90"), ingredient.getUnitCost());
	}
	
	@Test 
	void testCompareToException() {
		Assertions.assertThrows(IllegalArgumentException.class, new Executable() {

	        @Override
	        public void execute() throws Throwable {

	            Ingredient ingredient=new Ingredient("Coffee", new BigDecimal("0.90"));
	            @SuppressWarnings("unused")
				int compare=ingredient.compareTo(null);

	        }
	    });
	}
	
	@Test 
	void testCompareTo() {
		Ingredient ingredient1=new Ingredient("Coffee", new BigDecimal("0.90"));
		Ingredient ingredient2=new Ingredient("Coffee",new BigDecimal("0.80"));
		Ingredient ingredient3=new Ingredient("Decaf Coffee",new BigDecimal("0.80"));
        int compare12=ingredient1.compareTo(ingredient2);
        int compare23=ingredient2.compareTo(ingredient3);
        Assertions.assertSame(0, compare12);
        Assertions.assertTrue(compare23<0);
	}
	
	@Test 
	void testEquals() {
		Ingredient ingredient1=new Ingredient("Coffee", new BigDecimal("0.90"));
		Ingredient ingredient2=new Ingredient("Coffee",new BigDecimal("0.80"));
		Ingredient ingredient3=new Ingredient("Decaf Coffee",new BigDecimal("0.80"));
		boolean equals12=ingredient1.equals(ingredient2);
        boolean equals23=ingredient2.equals(ingredient3);
        boolean equalsNull=ingredient2.equals(null);
        Assertions.assertTrue(equals12);
        Assertions.assertFalse(equals23);
        Assertions.assertFalse(equalsNull);
	}
	
	@Test 
	void testToString() {
		Ingredient ingredient=new Ingredient("Coffee", new BigDecimal("0.90"));
		Assertions.assertEquals("Coffee", ingredient.toString());
	}

}
