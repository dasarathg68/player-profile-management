package JAVAEXAM;

public class Person {
	private String Name; //declaring Name of String type
	private int count;//declaring count of type int (number of matches)
	private int id;//declaring id of type int (unique for every person)
	
	Person()//default constructor
	{
		Name="";//Initializing default value to Name
		setCount(0);//Initializing default value to count
		
	}
	
	public int getCount()//function to return number of matches played by the person
	   {
		return count;//returns an integer that is number of matches played by the person 
	   }
	
	public int getId() //function to return the ID of the person
	   {
		return id;     //returns ID
	   }
	
	public String getName()//function to return the name of the person 
	  {
	 	return Name;    //returns Name of type String
	  }
	
	public void setName(String name)//function to set the value of Name
	  {
		Name = name;   //Sets the value of Name 
	  }

	public void setCount(int count) //function to set the value of Count
	{
		this.count = count;   //sets the value of count
	}

	public void setId(int id) //function to set ID
	{
		this.id = id;        //sets the value of ID
	}
}
