package edu.ucalgary.ensf409;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class SupplyChain{
	String outputFileName;
	String inputFileName;
    public int execute(String input){
        input = input.replaceAll("[^0-9a-zA-Z ]", " ");
        //Remove all chars except "0-9","A-Z","a-z";
        input=input.toUpperCase();
        String inputArray[] = input.split("\\s+");

        
        
        int requiredTimes=Integer.parseInt(inputArray[2]);
        Combination result=null;
        
        Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","tianfan","Wenyan3524");
    	myJDBC.initializeConnection();
    	
        LinkedList<String>suggestedManufacturer=new LinkedList<>();
        LinkedList<Manufacturer>searchedManu=myJDBC.selectAllFromTable("MANUFACTURER");
		LinkedList<Combination>outputResults=new LinkedList<>();
        while(requiredTimes!=0) {
        
    	if(inputArray[1].equals("CHAIR")) {
        LinkedList<Chair>searchedResults=myJDBC.selectTypeFromCategory(inputArray[1], inputArray[0]);
        if(searchedResults==null) {
        	return -1;
        }
        Algorithm obj=new Algorithm();
        result=obj.findCheapestSet(searchedResults);
        if(result==null&&searchedResults!=null) {
    	   for(int i=0;i<searchedManu.size();i++ ) {
    		   if(searchedManu.get(i).getManuID().equals(searchedResults.get(0).getManuID())) {
    			   suggestedManufacturer.add(searchedManu.get(i).getName());
    			   
    		   }
    	   }
    	   
    	   writeFileException(suggestedManufacturer);
    	   return -1;
    	}
        outputResults.add(result);
    	}
       
    	if(inputArray[1].equals("DESK")) {
            LinkedList<Desk>searchedResults=myJDBC.selectTypeFromCategory(inputArray[1], inputArray[0]);
            if(searchedResults==null) {
            	return -1;
            }
            Algorithm obj=new Algorithm();
           result=obj.findCheapestSet(searchedResults);
           if(result==null&&searchedResults!=null) {
        	   for(int i=0;i<searchedManu.size();i++ ) {
        		   if(searchedManu.get(i).getManuID().equals(searchedResults.get(0).getManuID())) {
        			   suggestedManufacturer.add(searchedManu.get(i).getName());
        		   }
        	   }
        	   writeFileException(suggestedManufacturer);
        	   return -1;
        	}
           outputResults.add(result);
            
        	}
    	if(inputArray[1].equals("LAMP")) {
            LinkedList<Lamp>searchedResults=myJDBC.selectTypeFromCategory(inputArray[1], inputArray[0]);
            if(searchedResults==null) {
            	return -1;
            }
            Algorithm obj=new Algorithm();
           result=obj.findCheapestSet(searchedResults);
           if(result==null&&searchedResults!=null) {
        	   for(int i=0;i<searchedManu.size();i++ ) {
        		   if(searchedManu.get(i).getManuID().equals(searchedResults.get(0).getManuID())) {
        			   suggestedManufacturer.add(searchedManu.get(i).getName());
        		   }
        	   }
        	   writeFileException(suggestedManufacturer);
        	   return -1;
        	}
           outputResults.add(result);
            
        	}
    	if(inputArray[1].equals("FILING")) {
            LinkedList<Filing>searchedResults=myJDBC.selectTypeFromCategory(inputArray[1], inputArray[0]);
            if(searchedResults==null) {
            	return -1;
            }
            Algorithm obj=new Algorithm();
           result=obj.findCheapestSet(searchedResults);
           if(result==null&&searchedResults!=null) {
        	   for(int i=0;i<searchedManu.size();i++ ) {
        		   if(searchedManu.get(i).getManuID().equals(searchedResults.get(0).getManuID())) {
        			   suggestedManufacturer.add(searchedManu.get(i).getName());
        		   		}
        	   		}
        	   writeFileException(suggestedManufacturer);
        	   return -1;
            
        		}
           outputResults.add(result);
            
        	}

    	requiredTimes--;
        }
        
        writeFile(outputResults);
        
    }

    public void writeFile(LinkedList<Combination>result){
        try{
            FileWriter myWriter=new FileWriter(outputFileName,true);
            File f=new File(outputFileName);


                if(f.length()!=0){
                    myWriter.write("\n");
                }
                
                myWriter.write(output);
                myWriter.flush();
            }

            myWriter.close();
        }
        catch (IOException e) {
             System.out.println("An error occurred.");
        }
    }
    public void readInput(String inputFileName) {
        File f = null;
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
            String REGEX="(User request){1}[:]{1}[\\S]+[,]{1}[\\S]+";
            if(inputCommand.matches(REGEX)){
                int i=execute(inputCommand);
            }
            else{
                    writeFile("Input file error.");
                    sc.close();
                    a.close();
                    return;
            }
            sc.close();
            a.close();
        } catch (IOException e) {
            System.out.println("Cannot Read File.");
        }
    }
}