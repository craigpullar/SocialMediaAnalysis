import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Timer;

import twitter4j.TwitterException;



public class Application {
	
	public static void main(String[] args) throws Exception {
		@SuppressWarnings("unused")
		final
		Frame frame = new Frame();
		final Database db = new Database();
		final Scraper scraper = new Scraper(db);
		
		frame.getTwitterScrapeButton().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String searchTerm = frame.getSearchInput().getText();
				scraper.setSearchTerm(searchTerm);
				scraper.start();
				}
		});
		
		scraper.setTweets(db.selectAllTweets());
		for (int i = 0; i < scraper.getTweets().size();i++){
			Tweet tweet = scraper.getTweets().get(i);
			tweet.printTweet();
		}
		
	}
}
