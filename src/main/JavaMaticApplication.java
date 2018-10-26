package main;

import javaMaticMachine.JavaMaticMachine;
import javaMaticMachine.MachineDisplay;
import javaMaticMachine.Transaction;

public class JavaMaticApplication {

	public static void main(String[] args) {
		JavaMaticMachine machine=new JavaMaticMachine();
		MachineDisplay screen=new MachineDisplay(machine);
		Transaction transaction=new Transaction(screen);
		transaction.start();
	}

}
