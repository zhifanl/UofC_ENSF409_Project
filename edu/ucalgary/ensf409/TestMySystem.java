package edu.ucalgary.ensf409;

import static org.junit.Assert.assertEquals;
import java.sql.*;
import java.util.LinkedList;
import org.junit.Test;
/**
 * ****************************************************************************************************************
 * !!!!!!!Requirement for running this Junit Testing program!!!!!!.
 * 1. need to create a local mysql user with username: "ensf409test", and password: "password"
 * 2. need to use the inventory database, to use that database, type: "source" and "the location of inventory file"
 * 3. Now it is good to run this program.
 * 
 * 
 * Boundary cases tests: TestConnection(), TestConnectionURL(),TestWrongCategory(),TestWrongTypeName(),TestInvalidOrderNumber()
 * The rest of the test cases: Test if the result from Algorithm.findCheapestSet() will match the expected result.
 * 
 * 
 * @author Zhifan Li
 * @version 1.0
 * @since 1.0
 * *****************************************************************************************************************
 */
@SuppressWarnings("unchecked")
public class TestMySystem {



	/**
	 * test:Connection with wrong user name
	 * Boundary case: wrong user name given
	 * expected to throw exception
	 */
	@Test(expected=SQLException.class)
	public void TestConnection()throws SQLException {
		Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","wrongusername","password");
		myJDBC.initializeConnection();
	}



	/**
	 * test:ConnectionURL
	 * Boundary case: wrong URL given
	 * expected to throw exception
	 */
	@Test(expected=SQLException.class)
	public void TestConnectionURL() throws SQLException {
		Inventory myJDBC = new Inventory("jdbc:mysql://localhost/wrongname","ensf409test","password");
		myJDBC.initializeConnection();
	}


	/**
	 * test:WrongCategory
	 * Boundary case: wrong category name given (DESKII is invalid), excepted to throw exception
	 * @throws SQLException 
	 */
	@Test(expected=IllegalArgumentException.class)
	//Put wrong Category name
	public void TestWrongCategory() throws SQLException  {
		Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","ensf409test","password");
		myJDBC.initializeConnection();
		myJDBC.selectTypeFromCategory("DESKII", "STANDING");
	}


	/**
	 * test:WrongTypeName
	 * Boundary case: wrong type name given,AAAAAASTANING is invalid, expected to throw exception
	 * @throws SQLException 
	 */
	@Test(expected=IllegalArgumentException.class)
	public void TestWrongTypeName() throws SQLException {
		Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","ensf409test","password");
		myJDBC.initializeConnection();
		myJDBC.selectTypeFromCategory("DESK", "AAAAAASTANDING");
	}



	/**
	 * test:InvalidOrderNumber
	 * Boundary case: wrong order number -1 given,expected to throw exception
	 * @throws SQLException 
	 */
	@Test(expected=IllegalArgumentException.class)
	public void TestInvalidOrderNumber() throws SQLException {
		Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","ensf409test","password");
		myJDBC.initializeConnection();
		LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("DESK", "STANDING");
		Algorithm obj=new Algorithm();
		obj.findCheapestSet(searchedResults,-1,"DESK");
	}


	/**
	 * test:InvalidOrderNumber2
	 * Boundary case: wrong order number 0 given,expected to throw exception
	 * @throws SQLException 
	 */
	@Test(expected=IllegalArgumentException.class)
	public void TestInvalidOrderNumber2() throws SQLException {
		Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","ensf409test","password");
		myJDBC.initializeConnection();
		LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("DESK", "STANDING");
		Algorithm obj=new Algorithm();
		obj.findCheapestSet(searchedResults,0,"DESK");
	}


	//Test cases for CHAIR
	/**
	 * test input: mesh chair,1 
	 * expected result: 150
	 * @throws SQLException
	 */
	@Test
	public void TestMeshChair1() throws SQLException {
		Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","ensf409test","password");
		myJDBC.initializeConnection();

		LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("CHAIR", "MESH");

		Algorithm obj=new Algorithm();
		String[][] result=obj.findCheapestSet(searchedResults,1,"CHAIR");

		boolean isTwoEqual = result[1][0].equals("150");
		String a=String.valueOf(isTwoEqual);
		assertEquals(a,"true");
	}


