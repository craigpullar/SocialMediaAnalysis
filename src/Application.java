import java.awt.Dimension;


public class Application {
	
	public static void main(String[] args) throws Exception {
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		@SuppressWarnings("unused")
		Frame frame = new Frame(screenSize);
		Database db = new Database();
		Scraper scraper = new Scraper();
		scraper.searchTweets("Justin Beiber");
		for (int i = 0; i < scraper.getTweets().size();i++){
			Tweet tweet = scraper.getTweets().get(i);
			tweet.printTweet();
		}
		
	}
}
