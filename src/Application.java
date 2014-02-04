import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import twitter4j.TwitterException;



public class Application {
	
	public static void main(String[] args) throws Exception {
		@SuppressWarnings("unused")
		final
		Frame frame = new Frame();
		Database db = new Database();
		final Scraper scraper = new Scraper();
		frame.getTwitterScrapeButton().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String searchTerm = frame.getSearchInput().getText();
				try {
					scraper.searchTweets(searchTerm);
				} catch (TwitterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for (int i = 0; i < scraper.getTweets().size();i++){
					Tweet tweet = scraper.getTweets().get(i);
					tweet.printTweet();
				}
			}
		});

		
	}
}
