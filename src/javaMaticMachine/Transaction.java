package javaMaticMachine;

import java.util.Scanner;

import exceptions.DrinkOutOfStockException;

public class Transaction {
	private MachineDisplay screen;
	private Scanner s=new Scanner(System.in);
	
	public Transaction(MachineDisplay screen) {
		if (screen==null) {
			throw new IllegalArgumentException("screen can not be null when doing construction for Transaction.");
		}
		this.screen=screen;
	}
	
	public void start() {
		screen.display();
		
		String input=s.nextLine();
		while(!input.equals("q") && !input.equals("Q")){
			try {
				if(input.isEmpty()) {
					input=s.nextLine();
					continue;
				}else if (input.equals("r") || input.equals("R")){
					screen.pushToReStock();
				}else {
					screen.pushToMakeDrink(Integer.parseInt(input));
				}
			}catch(NumberFormatException e) {
				System.out.println("Invalid Selection:"+input);
			}catch(DrinkOutOfStockException e2) {
				System.out.println(e2.getMessage());
			}catch(IllegalArgumentException e3) {
				System.out.println(e3.getMessage());
			}
			screen.display();
			input=s.nextLine();
		}
		end();
	}
	
	private void end() {
		s.close();
	}
}
