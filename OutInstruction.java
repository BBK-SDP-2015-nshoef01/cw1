package cw1;

public class OutInstruction extends Instruction{
	
	private int result;

	public OutInstruction(String l, String op) {
		super(l, op);
	}
	
	public OutInstruction(String label, int result) {
		this(label, "out");
		this.result = result;
	}


	@Override
	public void execute(Machine m) {
		int value1 = m.getRegisters().getRegister(result);
		System.out.println(value1);
		
	}

}
