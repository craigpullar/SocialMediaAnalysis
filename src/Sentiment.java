
public class Sentiment {

	//--------------\\
	//--[[DECLARE]]--\\
	//---------------\\
	private int ID;
	private int tweetID;
	private int analysisID;
	private int sentiment;
	
	//--------------------\\
	//--[[CONSTRUCTORS]]--\\
	//--------------------\\
	public Sentiment(int ID, int tweetID, int analysisID, int sentiment){
		this.ID = ID;
		this.tweetID = tweetID;
		this.analysisID = analysisID;
		this.sentiment = sentiment;
	}
	
	//------------------------\\
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
	public int getAnalysisID() {
		return analysisID;
	}
	public void setAnalysisID(int analysisID) {
		this.analysisID = analysisID;
	}
	public int getSentiment() {
		return sentiment;
	}
	public void setSentiment(int sentiment) {
		this.sentiment = sentiment;
	}
}
