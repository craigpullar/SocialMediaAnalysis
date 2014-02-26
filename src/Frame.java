//add menu bar
//add drop down list


import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Frame extends JFrame //FRAME
{
	private static final int WIDTH = 800; //WIDTH variable
	private static final int HEIGHT = 600; //HEIGHT Variable
    private	JComboBox<Analysis> analysisList;
    private JTextField searchInput;
    private JLabel scrapeStatus;
    private JButton twitterScrapeButton;
    

	private JPanel Tab3;
    private JPanel AnalsisPanel;
    private JTabbedPane resultsPanel;
    
    
    //Declare result data components
    private JTextArea rawDataDisplay;
    private JTextArea sentimentDataDisplay;
    private JTextArea personaDisplay;
    
    public Frame(Database db) throws SQLException
		{
			setTitle("Scrapper");//Sets the title of the frame
			Container pane = getContentPane();
			//pane.setLayout(new GridLayout(2, 1));
			
			JTabbedPane App = new JTabbedPane();
            
            this.setContentPane(App);
		
			//creates the tabbed template on the application
			//getContentPane().add(App);
			
            //create menu
            JMenuBar menuBar = new JMenuBar(); //sets up JMenuBar container
            JMenu mainMenu = new JMenu("Scrapper"); //sets up the new JMenu (Menu) which will go in the JMenuBar Container
            JMenuItem exitI = new JMenuItem ("Quit"); //Creates the exitI element for the menu
            mainMenu.add(exitI); //adds the exitI element to the menu
            menuBar.add(mainMenu); //adds the menu to the menuBar
            setJMenuBar(menuBar); //make the menubar default
            
            
            //create tabs
			JPanel Tab1 = new JPanel();
			JPanel Tab2 = new JPanel();
            this.Tab3 = new JPanel();
            
            //
            this.setAnalysisList(new JComboBox());
            JPanel Tab31 = new JPanel();
            Tab31.setBackground (Color.RED);
            //Tab31.setAlignmentX(Component.RIGHT_ALIGNMENT);
            
            JPanel Tab32 = new JPanel();
            Tab32.setBackground (Color.BLUE);
            
            JPanel Tab33 = new JPanel();
            Tab33.setBackground (Color.GREEN);
            //Tab33.setAlignmentX(Component.LEFT_ALIGNMENT);
            
            JPanel Tab34 = new JPanel();
            Tab34.setBackground (Color.YELLOW);
            //Tab34.setAlignmentX(Component.RIGHT_ALIGNMENT);
            
            JPanel Tab35 = new JPanel();
            Tab35.setBackground (Color.PINK);
            //Tab35.setAlignmentX(Component.LEFT_ALIGNMENT);
        
			//add the tabs to out Tabbed Pane and names them
			App.addTab("Twitter", Tab1);
			App.addTab("Flicker", Tab2);
            App.addTab("Results", Tab3);
            
            Tab3.setLayout(new GridLayout(3,1));
            //creates buttons to the tabbed pages
			this.setTwitterScrapeButton(new JButton("Scrape"));
            this.getTwitterScrapeButton().setBounds(5,5,20,20);
            JButton test1 = new JButton("Scrape");
            
            //creates TextField for Searching
            this.setSearchInput(new JTextField("Search"));
            JTextField newSearch1 = new JTextField("Search");
            
            //Create scrapper status label
            this.setScrapeStatus(new JLabel("Click to scrape"));
		
			//creates the label for the tabs
			//JLabel firstTab = new JLabel();
			//firstTab.setText("Click Scrape");
            //JLabel secondTab = new JLabel();
			//secondTab.setText("Click Scrape");
            
            //adds Components to the Tab1
            Tab1.add(this.getSearchInput());
            Tab1.add(this.getTwitterScrapeButton());
            //Tab1.add(firstTab);
            Tab1.add(this.getScrapeStatus());
	           
            //adds components to the tab2
            Tab2.add(newSearch1);
            Tab2.add(test1);
            //Tab2.add(secondTab);
            
            //Create results data components
            this.setRawDataDisplay(new JTextArea());
            this.setSentimentDataDisplay(new JTextArea());
            this.setPersonaDisplay(new JTextArea());
            
            //results panel
            this.setResultsPanel(new JTabbedPane());
            Tab3.add(this.getResultsPanel());
            
            //Sentiment
            
            
            //Analysis Panel
            this.setAnalsisPanel(new JPanel());
            Tab3.add(this.getAnalsisPanel());
            this.getAnalsisPanel().add(this.getAnalysisList());
            
            //Create list of analysis
            ArrayList<Analysis> analysisObjectList = db.selectAllAnalysis();
            this.fillAnalysisList(db);
            if(analysisObjectList.size() > 0) {
	            this.fillRawData(db,0);
	            this.fillSentimentData(db, 0);
	            this.fillPersonaData(db, 0);
            }
            

            
            //Adds JPanels to results panel with scroll panes
            this.getResultsPanel().add("Map",Tab31);
            this.getResultsPanel().add("Sentiment",new JScrollPane(this.getSentimentDataDisplay()));
            this.getResultsPanel().add("Personas",new JScrollPane(this.getPersonaDisplay()));
            this.getResultsPanel().add("Raw Data",new JScrollPane(this.getRawDataDisplay()));
            this.getResultsPanel().add("Tag Cloud",Tab35);
            
			//JFrame Properties
            this.pack();
            setSize(WIDTH, HEIGHT);//Sets the size of the frame
			setVisible(true);//Makes the frame visible
			setDefaultCloseOperation(EXIT_ON_CLOSE);//Closes the application when exit button is pressed
            
           
        }
    
    //-----------------\\
    //--[[FUNCTIONS]]--\\
    //-----------------\\
    public void fillAnalysisList(Database db) throws SQLException {
    	//this.setAnalysisList(new JComboBox());
    	this.Tab3.remove(this.getAnalysisList());
    	ArrayList<Analysis> analysisList = db.selectAllAnalysis();
    	ArrayList<String> searchTerms = new ArrayList<String>();
    	for (Analysis analysis: analysisList){
    		searchTerms.add(analysis.getSearchTerm());
    	}
    	DefaultComboBoxModel model = new DefaultComboBoxModel( searchTerms.toArray() );
    	this.getAnalysisList().setModel(model);
    	this.Tab3.add(this.getAnalysisList());
    	
    }
    public void fillSentimentData(Database db, int index) throws SQLException {
    	this.getSentimentDataDisplay().setText(null);
    	this.getSentimentDataDisplay().setEditable(false);
    	this.getSentimentDataDisplay().setBackground(null);
    	this.getSentimentDataDisplay().setAutoscrolls(true);
    	ArrayList<Analysis> analysisObjectList = db.selectAllAnalysis();
    	ArrayList<Sentiment> sentiments = db.selectSentiments(analysisObjectList.get(index));
    	double positive = 0;
    	double negative = 0;
    	for (Sentiment sentiment: sentiments) {
    		if (sentiment.getSentiment() == 0) positive++;
    		else negative++;
    	}
    	if (positive == 0 || negative == 0){
    		this.getSentimentDataDisplay().append("Not enough analysis");
    	}
    	else {
    		DecimalFormat df = new DecimalFormat("#.00");
	    	double positivePercent = (positive/(positive + negative))*100;
	    	double negativePercent =(negative/(positive + negative))*100;
	    	this.getSentimentDataDisplay().append("Positive Percentage: " + df.format(positivePercent) + "% \n");
	    	this.getSentimentDataDisplay().append("Negative Percentage: " + df.format(negativePercent) + "% \n");
    	}
    }
    public void fillRawData(Database db,int index) throws SQLException {
    	this.getRawDataDisplay().setText(null);
    	this.getRawDataDisplay().setEditable(false);
    	this.getRawDataDisplay().setBackground(null);
    	this.getRawDataDisplay().setAutoscrolls(true);
    	ArrayList<Tweet> tweets = db.searchTweets(this.getAnalysisList().getItemAt(index).toString());
    	for (Tweet tweet:tweets){
    		this.getRawDataDisplay().append("//----------------------------------\\ \n");
    		this.getRawDataDisplay().append("TweetID: " + tweet.getID() + "\n");
    		this.getRawDataDisplay().append("UserID: " + tweet.getUserID() + "\n");
    		this.getRawDataDisplay().append("Content: " + tweet.getContent().toString() + "\n");
    		this.getRawDataDisplay().append("Date: " + tweet.getDate().toString() + "\n");
    		this.getRawDataDisplay().append("Location: " + tweet.getLocation().toString() + "\n");
    	}
    }
    public void fillPersonaData(Database db,int index) throws SQLException {
    	ArrayList<Analysis> analysisObjectList = db.selectAllAnalysis();
    	ArrayList<User> users = new ArrayList<User>();
    	Persona persona = new Persona();
		if(db.selectPersona(( analysisObjectList).get(index)) != null) {
    		persona =	db.selectPersona(analysisObjectList.get(index));
		}
		else {
			users = db.selectUsers(analysisObjectList.get(index));
			int tweetCount = 0;
			int noFollowing = 0;
			int noFollowers = 0;
			ArrayList<Integer> locationCount = new ArrayList<Integer>();
			ArrayList<String> locations = new ArrayList<String>();
			int largestCount = 0;
			
			long totalSeconds = 0;
			for (User user:users) {
				tweetCount += user.getNoTweets();
				noFollowing += user.getNoFollowing();
				noFollowers += user.getNoFollowers();
				totalSeconds += user.getJoinDate().getTime() / 1000L;
				if(!locations.contains(user.getLocation())) {
					locations.add(user.getLocation());
					locationCount.add(0);
				}
				else {
					int locationIndex = locations.indexOf(user.getLocation());
					int currentCount = locationCount.get(locationIndex);
					locationCount.set(locationIndex, currentCount++);
				}
			}
			int avgTweetCount = tweetCount/users.size();
			int avgNoFollowing = noFollowing/users.size();
			int avgNoFollowers = noFollowers/users.size();
			long avgSeconds = totalSeconds/users.size();
			Date averageDate = new Date(avgSeconds * 1000L);
			int bestLocationIndex = 0;
			for(int i = 0; i < locationCount.size(); i++){
				if (locationCount.get(i) > largestCount) {
					largestCount = locationCount.get(i);
					bestLocationIndex = i;
				}
			}
			String avgLocation = locations.get(bestLocationIndex);
			int ID = (int) (Math.random() * 99999999);
			persona = new Persona(ID,avgTweetCount,avgNoFollowing,avgNoFollowers,
					avgLocation,averageDate,analysisObjectList.get(index).getID());
			db.savePersona(persona);
			
		}
    	this.getPersonaDisplay().setText(null);
    	this.getPersonaDisplay().setEditable(false);
    	this.getPersonaDisplay().setBackground(null);
    	this.getPersonaDisplay().setAutoscrolls(true);
    	this.getPersonaDisplay().append("The following persona is the average user tweeting about the search term"+"\n");
    	this.getPersonaDisplay().append("//-------------------------\\ \n");
    	this.getPersonaDisplay().append("PersonaID: " + persona.getID()+"\n");
    	this.getPersonaDisplay().append("Tweet Count: " + persona.getNoTweets()+"\n");
    	this.getPersonaDisplay().append("Number they are following: " + persona.getNoFollowing()+"\n");
    	this.getPersonaDisplay().append("Number of followers: " + persona.getNoFollowers()+"\n");
    	this.getPersonaDisplay().append("Location: " + persona.getLocation()+"\n");
    	this.getPersonaDisplay().append("Join Date: " + persona.getJoinDate()+"\n");
    }
	
	//------------------------\\
	//--[[GETTER & SETTERS]]--\\
	//------------------------\\
	
	public JTextField getSearchInput() {
		return searchInput;
	}

	public void setSearchInput(JTextField searchInput) {
		this.searchInput = searchInput;
	}

	public JLabel getScrapeStatus() {
		return scrapeStatus;
	}

	public void setScrapeStatus(JLabel scrapeStatus) {
		this.scrapeStatus = scrapeStatus;
	}

	public JButton getTwitterScrapeButton() {
		return twitterScrapeButton;
	}

	public void setTwitterScrapeButton(JButton twitterScrapeButton) {
		this.twitterScrapeButton = twitterScrapeButton;
	}

	public JComboBox getAnalysisList() {
		return analysisList;
	}

	public void setAnalysisList(JComboBox analysisList) {
		this.analysisList = analysisList;
	}

	public JTextArea getRawDataDisplay() {
		return rawDataDisplay;
	}

	public void setRawDataDisplay(JTextArea jTextArea) {
		this.rawDataDisplay = jTextArea;
	}

	public JPanel getAnalsisPanel() {
		return AnalsisPanel;
	}

	public void setAnalsisPanel(JPanel analsisPanel) {
		AnalsisPanel = analsisPanel;
	}
	public JPanel getTab3() {
		return Tab3;
	}

	public void setTab3(JPanel tab3) {
		Tab3 = tab3;
	}

	public JTabbedPane getResultsPanel() {
		return resultsPanel;
	}

	public void setResultsPanel(JTabbedPane resultsPanel) {
		this.resultsPanel = resultsPanel;
	}

	public int getWidth() {
		return WIDTH;
	}

	public int getHeight() {
		return HEIGHT;
	}

	public JTextArea getSentimentDataDisplay() {
		return sentimentDataDisplay;
	}

	public void setSentimentDataDisplay(JTextArea sentimentDataDisplay) {
		this.sentimentDataDisplay = sentimentDataDisplay;
	}

	public JTextArea getPersonaDisplay() {
		return personaDisplay;
	}

	public void setPersonaDisplay(JTextArea personaDisplay) {
		this.personaDisplay = personaDisplay;
	}
		
}