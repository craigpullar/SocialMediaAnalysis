import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;



public class Scraper {
	
	//---------------\\
	//--[[DECLARE]]--\\
	//---------------\\
	private Twitter twitter;
	private TwitterFactory twitterFactory;
	private ConfigurationBuilder cb;
	
	//--------------------\\
	//--[[CONSTRUCTORS]]--\\
	//--------------------\\
	public Scraper(){
		this.cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
			.setOAuthConsumerKey("D6hyDIHzqSscjJNNUjzk9Q")
			.setOAuthConsumerSecret("ZrhZJmzcoHOgZds3LWtXfVLD6pcCgTPoUaVc2cdrCA")
			.setOAuthAccessToken("16239325-tBacRdawcrlxIb4pt6LUAilRPOErLsctHuWvax26u")
			.setOAuthAccessTokenSecret("uWL2FyTMXREjK8dBfjbuDzo130tt4sYRu1Wu8n8WJEdFX");
		this.twitterFactory = new TwitterFactory(cb.build());
		this.twitter = this.twitterFactory.getInstance();
	}
	
	//----------------\\
	//--[[FUNCTIONS]]--\\
	//-----------------\\
	public void search(String searchTerm) throws TwitterException{
		Query query = new Query(searchTerm);
		QueryResult result = this.twitter.search(query);
	    for (Status status : result.getTweets()) {
	        System.out.println(status.getText());
	    }
	}
}
