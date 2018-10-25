import java.util.Scanner;

public class JavaMaticApplication {

	public static void main(String[] args) {
		JavaMaticMachine machine=new JavaMaticMachine();
		machine.display();
		int length=machine.getMenuSize();
		Scanner s=new Scanner(System.in);
		String input=s.nextLine();
		while(!input.equals("q") && !input.equals("Q")){
			
			try {
				if (input.equals("r") || input.equals("R")){
					machine.reStock();
				}else if (Integer.parseInt(input)>0 && Integer.parseInt(input)<=length) {
					machine.makeDrink(Integer.parseInt(input));
				}else {
					System.out.println("Invalid Selection:"+input);
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
