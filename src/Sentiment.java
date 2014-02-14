
public class Sentiment {

	//--------------\\
	//--[[DECLARE]]--\\
	//---------------\\
	private long tweetID;
	private int analysisID;
	private int sentiment;
	
	//--------------------\\
	//--[[CONSTRUCTORS]]--\\
	//--------------------\\
	public Sentiment(long tweetID, int analysisID, int sentiment) {
		this.tweetID = tweetID;
		this.analysisID = analysisID;
		this.sentiment = sentiment;
	}
	
	//------------------------\\
	//--[[GETTERS & SETTERS]]--\\
	//-------------------------\\
	public long getTweetID() {
		return tweetID;
	}
	public void setTweetID(long tweetID) {
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
