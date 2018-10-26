package testCases;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import exceptions.NoMatchItemFoundException;
import valueInitialization.DefaultIngredients;



class NoMatchItemFoundExceptionTest {

	@Test
	void test() {
		Assertions.assertThrows(NoMatchItemFoundException.class, new Executable() {

	        @Override
	        public void execute() throws Throwable {
	        	
	        	DefaultIngredients.searchIngredientByName("Caramel Macciato");
	        }
	    });
	}

}
