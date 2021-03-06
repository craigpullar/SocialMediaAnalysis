import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import twitter4j.GeoLocation;


public class Database {
	
	//--------------\\
	//--[[DECLARE]]--\\
	//---------------\\
	private Connection connection;
	static final String JDBC_DRIVER = "org.sqlite.JDBC";  
	static final String DB_URL = "jdbc:sqlite:rsrc/data.db";
	private String SQL;
	private File file;
	private Boolean dbExists;
	private Statement statement;
	
	//-------------------\\
	//--[[CONSTRUCTORS]]--\\
	//--------------------\\
	public Database() throws Exception{
		Class.forName(JDBC_DRIVER);
		
		//Check if the database file exists//
		file = new File("rsrc/data.db");
		if (file.exists()){
			this.dbExists = true;//Sets a boolean to true if it does exist
		}
		else {
			this.dbExists = false;//Sets a boolean to false otherwise
		}
		
		//Get the database connection, if it doesn't exist create the file
		connection = DriverManager.getConnection(DB_URL);
		
		//If the database was just created, create the tables
		if(!dbExists){
			this.create();
		}

	}
	
	//----------------\\
	//--[[FUNCTIONS]]--\\
	//-----------------\\
	public void executeSQL(String SQL) throws SQLException{//Execute SQL function
		this.setSQL(SQL);//Set SQL function
		this.statement = connection.createStatement();//Create new statement
		this.statement.execute(SQL);//Execute statement
	}
	//-----------------------\\
	//--[[SEARCH FUNCTIONS]]--\\
	//------------------------\\
	
	public ArrayList<Analysis> selectAllAnalysis() throws SQLException {
		ArrayList<Analysis> analysisList = new ArrayList<Analysis>();
		String SQL = "SELECT * FROM Analysis";
		this.executeSQL(SQL);
		ResultSet result = this.statement.getResultSet();
		while(result.next()) {
			int ID = result.getInt("ID");
			String searchTerm = result.getString("SearchTerm");
			Analysis analysis = new Analysis(ID,searchTerm);
			analysisList.add(analysis);
		}
		return analysisList;
		
	}
	public ArrayList<Tweet> searchTweets(String searchTerm) throws SQLException {
		ArrayList<Tweet> tweets = new ArrayList<Tweet>();
		String SQL = "SELECT * FROM Twitter_Tweet WHERE Content LIKE '% " + searchTerm + " %'";
		this.executeSQL(SQL);
		ResultSet result = this.statement.getResultSet();//Get results
		while (result.next()) {//Loop through results
			int ID = result.getInt("ID");
			int userID = result.getInt("UserID");
			String content = result.getString("Content");
			Date date = result.getDate("Date");
			double lat = result.getDouble("GeoLatitude");
			double lon = result.getDouble("GeoLongitude");
			GeoLocation location = new GeoLocation(lat,lon);
			Tweet tweet = new Tweet(ID,userID,content,date,location);//Create tweets
			tweets.add(tweet);//Add to list of tweets
		}
		return tweets;
	}
	//------------------------\\
	//--[[SELECT FUNCTIONS]]--\\
	//------------------------\\
	public ArrayList<Sentiment> selectSentiments(Analysis analysis) throws SQLException {
		ArrayList<Sentiment> sentiments = new ArrayList<Sentiment>();
		String SQL = "SELECT * FROM Twitter_Tweet_Sentiment_Analysis"
				+ " WHERE AnalysisID = " + analysis.getID();
		this.executeSQL(SQL);//execute SQL
		ResultSet result = this.statement.getResultSet();//Get results
		while (result.next()) {//Loop through results
			int TweetID = result.getInt("TweetID");
			int analysisID1 = result.getInt("AnalysisID");
			int sentimentValue = result.getInt("Sentiment");
			Sentiment sentiment = new Sentiment(TweetID,analysisID1,sentimentValue);
			sentiments.add(sentiment);
		}
		return sentiments;
	}
	public ArrayList<Tweet> selectAllTweets() throws SQLException{//Load all tweets function
		ArrayList<Tweet> tweets = new ArrayList<Tweet>();//Create list of tweets
		String SQL = "SELECT * FROM Twitter_Tweet";//Define SQL statement
		this.executeSQL(SQL);//execute SQL
		ResultSet result = this.statement.getResultSet();//Get results
		while (result.next()) {//Loop through results
			int ID = result.getInt("ID");
			int userID = result.getInt("UserID");
			String content = result.getString("Content");
			Date date = result.getDate("Date");
			double lat = result.getDouble("GeoLatitude");
			double lon = result.getDouble("GeoLongitude");
			GeoLocation location = new GeoLocation(lat,lon);
			Tweet tweet = new Tweet(ID,userID,content,date,location);//Create tweets
			tweets.add(tweet);//Add to list of tweets
		}
		return tweets;//Return list of tweets
	}
	
