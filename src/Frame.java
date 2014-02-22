//add menu bar
//add drop down list


import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;

public class Frame extends JFrame //FRAME
{
	private static final int WIDTH = 400; //WIDTH variable
	private static final int HEIGHT = 300; //HEIGHT Variable
    private	JComboBox<Analysis> analysisList;
    private JTextField searchInput;
    private JLabel scrapeStatus;
    private JButton twitterScrapeButton;
    private JPanel Tab3;
    
    public Frame(Database db) throws SQLException
		{
			setTitle("Scrapper");//Sets the title of the frame
			Container pane = getContentPane();
			//pane.setLayout(new GridLayout(2, 1));
			
			JTabbedPane App = new JTabbedPane();
            this.setLayout(null);
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
            Tab32.setBounds(5, 5, 25, 25);
            
            JPanel Tab33 = new JPanel();
            Tab33.setBackground (Color.GREEN);
            //Tab33.setAlignmentX(Component.LEFT_ALIGNMENT);
            
            JPanel Tab34 = new JPanel();
            Tab34.setBackground (Color.YELLOW);
            //Tab34.setAlignmentX(Component.RIGHT_ALIGNMENT);
            
            JPanel Tab35 = new JPanel();
            Tab35.setBackground (Color.PINK);
            //Tab35.setAlignmentX(Component.LEFT_ALIGNMENT);
    
            /*
            //Adds ComboBox to Tab3
            combo = new JComboBox();
            Tab3.add(combo);
            //Populates the list
            for(int i = 0; i < rList.length; i++)
                combo.addItem(rList[i]);  // Populates the list from rList */
            
            
			//add the tabs to out Tabbed Pane and names them
			App.addTab("Twitter", Tab1);
			App.addTab("Flicker", Tab2);
            App.addTab("Results", Tab3);
            
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
            
            //Adds Text Area to Tab31
            Tab31.add(new JLabel("Map"));
            Tab32.add(new JLabel("Date Range"));
            Tab33.add(new JLabel("Pie Chart"));
            Tab34.add(new JLabel("Raw Data"));
            Tab35.add(new JLabel("Tag Cloud"));
            

            
            //Adds JPanels to Tab3
            Tab3.add(this.getAnalysisList());
            Tab3.add(Tab31);
            Tab3.add(Tab32);
            Tab3.add(Tab33);
            Tab3.add(Tab34);
            Tab3.add(Tab35);
            
            //Create list of analysis
            this.fillAnalysisList(db);
            
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
		
}