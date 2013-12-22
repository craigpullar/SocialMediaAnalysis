import java.sql.SQLException;


public class createDB {
	
	//--[[Declare]]--\\
	private Database db;
	
	//--[[Main]]--\\
	public static void main(String[] args){
		
	}
	
	//--[[Twitter Tables]]--\\
	public void twitterTweet() throws SQLException{
		String SQL = "CREATE TABLE Twitter_Tweet (" +
				"ID int NOT NULL AUTO_INCREMENT," +
				"UserID int NOT NULL FOREIGN KEY," +
				"Content varchar(160) NOT NULL," +
				"Date DATE NOT NULL," +
				"Time int NOT NULL," +
				"Location text," +
				"PRIMARY KEY (ID)" +
				");";
		this.db.executeSQL(SQL);
	}
	
	public void twitterUser() throws SQLException{
		String SQL = "CREATE TABLE Twitter_User (" +
				"ID int NOT NULL AUTO_INCREMENT," +
				"NoTweets int NOT NULL," +
				"NoFollowing int NOT NULL," +
				"NoFollowers int NOT NULL," +
				"Location text," +
				"DOB date NOT NULL," +
				"JoinDate date NOT NULL," +
				"PRIMARY KEY (ID)" +
				");";
		this.db.executeSQL(SQL);
	}
	
	public void twitterHashTag() throws SQLException{
		String SQL = "CREATE TABLE Twitter_HashTag (" +
				"ID int NOT NULL AUTO_INCREMENT," +
				"TweetID int NOT NULL FOREIGN KEY," +
				"Content varchar(160) NOT NULL," +
				"PRIMARY KEY (ID)" +
				");";
		this.db.executeSQL(SQL);
	}
	
	//--[[Flickr Tables]]--\\
	public void FlickrImage() throws SQLException{
		String SQL = "CREATE TABLE Flickr_Image (" +
				"ID int NOT NULL AUTO_INCREMENT," +
				"UserID int NOT NULL FOREIGN KEY," +
				"Title text NOT NULL," +
				"DateTaken Date NOT NULL," +
				"Views int NOT NULL," +
				"PRIMARY KEY (ID)"+
				");";
		this.db.executeSQL(SQL);
	}
	
	public void FlickrUser() throws SQLException{
		String SQL = "CREATE TABLE Flickr_User (" +
				"ID int NOT NULL AUTO_INCREMENT," +
				"NoImages int NOT NULL,"+
				"NoFollowing int NOT NULL," +
				"NoFollowers int not null," +
				"Location text," +
				"DOB date," +
				"JoinDate date," +
				"PRIMARY KEY (ID)" +
				");";
		this.db.executeSQL(SQL);
	}
	
	public void FlickrTag() throws SQLException{
		String SQL = "CREATE TABLE Flickr_Tag (" +
				"ID int NOT NULL AUTO_INCREMENT," +
				"ImageID int NOT NULL FOREIGN KEY," +
				"Content text not null," +
				"PRIMARY KEY (ID)" +
				");";
		this.db.executeSQL(SQL);
	}
	
	//--[[Analysis Table]]--\\
	public void Analysis() throws SQLException{
		String SQL = "";
		this.db.executeSQL(SQL);
	}
	
	//--[[Twitter Analysis Tables]]--\\
	public void twitterLocation() throws SQLException{
		String SQL = "";
		this.db.executeSQL(SQL);
	}
	
	public void twitterPersona() throws SQLException{
		String SQL = "";
		this.db.executeSQL(SQL);
	}
	
	public void tweetSentiment() throws SQLException{
		String SQL = "";
		this.db.executeSQL(SQL);
	}
	
	//--[[Flickr Analysis Tables]]--\\
	public void flickrLocation() throws SQLException{
		String SQL = "";
		this.db.executeSQL(SQL);
	}
	
	public void flickrPersona() throws SQLException{
		String SQL = "";
		this.db.executeSQL(SQL);
	}
	
	public void imageSentiment() throws SQLException{
		String SQL = "";
		this.db.executeSQL(SQL);
	}
}
