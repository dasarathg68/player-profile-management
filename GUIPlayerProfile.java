package JAVAEXAM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GUIPlayerProfile {

	private JFrame frame;               //declare frame of type JFrame
	
	private JTextField textFieldName;   //declaring text field for accepting name of the person
	private JTextField textFieldID;     //declaring text field for accepting ID of the person
	private JTextField textFieldMatchCount;//declaring text field for accepting the number of matches played 
	private JTextField textFieldTotalGoals;// declaring text field for accepting goals scored
	
	
	private JTextField textFieldSearch;//declaring text field for accepting ID of the player to be searched
	private JTextArea textArea;        //declaring textArea of type JTextArea to display the details    
	ArrayList <Player> PList=new ArrayList<>();// declaring an ArrayList PList of type Player 
	
    boolean ref=false;//declaring boolean variable for error handling
    int ctposition=0;//declaring ctposition of type int, it tells the current position in the ArrayList 

    
    
    
	public static void main(String[] args) //main function
	 {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try //try block
				{
					GUIPlayerProfile window = new GUIPlayerProfile();
					//initializes object of the current class and calls constructor 
					
					window.frame.setVisible(true);//setting frame visibility to true
				} 
				
				catch (Exception e) //catch block
				{
					e.printStackTrace();//Exception is raised
				}
			}
		});
	 }

	
	public GUIPlayerProfile() //default constructor
	  {
		commenceOperations();
		//calls commenceOperations() 
	  }


	private void commenceOperations() //function to display frame, its content and operations
	{
		frame = new JFrame("Players Profile Management-Basketball");//initialize frame and sets title 
		frame.setBounds(100, 100, 649, 594);//setting frame size
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//to close the frame once exit is pressed
		frame.getContentPane().setLayout(null);//setting layout to null
		
		JLabel lblNewLabel = new JLabel("Player Profile Management");//Header label for the frame
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));      //setting font to BOLD and "Tahoma"
		lblNewLabel.setBounds(182, 10, 361, 43);        //setting label size
		frame.getContentPane().add(lblNewLabel);        //adding label to the frame
		
		
		JLabel lblNewLabel_1 = new JLabel("Name");//label to display "Name" next to the text field accepting Name
		lblNewLabel_1.setBounds(37, 90, 124, 43);//setting label size
		frame.getContentPane().add(lblNewLabel_1);//adding label to the frame
		
		
		JLabel lblNewLabel_1_1 = new JLabel("ID");//label to display "ID" next to the text field accepting ID
		lblNewLabel_1_1.setBounds(37, 155, 124, 48);//setting label size
		frame.getContentPane().add(lblNewLabel_1_1);//adding label to the frame
		
		
		JLabel lblNewLabel_1_2 = new JLabel("Match Count");
		//label to display "Match Count" next to the text field accepting number of matches
		lblNewLabel_1_2.setBounds(37, 225, 124, 43);//setting label size
		frame.getContentPane().add(lblNewLabel_1_2);//adding label to the frame
		
		
		JLabel lblNewLabel_1_3 = new JLabel("Total goals");
		//label to display "Total Goals" next to the text field accepting total goals
		lblNewLabel_1_3.setBounds(37, 289, 124, 43);//setting label size
		frame.getContentPane().add(lblNewLabel_1_3);//adding label to the frame
		
		textFieldName = new JTextField();//text field to accept name from user
		textFieldName.setBounds(191, 95, 165, 38);//setting text field size
		frame.getContentPane().add(textFieldName);//adding text field to frame
		textFieldName.setColumns(10);
		
		textFieldID = new JTextField();//text field to accept ID from user
		textFieldID.setColumns(10);
		textFieldID.setBounds(191, 165, 165, 38);//setting text field size
		frame.getContentPane().add(textFieldID);//adding text field to frame
		
		textFieldMatchCount = new JTextField();//text field to accept number of matches from user
		textFieldMatchCount.setColumns(10);
		textFieldMatchCount.setBounds(191, 230, 165, 38);//setting text field size
		frame.getContentPane().add(textFieldMatchCount);//adding text field to frame
		
		textFieldTotalGoals = new JTextField();//text field to accept total goals scored from user
		textFieldTotalGoals.setColumns(10);
		textFieldTotalGoals.setBounds(191, 294, 165, 38);//setting text field size
		frame.getContentPane().add(textFieldTotalGoals);//adding text field to frame
		
		JButton Insertbtn = new JButton("Insert"); //declaring a button that accepts all details
		Insertbtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) throws NumberFormatException
			//throws an exception if there is a character in place of a number
			{
				try//try block
				{
					
					Player P=new Player();//temporary variable of type Player
					String playerName;//variable of String type
					String temp;// temporary variable of type String
					playerName=textFieldName.getText(); //gets text from the text field
					int ID,matchCount,totalGoals;
					//for storing values of ID,number of matches and total goals from text fields
					
					temp=textFieldID.getText();//gets ID from text field
					ID=Integer.parseInt(temp);//parses through the given String and converts to int
					
					temp=textFieldMatchCount.getText();//gets match count from text field
					matchCount=Integer.parseInt(temp);//parses through the given String and converts to int
					
					temp=textFieldTotalGoals.getText();//gets total goals from text field
					totalGoals=Integer.parseInt(temp);//parses through the given String and converts to int
					
					ref=P.setPlayer(playerName,matchCount, ID,totalGoals);
					//calls the setter function of Player to initialize values to the object
					
					if(ref)//if the values are initialized successfully, it enters this block
					{
						PList.add(P);//adds the object onto the list
						textArea.setText("Added successfully");//displays message in the text Area
					}
					else //if values weren't initialized successfully
						textArea.setText("Failed to add");//displays message in the text Area
					
					
				}
				catch(Exception ae)//catch block for NumberFormatException
				{
					textArea.setText("Please enter valid data");//displays message in the text Area
				}
				
				textFieldName.setText(null);//clears text field
				textFieldID.setText(null);//clears text field
				textFieldMatchCount.setText(null);//clears text field
				textFieldTotalGoals.setText(null);//clears text field
			}
		});
		Insertbtn.setBounds(126, 355, 85, 21);//setting button size
		frame.getContentPane().add(Insertbtn);//adding button to the frame
		
		textArea = new JTextArea(); //initializing text area
		textArea.setBounds(191, 421, 341, 114);//setting text area size
		frame.getContentPane().add(textArea);// adding text area to frame
		
		JButton btnNewButton_1 = new JButton("<<");
		//creating a button that displays first player details in the list
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				if(!(PList.isEmpty()))//checks if list is empty
				{
					ctposition=0;	//sets position to 0
				    Player temp=new Player();//temporary variable of type String
				    temp=PList.get(ctposition);	//gets the first object in the list and stores it in temp
				    textArea.setText(temp.toString());//text area is set with the details from temp.toString()
				}
				else //if empty
					textArea.setText("No players available");//displays message in text area
			}
		});
		btnNewButton_1.setBounds(191, 390, 61, 21);//setting button size
		frame.getContentPane().add(btnNewButton_1);// adding button to the frame
		
		JButton btnNewButton_1_1 = new JButton("<");
		//button to display previous player details
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				ctposition--;//subtracts 1 from ctposition 
				
				if(ctposition>-1)//check ArrayList bounds
				  {
					Player temp=new Player();//temporary variable of type Player
				    temp=PList.get(ctposition);	//gets the object in the list and stores it in temp
				    textArea.setText(temp.toString());//text area is set with the details from temp.toString()
				  }
				else//if out of bounds
					textArea.setText("Out of bounds");//displays message in text area
			}
		});
		btnNewButton_1_1.setBounds(297, 390, 46, 21);//setting button size
		frame.getContentPane().add(btnNewButton_1_1);//adding button to the frame
		
		JButton btnNewButton_1_2 = new JButton(">>");
		//button to display last player details
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(!(PList.isEmpty()))//checks if list is empty
				{
					ctposition=PList.size()-1;//stores the (length of the list )-1 in ctposition
					Player temp=new Player();//temporary variable of type Player
					temp=PList.get(ctposition);	//gets the last object in the list and stores it in temp
					textArea.setText(temp.toString());//text area is set with the details from temp.toString()				
				}
				else //if empty
					textArea.setText("No players available");//displays message in text area
			}
		});
		btnNewButton_1_2.setBounds(471, 390, 61, 21);//sets button size
		frame.getContentPane().add(btnNewButton_1_2);//adds the button to the frame
		
		JButton btnNewButton_1_3 = new JButton(">");
		//button to display next element on the list
		btnNewButton_1_3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
					ctposition++;//increments ctposition by1
					
					if(ctposition<PList.size())//check if ctposition within ArrayList bounds
					  {
						Player temp=new Player();//temporary variable of type Player
					    temp=PList.get(ctposition);	//gets the next object in the list and stores it in temp
					    textArea.setText(temp.toString());//text area is set with the details from temp.toString()	
					  }
					else//if empty
						textArea.setText("Out of bounds");//displays message in text area
			}
				
		});
		btnNewButton_1_3.setBounds(391, 390, 46, 21);//setting button size
		frame.getContentPane().add(btnNewButton_1_3);//adding button to the frame
		
		JLabel lblNewLabel_2 = new JLabel("Search Player ");
		//creating label 
		lblNewLabel_2.setBounds(498, 97, 92, 28);//setting size
		frame.getContentPane().add(lblNewLabel_2);//adding label to the frame
		
		textFieldSearch = new JTextField();//creating text field to accept Id to be searched
		textFieldSearch.setColumns(10);
		textFieldSearch.setBounds(460, 135, 165, 38);// setting text field size
		frame.getContentPane().add(textFieldSearch);//adding text field to the frame
		
		JLabel lblNewLabel_3 = new JLabel("Enter ID");// creating label 
		lblNewLabel_3.setBounds(375, 147, 110, 13);//setting label size
		frame.getContentPane().add(lblNewLabel_3);//adding label to the frame
		
		JButton Searchbtn = new JButton("Search");
		//creating button to search player based on ID
		Searchbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) throws NumberFormatException
			//throws Exception if character present instead of a number
			{
				try//try block
				{
				String temp;// temporary variable of type String
				int ID;//to store ID
				temp=textFieldSearch.getText();//gets text from the text field
				Player P=new Player(); //temporary variable of type Player
				ID=Integer.parseInt(temp);//stores ID in the variable
				
				for(Player k:PList)
				{
					if(k.getId()==ID)//searches for ID in the list and compares with the entered value
					{
						P=k;//copies if true
						ref=true;//ref is set if found
					}
				}
				
				
				if((ref==true)&&(P.getId()!=0))//if found and id is not null 
				  {
					textArea.setText("Found!"+"\n"+P.toString());//displays the details of the player
				  }
				else
					textArea.setText("Not found");//displays message in text Area
				}
				catch(Exception k)//catches NumberFormatException 
				{
					textArea.setText("Enter valid data");//displays message in text Area
				}
			}
		});
		Searchbtn.setBounds(498, 199, 85, 21);//setting button size
		frame.getContentPane().add(Searchbtn);//adding button to the frame
		
		JButton BestPlayerbtn = new JButton("Best Player");
		//button to display the best player based on goal rate
		BestPlayerbtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				float bestGoalCount=0;//assuming best goal rate to be 0
				Player temp=new Player();//temporary variable
				for(Player k:PList)
				{
					if(k.getGoal_rate()>bestGoalCount)//if goal rate is better than bestGoalCount
					{
						bestGoalCount=k.getGoal_rate();//takes that value
						temp=k;//copies if true in temp
					}
				}
				
				if(PList.size()>0)//checks if empty
				{
					textArea.setText("Best Player Details:\n"+temp.toString());
				}
				else //if empty
					textArea.setText("List is empty");//display in text area
			}
		});
		BestPlayerbtn.setBounds(460, 300, 123, 21);//setting bounds 
		frame.getContentPane().add(BestPlayerbtn);//adding button to frame
		
		JLabel lblNewLabel_4 = new JLabel("Click to find out best player");//adding label 
		lblNewLabel_4.setBounds(449, 267, 158, 13);//setting size
		frame.getContentPane().add(lblNewLabel_4);//add label to frame

	}
}
