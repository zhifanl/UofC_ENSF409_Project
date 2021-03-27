package edu.ucalgary.ensf409;

import java.sql.*;
import java.util.LinkedList;

/**
 * @author tianfan zhou <a href="mailto:tianfan.zhou@ucalgary.ca">
 * tianfan.zhou@ucalgary.ca</a>
 *  
 * @version 1.0
 * @since   1.0
 */

public class Inventory {
	public final String DBURL; //store the database url information
    public final String USERNAME; //store the user's account username
    public final String PASSWORD; //store the user's account password
    
    private Connection dbConnect;
    private ResultSet results;
    
	/**
	 * Constructor
	 * @param url DBURL
	 * @param username USERNAME
	 * @param password PASSWORD
	 */
    public Inventory(String dburl, String username, String password) {
    	this.DBURL = dburl;
    	this.USERNAME = username;
    	this.PASSWORD = password;
    }
    
    /**
     * getter method for DBURL
     * @return DBURL
     */
    public String getDBURL() {
    	return this.DBURL;
    }
    
    /**
     * getter method for USERNAME
     * @return USERNAME
     */
    public String getUSERNAME() {
    	return this.USERNAME;
    }
    
    /**
     * getter method for PASSWORD
     * @return PASSWORD
     */
    public String getPASSWORD() {
    	return this.PASSWORD;
    }
    
    /**
     * method to create a connection to the database
     * store the instance into data member dbConnect
     */
    public void initializeConnection() {
    	try {
    		dbConnect = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
    	}catch (SQLException e) {
    		 e.printStackTrace();
    	}
    }
    
    public LinkedList<String[]> selectAllFromTable(String tableName) {
    	LinkedList result = null;
    	Statement Stmt = null;
    	
    	if(tableName.matches("CHAIR")) {
    		try {
        		Stmt = dbConnect.createStatement();
        		result = new LinkedList<Chair> ();
        		Chair temp = new Chair ();
        		results = Stmt.executeQuery("SELECT * FROM CHAIR");
        		while(results.next()) {
        			Chair.setID() = results.getString("ID");
        			Chair.setType() = results.getString("Type");
        			Chair.setLegs() = results.getString("Legs");
        			Chair.setArms() = results.getString("Arms");
        			Chair.setSeat() = results.getString("Seat");
        			Chair.setCushion() = results.getString("Cushion");
        			Chair.setPrice() = results.getString("Price");
        			Chair.setManuID() = results.getString("ManuID");
        			result.append(temp);
        		}
        	}catch (SQLException e) {
    			e.printStackTrace();
    		}finally {
    			if(Stmt!=null) {
    				try {
    					Stmt.close();
    				} catch (SQLException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
    			}
    		
    		}
    	}
    	
    	else if(tableName.matches("DESK")) {	
    		try {
        		Stmt = dbConnect.createStatement();
        		result = new LinkedList<Desk> ();
        		Desk temp = new Desk ();
        		results = Stmt.executeQuery("SELECT * FROM DESK");
        		while(results.next()) {
        			Desk.setID() = results.getString("ID");
        			Desk.setType() = results.getString("Type");
        			Desk.setLegs() = results.getString("Legs");
        			Desk.setTop() = results.getString("Top");
        			Desk.setDrawer() = results.getString("Drawer");
        			Desk.setPrice() = results.getString("Price");
        			Desk.setManuID() = results.getString("ManuID");
        			result.append(temp);
        		}
        	}catch (SQLException e) {
    			e.printStackTrace();
    		}finally {
    			if(Stmt!=null) {
    				try {
    					Stmt.close();
    				} catch (SQLException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
    			}
    		
    		}
    	}
		
    	else if(tableName.matches("FILING")) {
    		try {
        		Stmt = dbConnect.createStatement();
        		result = new LinkedList<Filing> ();
        		Filing temp = new Filing ();
        		results = Stmt.executeQuery("SELECT * FROM FILING");
        		while(results.next()) {
        			Filing.setID() = results.getString("ID");
        			Filing.setType() = results.getString("Type");
        			Filing.setRails() = results.getString("Rails");
        			Filing.setDrawers() = results.getString("Drawers");
        			Filing.setCabinet() = results.getString("Cabinet");
        			Filing.setPrice() = results.getString("Price");
        			Filing.setManuID() = results.getString("ManuID");
        			result.append(temp);
        		}
        	}catch (SQLException e) {
    			e.printStackTrace();
    		}finally {
    			if(Stmt!=null) {
    				try {
    					Stmt.close();
    				} catch (SQLException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
    			}
    		
    		}
    	}
    	else if(tableName.matches("LAMP")) {
    		
    		try {
        		Stmt = dbConnect.createStatement();
        		result = new LinkedList<Lamp> ();
        		Lamp temp = new Lamp ();
        		results = Stmt.executeQuery("SELECT * FROM LAMP");
        		while(results.next()) {
        			Lamp.setID() = results.getString("ID");
        			Lamp.setType() = results.getString("Type");
        			Lamp.setBase() = results.getString("Base");
        			Lamp.setBulb() = results.getString("Bulb");
        			Lamp.setPrice() = results.getString("Price");
        			Lamp.setManuID() = results.getString("ManuID");
        			result.append(temp);
        		}
        	}catch (SQLException e) {
    			e.printStackTrace();
    		}finally {
    			if(Stmt!=null) {
    				try {
    					Stmt.close();
    				} catch (SQLException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
    			}
    		
    		}
    	}
    	
    	else if(tableName.matches("MANUFACTURER")) {
    		
    		try {
        		Stmt = dbConnect.createStatement();
        		result = new LinkedList<Manufacturer> ();
        		Manufacturer temp = new Manufacturer ();
        		results = Stmt.executeQuery("SELECT * FROM MAUNFACTURER");
        		while(results.next()) {
        			Manufacturer.setManuID() = results.getString("ManuID");
        			Manufacturer.setName() = results.getString("Name");
        			Manufacturer.setPhone() = results.getString("Phone");
        			Manufacturer.setProvince() = results.getString("Province");
        			result.append(temp);
        		}
        	}catch (SQLException e) {
    			e.printStackTrace();
    		}finally {
    			if(Stmt!=null) {
    				try {
    					Stmt.close();
    				} catch (SQLException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
    			}
    		
    		}
    	}
    	
    	else {
    		return null;
    	}
    	
    }
    
    public void deleteFromTable(String tableName, String ID) {
    	if(!tableName.matches("CHAIR") && !tableName.matches("LAMP") && !tableName.matches("DESK") && !tableName.matches("FILING")) {
    		return;
    	}
    	else {
    		PreparedStatement ps = null;
        	try {
        		String query = "DELETE FROM " + tableName + " WHERE ID = ?";
        		ps = dbConnect.prepareStatement(query);
        		
        		ps.setString(1, ID);
        		ps.executeUpdate();
        	}catch(SQLException e) {
        		e.printStackTrace();
        	}finally {
        		if(ps!=null) {
        			try {
        				ps.close();
        			} catch (SQLException e) {
        				// TODO Auto-generated catch block
        				e.printStackTrace();
        			}
        		}
        	}
    	}
    }
}
