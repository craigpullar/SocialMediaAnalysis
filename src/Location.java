
public class Location {
	
	//---------------\\
	//--[[DECLARE]]--\\
	//---------------\\
	private int ID;
	private String location;
	private int noTweets;
	private int noUsers;
	private int noReplies;
	private int noFavourites;
	private int noHashTags;
	private int analysisID;
	
	//--------------------\\
	//--[[CONSTRUCTORS]]--\\
	//--------------------\\
	
	public Location(int ID, String location, int noUsers, int noReplies, int noFavourites, int noHashTags, int analysisID){
		this.ID = ID;
		this.location = location;
		this.noUsers = noUsers;
		this.noReplies = noReplies;
		this.noFavourites = noFavourites;
		this.noHashTags = noHashTags;
		this.analysisID = analysisID;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getNoTweets() {
		return noTweets;
	}
	public void setNoTweets(int noTweets) {
		this.noTweets = noTweets;
	}
	public int getNoUsers() {
		return noUsers;
	}
	public void setNoUsers(int noUsers) {
		this.noUsers = noUsers;
	}
	public int getNoReplies() {
		return noReplies;
	}
	public void setNoReplies(int noReplies) {
		this.noReplies = noReplies;
	}
	public int getNoFavourites() {
		return noFavourites;
	}
	public void setNoFavourites(int noFavourites) {
		this.noFavourites = noFavourites;
	}
	public int getNoHashTags() {
		return noHashTags;
	}
	public void setNoHashTags(int noHashTags) {
		this.noHashTags = noHashTags;
	}
	public int getAnalysisID() {
		return analysisID;
	}
	public void setAnalysisID(int analysisID) {
		this.analysisID = analysisID;
	}
	

}
