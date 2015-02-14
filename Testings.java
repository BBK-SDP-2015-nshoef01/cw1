package cw1;

import static org.junit.Assert.*; 

import org.junit.Test;
/**
 * This is a test class.
 * I assumed I need to test only the methods I had to implement, 
 * therefore I didn't write a test class for each class and put all my testings together in this class. 
 * For each test there is a text file with a relevant computation to test.
 */
public class Testings {
	

	/**
	 * This is a test for the method execute() in the class SubInstruction.
	 * File in use: sub.txt
	 */
	@Test
	public void testExecuteSub() {
		Machine m = new Machine();
		Translator t = new Translator("sub.txt");
		t.readAndTranslate(m.getLabels(), m.getProg());
		m.execute();
		assertEquals(m.getRegisters().getRegister(3),16);
	}
	/**
	 * This is a test for the method execute() in class MulInstruction.
	 * File in sue: mul.txt
	 */
	
	@Test
	public void testExecuteMul(){
		Machine m = new Machine();
		Translator t = new Translator("mul.txt");
		t.readAndTranslate(m.getLabels(), m.getProg());
		m.execute();
		assertEquals(m.getRegisters().getRegister(3), 14);
	}
	
	/**
	 * This is a test for the method execute() in class DivInstruction.
	 * File in use: div.txt
	 */
	@Test
	public void testExecuteDiv(){
		Machine m = new Machine();
		Translator t = new Translator("div.txt");
		t.readAndTranslate(m.getLabels(), m.getProg());
		m.execute();
		assertEquals(m.getRegisters().getRegister(3), 2);
	}
	
	/**
	 * This is a test for the method execute() in class OutInstruction.
	 * File in use: out.txt
	 */
	@Test
	public void testExecuteOut(){
		Machine m = new Machine();
		Translator t = new Translator("out.txt");
		t.readAndTranslate(m.getLabels(), m.getProg());
		m.execute();
		assertEquals(m.getProg().get(1).opcode, "out");	
	}
	
	/**
	 * This is a test for the method execute() in class BnzInstruction.
	 * File in use: bnz.txt
	 */
	@Test
	public void testExecuteBnz(){
		Machine m = new Machine();
		Translator t = new Translator("bnz.txt");
		t.readAndTranslate(m.getLabels(), m.getProg());
		m.execute();
		assertEquals(m.getRegisters().getRegister(2), 0);
	}
	/**
	 * This is an integration test check to make sure the machine can deal with a computation of different instructions together.
	 * File in use: integrate.txt
	 */
	@Test
	public void integrationTest() {
		Machine m = new Machine();
		Translator t = new Translator("integrate.txt");
		t.readAndTranslate(m.getLabels(), m.getProg());
		m.execute();
		assertEquals(m.getRegisters().getRegister(1), 0);
		assertEquals(m.getRegisters().getRegister(2), 50);
		assertEquals(m.getRegisters().getRegister(3), 4);
		assertEquals(m.getRegisters().getRegister(4), 1);
		assertEquals(m.getRegisters().getRegister(30), 1);
		assertEquals(m.getProg().get(9).opcode, "out");	
			
		
		
	}

}
