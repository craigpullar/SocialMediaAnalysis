import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Frame extends JFrame{
	
	//---------------\\
	//--[[DECLARE]]--\\
	//---------------\\
	private int width;
	private int height;
	private JPanel panel;
	
	//--------------------\\
	//--[[CONSTRUCTORS]]--\\
	//--------------------\\
	public Frame(int width, int height) {
		this.width = width;
		this.height = height;
		this.panel = new JPanel();
		
		this.setContentPane(this.panel);
		this.setLayout(null);
		this.setPreferredSize(new Dimension(this.width, this.height));
		this.setMinimumSize(new Dimension(this.width,this.height));
		this.setMaximumSize(new Dimension(this.width,this.height));
		this.setResizable(false);
		this.setLocation(20,20);
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
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
}
