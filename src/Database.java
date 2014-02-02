import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Database {
	
	//--------------\\
	//--[[DECLARE]]--\\
	//---------------\\
	private Connection connection;
	static final String JDBC_DRIVER = "org.sqlite.JDBC";  
	static final String DB_URL = "jdbc:sqlite:data.db";
	private String SQL;
	private File file;
	private Boolean dbExists;
	
	//-------------------\\
	//--[[CONSTRUCTORS]]--\\
	//--------------------\\
	public Database() throws Exception{
		Class.forName(JDBC_DRIVER);
		
		//Check if the database file exists//
		file = new File("data.db");
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
	public void executeSQL(String SQL) throws SQLException{
		this.setSQL(SQL);
		Statement statement = connection.createStatement();
		statement.execute(SQL);
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
	
	}
	//--[[Twitter Tables]]--\\
	public void twitterTweet() throws SQLException{
		String SQL = "CREATE TABLE Twitter_Tweet (" +
				"ID INTEGER NOT NULL," +
				"UserID INT NOT NULL," +
				"Content varchar(160) NOT NULL," +
				"Date DATE NOT NULL," +
				"Location INT," +
				"PRIMARY KEY (ID)" +
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
		String SQL = "CREATE TABLE Anaylsis(" +
					"ID INT NOT NULL," +
					"SearchTerm text not null," +
					"PRIMARY KEY (ID)" +
					");";
		this.executeSQL(SQL);
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
		this.executeSQL(SQL);
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