	public ArrayList<User> selectAllUsers() throws SQLException{
		ArrayList<User> users = new ArrayList<User>();//Create list of users
		String SQL = "SELECT * FROM Twitter_User";//Define SQL
		this.executeSQL(SQL);//Execute SQL
		ResultSet result = this.statement.getResultSet();//Get results
		while (result.next()){
			int ID = result.getInt("ID");
			int noTweets = result.getInt("NoTweets");
			int noFollowing = result.getInt("NoFollowing");
			int noFollowers = result.getInt("NoFollowers");
			String location = result.getString("Location");
			Date joinDate = result.getDate("JoinDate");
			int analysisID = result.getInt("AnalysisID");
			User user = new User(ID,noTweets,noFollowing,noFollowers,location,joinDate,analysisID);
			users.add(user);
		}
		return users;
	}
	
	public ArrayList<User> selectUsers(Analysis analysis) throws SQLException {
		ArrayList<User> users = new ArrayList<User>();//Create list of users
		String SQL = "SELECT * FROM Twitter_User WHERE AnalysisID = " + analysis.getID();//Define SQL
		this.executeSQL(SQL);//Execute SQL
		ResultSet result = this.statement.getResultSet();//Get results
		while (result.next()){
			int ID = result.getInt("ID");
			int noTweets = result.getInt("NoTweets");
			int noFollowing = result.getInt("NoFollowing");
			int noFollowers = result.getInt("NoFollowers");
			String location = result.getString("Location");
			Date joinDate = result.getDate("JoinDate");
			int analysisID = result.getInt("AnalysisID");
			User user = new User(ID,noTweets,noFollowing,noFollowers,location,joinDate,analysisID);
			users.add(user);
		}
		return users;
	}
	
	public Persona selectPersona(Analysis analysis) throws SQLException {
		String SQL = "SELECT * FROM Twitter_Persona WHERE AnalysisID = " + analysis.getID();//Define SQL
		this.executeSQL(SQL);//Execute SQL
		ResultSet result = this.statement.getResultSet();//Get results
		while (result.next()){
			int ID = result.getInt("ID");
			int noTweets = result.getInt("NoTweets");
			int noFollowing = result.getInt("NoFollowing");
			int noFollowers = result.getInt("NoFollowers");
			String location = result.getString("Location");
			Date joinDate = result.getDate("JoinDate");
			int analysisID = result.getInt("AnalysisID");
			Persona persona = new Persona(ID,noTweets,noFollowing,noFollowers,location,joinDate, analysisID);
			return persona;
		}
		return null;
	}
	
	//-----------------------\\
	//--[[EXIST FUNCTIONS]]--\\
	//-----------------------\\
	public boolean tweetExists(Tweet tweet) throws SQLException{//Function to check if tweet exists
		String SQL = "SELECT * FROM Twitter_Tweet ";//Define SQL
			SQL +=  "WHERE ID =" + tweet.getID();
		this.executeSQL(SQL);//Execute SQL
		ResultSet result = this.statement.getResultSet();//Get result
		if(result.next()){//If there is a result
			return true;
		}
		return false;
	}
	
