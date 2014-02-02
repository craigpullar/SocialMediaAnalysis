import java.util.Date;


public class User {
	
	//---------------\\
	//--[[DECLARE]]--\\
	//---------------\\
	private long ID;
	private int noTweets;
	private int noFollowing;
	private int noFollowers;
	private String location;
	private Date joinDate;
	
	//--------------------\\
	//--[[CONSTRUCTORS]]--\\
	//--------------------\\
	public User(long ID, int noTweets, int noFollowing, int noFollowers, String location, Date joinDate ){
		this.setID(ID);
		this.setNoTweets(noTweets);
		this.setNoFollowing(noFollowing);
		this.setNoFollowers(noFollowers);
		this.setLocation(location);
		this.setJoinDate(joinDate);
	}
	
	//-------------------------\\
	//--[[GETTERS & SETTERS]]--\\
	//-------------------------\\
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public int getNoTweets() {
		return noTweets;
	}
	public void setNoTweets(int noTweets) {
		this.noTweets = noTweets;
	}
	public int getNoFollowing() {
		return noFollowing;
	}
	public void setNoFollowing(int noFollowing) {
		this.noFollowing = noFollowing;
	}
	public int getNoFollowers() {
		return noFollowers;
	}
	public void setNoFollowers(int noFollowers) {
		this.noFollowers = noFollowers;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
}
