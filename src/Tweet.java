import java.util.Date;


public class Tweet {

	//--------------\\
	//--[[DECLARE]]--\\
	//---------------\\
	
	private int ID;
	private int userID;
	private String content;
	private Date date;
	private int time;
	private int location;
	
	//--------------------\\
	//--[[CONSTRUCTORS]]--\\
	//--------------------\\
	
	public Tweet(int ID,int userID, String content,Date date,int time,int location){
		this.setID(ID);
		this.setUserID(userID);
		this.setContent(content);
		this.setDate(date);
		this.setTime(time);
		this.setLocation(location);
	}

	
	//--[[GETTERS & SETTERS]]--\\
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}
	
}
