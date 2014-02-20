import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Timer;

import twitter4j.TwitterException;



public class Application {
	
	public static void main(String[] args) throws Exception {
		@SuppressWarnings("unused")
		final Database db = new Database();
		final Frame frame = new Frame(db);
		final Scraper scraper = new Scraper(db);
		
		
		
		frame.getTwitterScrapeButton().addActionListener(new ActionListener(){
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {//If the scrape button is clicked
				// TODO Auto-generated method stub
				if (!scraper.isRunning()){
					String searchTerm = frame.getSearchInput().getText();//Get search term
					Analysis analysis = new Analysis(searchTerm);//Create analysis object
					Analyser analyser = new Analyser(analysis);
					System.out.println(analysis.getID());
					try {
						db.saveAnalysis(analysis);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}//Save analysis object

					frame.getScrapeStatus().setText("Scraping..");
					scraper.setAnalysis(analysis);//set the search term of the scraper
					scraper.setRunning(true);
				}
				else {
					scraper.setRunning(false);
					frame.getScrapeStatus().setText("Not currently scraping");
				}
			}
		});
		
		scraper.setTweets(db.selectAllTweets());//Load tweets into memory
		for (int i = 0; i < scraper.getTweets().size();i++){//Print tweets
			Tweet tweet = scraper.getTweets().get(i);
			tweet.printTweet();
		}
		
	}
}
