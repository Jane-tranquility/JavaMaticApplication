import java.util.Scanner;

public class JavaMaticApplication {

	public static void main(String[] args) {
		JavaMaticMachine machine=new JavaMaticMachine();
		machine.start();
		
		Scanner s=new Scanner(System.in);
		String input=s.nextLine();
		while(!input.equals("q") && !input.equals("Q")){
			if (input.equals("r") || input.equals("R")){
				machine.reStock();
			}
			input=s.nextLine();
		}
		
		s.close();
	}

}
