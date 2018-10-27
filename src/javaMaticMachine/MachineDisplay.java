package javaMaticMachine;

import java.util.Map;

import exceptions.DrinkOutOfStockException;
import ingredient.Ingredient;

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
	
	private void displayInventory() {
		System.out.println("Inventory:");
		for (Map.Entry<Ingredient, Integer> entry:machine.getStock().entrySet()) {
			System.out.println(entry.getKey()+","+entry.getValue());
		}
	}
	
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
	
	
//	public void transactionStart() {
//		display();
//		Scanner s=new Scanner(System.in);
//		String input=s.nextLine();
//		while(!input.equals("q") && !input.equals("Q")){
//			try {
//				if(input.isEmpty()) {
//					input=s.nextLine();
//					continue;
//				}else if (input.equals("r") || input.equals("R")){
//					machine.reStock();
//				}else {
//					machine.makeDrink(Integer.parseInt(input));
//				}
//			}catch(NumberFormatException e) {
//				System.out.println("Invalid Selection:"+input);
//			}
//			display();
//			input=s.nextLine();
//		}
//		s.close();
//	}
	
}
