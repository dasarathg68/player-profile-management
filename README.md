# Description

This submission formed the basis of CSE208: JAVA PROGRAMMING end semester examinations conducted in June 2021.
It uses the Java Swing library to create a window based application.

# Problem

Players Profile Management – Basketball:
Basketball board wants to maintain the player's profile and find the top player based on their goal rate.
Create a class called "Person" which has three data members "Name" of string datatype, "count" of
int type to mention the number of matches played by the player, "id" of int type is used to identify the
player uniquely.
Create a subclass "Player" from “Person” which includes data member "goal_count" of int type and
data member “goal_rate” which is calculated by dividing the goal_count by number of
matches(“count”) played so far.
Create a GUI with the following Swing components.

1. Four text fields to receive name, id, match count, total goals count
2. One text area to display the player details
3. Seven buttons with caption "Insert", "search", "best player", "<<", "<", ">", ">>"

- To get the player details, enter the details in thecorresponding text field then add the details in
  the Arraylist1 by pressing "Insert" button.

- Before pressing the "Insert" button, check that all needed fields are filled in. Throw the user-
  defined Exception if it is not properly filled out.

- When we press the "search" button, Search the player details based on the id.
- When we press the button "bestplayer" displaysthe best player details based on goal rate.
- When we press the "<<" button shows the first player details in the text area.
- When we press "<", ">", ">>" these buttons show the previous, next, last player details
  respectively in the text area.
