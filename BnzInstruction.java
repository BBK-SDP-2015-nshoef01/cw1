package cw1;

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

}
