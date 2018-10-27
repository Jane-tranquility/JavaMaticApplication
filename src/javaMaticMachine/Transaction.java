package javaMaticMachine;

import java.util.Scanner;

import exceptions.DrinkOutOfStockException;


/*
 * Transaction class takes an input from the user and acts accordingly.
 */
public class Transaction {
	private MachineDisplay screen;
	private Scanner s=new Scanner(System.in);
	
	public Transaction(MachineDisplay screen) {
		if (screen==null) {
			throw new IllegalArgumentException("screen can not be null when doing construction for Transaction.");
		}
		this.screen=screen;
	}
	
	/*
	 * to start the transaction
	 */
	public void start() {
		screen.display();
		
		String input=s.nextLine();
		// if user input is 'q' or 'Q', quit the application
		while(!input.equals("q") && !input.equals("Q")){
			try {
				//if the user input is empty line, do nothing
				if(input.isEmpty()) {
					input=s.nextLine();
					continue;
					//if the user input is 'r' or '	r', reStock the inventory of the machine
				}else if (input.equals("r") || input.equals("R")){
					System.out.println("Restocking the Inventory...");
					screen.pushToReStock();
				}else {
					//make drinks 
					screen.pushToMakeDrink(Integer.parseInt(input));
				}
				//if the choice can not be converted to an integer ==>NumberFormatException=>invalid selection
			}catch(NumberFormatException e) {
				System.out.println("Invalid Selection:"+input);
				//if drink out of order==>DrinkOutOfStockException ==>print out of order
			}catch(DrinkOutOfStockException e2) {
				System.out.println(e2.getMessage());
				//if the passing integer is out of range=>illegalArgumentException=>print invalid selection
			}catch(IllegalArgumentException e3) {
				System.out.println(e3.getMessage());
			}
			screen.display();
			input=s.nextLine();
		}
		System.out.println("Quittin the application...");
		end();
	}
	
	/*
	 * close the Scanner
	 */
	private void end() {
		s.close();
	}
}
