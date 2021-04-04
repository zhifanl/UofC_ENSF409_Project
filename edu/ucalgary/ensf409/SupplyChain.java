package edu.ucalgary.ensf409;


import java.io.*;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * @author Tianfan Zhou, Zhifan Li, Manpreet Singh, Taimoor Abrar
 * @version 1.3
 * @since 1.0
 */
public class SupplyChain{
	String outputFileName;
	String inputFileName;
	String inputString;
	String username;
	String password;
	public SupplyChain(String username,String password) {
		this.username=username;//set user name
		this.password=password;//set password
	}
	@SuppressWarnings("unchecked") //do not let it create any warnings
	public int execute(String input) throws SQLException{
		input = input.replaceAll("[^-0-9a-zA-Z ]", " ");
		//Remove all chars except "0-9","A-Z","a-z";
		input=input.toUpperCase();
		String inputArray[] = input.split("\\s+");//split the input into an array of strings

		if(inputArray[0].equals("SWING")&&inputArray[1].equals("ARM")&&inputArray[2].equals("LAMP")) {
			inputArray[0]="SWING ARM";
			inputArray[1]="LAMP";
			inputArray[2]=inputArray[3];
		}//special case: swing arm lamp, since there is an empty space between swing and arm, we need to manually changed it to the array.
		int requiredTimes=Integer.parseInt(inputArray[2]); //required number of order
		if(requiredTimes<=0) {
			throw new IllegalArgumentException("The number you ordered is less than or equals to zero...");
		}
		String[][] result= null;

		Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory",username,password);  //create Inventory object and also connect to database.
		myJDBC.initializeConnection(); //connect to database.

		LinkedList<String>suggestedManufacturer=new LinkedList<>();
		LinkedList<Manufacturer>searchedManu=myJDBC.selectAllFromTable("MANUFACTURER"); // do searching to get all the Manufacturer information into the linked list object.

		LinkedList<Furniture> searchedResults=(LinkedList<Furniture>)myJDBC.selectTypeFromCategory(inputArray[1], inputArray[0]);
		//get the result with specified type and category in a LinkedList

		
		// If cannot find anything, return directly
		Algorithm obj=new Algorithm();
		//generate an algorithm object
		//if category is chair
		if(inputArray[1].equals("CHAIR")) {
			result = obj.findCheapestSet(searchedResults,requiredTimes,"CHAIR");
		}
		//if category is desk
		else if(inputArray[1].equals("DESK")) {
			result=obj.findCheapestSet(searchedResults,requiredTimes,"DESK");
		}
		//if category is lamp
		else if(inputArray[1].equals("LAMP")) {
			result=obj.findCheapestSet(searchedResults,requiredTimes,"LAMP");
		}
		//if category is filing
		else if(inputArray[1].equals("FILING")) {
			result=obj.findCheapestSet(searchedResults,requiredTimes,"FILING");
		}
		if(result==null) {
			for(int i=0;i<searchedManu.size();i++ ) {
				for(int j=0;j<searchedResults.size();j++) {
					if(searchedManu.get(i).getManuID().equals(((Furniture) searchedResults.get(j)).getManuID())) {
						if(!suggestedManufacturer.contains(searchedManu.get(i).getName())) {
							suggestedManufacturer.add(searchedManu.get(i).getName());
						}
					}
				}
			}// cannot find the correct order, do not change database, populate the list of suggested Manufacturer and write it to the output file.
			writeFileException(suggestedManufacturer);
			return -1;
		}
		else {
			writeFile(result); // if there exists correct order, then write the detailed order information to the file(IDs and total prices)
			return 1;
		}
	}

	/**
	 * @param suggestedManufacturer the LinkedList of manufacturer that suggested
	 */
	public void writeFileException( LinkedList<String>suggestedManufacturer) {
		try{
			FileWriter myWriter=new FileWriter(outputFileName,true);
			String output="Order cannot be fulfilled based on current inventory. Suggested manufacturers are ";
			for(int i=0;i<suggestedManufacturer.size();i++) {
				output+=suggestedManufacturer.get(i)+", ";
			}
			output=output.substring(0,output.length()-2);
			output+=".";
			myWriter.write(output);
			myWriter.close();
			new GUIApp(output);

		}catch(IOException e) {
			System.out.println("An error occurred.");
		}
	}

	/**
	 * @param result 2-D array of String of store the order information
	 */
	public void writeFile(String[][]result){
		try{
			FileWriter myWriter=new FileWriter(outputFileName,true);
			String output=new String();
			output+="Furniture Order Form"+"\n"+"\n";
			output+="Faculty Name:"+"\n";
			output+="Contact:"+"\n";
			output+="Date:"+"\n"+"\n";
			output+="Original Request: "+inputString+"\n"+"\n";
			output+="Items Ordered"+"\n";
			myWriter.write(output);
			myWriter.flush();
			String order= new String ();
			// write file with the ID and total price it finds.
			for(int i=0;i<result[0].length;i++) {
				order += "ID: "+ result[0][i] + '\n';
			}
			order+="\n";
			order+="Total Price: "+ result[1][0];
			myWriter.write(order);
			myWriter.flush();
			myWriter.close();
			new GUIApp(output+order);
		}
		catch (IOException e) {
			System.out.println("An error occurred.");
		}
	}
	/**
	 * @param error Write to the file input error
	 */
	public void writeFileError(String error) {
		try{
			FileWriter myWriter=new FileWriter(outputFileName,true);
			myWriter.write(error);
			myWriter.close();
		}catch(IOException e) {
			System.out.println("An error occurred.");
		}
	}
	/**
	 * @param inputFileName1 input file name
	 * @param outputFileName1 output file name 
	 * @throws SQLException 
	 */
	public void readInput(String inputFileName1,String outputFileName1) throws SQLException {
		File f = null;
		inputFileName=inputFileName1;
		outputFileName=outputFileName1;
		try {
			f = new File(inputFileName);
			if (!f.exists()) {
				throw new FileNotFoundException("File does not exist");
			} else if (!f.canRead()) {
				throw new IOException("File is not readable");
			}
			FileWriter myWriter = new FileWriter(outputFileName);
			myWriter.close();
			// refresh the old output file. so that every time program runs, it appends new thing to a new output file.
			FileReader a = new FileReader(f);
			BufferedReader sc = new BufferedReader(a);
			String inputCommand = sc.readLine();

			if(inputCommand.contains("User request: ")){ // make sure it reads the correct input
				int index=inputCommand.indexOf(":")+2;
				inputCommand=inputCommand.substring(index);
				inputString=inputCommand;
				execute(inputCommand); // call the execute method, it contains input information, and inside it, it will create connection to database, do algorithm of searching the best result, and write the correct output to file
			}
			else{
				writeFileError("Input file error.");
				sc.close();
				a.close();
				return;
			}
			sc.close();
			a.close();
		} catch (IOException e) {
			System.out.println("Cannot Read File."); // write file cannot read file if the system fails to read it 
		}
	}
}