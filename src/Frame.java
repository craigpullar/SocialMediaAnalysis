//add menu bar
//add drop down list


import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;

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
    
    
    //Declare Raw data components
    private JTextArea rawDataDisplay;
    
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
            
            //Create raw data components
            this.setRawDataDisplay(new JTextArea());
            
            //results panel
            this.setResultsPanel(new JTabbedPane());
            Tab3.add(this.getResultsPanel());
            
            //Sentiment
            
            
            //Analysis Panel
            this.setAnalsisPanel(new JPanel());
            Tab3.add(this.getAnalsisPanel());
            this.getAnalsisPanel().add(this.getAnalysisList());
            
            //Create list of analysis
            this.fillAnalysisList(db);
            this.fillRawData(db);
            
            //Adds JPanels to results panel
            this.getResultsPanel().add("Map",Tab31);
            this.getResultsPanel().add("Sentiment",Tab32);
            this.getResultsPanel().add("Pie Chart",Tab33);
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
    
    public void fillRawData(Database db) throws SQLException {
    	this.getRawDataDisplay().setEditable(false);
    	this.getRawDataDisplay().setBackground(null);
    	this.getRawDataDisplay().setAutoscrolls(true);
    	ArrayList<Tweet> tweets= db.searchTweets(this.getAnalysisList().getItemAt(0).toString());
    	for (Tweet tweet:tweets){
    		this.getRawDataDisplay().append("//----------------------------------\\ \n");
    		this.getRawDataDisplay().append("TweetID: " + tweet.getID() + "\n");
    		this.getRawDataDisplay().append("UserID: " + tweet.getUserID() + "\n");
    		this.getRawDataDisplay().append("Content: " + tweet.getContent().toString() + "\n");
    		this.getRawDataDisplay().append("Date: " + tweet.getDate().toString() + "\n");
    		this.getRawDataDisplay().append("Location: " + tweet.getLocation().toString() + "\n");
    	}
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
		
}