	/**
	 * test input: mesh chair,2 
	 * expected result: not found
	 * @throws SQLException
	 */
	@Test
	public void TestMeshChair2() throws SQLException {
		Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","ensf409test","password");
		myJDBC.initializeConnection();

		LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("CHAIR", "MESH");

		Algorithm obj=new Algorithm();
		String[][] result=obj.findCheapestSet(searchedResults,2,"CHAIR");

		boolean isTwoEqual = result==null;
		String a=String.valueOf(isTwoEqual);
		assertEquals(a,"true");
	}


	/**
	 * test input: mesh chair,3
	 * expected result: not found
	 * @throws SQLException
	 */
	@Test
	public void TestMeshChair3()throws SQLException {
		Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","ensf409test","password");
		myJDBC.initializeConnection();

		LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("CHAIR", "MESH");

		Algorithm obj=new Algorithm();
		String[][] result=obj.findCheapestSet(searchedResults,3,"CHAIR");

		boolean isTwoEqual = result==null;
		String a=String.valueOf(isTwoEqual);
		assertEquals(a,"true");
	}



	/**
	 * test input: executive chair,1
	 * expected result: 400
	 * @throws SQLException
	 */
	@Test
	public void TestExecutiveChair1() throws SQLException{
		Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","ensf409test","password");
		myJDBC.initializeConnection();

		LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("CHAIR", "EXECUTIVE");

		Algorithm obj=new Algorithm();
		String[][] result=obj.findCheapestSet(searchedResults,1,"CHAIR");

		boolean isTwoEqual = result[1][0].equals("400");
		String a=String.valueOf(isTwoEqual);
		assertEquals(a,"true");
	}



	/**
	 * test input: executive chair,2
	 * expected result:not found
	 * @throws SQLException
	 */
	@Test
	public void TestExecutiveChair2()throws SQLException {
		Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","ensf409test","password");
		myJDBC.initializeConnection();
		LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("CHAIR", "EXECUTIVE");

		Algorithm obj=new Algorithm();
		String[][] result=obj.findCheapestSet(searchedResults,2,"CHAIR");

		boolean isTwoEqual = result==null;
		String a=String.valueOf(isTwoEqual);
		assertEquals(a,"true");
	}


	/**
	 * test input: ergonomic chair,1
	 * expected result: 250
	 * @throws SQLException
	 */
	@Test
	public void TestErgonomicChair1()throws SQLException {
		Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","ensf409test","password");
		myJDBC.initializeConnection();

		LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("CHAIR", "ERGONOMIC");

		Algorithm obj=new Algorithm();
		String[][] result=obj.findCheapestSet(searchedResults,1,"CHAIR");

		boolean isTwoEqual = result[1][0].equals("250");
		//200+50=250
		String a=String.valueOf(isTwoEqual);
		assertEquals(a,"true");
	}


	/**
	 * test input: ergonomic chair,2
	 * expected result: 250
	 * @throws SQLException
	 */
	@Test
	public void TestErgonomicChair2()throws SQLException {
		Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","ensf409test","password");
		myJDBC.initializeConnection();

		LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("CHAIR", "ERGONOMIC");

		Algorithm obj=new Algorithm();
		String[][] result=obj.findCheapestSet(searchedResults,2,"CHAIR");

		boolean isTwoEqual = result==null;
		//200+50=250
		String a=String.valueOf(isTwoEqual);
		assertEquals(a,"true");
	}


	/**
	 * test input: kneeling chair,1
	 * expected result: not found
	 * @throws SQLException
	 */
	@Test
	public void TestChairKneeling1()throws SQLException {
		Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","ensf409test","password");
		myJDBC.initializeConnection();

		LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("CHAIR", "KNEELING");

		Algorithm obj=new Algorithm();
		String[][] result=obj.findCheapestSet(searchedResults,1,"CHAIR");

		boolean isTwoEqual = result==null;
		String a=String.valueOf(isTwoEqual);
		assertEquals(a,"true");
	}


	/**
	 * test input: task chair,1
	 * expected result: 150
	 * @throws SQLException
	 */
	@Test
	public void TestChairTask1()throws SQLException {
		Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","ensf409test","password");
		myJDBC.initializeConnection();

		LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("CHAIR", "TASK");

		Algorithm obj=new Algorithm();
		String[][] result=obj.findCheapestSet(searchedResults,1,"CHAIR");

		boolean isTwoEqual = result[1][0].equals("150");

		String a=String.valueOf(isTwoEqual);
		assertEquals(a,"true");
	}


