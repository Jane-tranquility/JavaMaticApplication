package testCases;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import javaMaticMachine.JavaMaticMachine;
import javaMaticMachine.MachineDisplay;

class MachineDisplayTest {

	@Test
	void testParameterInConstructor() {
		Assertions.assertThrows(IllegalArgumentException.class, new Executable() {

	        @Override
	        public void execute() throws Throwable {
	    		@SuppressWarnings("unused")
				MachineDisplay screen=new MachineDisplay(null);
	        }
	    });
	}
	
	@Test
	void testGetMachine() {
		JavaMaticMachine machine=new JavaMaticMachine();
		MachineDisplay screen=new MachineDisplay(machine);
		
		Assertions.assertEquals(machine, screen.getMachine());
	}

}