	public boolean userExists(User user) throws SQLException {//Function to check if user exists
		String SQL = "SELECT * FROM Twitter_User ";//Define SQL
			SQL += "WHERE ID =" + user.getID();
		this.executeSQL(SQL);//Execute SQL
		ResultSet result = this.statement.getResultSet();//Get result
		if(result.next()){//If there is a result
			return true;
		}
		return false;
	}
	
	public boolean sentimentExists(Sentiment sentiment) throws SQLException {
		String SQL = "SELECT * FROM Twitter_Tweet_Sentiment_Analysis"
				+ " WHERE TweetID = " + sentiment.getTweetID();
		this.executeSQL(SQL);//Execute SQL
		ResultSet result = this.statement.getResultSet();//Get result
		if(result.next()){//If there is a result
			return true;
		}
		return false;
	}
	//-----------------------------\\
	//--[[SAVE OBJECT FUNCTIONS]]--\\
	//-----------------------------\\
	public void saveTweet(Tweet tweet,Analysis analysis) throws SQLException{//Save tweet to the database
		String SQL = "INSERT INTO Twitter_Tweet " +//Define SQL
						"VALUES(" +
						tweet.getID()+ "," +
						tweet.getUserID() + "," +
						"'" + tweet.getContent().replace("'", "!") + "'," +
						"'" + tweet.getDate() + "'," +
						tweet.getLocation().getLatitude() + "," +
						tweet.getLocation().getLongitude() + "," +
						analysis.getID() +
						");";
		this.executeSQL(SQL);//Execute SQL
	}
	
	public void saveUser(User user) throws SQLException{
		String SQL = "INSERT INTO Twitter_User " +
						"VALUES(" +
						user.getID() + "," +
						user.getNoTweets() + "," +
						user.getNoFollowing() + "," +
						user.getNoFollowers() + "," +
						"'" + user.getLocation().replace("'", "!") + "'," +
						"'" + user.getJoinDate() + "'," +
						user.getAnalysisID() +
						");";
		this.executeSQL(SQL);
	}
	
	public void saveAnalysis(Analysis analysis) throws SQLException{
		String SQL = "INSERT INTO Analysis (ID,SearchTerm)" +
						"VALUES(" +
						analysis.getID() +"," +
						"'" + analysis.getSearchTerm() + "'" +
						");";
		this.executeSQL(SQL);				
	}
	
	public void saveSentiment(Sentiment sentiment) throws SQLException {
		String SQL = "INSERT INTO Twitter_Tweet_Sentiment_Analysis " +
						"VALUES(" +
						sentiment.getTweetID() + "," +
						sentiment.getSentiment() + "," +
						sentiment.getAnalysisID() +
						");";
		this.executeSQL(SQL);
	}
	
	public void savePersona(Persona persona) throws SQLException {
		String SQL = "INSERT INTO Twitter_Persona " +
				"VALUES(" +
				persona.getID() + "," +
				persona.getNoTweets() + "," +
				persona.getNoFollowing() + "," +
				persona.getNoFollowers() + "," +
				"'" + persona.getLocation().replace("'", "!") + "'," +
				"'" + persona.getJoinDate() + "'," +
				persona.getAnalysisID() +
				");";
		this.executeSQL(SQL);
	}
	
	//------------------------------\\
	//--[[CREATE TABLE FUNCTIONS]]--\\
	//------------------------------\\
	public void create() throws SQLException{
		this.twitterTweet();
		this.twitterUser();
		this.tweetLocation();
		this.twitterPersona();
		this.twitterHashTag();
		this.Analysis();
		this.twitterSentiment();
	
	}
	//--[[Twitter Tables]]--\\
	public void twitterTweet() throws SQLException{
		String SQL = "CREATE TABLE Twitter_Tweet (" +
				"ID INTEGER NOT NULL," +
				"UserID INT NOT NULL," +
				"Content varchar(160) NOT NULL," +
				"Date DATE NOT NULL," +
				"GeoLatitude LONG," +
				"GeoLongitude LONG," +
				"AnalysisID INT NOT NULL," +
				"PRIMARY KEY (ID)" +
				"FOREIGN KEY(AnalysisID) References Analysis(ID)" +
				"FOREIGN KEY(UserID) References Twitter_User(ID)" +
				");";
		this.executeSQL(SQL);
	}
	
