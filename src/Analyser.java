import java.util.ArrayList;


public class Analyser {
	//---------------\\
	//--[[DECLARE]]--\\
	//---------------\\
	private Analysis analysis;
	private Sentiment sentiment;
	private ArrayList<Sentiment> sentiments;
	
	//--------------------\\
	//--[[CONSTRUCTORS]]--\\
	//--------------------\\
	public Analyser(Analysis analysis) {
		this.setAnalysis(analysis);
	}
	//-----------------\\
	//--[[FUNCTIONS]]--\\
	//-----------------\\
	public ArrayList<Sentiment> sentimentAnalysis(ArrayList<Tweet> tweets) {
		
		return this.sentiments;
	}

	//-------------------------\\
	//--[[GETTERS & SETTERS]]--\\
	//-------------------------\\
	public Analysis getAnalysis() {
		return analysis;
	}

	public void setAnalysis(Analysis analysis) {
		this.analysis = analysis;
	}

	public Sentiment getSentiment() {
		return sentiment;
	}

	public void setSentiment(Sentiment sentiment) {
		this.sentiment = sentiment;
	}

	public ArrayList<Sentiment> getSentiments() {
		return sentiments;
	}

	public void setSentiments(ArrayList<Sentiment> sentiments) {
		this.sentiments = sentiments;
	}
}