	/**
	 * test input: task chair,2
	 * expected result: not found
	 * @throws SQLException
	 */
	@Test
	public void TestChairTask2()throws SQLException {
		Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","ensf409test","password");
		myJDBC.initializeConnection();

		LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("CHAIR", "TASK");

		Algorithm obj=new Algorithm();
		String[][] result=obj.findCheapestSet(searchedResults,2,"CHAIR");

		boolean isTwoEqual = result==null;

		String a=String.valueOf(isTwoEqual);
		assertEquals(a,"true");
	}


	/**
	 * test input: desk lamp,1
	 * expected result: 20
	 * @throws SQLException
	 */
	//Test cases for LAMP
	@Test
	public void TestLampDesk1()throws SQLException {
		Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","ensf409test","password");
		myJDBC.initializeConnection();

		LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("LAMP", "DESK");

		Algorithm obj=new Algorithm();
		String[][] result=obj.findCheapestSet(searchedResults,1,"LAMP");

		boolean isTwoEqual = result[1][0].equals("20");
		String a=String.valueOf(isTwoEqual);
		assertEquals(a,"true");
	}


	/**
	 * test input: desk lamp,2
	 * expected result: 40
	 * @throws SQLException
	 */
	//Test cases for LAMP
	@Test
	public void TestLampDesk2()throws SQLException {
		Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","ensf409test","password");
		myJDBC.initializeConnection();

		LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("LAMP", "DESK");

		Algorithm obj=new Algorithm();
		String[][] result=obj.findCheapestSet(searchedResults,2,"LAMP");

		boolean isTwoEqual = result[1][0].equals("40");
		String a=String.valueOf(isTwoEqual);
		assertEquals(a,"true");
	}


	/**
	 * test input: desk lamp,3
	 * expected result: 60
	 * @throws SQLException
	 */
	//Test cases for LAMP
	@Test
	public void TestLampDesk3()throws SQLException {
		Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","ensf409test","password");
		myJDBC.initializeConnection();

		LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("LAMP", "DESK");

		Algorithm obj=new Algorithm();
		String[][] result=obj.findCheapestSet(searchedResults,3,"LAMP");

		boolean isTwoEqual = result[1][0].equals("60");
		String a=String.valueOf(isTwoEqual);
		assertEquals(a,"true");
	}



	/**
	 * test input: desk lamp,4
	 * expected result: not found
	 * @throws SQLException
	 */
	//Test cases for LAMP
	@Test
	public void TestLampDesk4()throws SQLException {
		Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","ensf409test","password");
		myJDBC.initializeConnection();

		LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("LAMP", "DESK");

		Algorithm obj=new Algorithm();
		String[][] result=obj.findCheapestSet(searchedResults,4,"LAMP");

		boolean isTwoEqual = result==null;
		String a=String.valueOf(isTwoEqual);
		assertEquals(a,"true");
	}



	/**
	 * test input: swing arm lamp,1
	 * expected result: 30
	 * @throws SQLException
	 */
	@Test
	public void TestLampSwingArm1()throws SQLException {
		Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","ensf409test","password");
		myJDBC.initializeConnection();

		LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("LAMP", "SWING ARM");

		Algorithm obj=new Algorithm();
		String[][] result=obj.findCheapestSet(searchedResults,1,"LAMP");

		boolean isTwoEqual = result[1][0].equals("30");
		String a=String.valueOf(isTwoEqual);
		assertEquals(a,"true");
	}



	/**
	 * test input: swing arm lamp,2
	 * expected result: 60
	 * @throws SQLException
	 */
	@Test
	public void TestLampSwingArm2()throws SQLException {
		Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","ensf409test","password");
		myJDBC.initializeConnection();

		LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("LAMP", "SWING ARM");

		Algorithm obj=new Algorithm();
		String[][] result=obj.findCheapestSet(searchedResults,2,"LAMP");

		boolean isTwoEqual = result[1][0].equals("60");
		String a=String.valueOf(isTwoEqual);
		assertEquals(a,"true");
	}


	/**
	 * test input: swing arm lamp,3
	 * expected result: not found
	 * @throws SQLException
	 */
	@Test
	public void TestLampSwingArm3()throws SQLException {
		Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","ensf409test","password");
		myJDBC.initializeConnection();

		LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("LAMP", "SWING ARM");

		Algorithm obj=new Algorithm();
		String[][] result=obj.findCheapestSet(searchedResults,3,"LAMP");

		boolean isTwoEqual = result==null;
		String a=String.valueOf(isTwoEqual);
		assertEquals(a,"true");
	}




