package testCases;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import exceptions.DrinkOutOfStockException;
import javaMaticMachine.JavaMaticMachine;


class DrinkOutOfStockExceptionTest {

	@Test
	void test() {
		Assertions.assertThrows(DrinkOutOfStockException.class, new Executable() {

	        @Override
	        public void execute() throws Throwable {
	        	JavaMaticMachine machine=new JavaMaticMachine();
	        	machine.makeDrink(1);
	        	machine.makeDrink(1);
	        	machine.makeDrink(1);
	        	machine.makeDrink(1);
	        }
	    });
	}

}
