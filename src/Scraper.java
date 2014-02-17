import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import twitter4j.GeoLocation;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;



public class Scraper extends Thread{
	
	//---------------\\
	//--[[DECLARE]]--\\
	//---------------\\
	private Twitter twitter;
	private TwitterFactory twitterFactory;
	private ConfigurationBuilder cb;
	private ArrayList<Tweet> tweets;
	private ArrayList<User> users;
	private User user;
	private Tweet tweet;
	private Database db;
	private boolean running;
	private Analysis analysis;
	
	//--------------------\\
	//--[[CONSTRUCTORS]]--\\
	//--------------------\\
	public Scraper(Database db){
		this.db = this.setDb(db);//creates a sb object to be used within the class
		this.cb = new ConfigurationBuilder();//Configures the twitter developer account
		this.tweets = new ArrayList<Tweet>();
		this.users = new ArrayList<User>();
		this.setAnalysis(analysis);
		cb.setDebugEnabled(true)
			.setOAuthConsumerKey("D6hyDIHzqSscjJNNUjzk9Q")
			.setOAuthConsumerSecret("ZrhZJmzcoHOgZds3LWtXfVLD6pcCgTPoUaVc2cdrCA")
			.setOAuthAccessToken("16239325-tBacRdawcrlxIb4pt6LUAilRPOErLsctHuWvax26u")
			.setOAuthAccessTokenSecret("uWL2FyTMXREjK8dBfjbuDzo130tt4sYRu1Wu8n8WJEdFX");//Configuration ends here
		this.twitterFactory = new TwitterFactory(cb.build());//Set the twitter object config to our config
		this.twitter = this.twitterFactory.getInstance();//Get twitter
		this.running = false;
		this.start();
	}
	
	//----------------\\
	//--[[FUNCTIONS]]--\\
	//-----------------\\
	public void searchTweets(String searchTerm) throws TwitterException{
		Query query = new Query(searchTerm);//define the query
		query.setCount(100);//Set number of tweets to return per page MAX 100
		QueryResult result = this.twitter.search(query);//search and commit results to variable
		
	    for (Status status : result.getTweets()) {//Loop through results
	    	twitter4j.User scrapedUser = status.getUser();//Get the user from the tweet
	    	
	    	//Get the tweet fields
	    	long ID = status.getId();
	    	long userID = scrapedUser.getId();
	    	String content = status.getText();
	    	Date date = status.getCreatedAt();
	    	GeoLocation location = status.getGeoLocation();
	    	
	    	//Get the user fields
		    int noTweets = scrapedUser.getStatusesCount();
		    int following = scrapedUser.getFriendsCount();
		    int followers = scrapedUser.getFollowersCount();
		    String userLocation = scrapedUser.getLocation();
		    Date joinDate = scrapedUser.getCreatedAt();

		    this.user = new User(userID,noTweets,following,followers,userLocation,joinDate);//Create user as defined by us
		    this.users.add(this.user);//add user to list of users

	        this.tweet = new Tweet(ID,userID,content,date,location);//Create a tweet as defined by us
	        this.tweets.add(tweet);//add tweet to list of tweets
	    }
	}
	
	public void clearTweets(){
		this.tweets = new ArrayList<Tweet>();
	}
	
	public void run() {//Overide the thread function so when the thread starts this is run
		while(true){
			while(this.isRunning()){
				if (!this.isRunning()){
					this.setRunning(false);
				}
				this.clearTweets();//Clear memory of tweets
				try {
					this.searchTweets(analysis.getSearchTerm());//Search for tweets
				} catch (TwitterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				for (int i = 0; i < this.getTweets().size();i++){//Loop through tweets
					Tweet tweet = this.getTweets().get(i);
					try {
						if(!this.db.tweetExists(tweet)){//if tweet does not exist in DB
							this.db.saveTweet(tweet,this.analysis);//Save tweet to DB
							tweet.printTweet();//Print tweet to console
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				this.clearTweets();//Clear tweets from memory
				
				for (int i = 0; i < this.getUsers().size(); i++) {//Loop through users
					User user = this.getUsers().get(i);
					try {
						if (!this.db.userExists(user)) {//If user does not exist in DB
							this.db.saveUser(user);//Save user to DB
							System.out.println("USER SAVED!");
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {
					this.sleep(10 * 1000);//ReSchedule event for 10 seconds time
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			while(!this.isRunning()){
				if(this.isRunning()) {
					this.setRunning(true);
				}
			}
		}
	}
	


	//------------------------\\
	//--[[GETTER & SETTERS]]--\\
	//------------------------\\
	public boolean isRunning() {
		return this.running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}
	
	public Twitter getTwitter() {
		return twitter;
	}

	public void setTwitter(Twitter twitter) {
		this.twitter = twitter;
	}

	public TwitterFactory getTwitterFactory() {
		return twitterFactory;
	}

	public void setTwitterFactory(TwitterFactory twitterFactory) {
		this.twitterFactory = twitterFactory;
	}

	public ConfigurationBuilder getCb() {
		return cb;
	}

	public void setCb(ConfigurationBuilder cb) {
		this.cb = cb;
	}

	public ArrayList<Tweet> getTweets() {
		return tweets;
	}

	public void setTweets(ArrayList<Tweet> tweets) {
		this.tweets = tweets;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Tweet getTweet() {
		return tweet;
	}

	public void setTweet(Tweet tweet) {
		this.tweet = tweet;
	}

	public Database getDb() {
		return db;
	}

	public Database setDb(Database db) {
		return this.db = db;
	}
	
	public Analysis getAnalysis() {
		return analysis;
	}

	public void setAnalysis(Analysis analysis) {
		this.analysis = analysis;
	}
}
