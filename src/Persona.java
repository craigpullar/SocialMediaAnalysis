import java.util.Date;

public class Persona extends User{
	
	//---------------\\
	//--[[DECLARE]]--\\
	//---------------\\
	private int analysisID;
	
	//-------------------\\
	//--[[CONSTRUCTOR]]--\\
	//-------------------\\
	public Persona(int ID, int noTweets, int noFollowing, int noFollowers,
			int location, Date DOB, Date joinDate,int analysisID) {
		super(ID, noTweets, noFollowing, noFollowers, location, DOB, joinDate);
		this.analysisID = analysisID;
	}

	//-------------------------\\
	//--[[GETTERS & SETTERS]]--\\
	//-------------------------\\
	public int getAnalysisID() {
		return analysisID;
	}

	public void setAnalysisID(int analysisID) {
		this.analysisID = analysisID;
	}
	

}
