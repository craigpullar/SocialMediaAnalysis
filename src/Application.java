import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;


public class Application {
	
	public static void main(String[] args) {
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		@SuppressWarnings("unused")
		Frame frame = new Frame(screenSize);
		
	}
}
