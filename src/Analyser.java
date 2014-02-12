import java.util.ArrayList;


public class Analyser {
	//---------------\\
	//--[[DECLARE]]--\\
	//---------------\\
	private Analysis analysis;
	private Sentiment sentiment;
	private ArrayList<Sentiment> sentiments;
	private Location location;
	private ArrayList<Location> locations;
	
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
	
	public ArrayList<Location> locationAnalysis(ArrayList<Tweet> tweets) {
		
		return this.locations;
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
	
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public ArrayList<Location> getLocations() {
		return locations;
	}
	
	public void setLocations(ArrayList<Location> locations) {
		this.locations = locations;
	}
}