	public void twitterUser() throws SQLException{
		String SQL = "CREATE TABLE Twitter_User (" +
				"ID INT NOT NULL," +
				"NoTweets INT NOT NULL," +
				"NoFollowing INT NOT NULL," +
				"NoFollowers INT NOT NULL," +
				"Location INT," +
				"JoinDate date NOT NULL," +
				"AnalysisID INT NOT NULL," +
				"FOREIGN KEY(AnalysisID) References Analysis(ID)" +
				"PRIMARY KEY (ID)" +
				");";
		this.executeSQL(SQL);
	}
	
	public void twitterHashTag() throws SQLException{
		String SQL = "CREATE TABLE Twitter_HashTag (" +
				"ID INT NOT NULL," +
				"TweetID INT NOT NULL," +
				"Content varchar(160) NOT NULL," +
				"PRIMARY KEY (ID)" +
				"FOREIGN KEY (TweetID) references Twitter_Tweet(ID)" +
				");";
		this.executeSQL(SQL);
	}
	
	//--[[Analysis Table]]--\\
	public void Analysis() throws SQLException{
		String SQL = "CREATE TABLE Analysis(" +
					"ID INTEGER PRIMARY KEY NOT NULL," +
					"SearchTerm text not null" +
					");";
		this.executeSQL(SQL);
	}
	
	//--[[Twitter Analysis Tables]]--\\
	public void twitterSentiment() throws SQLException{
		String SQL = "CREATE TABLE Twitter_Tweet_Sentiment_Analysis(" +
				"TweetID INTEGER NOT NULL," +
				"Sentiment INTEGER NOT NULL," +
				"AnalysisID INTEGER NOT NULL," +
				"FOREIGN KEY (TweetID) references Twitter_Tweer(ID)," +
				"FOREIGN KEY (AnalysisID) references Analysis(ID)," +
				"PRIMARY KEY (TweetID)" +
				");";
		this.executeSQL(SQL);
	}
	
	public void twitterPersona() throws SQLException{
		String SQL = "CREATE TABLE Twitter_Persona(" +
				"ID INT NOT NULL," +
				"NoTweets INT NOT NULL," +
				"NoFollowing INT NOT NULL," +
				"NoFollowers INT NOT NULL," +
				"Location INT NOT NULL," +
				"JoinDate date NOT NULL," +
				"AnalysisID INT NOT NULL," +
				"FOREIGN KEY (AnalysisID) references Analysis(ID),"+
				"PRIMARY KEY (ID)" +
				");";
		this.executeSQL(SQL);
	}
	
	public void tweetLocation() throws SQLException{
		String SQL = "CREATE TABLE Twitter_Location_Analysis(" +
				"ID INT NOT NULL," +
				"Location Text NOT NULL," +
				"NoTweets INT NOT NULL," +
				"NoUsers INT NOT NULL," +
				"NoReplies INT," +
				"NoFavourites INT," +
				"NoHashTags INT NOT NULL," +
				"AnalysisID INT NOT NULL," +
				"FOREIGN KEY (AnalysisID) references Analysis(ID),"+
				"PRIMARY KEY (ID)" +
				");";
		this.executeSQL(SQL);
	}
	
	//-------------------------\\
	//--[[GETTERS & SETTERS]]--\\
	//-------------------------\\
	public String getSQL() {
		return SQL;
	}

	public void setSQL(String sql) {
		this.SQL = sql;
	}
}
