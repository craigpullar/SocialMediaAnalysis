import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;


public class Frame extends JFrame{
	
	//---------------\\
	//--[[DECLARE]]--\\
	//---------------\\
	private static final int WIDTH = 400; //WIDTH variable
	private static final int HEIGHT = 300; //HEIGHT Variable
	private JButton twitterScrapeButton;
	private JTextField searchInput;
	private JLabel scrapeStatus;
	
	//-------------------\\
	//--[[CONSTRUCTOR]]--\\
	//-------------------\\
	public Frame() 
		{
			setTitle("Scrapper");//Sets the title of the frame
			Container pane = getContentPane();
			pane.setLayout(new GridLayout(2, 1));
			
			JTabbedPane App = new JTabbedPane();
			
			//creates the tabbed template on the application
			getContentPane().add(App);
			//create tabs
			JPanel Tab1 = new JPanel();
			JPanel Tab2 = new JPanel();
		
			//add the tabs to out Tabbed Pane and names them
			App.addTab("Twitter", Tab1);
			App.addTab("Flicker", Tab2);
            
            //creates buttons to the tabbed pages
			this.twitterScrapeButton = new JButton("Scrape");
            JButton test1 = new JButton("Scrape");
            
            //creates TextField for Searching
            this.searchInput = new JTextField("Search");
            JTextField newSearch1 = new JTextField("Search");
            
            this.scrapeStatus = new JLabel("Not currently scraping");
			//creates the label for the tabs
			JLabel firstTab = new JLabel();
			firstTab.setText("Click Scrape");
			Tab1.add(firstTab);
            //adds Search textfield to tab1
            Tab1.add(searchInput);
            //add button to tab1
            Tab1.add(twitterScrapeButton);
            Tab1.add(this.scrapeStatus);
		
			JLabel secondTab = new JLabel();
			secondTab.setText("Click Scrape");
			Tab2.add(secondTab);
            //add Search Textfield to tab2
            Tab2.add(newSearch1);
            //add button test1 to tab2
            Tab2.add(test1);
            
			//JFrame Properties
			setSize(WIDTH, HEIGHT);//Sets the size of the frame
			setVisible(true);//Makes the frame visible
			setDefaultCloseOperation(EXIT_ON_CLOSE);//Closes the application when exit button is pressed
		}
	
	//-------------------------\\
	//--[[GETTERS & SETTERS]]--\\
	//-------------------------\\

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


	public JTextField getSearchInput() {
		return searchInput;
	}


	public void setSearchInput(JTextField searchInput) {
		this.searchInput = searchInput;
	}


	public int getWidth() {
		return WIDTH;
	}

	public int getHeight() {
		return HEIGHT;
	}	
		

}
