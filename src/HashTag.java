
public class HashTag {
	
	//---------------\\
	//--[[DECLARE]]--\\
	//---------------\\
	private int ID;
	private int tweetID;
	private String content;
	
	//--------------------\\
	//--[[CONSTRUCTORS]]--\\
	//--------------------\\
	public HashTag(int ID, int tweetID, String content){
		this.ID = ID;
		this.tweetID = tweetID;
		this.content = content;
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
	public int getTweetID() {
		return tweetID;
	}
	public void setTweetID(int tweetID) {
		this.tweetID = tweetID;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

}