	/**
	 * test input: study lamp,1
	 * expected result: 10
	 * @throws SQLException
	 */
	@Test
	public void TestLampStudy1() throws SQLException{
		Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","ensf409test","password");
		myJDBC.initializeConnection();

		LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("LAMP", "STUDY");

		Algorithm obj=new Algorithm();
		String[][] result=obj.findCheapestSet(searchedResults,1,"LAMP");

		boolean isTwoEqual = result[1][0].equals("10");
		String a=String.valueOf(isTwoEqual);
		assertEquals(a,"true");
	}


	/**
	 * test input: study lamp,2
	 * expected result: 20
	 * @throws SQLException
	 */
	@Test
	public void TestLampStudy2() throws SQLException{
		Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","ensf409test","password");
		myJDBC.initializeConnection();

		LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("LAMP", "STUDY");

		Algorithm obj=new Algorithm();
		String[][] result=obj.findCheapestSet(searchedResults,2,"LAMP");

		boolean isTwoEqual = result[1][0].equals("20");
		String a=String.valueOf(isTwoEqual);
		assertEquals(a,"true");
	}



	/**
	 * test input: study lamp,3
	 * expected result: 10
	 * @throws SQLException
	 */
	@Test
	public void TestLampStudy3() throws SQLException{
		Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","ensf409test","password");
		myJDBC.initializeConnection();

		LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("LAMP", "STUDY");

		Algorithm obj=new Algorithm();
		String[][] result=obj.findCheapestSet(searchedResults,3,"LAMP");

		boolean isTwoEqual = result==null;
		String a=String.valueOf(isTwoEqual);
		assertEquals(a,"true");
	}


	/**
	 * test input: small filing,1
	 * expected result: 100
	 * @throws SQLException
	 */
	//Test cases for FILING
	@Test
	public void TestFilingSmall1()throws SQLException {
		Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","ensf409test","password");
		myJDBC.initializeConnection();

		LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("FILING", "SMALL");

		Algorithm obj=new Algorithm();
		String[][] result=obj.findCheapestSet(searchedResults,1,"FILING");
		boolean isTwoEqual = result[1][0].equals("100");
		String a=String.valueOf(isTwoEqual);
		assertEquals(a,"true");
	}



	/**
	 * test input: small filing,2
	 * expected result: 200
	 * @throws SQLException
	 */
	//Test cases for FILING
	@Test
	public void TestFilingSmall2()throws SQLException {
		Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","ensf409test","password");
		myJDBC.initializeConnection();

		LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("FILING", "SMALL");

		Algorithm obj=new Algorithm();
		String[][] result=obj.findCheapestSet(searchedResults,2,"FILING");

		boolean isTwoEqual = result[1][0].equals("200");
		String a=String.valueOf(isTwoEqual);
		assertEquals(a,"true");
	}


	/**
	 * test input: small filing,3
	 * expected result: 300
	 * @throws SQLException
	 */
	//Test cases for FILING
	@Test
	public void TestFilingSmall3()throws SQLException {
		Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","ensf409test","password");
		myJDBC.initializeConnection();

		LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("FILING", "SMALL");

		Algorithm obj=new Algorithm();
		String[][] result=obj.findCheapestSet(searchedResults,3,"FILING");

		boolean isTwoEqual = result[1][0].equals("300");
		String a=String.valueOf(isTwoEqual);
		assertEquals(a,"true");
	}



	/**
	 * test input: small filing,4
	 * expected result: not found
	 * @throws SQLException
	 */
	//Test cases for FILING
	@Test
	public void TestFilingSmall4()throws SQLException {
		Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","ensf409test","password");
		myJDBC.initializeConnection();

		LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("FILING", "SMALL");

		Algorithm obj=new Algorithm();
		String[][] result=obj.findCheapestSet(searchedResults,4,"FILING");

		boolean isTwoEqual = result==null;
		String a=String.valueOf(isTwoEqual);
		assertEquals(a,"true");
	}


	/**
	 * test input: medium filing,1
	 * expected result: 200
	 * @throws SQLException
	 */
	@Test
	public void TestFilingMedium1() throws SQLException{
		Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","ensf409test","password");
		myJDBC.initializeConnection();

		LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("FILING", "MEDIUM");

		Algorithm obj=new Algorithm();
		String[][] result=obj.findCheapestSet(searchedResults,1,"FILING");
		boolean isTwoEqual = result[1][0].equals("200");
		String a=String.valueOf(isTwoEqual);
		assertEquals(a,"true");
	}



