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
	String inputString;
    public int execute(String input){
        input = input.replaceAll("[^0-9a-zA-Z ]", " ");
        //Remove all chars except "0-9","A-Z","a-z";
        input=input.toUpperCase();
        String inputArray[] = input.split("\\s+");

        
        
        int requiredTimes=Integer.parseInt(inputArray[2]);
        Combination result= null;
        
        Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","tianfan","Wenyan3524");
    	myJDBC.initializeConnection();
    	
        LinkedList<String>suggestedManufacturer=new LinkedList<>();
        LinkedList<Manufacturer>searchedManu=myJDBC.selectAllFromTable("MANUFACTURER");
		//LinkedList<Combination>outputResults=new LinkedList<>();
        
        FurnitureList searchedResults = new FurnitureList();
    	searchedResults.setFurnitureList(myJDBC.selectTypeFromCategory(inputArray[1], inputArray[0]));
		
        while(requiredTimes!=0) {
        
    	if(inputArray[1].equals("CHAIR")) {
        //LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory(inputArray[1], inputArray[0]);
    	
        if(searchedResults.getFurnitureList()==null) {
        	return -1;
        }
        Algorithm obj=new Algorithm();
        
        result = obj.findCheapestSet(searchedResults.getFurnitureList());
        /*
        if(result==null&&searchedResults.getFurnitureList()!=null) {
    	   for(int i=0;i<searchedManu.size();i++ ) {
    		   if(searchedManu.get(i).getManuID().equals(searchedResults.getFurnitureList().get(0).getManuID())) {
    			   suggestedManufacturer.add(searchedManu.get(i).getName());
    			   
    		   }
    	   }
    	   
    	   writeFileException(suggestedManufacturer);
    	   return -1;
    	}
    	*/
        if(result!=null) {
        	searchedResults.addToCombinationList(result);
        	searchedResults.updateQuantity(result);
        }
        //myJDBC.deleteFromTable("CHAIR", result.getID1());
        //if(result.getID2()!=null) {myJDBC.deleteFromTable("CHAIR", result.getID2());}
        //if(result.getID3()!=null) {myJDBC.deleteFromTable("CHAIR", result.getID3());}
        //if(result.getID4()!=null) {myJDBC.deleteFromTable("CHAIR", result.getID4());}
    	}
       
    	if(inputArray[1].equals("DESK")) {
            //LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory(inputArray[1], inputArray[0]);
        	
            if(searchedResults.getFurnitureList()==null) {
            	return -1;
            }
            Algorithm obj=new Algorithm();
           result=obj.findCheapestSet(searchedResults.getFurnitureList());
           
           /*
           if(result==null&&searchedResults.getFurnitureList()!=null) {
        	   for(int i=0;i<searchedManu.size();i++ ) {
        		   if(searchedManu.get(i).getManuID().equals(searchedResults.getFurnitureList().get(0).getManuID())) {
        			   suggestedManufacturer.add(searchedManu.get(i).getName());
        		   }
        	   }
        	   writeFileException(suggestedManufacturer);
        	   return -1;
        	}
        	*/
           
           if(result!=null) {
        	   searchedResults.addToCombinationList(result);
        	   searchedResults.updateQuantity(result);
           }
           //myJDBC.deleteFromTable("DESK", result.getID1());
           //if(result.getID2()!=null) {myJDBC.deleteFromTable("DESK", result.getID2());}
           //if(result.getID3()!=null) {myJDBC.deleteFromTable("DESK", result.getID3());}
           //if(result.getID4()!=null) {myJDBC.deleteFromTable("DESK", result.getID4());}
            
        	}
    	if(inputArray[1].equals("LAMP")) {
            //LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory(inputArray[1], inputArray[0]);

            if(searchedResults.getFurnitureList()==null) {
            	return -1;
            }
            Algorithm obj=new Algorithm();
           result=obj.findCheapestSet(searchedResults.getFurnitureList());
           /*
           if(result==null&&searchedResults!=null) {
        	   for(int i=0;i<searchedManu.size();i++ ) {
        		   if(searchedManu.get(i).getManuID().equals(searchedResults.get(0).getManuID())) {
        			   suggestedManufacturer.add(searchedManu.get(i).getName());
        		   }
        	   }
        	   writeFileException(suggestedManufacturer);
        	   return -1;
        	}
        	*/
           if(result!=null) {
        	   searchedResults.addToCombinationList(result);
        	   searchedResults.updateQuantity(result);
           }
           //myJDBC.deleteFromTable("LAMP", result.getID1());
           //if(result.getID2()!=null) {myJDBC.deleteFromTable("LAMP", result.getID2());}
           //if(result.getID3()!=null) {myJDBC.deleteFromTable("LAMP", result.getID3());}
           //if(result.getID4()!=null) {myJDBC.deleteFromTable("LAMP", result.getID4());}
            
        	}
    	if(inputArray[1].equals("FILING")) {
            //LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory(inputArray[1], inputArray[0]);
    		
            if(searchedResults.getFurnitureList()==null) {
            	return -1;
            }
            Algorithm obj=new Algorithm();
           result=obj.findCheapestSet(searchedResults.getFurnitureList());
           /*
           if(result==null&&searchedResults!=null) {
        	   for(int i=0;i<searchedManu.size();i++ ) {
        		   if(searchedManu.get(i).getManuID().equals(searchedResults.get(0).getManuID())) {
        			   suggestedManufacturer.add(searchedManu.get(i).getName());
        		   		}
        	   		}
        	   writeFileException(suggestedManufacturer);
        	   return -1;
            
        		}
        		*/
           
           if(result!=null) {
        	   searchedResults.addToCombinationList(result);
        	   searchedResults.updateQuantity(result);
           }
           //outputResults.add(result);
           //myJDBC.deleteFromTable("FILING", result.getID1());
           //if(result.getID2()!=null) {myJDBC.deleteFromTable("FILING", result.getID2());}
           //if(result.getID3()!=null) {myJDBC.deleteFromTable("FILING", result.getID3());}
           //if(result.getID4()!=null) {myJDBC.deleteFromTable("FILING", result.getID4());}
           
        	}
    	
    	requiredTimes--;
    	
        }
        
        if(searchedResults.getCombinationList().size()!= Integer.parseInt(inputArray[2])) {
        	for(int i=0;i<searchedManu.size();i++ ) {
     		   if(searchedManu.get(i).getManuID().equals(searchedResults.getFurnitureList().get(0).getManuID())) {
     			   suggestedManufacturer.add(searchedManu.get(i).getName());
     		   		}
     	   		}
     	   writeFileException(suggestedManufacturer);
     	   return -1;
        }
        
        else {
        	writeFile(searchedResults.findAllID(),searchedResults.findTotalPrice());
            return 1;
        }
        
    }
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
    	}catch(IOException e) {
            System.out.println("An error occurred.");
       }
   
            
    }
    public void writeFile(LinkedList<String> id, int totalPrice){
        try{
            FileWriter myWriter=new FileWriter(outputFileName,true);
            File f=new File(outputFileName);
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
            for(int i=0;i<id.size();i++) {
            	/*
            	order+="ID: "+result.get(i).getID1()+'\n';
            	if(result.get(i).getID2()!=null) {order+="ID: "+result.get(i).getID2()+'\n';}
            	if(result.get(i).getID3()!=null) {order+="ID: "+result.get(i).getID3()+'\n';}
            	if(result.get(i).getID4()!=null) {order+="ID: "+result.get(i).getID4()+'\n';}
            	order+="\n";
            	order+="Total Price: "+result.get(i).getPrice();
            	*/
            	order += "ID: "+ id.get(i) + '\n';
            	
            }
            
            order+="\n";
        	order+="Total Price: "+ totalPrice;

            myWriter.write(order);
            myWriter.flush();

            myWriter.close();
        }
        catch (IOException e) {
             System.out.println("An error occurred.");
        }
    }
    public void writeFileError(String error) {
    	try{
            FileWriter myWriter=new FileWriter(outputFileName,true);
            myWriter.write(error);
            myWriter.close();
    	}catch(IOException e) {
            System.out.println("An error occurred.");
       }
    }
    public void readInput(String inputFileName1,String outputFileName1) {
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

            if(inputCommand.contains("User request: ")){
            	int index=inputCommand.indexOf(":")+2;
            	inputCommand=inputCommand.substring(index);
            	inputString=inputCommand;
                int i=execute(inputCommand);
//                if(i==-1) {
//                	return;
//                }
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
            System.out.println("Cannot Read File.");
        }
    }
}