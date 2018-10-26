package testCases;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import exceptions.NoMatchItemFoundException;
import ingredient.Ingredient;
import valueInitialization.DefaultIngredients;


class DefaultIngredientsTest {

	@Test
	void testSearchNullException() {
		Assertions.assertThrows(IllegalArgumentException.class, new Executable() {

	        @Override
	        public void execute() throws Throwable {
	        	DefaultIngredients.searchIngredientByName(null);
	        }
	    });
	}
	
	@Test
	void testSearchNoItemFoundException() {
		Assertions.assertThrows(NoMatchItemFoundException.class, new Executable() {

	        @Override
	        public void execute() throws Throwable {
	        	DefaultIngredients.searchIngredientByName("Caramel Macciato");
	        }
	    });
	}
	
	@Test
	void testSearchIngredientByName1() {
		String output;
		try {
			Ingredient ingredient=DefaultIngredients.searchIngredientByName("Coffee");
			output=ingredient.toString();
		}catch(NoMatchItemFoundException e) {
			output="No matched Ingredient found";
		}
		Assertions.assertEquals("Coffee", output);
		
	}
	
	@Test
	void testSearchIngredientByName2() {
		String output;
		try {
			Ingredient ingredient=DefaultIngredients.searchIngredientByName("Caramel Macciato");
			output=ingredient.toString();
		}catch(NoMatchItemFoundException e) {
			output="No matched Ingredient found";
		}
		Assertions.assertEquals("No matched Ingredient found", output);
		
	}

}
