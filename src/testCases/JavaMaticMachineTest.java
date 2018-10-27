package testCases;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import exceptions.DrinkOutOfStockException;
import ingredient.Drink;
import ingredient.Ingredient;
import javaMaticMachine.JavaMaticMachine;
import valueInitialization.DefaultDrinks;
import valueInitialization.DefaultIngredients;

class JavaMaticMachineTest {

	@Test
	void testGetStock() {
		JavaMaticMachine machine=new JavaMaticMachine();
		SortedMap<Ingredient, Integer> stock=machine.getStock();
		SortedMap<Ingredient, Integer> expected=new TreeMap<Ingredient, Integer>();
		for (Ingredient item: DefaultIngredients.getDefaultIngredients()) {
			expected.put(item, 10);
		}
		
		Assertions.assertEquals(expected, stock);
	}
	
	@Test
	void testGetDrinkMenu() {
		JavaMaticMachine machine=new JavaMaticMachine();
		List<Drink> stock=machine.getDrinkMenu();
		List<Drink> expected=DefaultDrinks.getDefaultDrinks();
		
		Assertions.assertEquals(expected, stock);
	}
	
	@Test
	void testReStock() {
		JavaMaticMachine machine=new JavaMaticMachine();
		try {
			machine.makeDrink(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		SortedMap<Ingredient, Integer> expected=new TreeMap<Ingredient, Integer>();
		for (Ingredient item: DefaultIngredients.getDefaultIngredients()) {
			expected.put(item, 10);
		}
		
		Assertions.assertNotEquals(expected, machine.getStock());
		machine.reStock();
		Assertions.assertEquals(expected, machine.getStock());
	}
	
	@Test
	void testMakeDrinkIndexTooSmall() {
		JavaMaticMachine machine=new JavaMaticMachine();
		SortedMap<Ingredient, Integer> expected=new TreeMap<Ingredient, Integer>();
		for (Ingredient item: DefaultIngredients.getDefaultIngredients()) {
			expected.put(item, 10);
		}
		String output="";
		try {
			machine.makeDrink(0);
		}catch(IllegalArgumentException e) {
			output=e.getMessage();
		}catch(DrinkOutOfStockException e2) {
			output=e2.getMessage();
		}
		Assertions.assertEquals(expected, machine.getStock());
		Assertions.assertEquals("Invalid Selection:0", output);
	}
	
	@Test
	void testMakeDrinkIndexTooBig() {
		JavaMaticMachine machine=new JavaMaticMachine();
		SortedMap<Ingredient, Integer> expected=new TreeMap<Ingredient, Integer>();
		for (Ingredient item: DefaultIngredients.getDefaultIngredients()) {
			expected.put(item, 10);
		}
		String output="";
		try {
			machine.makeDrink(10);
		}catch(IllegalArgumentException e) {
			output=e.getMessage();
		}catch(DrinkOutOfStockException e2) {
			output=e2.getMessage();
		}
		Assertions.assertEquals(expected, machine.getStock());
		Assertions.assertEquals("Invalid Selection:10", output);
	}
	
	@Test
	void testMakeDrink() {
		JavaMaticMachine machine=new JavaMaticMachine();
		SortedMap<Ingredient, Integer> expected=new TreeMap<Ingredient, Integer>();
		for (Ingredient item: DefaultIngredients.getDefaultIngredients()) {
			if (item.getName().equals("Espresso")) {
				expected.put(item, 1);
			}else {
				expected.put(item, 10);
			}
		}
		String output="";
		try {
			machine.makeDrink(1);
			machine.makeDrink(1);
			machine.makeDrink(1);
			machine.makeDrink(1);
		}catch(IllegalArgumentException e) {
			output=e.getMessage();
		}catch(DrinkOutOfStockException e2) {
			output=e2.getMessage();
		}
		Assertions.assertEquals(expected, machine.getStock());
		Assertions.assertEquals("Out of stock:Caffe Americano", output);
	}
	
	@Test
	void testIsOutOfStockNull() {
		Assertions.assertThrows(IllegalArgumentException.class, new Executable() {

	        @Override
	        public void execute() throws Throwable {
	        	JavaMaticMachine machine=new JavaMaticMachine();
	    		machine.isDrinkOutOfStock(null);
	        }
	    });
	}

	@Test
	void testIsOutOfStock() {
		JavaMaticMachine machine=new JavaMaticMachine();
		Drink drink=machine.getDrinkMenu().get(0);
		Assertions.assertFalse(machine.isDrinkOutOfStock(drink));
		
		try {
			machine.makeDrink(1);
			machine.makeDrink(1);
			machine.makeDrink(1);
		}catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}catch(DrinkOutOfStockException e2) {
			System.out.println(e2.getMessage());
		}
		
		Assertions.assertTrue(machine.isDrinkOutOfStock(drink));
	}
}
