package cw1;

import static org.junit.Assert.*; 

import org.junit.Test;
/**
 * I assumed I need to test only the methods I had to implement, 
 * therefore I didn't write a test class for each class and put all my testings together in this class. 
 */
public class Testings {
	

	/**
	 * This is a test for the method execute() in the class SubInstruction.
	 */
	@Test
	public void testExecuteSub() {
		Machine m = new Machine();
		Translator t = new Translator("sub.txt");
		t.readAndTranslate(m.getLabels(), m.getProg());
		m.execute();
		assertEquals(m.getRegisters().getRegister(3),16);
	}
	
	@Test
	public void testExecuteMul(){
		Machine m = new Machine();
		Translator t = new Translator("mul.txt");
		t.readAndTranslate(m.getLabels(), m.getProg());
		m.execute();
		assertEquals(m.getRegisters().getRegister(3), 14);
	}
	@Test
	public void testExecuteDiv(){
		Machine m = new Machine();
		Translator t = new Translator("div.txt");
		t.readAndTranslate(m.getLabels(), m.getProg());
		m.execute();
		assertEquals(m.getRegisters().getRegister(3), 2);
	}
	@Test
	public void testExecuteOut(){
		Machine m = new Machine();
		Translator t = new Translator("out.txt");
		t.readAndTranslate(m.getLabels(), m.getProg());
		m.execute();
		assertEquals(m.getProg().get(1).opcode, "out");	
	}

}