	/**
	 * test input: medium filing,2
	 * expected result: 400
	 * @throws SQLException
	 */
	@Test
	public void TestFilingMedium2() throws SQLException{
		Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","ensf409test","password");
		myJDBC.initializeConnection();

		LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("FILING", "MEDIUM");

		Algorithm obj=new Algorithm();
		String[][] result=obj.findCheapestSet(searchedResults,2,"FILING");
		boolean isTwoEqual = result[1][0].equals("400");
		String a=String.valueOf(isTwoEqual);
		assertEquals(a,"true");
	}


	/**
	 * test input: medium filing,3
	 * expected result: 200
	 * @throws SQLException
	 */
	@Test
	public void TestFilingMedium3() throws SQLException{
		Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","ensf409test","password");
		myJDBC.initializeConnection();

		LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("FILING", "MEDIUM");

		Algorithm obj=new Algorithm();
		String[][] result=obj.findCheapestSet(searchedResults,3,"FILING");
		//will not find anything,  so return null;
		boolean isTwoEqual = result[1][0].equals("650");
		String a=String.valueOf(isTwoEqual);
		assertEquals(a,"true");
	}



	/**
	 * test input: medium filing,4
	 * expected result: not found
	 * @throws SQLException
	 */
	@Test
	public void TestFilingMedium4() throws SQLException{
		Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","ensf409test","password");
		myJDBC.initializeConnection();

		LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("FILING", "MEDIUM");

		Algorithm obj=new Algorithm();
		String[][] result=obj.findCheapestSet(searchedResults,4,"FILING");
		//will not find anything,  so return null;
		boolean isTwoEqual = result==null;
		String a=String.valueOf(isTwoEqual);
		assertEquals(a,"true");
	}


	/**
	 * test input: large filing,1
	 * expected result: 300
	 * @throws SQLException
	 */
	@Test
	public void TestFilingLarge1()throws SQLException {
		Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","ensf409test","password");
		myJDBC.initializeConnection();

		LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("FILING", "LARGE");

		Algorithm obj=new Algorithm();
		String[][] result=obj.findCheapestSet(searchedResults,1,"FILING");

		boolean isTwoEqual = result[1][0].equals("300");
		String a=String.valueOf(isTwoEqual);
		assertEquals(a,"true");
	}


	/**
	 * test input: large filing,2
	 * expected result: 600
	 * @throws SQLException
	 */
	@Test
	public void TestFilingLarge2()throws SQLException {
		Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","ensf409test","password");
		myJDBC.initializeConnection();

		LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("FILING", "LARGE");

		Algorithm obj=new Algorithm();
		String[][] result=obj.findCheapestSet(searchedResults,2,"FILING");

		boolean isTwoEqual = result[1][0].equals("600");
		String a=String.valueOf(isTwoEqual);
		assertEquals(a,"true");
	}


	/**
	 * test input: large filing,3
	 * expected result: not found
	 * @throws SQLException
	 */
	@Test
	public void TestFilingLarge3()throws SQLException {
		Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","ensf409test","password");
		myJDBC.initializeConnection();

		LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("FILING", "LARGE");

		Algorithm obj=new Algorithm();
		String[][] result=obj.findCheapestSet(searchedResults,3,"FILING");

		boolean isTwoEqual = result==null;
		String a=String.valueOf(isTwoEqual);
		assertEquals(a,"true");
	}


	/**
	 * test input: traditional desk,1
	 * expected result: 100
	 * @throws SQLException
	 */
	//Test cases for desk.
	@Test
	public void TestDeskTraditional1()throws SQLException {
		Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","ensf409test","password");
		myJDBC.initializeConnection();

		LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("DESK", "TRADITIONAL");

		Algorithm obj=new Algorithm();
		String[][] result=obj.findCheapestSet(searchedResults,1,"DESK");

		boolean isTwoEqual = result[1][0].equals("100");

		String a=String.valueOf(isTwoEqual);
		assertEquals(a,"true");
	}


	/**
	 * test input: traditional desk,2
	 * expected result: 200
	 * @throws SQLException
	 */
	//Test cases for desk.
	@Test
	public void TestDeskTraditional2()throws SQLException {
		Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","ensf409test","password");
		myJDBC.initializeConnection();

		LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("DESK", "TRADITIONAL");

		Algorithm obj=new Algorithm();
		String[][] result=obj.findCheapestSet(searchedResults,2,"DESK");

		boolean isTwoEqual = result[1][0].equals("200");

		String a=String.valueOf(isTwoEqual);
		assertEquals(a,"true");
	}



