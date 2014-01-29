import java.sql.SQLException;


public class createDB {
	
	//--[[Declare]]--\\
	private Database db;
	
	public createDB(Database db){
		this.db = db;
	}
	
	public void create() throws SQLException{
		this.twitterTweet();
		this.twitterUser();
		this.tweetLocation();
		this.twitterPersona();
		this.twitterHashTag();
		this.Analysis();
	
	}
	//--[[Twitter Tables]]--\\
	public void twitterTweet() throws SQLException{
		String SQL = "CREATE TABLE Twitter_Tweet (" +
				"ID INTEGER NOT NULL," +
				"UserID INT NOT NULL," +
				"Content varchar(160) NOT NULL," +
				"Date DATE NOT NULL," +
				"Time INT NOT NULL," +
				"Location text," +
				"PRIMARY KEY (ID)" +
				"FOREIGN KEY(UserID) References Twitter_User(ID)" +
				");";
		this.db.executeSQL(SQL);
	}
	
	public void twitterUser() throws SQLException{
		String SQL = "CREATE TABLE Twitter_User (" +
				"ID INT NOT NULL," +
				"NoTweets INT NOT NULL," +
				"NoFollowing INT NOT NULL," +
				"NoFollowers INT NOT NULL," +
				"Location text," +
				"DOB date NOT NULL," +
				"JoinDate date NOT NULL," +
				"PRIMARY KEY (ID)" +
				");";
		this.db.executeSQL(SQL);
	}
	
	public void twitterHashTag() throws SQLException{
		String SQL = "CREATE TABLE Twitter_HashTag (" +
				"ID INT NOT NULL," +
				"TweetID INT NOT NULL," +
				"Content varchar(160) NOT NULL," +
				"PRIMARY KEY (ID)" +
				"FOREIGN KEY (TweetID) references Twitter_Tweet(ID)" +
				");";
		this.db.executeSQL(SQL);
	}
	
	//--[[Analysis Table]]--\\
	public void Analysis() throws SQLException{
		String SQL = "CREATE TABLE Anaylsis(" +
					"ID INT NOT NULL," +
					"SearchTerm text not null," +
					"PRIMARY KEY (ID)" +
					");";
		this.db.executeSQL(SQL);
	}
	
	//--[[Twitter Analysis Tables]]--\\
	public void twitterSentiment() throws SQLException{
		String SQL = "CREATE TABLE Twitter_Tweet_Sentiment_Analysis(" +
				"ID INT NOT NULL," +
				"TweetID INT NOT NULL FOREIGN KEY," +
				"Sentiment INT NOT NULL," +
				"AnalysisID INT NOT NULL FOREIGN KEY," +
				"FOREIGN KEY TweetID references Twitter_Tweer(ID)," +
				"FOREIGN KEY (AnalysisID) references Analysis(ID)," +
				"PRIMARY KEY (ID)" +
				");";
		this.db.executeSQL(SQL);
	}
	
	public void twitterPersona() throws SQLException{
		String SQL = "CREATE TABLE Twitter_Persona(" +
				"ID INT NOT NULL," +
				"NoTweets INT NOT NULL," +
				"NoFollowing INT NOT NULL," +
				"NoFollowers INT NOT NULL," +
				"Location INT NOT NULL," +
				"DOB date NOT NULL," +
				"JoinDate date NOT NULL," +
				"AnalysisID INT NOT NULL," +
				"FOREIGN KEY (AnalysisID) references Analysis(ID),"+
				"PRIMARY KEY (ID)" +
				");";
		this.db.executeSQL(SQL);
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
		this.db.executeSQL(SQL);
	}
}
