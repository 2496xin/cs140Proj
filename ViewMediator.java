package projectview;

import java.util.Observable;

import javax.swing.JFrame;

import project.MachineModel;

public class ViewMediator extends Observable {
	private MachineModel model;
	private JFrame frame;
	
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
}
