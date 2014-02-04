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



public class Scraper {
	
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
	
	//--------------------\\
	//--[[CONSTRUCTORS]]--\\
	//--------------------\\
	public Scraper(){
		this.cb = new ConfigurationBuilder();
		this.tweets = new ArrayList<Tweet>();
		this.users = new ArrayList<User>();
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
	public void searchTweets(String searchTerm) throws TwitterException{
		Query query = new Query(searchTerm);//define the query
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
	        this.tweets.add(this.tweet);//add tweet to list of tweets
	    }
	}
	
	public void clearTweets(){
		this.tweets = new ArrayList<Tweet>();
	}
	
	//------------------------\\
	//--[[GETTER & SETTERS]]--\\
	//------------------------\\
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
}
