
public class Analysis {

	//--------------\\
	//--[[DECLARE]]--\\
	//---------------\\
	private int ID;
	private String searchTerm;

	
	//--------------------\\
	//--[[CONSTRUCTORS]]--\\
	//--------------------\\
	public Analysis (String searchTerm){
		this.searchTerm = searchTerm;
		this.ID = (int) (Math.random() * 99999999);
	}
	public Analysis (int ID,String searchTerm){
		this.ID = ID;
		this.searchTerm = searchTerm;
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
	public String getSearchTerm() {
		return searchTerm;
	}
	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}
}