	/**
	 * test input: traditional desk,3
	 * expected result: not found
	 * @throws SQLException
	 */
	//Test cases for desk.
	@Test
	public void TestDeskTraditional3()throws SQLException {
		Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","ensf409test","password");
		myJDBC.initializeConnection();

		LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("DESK", "TRADITIONAL");

		Algorithm obj=new Algorithm();
		String[][] result=obj.findCheapestSet(searchedResults,3,"DESK");

		boolean isTwoEqual = result==null;

		String a=String.valueOf(isTwoEqual);
		assertEquals(a,"true");
	}



	/**
	 * test input: adjustable desk,1
	 * expected result: 250
	 * @throws SQLException
	 */
	@Test
	public void TestDeskAdjustable1()throws SQLException {
		Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","ensf409test","password");
		myJDBC.initializeConnection();


		LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("DESK", "ADJUSTABLE");

		Algorithm obj=new Algorithm();
		String[][] result=obj.findCheapestSet(searchedResults,1,"DESK");

		boolean isTwoEqual = result[1][0].equals("250");
		String a=String.valueOf(isTwoEqual);
		assertEquals(a,"true");
	}


	/**
	 * test input: adjustable desk,2
	 * expected result: 650
	 * @throws SQLException
	 */
	@Test
	public void TestDeskAdjustable2()throws SQLException {
		Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","ensf409test","password");
		myJDBC.initializeConnection();


		LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("DESK", "ADJUSTABLE");

		Algorithm obj=new Algorithm();
		String[][] result=obj.findCheapestSet(searchedResults,2,"DESK");

		boolean isTwoEqual = result[1][0].equals("650");
		String a=String.valueOf(isTwoEqual);
		assertEquals(a,"true");
	}


	/**
	 * test input: adjustable desk,3
	 * expected result: 1050
	 * @throws SQLException
	 */
	@Test
	public void TestDeskAdjustable3()throws SQLException {
		Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","ensf409test","password");
		myJDBC.initializeConnection();


		LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("DESK", "ADJUSTABLE");

		Algorithm obj=new Algorithm();
		String[][] result=obj.findCheapestSet(searchedResults,3,"DESK");

		boolean isTwoEqual = result[1][0].equals("1050");
		String a=String.valueOf(isTwoEqual);
		assertEquals(a,"true");
	}



	/**
	 * test input: adjustable desk,4
	 * expected result: not found
	 * @throws SQLException
	 */
	@Test
	public void TestDeskAdjustable4()throws SQLException {
		Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","ensf409test","password");
		myJDBC.initializeConnection();


		LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("DESK", "ADJUSTABLE");

		Algorithm obj=new Algorithm();
		String[][] result=obj.findCheapestSet(searchedResults,4,"DESK");

		boolean isTwoEqual = result==null;
		String a=String.valueOf(isTwoEqual);
		assertEquals(a,"true");
	}


	/**
	 * test input: standing desk,1
	 * expected result: 300
	 * @throws SQLException
	 */
	@Test
	public void TestDeskStanding1()throws SQLException {
		Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","ensf409test","password");
		myJDBC.initializeConnection();

		LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("DESK", "STANDING");

		Algorithm obj=new Algorithm();
		String[][] result=obj.findCheapestSet(searchedResults,1,"DESK");

		boolean isTwoEqual = result[1][0].equals("300");
		String a=String.valueOf(isTwoEqual);
		assertEquals(a,"true");
	}



	/**
	 * test input: standing desk,2
	 * expected result: 600
	 * @throws SQLException
	 */
	@Test
	public void TestDeskStanding2()throws SQLException {
		Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","ensf409test","password");
		myJDBC.initializeConnection();

		LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("DESK", "STANDING");

		Algorithm obj=new Algorithm();
		String[][] result=obj.findCheapestSet(searchedResults,2,"DESK");

		boolean isTwoEqual = result[1][0].equals("600");
		String a=String.valueOf(isTwoEqual);
		assertEquals(a,"true");
	}



	/**
	 * test input: standing desk,3
	 * expected result: not found
	 * @throws SQLException
	 */
	@Test
	public void TestDeskStanding3()throws SQLException {
		Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory","ensf409test","password");
		myJDBC.initializeConnection();

		LinkedList<Furniture>searchedResults=myJDBC.selectTypeFromCategory("DESK", "STANDING");

		Algorithm obj=new Algorithm();
		String[][] result=obj.findCheapestSet(searchedResults,3,"DESK");

		boolean isTwoEqual = result==null;
		String a=String.valueOf(isTwoEqual);
		assertEquals(a,"true");
	}


}
