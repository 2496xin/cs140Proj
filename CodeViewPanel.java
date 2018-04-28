package projectview;

import project.MachineModel;
import project.Memory;

public class CodeViewPanel implements Observer{
	private MachineModel model;
	private JScrollPane scroller;
	private JTextField[] codeHex = new JTextField[Memory.CODE_MAX/2];
	private JTextField[] codeDecimal = new JTextField[Memory.CODE_MAX/2];
	private int previousColor = -1;

	
	public CodeViewPanel(ViewMediator gui, MachineModel mdl) {
		model = mdl;
		gui.addObserver(this);
	}
}