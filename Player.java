package JAVAEXAM;

public class Player extends Person //Player inherits from Person class
  { 
	int goal_count; //declaring the number of goals scored by a player of type int
	float goal_rate;//declaring the goal rate of a player of type float
	
	
	private void Calculategoal_rate() //function to calculate the goal rate of a player
	  {
		goal_rate=goal_count/getCount();//goal rate is calculated by (total goals)/(number of matches played)
	  }
	
	
	public boolean setPlayer(String name, int count, int ID,int goalCount)
	//setter function for type Player; returns true if properly set
	{
		if(name!=""&&count!=0&&ID!=0&&goalCount!=0)//checks if all the parameters have some value
		{	 
		
		 setName(name);     //calls the setName() in class Person and sets the name
		 setCount(count);   //calls the setCount() in class Person and sets the count
		 setId(ID);         //calls the setId() in class Person and sets the ID
		
		 goal_count=goalCount;//sets the value of goal_count for the object of type Player
		
		 Calculategoal_rate(); //calls Calculategoal_rate() to calculate goal rate with the given values
		
		 return true;         //returns true as it has set all values successfully
		}
 
		 return false;        //returns false value if not set
	}
	
	public String toString()
	//this method returns all the objects of the class in String type
	  {
		return ("Name: "+getName()+"\nMatches:"+getCount()+"\nPlayer ID: "+getId()+"\nGoal Rate: "+goal_rate);
		//returns all objects of the class in String type
	  }
	
	float getGoal_rate()//method to return goal rate of a player
	{
		return goal_rate;//returns goal rate of the player
	}
}
