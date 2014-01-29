import java.awt.Dimension;


public class Application {
	
	public static void main(String[] args) throws Exception {
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		@SuppressWarnings("unused")
		Frame frame = new Frame(screenSize);
		Database db = new Database();
		createDB createDB = new createDB(db);
		createDB.create();
		
	}
}
