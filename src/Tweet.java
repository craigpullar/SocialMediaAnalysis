import java.util.Date;

import twitter4j.GeoLocation;


public class Tweet {

	//--------------\\
	//--[[DECLARE]]--\\
	//---------------\\
	
	private long ID;
	private long userID;
	private String content;
	private Date date;
	private GeoLocation location;
	
	//--------------------\\
	//--[[CONSTRUCTORS]]--\\
	//--------------------\\
	
	public Tweet(){
		
	}
	public Tweet(long ID,long userID, String content,Date date,GeoLocation location){
		this.setID(ID);
		this.setUserID(userID);
		this.setContent(content);
		this.setDate(date);
		this.setLocation(location);
		if (this.getLocation()== null){
			this.setLocation(new GeoLocation(0,0));
		}
	}

	
	//-----------------\\
	//--[[FUNCTIONS]]--\\
	//-----------------\\
	
	public void printTweet(){
		System.out.println("");
		System.out.println("//------------------\\");
		System.out.println("TweetID: " + this.getID());
		System.out.println("UserID: " + this.getUserID());
		System.out.println("Content: " + this.getContent());
		System.out.println("Date: " + this.getDate().toString());
		System.out.println("Location: " + this.getLocation().toString());
	}
	//--[[GETTERS & SETTERS]]--\\
	public long getID() {
		return ID;
	}

	public void setID(long iD2) {
		ID = iD2;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID2) {
		this.userID = userID2;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public GeoLocation getLocation() {
		return location;
	}

	public void setLocation(GeoLocation location2) {
		this.location = location2;
	}
	
}
