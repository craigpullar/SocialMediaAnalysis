import java.awt.Dimension;


public class Application {
	
	public static void main(String[] args) {
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		@SuppressWarnings("unused")
		Frame frame = new Frame(screenSize);
		
	}
}
