import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
	private BufferedReader fileReader;
	private String adjective;
	
	//--------------------\\
	//--[[CONSTRUCTORS]]--\\
	//--------------------\\
	public Analyser(Analysis analysis) {
		this.setAnalysis(analysis);
	}
	//-----------------\\
	//--[[FUNCTIONS]]--\\
	//-----------------\\
	public boolean sentimentAnalysis(Tweet tweet) throws IOException {
		File[] files = {new File("rsrc/positives.txt"), new File("rsrc/negatives.txt")};
		for (int i = 0; i < files.length; i++){
			this.fileReader = new BufferedReader(new FileReader(files[i]));
			this.adjective = this.fileReader.readLine();
			while(this.adjective != null) {
					if(tweet.getContent().contains(this.adjective)) {
						this.setSentiment(new Sentiment(tweet.getID(),this.analysis.getID(),i));
						return true;
					}
				this.adjective = this.fileReader.readLine();
			}
		}
		return false;
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
