package edu.ucalgary.ensf409;

import static org.junit.Assert.assertEquals;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;

import org.junit.Test;


public class TestMySystem {
	//Test cases for CHAIR
	@Test
	  public void GradingTest1() throws IOException{
		 Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","tianfan","Wenyan3524");
	    	myJDBC.initializeConnection();
	    	
	       
	    	
	        LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("CHAIR", "MESH");
	        
	        Algorithm obj=new Algorithm();
	        Combination result=obj.findCheapestSet(searchedResults);
	       
	    boolean isTwoEqual = result.getPrice()==150;
	   String a=String.valueOf(isTwoEqual);
	    assertEquals(a,"true");
	  }
	@Test
	  public void GradingTest2() throws IOException{
		 Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","tianfan","Wenyan3524");
	    	myJDBC.initializeConnection();
	    	
	     
	    	
	        LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("CHAIR", "EXECUTIVE");
	        
	        Algorithm obj=new Algorithm();
	        Combination result=obj.findCheapestSet(searchedResults);
	       
	    boolean isTwoEqual = result.getPrice()==400;
	   String a=String.valueOf(isTwoEqual);
	    assertEquals(a,"true");
	  }
	@Test
	  public void GradingTest3() throws IOException{
		 Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","tianfan","Wenyan3524");
	    	myJDBC.initializeConnection();
	       
	        LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("CHAIR", "ERGONOMIC");
	        
	        Algorithm obj=new Algorithm();
	        Combination result=obj.findCheapestSet(searchedResults);
	       
	    boolean isTwoEqual = result.getPrice()==250;
	    //200+50=250
	   String a=String.valueOf(isTwoEqual);
	    assertEquals(a,"true");
	  }
	
