package main;
import java.util.Scanner;

import javaMaticMachine.JavaMaticMachine;

public class JavaMaticApplication {

	public static void main(String[] args) {
		JavaMaticMachine machine=new JavaMaticMachine();
		machine.display();
		Scanner s=new Scanner(System.in);
		String input=s.nextLine();
		while(!input.equals("q") && !input.equals("Q")){
			
			try {
				if(input.isEmpty()) {
					input=s.nextLine();
					continue;
				}else if (input.equals("r") || input.equals("R")){
					machine.reStock();
				}else {
					machine.makeDrink(Integer.parseInt(input));
				}
			}catch(NumberFormatException e) {
				System.out.println("Invalid Selection:"+input);
			}
			machine.display();
			input=s.nextLine();
		}
		
		s.close();
	}

}
