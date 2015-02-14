package cw1;
/**
 * 
 * @author Noam
 * This instruction check if the value of a specified register is not 0.
 * If it's not, it instruct the machine to move to a specified label of the programme and keep the execution form there.
 */

public class BnzInstruction extends Instruction {
	
	private int register;
	private String nextLabel;
	

	public BnzInstruction(String l, String op) {
		super(l, op);
	}
	
	public BnzInstruction(String label, int register, String nextLabel) {
		this(label, "bnz");
		this.register = register;
		this.nextLabel = nextLabel;		
	}

	@Override
	public void execute(Machine m) {
		if (m.getRegisters().getRegister(register) != 0) {
			m.execute(m.getLabels().indexOf(nextLabel));
		}
	
	}
	@Override
	public String toString() {
		return super.toString() + " if register " + register + " is 0, move to label " + nextLabel;
	}

}
