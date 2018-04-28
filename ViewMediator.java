package projectview;

import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JPanel;

import project.MachineModel;
import java.awt.Container;

public class ViewMediator extends Observable {
	private MachineModel model;
	private JFrame frame;
	private MachineModel model;
	private CodeViewPanel codeViewPanel;
	private MemoryViewPanel memoryViewPanel1;
	private MemoryViewPanel memoryViewPanel2;
	private MemoryViewPanel memoryViewPanel3;
	//private ControlPanel controlPanel;
	//private ProcessorViewPanel processorPanel;
	//private MenuBarBuilder menuBuilder;
	private JFrame frame;
	private FilesManager filesManager;
	private Animator animator;
	
	public MachineModel getModel() {
		return model;
	}

	public void setModel(MachineModel model) {
		this.model = model;
	}

	public JFrame getFrame() {
		return frame;
	}
	
	public void step() {
		
	}
	
	public void setModel(MachineModel m) {
		model = m;
	}
	
	public MachineModel getModel() {
		return model;
	}
	
	private void createAndShowGUI() {
		animator = new Animator(this);
		filesManager = new FilesManager(this);
		filesManager.initialize();
		codeViewPanel = new CodeViewPanel(this, model);
		memoryViewPanel1 = new memoryViewPanel(this, model, 240);
		memoryViewPanel2 = new memoryViewPanel(this, model, Memory.DATA_SIZE/2);
		memoryViewPanel3 = new memoryViewPanel(this, model, Memory.DATA_SIZE/2, Memory.DATA_SIZE);
		//controlPanel = new ControlPanel(this);
		//processorPanel = new ProcessorPanel(this, model);
		//menuBuilder = new MenuBuilder(this);
		frame = new JFrame("Simulator");//syntax
		Container content = frame.getContentPane();
		
		content.setLayout(new BorderLayout(1,1));
		content.setBackground(Color.BLACK);
		
		frame.setSize(1200,600);//??
		JPanel center = new GridLayout(1, 3);
		frame.add(codeViewPanel.createCodeDisplay(),BorderLayout.LINE_START);
		center.add(memoryViewPanel1.createMemoryDisplay());
		center.add(memoryViewPanel2.createMemoryDisplay());
		center.add(memoryViewPanel3.createMemoryDisplay());
		
		//A grid layout (1,3) will put the three components side by side in equal amounts of space.
			
		frame.add(center,BorderLayout.CENTER); //"return HERE for the other GUI components."
	
		//Add the lines about closing the GUI (although we will replace it later) and showing the GUI
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// return HERE for other setup details
		frame.setVisible(true);
 
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ViewMediator mediator = new ViewMediator();
				MachineModel model = new MachineModel(
				//true,  
				//() -> mediator.setCurrentState(States.PROGRAM_HALTED)
				);
				mediator.setModel(model);
				mediator.createAndShowGUI();
			}
		});
	}
	States getCurrentState() {
		return //??
	}
	void setCurrentState(States currentState){
		return //??
	}
	
	/*
	At the state of this set method if currentState == States.PROGRAM_HALTED, then call animator.setAutoStepOn(false); 
	(Recall that the contants of an enum are Singleton objects--there can only be one copy in the whole program. 
	Therefore we can safely use == for equality). After calling the setCurrentState in model, we must repeat the 
	three lines that always follow a change of state (let's call these the 3 NOTIFY LINES):

	model.getCurrentState().enter();
	
	setChanged();
	notifyObservers();
	The call to the enter of a new state just makes sure the boolean array in the object is correct and then the notification mechanism of the Observer Pattern is invoked.
	 */
	
	public void exit() { // method executed when user exits the program
		int decision = JOptionPane.showConfirmDialog(
				frame, "Do you really wish to exit?",
				"Confirmation", JOptionPane.YES_NO_OPTION);
		if (decision == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
}