	@Test
	  public void GradingTest4() throws IOException{
		 Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","tianfan","Wenyan3524");
	    	myJDBC.initializeConnection();
	       
	        LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("CHAIR", "KNEELING");
	        
	        Algorithm obj=new Algorithm();
	        Combination result=obj.findCheapestSet(searchedResults);
	       //will not find anything,  so return null;
	    boolean isTwoEqual = result==null;
	   String a=String.valueOf(isTwoEqual);
	    assertEquals(a,"true");
	  }
	@Test
	  public void GradingTest5() throws IOException{
		 Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","tianfan","Wenyan3524");
	    	myJDBC.initializeConnection();
	       
	        LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("CHAIR", "TASK");
	        
	        Algorithm obj=new Algorithm();
	        Combination result=obj.findCheapestSet(searchedResults);
	       //will not find anything,  so return null;
	    boolean isTwoEqual = result.getPrice()==150;
	    //100+50==150;
	   String a=String.valueOf(isTwoEqual);
	    assertEquals(a,"true");
	  }
	//Test cases for LAMP
		@Test
	  public void GradingTest6() throws IOException{
		 Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","tianfan","Wenyan3524");
	    	myJDBC.initializeConnection();
	       
	        LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("LAMP", "DESK");
	        
	        Algorithm obj=new Algorithm();
	        Combination result=obj.findCheapestSet(searchedResults);
	       //will not find anything,  so return null;
	    boolean isTwoEqual = result.getPrice()==20;
	    //100+50==150;
	   String a=String.valueOf(isTwoEqual);
	    assertEquals(a,"true");
	  }
		@Test
		  public void GradingTest7() throws IOException{
			 Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","tianfan","Wenyan3524");
		    	myJDBC.initializeConnection();
		       
		        LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("LAMP", "SWING ARM");
		        
		        Algorithm obj=new Algorithm();
		        Combination result=obj.findCheapestSet(searchedResults);
		       //will not find anything,  so return null;
		    boolean isTwoEqual = result.getPrice()==30;
		    //100+50==150;
		   String a=String.valueOf(isTwoEqual);
		    assertEquals(a,"true");
		  }
		@Test
		  public void GradingTest8() throws IOException{
			 Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","tianfan","Wenyan3524");
		    	myJDBC.initializeConnection();
		       
		        LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("LAMP", "STUDY");
		        
		        Algorithm obj=new Algorithm();
		        Combination result=obj.findCheapestSet(searchedResults);
		       //will not find anything,  so return null;
		    boolean isTwoEqual = result.getPrice()==10;
		    //100+50==150;
		   String a=String.valueOf(isTwoEqual);
		    assertEquals(a,"true");
		  }
		//Test cases for FILING
		@Test
		  public void GradingTest9() throws IOException{
			 Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","tianfan","Wenyan3524");
		    	myJDBC.initializeConnection();
		       
		        LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("FILING", "SMALL");
		        
		        Algorithm obj=new Algorithm();
		        Combination result=obj.findCheapestSet(searchedResults);
		       //will not find anything,  so return null;
		    boolean isTwoEqual = result.getPrice()==100;
		    //100+50==150;
		   String a=String.valueOf(isTwoEqual);
		    assertEquals(a,"true");
		  }
		@Test
		  public void GradingTest10() throws IOException{
			 Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","tianfan","Wenyan3524");
		    	myJDBC.initializeConnection();
		       
		        LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("FILING", "MEDIUM");
		        
		        Algorithm obj=new Algorithm();
		        Combination result=obj.findCheapestSet(searchedResults);
		       //will not find anything,  so return null;
		    boolean isTwoEqual = result.getPrice()==200;
		    //100+50==150;
		   String a=String.valueOf(isTwoEqual);
		    assertEquals(a,"true");
		  }
		@Test
		  public void GradingTest11() throws IOException{
			 Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","tianfan","Wenyan3524");
		    	myJDBC.initializeConnection();
		       
		        LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("FILING", "LARGE");
		        
		        Algorithm obj=new Algorithm();
		        Combination result=obj.findCheapestSet(searchedResults);
		       //will not find anything,  so return null;
		    boolean isTwoEqual = result.getPrice()==300;
		    //100+50==150;
		   String a=String.valueOf(isTwoEqual);
		    assertEquals(a,"true");
		  }
		//Test cases for desk.
		@Test
		  public void GradingTest12() throws IOException{
			 Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","tianfan","Wenyan3524");
		    	myJDBC.initializeConnection();
		       
		        LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("DESK", "TRADITIONAL");
		        
		        Algorithm obj=new Algorithm();
		        Combination result=obj.findCheapestSet(searchedResults);
		       //will not find anything,  so return null;
		    boolean isTwoEqual = result.getPrice()==100;
		    //100+50==150;
		   String a=String.valueOf(isTwoEqual);
		    assertEquals(a,"true");
		  }
		@Test
		  public void GradingTest13() throws IOException{
			 Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","tianfan","Wenyan3524");
		    	myJDBC.initializeConnection();
		       
		        LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("DESK", "ADJUSTABLE");
		        
		        Algorithm obj=new Algorithm();
		        Combination result=obj.findCheapestSet(searchedResults);
		       //will not find anything,  so return null;
		    boolean isTwoEqual = result.getPrice()==250;
		    //100+50==150;
		   String a=String.valueOf(isTwoEqual);
		    assertEquals(a,"true");
		  }
		@Test
		  public void GradingTest14() throws IOException{
			 Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","tianfan","Wenyan3524");
		    	myJDBC.initializeConnection();
		       
		        LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("DESK", "STANDING");
		        
		        Algorithm obj=new Algorithm();
		        Combination result=obj.findCheapestSet(searchedResults);
		       //will not find anything,  so return null;
		    boolean isTwoEqual = result.getPrice()==300;
		    //100+50==150;
		   String a=String.valueOf(isTwoEqual);
		    assertEquals(a,"true");
		  }
		 @Test(expected=Exception.class)
		 //Put wrong Category name
		  public void GradingTest15() throws Exception{
			 Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","tianfan","Wenyan3524");
		    	myJDBC.initializeConnection();
		       
		        LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("DESKII", "STANDING");
		        
		        Algorithm obj=new Algorithm();
		        Combination result=obj.findCheapestSet(searchedResults);
		       //will not find anything,  so return null;
		    boolean isTwoEqual = result.getPrice()==300;
		    //100+50==150;
		   String a=String.valueOf(isTwoEqual);
		    assertEquals(a,"true");
		  }
		 @Test(expected=Exception.class)
		 //Put wrong Type name
		  public void GradingTest16() throws Exception{
			 Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","tianfan","Wenyan3524");
		    	myJDBC.initializeConnection();
		       
		        LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("DESK", "AAAAAASTANDING");
		        
		        Algorithm obj=new Algorithm();
		        Combination result=obj.findCheapestSet(searchedResults);
		       //will not find anything,  so return null;
		    boolean isTwoEqual = result.getPrice()==300;
		    //100+50==150;
		   String a=String.valueOf(isTwoEqual);
		    assertEquals(a,"true");
		  }
}
