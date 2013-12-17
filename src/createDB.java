import java.sql.SQLException;


public class createDB {
	
	//--[[Declare]]--\\
	private Database db;
	
	//--[[Main]]--\\
	public static void main(String[] args){
		
	}
	
	//--[[Twitter Tables]]--\\
	public void twitterTweet() throws SQLException{
		String SQL = "";
		this.db.executeSQL(SQL);
	}
	
	public void twitterUser() throws SQLException{
		String SQL = "";
		this.db.executeSQL(SQL);
	}
	
	public void twitterHashTag() throws SQLException{
		String SQL = "";
		this.db.executeSQL(SQL);
	}
	
	//--[[Flickr Tables]]--\\
	public void FlickrImage() throws SQLException{
		String SQL = "";
		this.db.executeSQL(SQL);
	}
	
	public void FlickrUser() throws SQLException{
		String SQL = "";
		this.db.executeSQL(SQL);
	}
	
	public void FlickrTag() throws SQLException{
		String SQL = "";
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
