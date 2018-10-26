package testCases;

import java.math.BigDecimal;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import ingredient.Drink;
import ingredient.Ingredient;
import ingredient.IngredientListItem;

class DrinkTest {

	@Test 
	void testConstructorNameException() {
		
		Assertions.assertThrows(IllegalArgumentException.class, new Executable() {

	        @Override
	        public void execute() throws Throwable {
	        	Ingredient ingredient1=new Ingredient("Coffee", new BigDecimal("0.90"));
	        	IngredientListItem ingredientListItem1=new IngredientListItem(ingredient1, 2);
	        	Ingredient ingredient2=new Ingredient("Coffee", new BigDecimal("0.90"));
	        	IngredientListItem ingredientListItem2=new IngredientListItem(ingredient2, 2);
	        	
	        	@SuppressWarnings("unused")
				Drink drink=new Drink(null, Arrays.asList(ingredientListItem1,ingredientListItem2));
	        }
	    });
	}
	
	@Test 
	void testConstructorIngredientListItemException() {
		
		Assertions.assertThrows(IllegalArgumentException.class, new Executable() {

	        @Override
	        public void execute() throws Throwable {
	        	
	        	@SuppressWarnings("unused")
				Drink drink=new Drink("Coffee", null);
	        }
	    });
	}
	
	@Test 
	void testGetName() {
		Ingredient coffee=new Ingredient("Coffee", new BigDecimal("0.75"));
    	IngredientListItem ingredientListItem1=new IngredientListItem(coffee, 3);
    	Ingredient sugar=new Ingredient("Sugar", new BigDecimal("0.25"));
    	IngredientListItem ingredientListItem2=new IngredientListItem(sugar, 1);
    	Ingredient cream=new Ingredient("Cream", new BigDecimal("0.25"));
    	IngredientListItem ingredientListItem3=new IngredientListItem(cream, 1);
		Drink drink=new Drink("Coffee", Arrays.asList(ingredientListItem1,ingredientListItem2,ingredientListItem3));
		
		Assertions.assertEquals("Coffee", drink.getName());
	}
	
	@Test 
	void testGetCost() {
		Ingredient coffee=new Ingredient("Coffee", new BigDecimal("0.75"));
    	IngredientListItem ingredientListItem1=new IngredientListItem(coffee, 3);
    	Ingredient sugar=new Ingredient("Sugar", new BigDecimal("0.25"));
    	IngredientListItem ingredientListItem2=new IngredientListItem(sugar, 1);
    	Ingredient cream=new Ingredient("Cream", new BigDecimal("0.25"));
    	IngredientListItem ingredientListItem3=new IngredientListItem(cream, 1);
		Drink drink=new Drink("Coffee", Arrays.asList(ingredientListItem1,ingredientListItem2,ingredientListItem3));
		
		Assertions.assertEquals(new BigDecimal("2.75"), drink.getCost());
	}
	
	@Test 
	void testGetRecipe() {
		Ingredient coffee=new Ingredient("Coffee", new BigDecimal("0.75"));
    	IngredientListItem ingredientListItem1=new IngredientListItem(coffee, 3);
    	Ingredient sugar=new Ingredient("Sugar", new BigDecimal("0.25"));
    	IngredientListItem ingredientListItem2=new IngredientListItem(sugar, 1);
    	Ingredient cream=new Ingredient("Cream", new BigDecimal("0.25"));
    	IngredientListItem ingredientListItem3=new IngredientListItem(cream, 1);
		Drink drink=new Drink("Coffee", Arrays.asList(ingredientListItem1,ingredientListItem2,ingredientListItem3));
		
		Assertions.assertEquals(Arrays.asList(ingredientListItem1,ingredientListItem2,ingredientListItem3), drink.getRecipe());
	}
	
	@Test 
	void testCompareToException() {
		Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
			
	        @Override
	        public void execute() throws Throwable {
	        	Ingredient coffee=new Ingredient("Coffee", new BigDecimal("0.75"));
	        	IngredientListItem ingredientListItem1=new IngredientListItem(coffee, 3);
	        	Ingredient sugar=new Ingredient("Sugar", new BigDecimal("0.25"));
	        	IngredientListItem ingredientListItem2=new IngredientListItem(sugar, 1);
	        	Ingredient cream=new Ingredient("Cream", new BigDecimal("0.25"));
	        	IngredientListItem ingredientListItem3=new IngredientListItem(cream, 1);
	    		Drink drink=new Drink("Coffee", Arrays.asList(ingredientListItem1,ingredientListItem2,ingredientListItem3));
	            
	            @SuppressWarnings("unused")
				int compare=drink.compareTo(null);

	        }
	    });
	}
	
	@Test 
	void testCompareTo() {
		
		Drink drink1=new Drink("Coffee", Arrays.asList(
				new IngredientListItem(new Ingredient("Coffee", new BigDecimal("0.75")),3),
				new IngredientListItem(new Ingredient("Sugar", new BigDecimal("0.25")),1),
				new IngredientListItem(new Ingredient("Cream", new BigDecimal("0.25")),1)));
		Drink drink2=new Drink("Caffe Americano",Arrays.asList( 
				new IngredientListItem(new Ingredient("Espresso", new BigDecimal("1.10")),3)));
		Drink drink3=new Drink("Caffe Americano",Arrays.asList( 
				new IngredientListItem(new Ingredient("Espresso", new BigDecimal("1.10")),10)));
			
		int compare12=drink1.compareTo(drink2);
        int compare23=drink2.compareTo(drink3);
        Assertions.assertTrue(compare12>0);
        Assertions.assertSame(0, compare23);
	}
	
	@Test
	void testEquals() {
		Drink drink1=new Drink("Coffee", Arrays.asList(
				new IngredientListItem(new Ingredient("Coffee", new BigDecimal("0.75")),3),
				new IngredientListItem(new Ingredient("Sugar", new BigDecimal("0.25")),1),
				new IngredientListItem(new Ingredient("Cream", new BigDecimal("0.25")),1)));
		Drink drink2=new Drink("Caffe Americano",Arrays.asList( 
				new IngredientListItem(new Ingredient("Espresso", new BigDecimal("1.10")),3)));
		Drink drink3=new Drink("Caffe Americano",Arrays.asList( 
				new IngredientListItem(new Ingredient("Espresso", new BigDecimal("1.10")),10)));
		
		boolean equals12=drink1.equals(drink2);
        boolean equals23=drink2.equals(drink3);
        boolean equalsNull=drink2.equals(null);
        Assertions.assertFalse(equals12);
        Assertions.assertTrue(equals23);
        Assertions.assertFalse(equalsNull);
	}
	
	@Test
	void testToSring() {
		Drink drink=new Drink("Coffee", Arrays.asList(
				new IngredientListItem(new Ingredient("Coffee", new BigDecimal("0.75")),3),
				new IngredientListItem(new Ingredient("Sugar", new BigDecimal("0.25")),1),
				new IngredientListItem(new Ingredient("Cream", new BigDecimal("0.25")),1)));
		Assertions.assertEquals("Coffee,$2.75", drink.toString());
	}

}
