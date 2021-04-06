package edu.ucalgary.ensf409;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Tianfan Zhou, Zhifan Li, Manpreet Singh, Taimoor Abrar
 * @version 1.0
 * @since 1.0
 *
 */

public class MySystem {

	
	/**
	 * main method
	 * How to run this program: 
	 * execute the main method and GUI window will pop to the user,
	 * in the window, type the user name as "scm", password as "ensf409", which are the default user name and password that this course uses.
	 * and type the order request: the format should be similar as this: "mesh chair,1", "executive chair,2", "swing arm lamp,3".
	 * then click "submit", and the program will execute these request and use the GUI to give you result, also Output.txt file will be generated that have required information on it.
	 * The GUI may give you error message if the user name is not found, or the password is not correct, or the DBURL is not correct in the SupplyChain java file
	 * The GUI may give you prompt if you enter a invalid number, also if you enter invalid information for required type or category.
	 * Every time it gives your error prompt, it will terminate itself, and you need to run this again.
	 * Output.txt file will also give error message if there is any error with your inputs.
	 * Check Output.txt file every time you finish running the program.
	 * @param Optional parameter
	 * @throws IOException 
	 * @throws SQLException  
	 */
	 public  static void main(String[] args) throws SQLException, IOException {
	
		GUIApp app=new GUIApp();			// create GUIApp object, a window will pop up to prompt for putting username and password.
		while(true){ 						// use a while loop to keep checking if the user has done submitting username and password.
			synchronized (app) {   			// synchronize GUIApp object app, and check if it gets username and password and submitted is also clicked.
				if(GUIApp.GotUsernameAndPassword==1&&app.getUsername()!=null&&app.getPassword()!=null) {
	    		break;
	    		}
			}
		}
		System.out.println("Got submitted inputs."); // print to console that user name and password are submitted.
	    SupplyChain obj=new SupplyChain(app.getUsername(),app.getPassword(),app.getInputRequest()); // creates a SupplyChain object.
	    obj.readInput(app.getInputRequest());		//start executing the input order command.
	 }
}
