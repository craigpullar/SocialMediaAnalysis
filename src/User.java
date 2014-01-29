import java.util.Date;


public class User {
	
	//---------------\\
	//--[[DECLARE]]--\\
	//---------------\\
	private int ID;
	private int noTweets;
	private int noFollowing;
	private int noFollowers;
	private int location;
	private Date DOB;
	private Date joinDate;
	
	//--------------------\\
	//--[[CONSTRUCTORS]]--\\
	//--------------------\\
	public User(int ID, int noTweets, int noFollowing, int noFollowers, int location, Date DOB, Date joinDate ){
		this.ID = ID;
		this.noTweets = noTweets;
		this.noFollowing = noFollowing;
		this.noFollowers = noFollowers;
		this.location = location;
		this.DOB = DOB;
		this.joinDate = joinDate;
	}
	
	//-------------------------\\
	//--[[GETTERS & SETTERS]]--\\
	//-------------------------\\
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
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
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = location;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
}
