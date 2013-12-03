import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Frame extends JFrame{
	
	//---------------\\
	//--[[DECLARE]]--\\
	//---------------\\
	private Dimension screenSize;
	private JPanel panel;
	
	//--------------------\\
	//--[[CONSTRUCTORS]]--\\
	//--------------------\\
	public Frame(Dimension screenSize) {
		this.screenSize = screenSize;
		this.panel = new JPanel();
		
		this.setContentPane(this.panel);
		this.setLayout(null);
		this.setPreferredSize(this.screenSize);
		this.setMinimumSize(this.screenSize);
		this.setMaximumSize(this.screenSize);
		this.setResizable(false);
		this.setLocation(0,0);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Social Media Anaylsis");
		
		this.pack();
		this.setVisible(true);
	}

	//----------------\\
	//--[[FUNCTIONS]]--\\
	//-----------------\\
	
	//-----------------------\\
	//--[[GETTER & SETTER]]--\\
	//-----------------------\\
	
	public Dimension getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(Dimension screenSize) {
		this.screenSize = screenSize;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
}
