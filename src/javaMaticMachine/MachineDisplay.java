package javaMaticMachine;

import java.util.Map;

import exceptions.DrinkOutOfStockException;
import ingredient.Ingredient;


/*
 * 	MachineDisplay works like the screen to display information to the user
 */
public class MachineDisplay {
	private JavaMaticMachine machine;
	
	public MachineDisplay(JavaMaticMachine machine) {
		if (machine==null) {
			throw new IllegalArgumentException("machine can not be null when doing construction for MachineDisplay.");
		}
		this.machine=machine;
	}
	
	public JavaMaticMachine getMachine() {
		return this.machine;
	}
	
	public void display() {
		displayInventory();
		System.out.println();
		displayMenu();
		System.out.println();
	}
	
	/*
	 * to display the inventory of the machine has
	 */
	private void displayInventory() {
		System.out.println("Inventory:");
		for (Map.Entry<Ingredient, Integer> entry:machine.getStock().entrySet()) {
			System.out.println(entry.getKey()+","+entry.getValue());
		}
	}
	
	/*
	 * to display names, and prices of each drink the machine can dispense
	 * and display to the user whether a drink is available
	 */
	private void displayMenu() {
		System.out.println("Menu:");
		for (int i=0;i<machine.getDrinkMenu().size();i++) {
			System.out.println((i+1)+","+machine.getDrinkMenu().get(i)+","+!machine.isDrinkOutOfStock(machine.getDrinkMenu().get(i)));
		}
	}
	
	public void pushToReStock() {
		machine.reStock();
	}
	
	public void pushToMakeDrink(int choice) throws DrinkOutOfStockException{
		machine.makeDrink(choice);
	}
	
}
