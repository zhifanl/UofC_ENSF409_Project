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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public LinkedList selectAllFromTable(String tableName) {
		LinkedList result = null;
		Statement Stmt = null;

		if(tableName.matches("CHAIR")) {
			try {
				Stmt = dbConnect.createStatement();
				result = new LinkedList<Chair> ();
				results = Stmt.executeQuery("SELECT * FROM CHAIR");
				while(results.next()) {
					Chair temp = new Chair ();
					temp.setID(results.getString("ID"));
					temp.setType(results.getString("Type"));
					temp.setLegs(results.getString("Legs"));
					temp.setArms(results.getString("Arms"));
					temp.setSeat(results.getString("Seat"));
					temp.setCushion(results.getString("Cushion"));
					temp.setPrice(results.getInt("Price"));
					temp.setManuID(results.getString("ManuID"));
					result.add(temp);

				}
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				if(Stmt!=null) {
					try {
						Stmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(results!=null) {
					try {
						results.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}

			}
		}

		else if(tableName.matches("DESK")) {	
			try {
				Stmt = dbConnect.createStatement();
				result = new LinkedList<Desk> ();
				results = Stmt.executeQuery("SELECT * FROM DESK");
				while(results.next()) {
					Desk temp = new Desk ();
					temp.setID(results.getString("ID"));
					temp.setType(results.getString("Type"));
					temp.setLegs(results.getString("Legs"));
					temp.setTop(results.getString("Top"));
					temp.setDrawer(results.getString("Drawer"));
					temp.setPrice(results.getInt("Price"));
					temp.setManuID(results.getString("ManuID"));
					result.add(temp);
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				if(Stmt!=null) {
					try {
						Stmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(results!=null) {
					try {
						results.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		else if(tableName.matches("FILING")) {
			try {
				Stmt = dbConnect.createStatement();
				result = new LinkedList<Filing> ();
				results = Stmt.executeQuery("SELECT * FROM FILING");
				while(results.next()) {
					Filing temp = new Filing ();
					temp.setID(results.getString("ID"));
					temp.setType(results.getString("Type"));
					temp.setRails(results.getString("Rails"));
					temp.setDrawers(results.getString("Drawers"));
					temp.setCabinet(results.getString("Cabinet"));
					temp.setPrice(results.getInt("Price"));
					temp.setManuID(results.getString("ManuID"));
					result.add(temp);
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				if(Stmt!=null) {
					try {
						Stmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(results!=null) {
					try {
						results.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}

			}
		}
		else if(tableName.matches("LAMP")) {

			try {
				Stmt = dbConnect.createStatement();
				result = new LinkedList<Lamp> ();
				results = Stmt.executeQuery("SELECT * FROM LAMP");
				while(results.next()) {
					Lamp temp = new Lamp ();
					temp.setID(results.getString("ID"));
					temp.setType(results.getString("Type"));
					temp.setBase(results.getString("Base"));
					temp.setBulb(results.getString("Bulb"));
					temp.setPrice(results.getInt("Price"));
					temp.setManuID(results.getString("ManuID"));
					result.add(temp);
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				if(Stmt!=null) {
					try {
						Stmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(results!=null) {
					try {
						results.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}

			}
		}

		else if(tableName.matches("MANUFACTURER")) {

			try {
				Stmt = dbConnect.createStatement();
				result = new LinkedList<Manufacturer> ();
				results = Stmt.executeQuery("SELECT * FROM MANUFACTURER");
				while(results.next()) {
					Manufacturer temp = new Manufacturer ();
					temp.setManuID(results.getString("ManuID"));
					temp.setName(results.getString("Name"));
					temp.setPhone(results.getString("Phone"));
					temp.setProvince(results.getString("Province"));
					result.add(temp);
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				if(Stmt!=null) {
					try {
						Stmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(results!=null) {
					try {
						results.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}

			}
		}

		return result;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public LinkedList selectTypeFromCategory(String category, String type){
		if(category.matches("CHAIR")) {
			LinkedList<Chair> temp = this.selectAllFromTable(category);
			LinkedList<Chair> result = new LinkedList<Chair> ();
			for(int i=0; i<temp.size(); i++) {
				if(temp.get(i).getType().toUpperCase().matches(type)) {
					result.add(temp.get(i));
				}
			}
			return result;
		}

		else if(category.matches("DESK")) {
			LinkedList<Desk> temp = this.selectAllFromTable(category);
			LinkedList<Desk> result = new LinkedList<Desk> ();
			for(int i=0; i<temp.size(); i++) {
				if(temp.get(i).getType().toUpperCase().matches(type)) {
					result.add(temp.get(i));
				}
			}
			return result;
		}

		else if(category.matches("LAMP")) {
			LinkedList<Lamp> temp = this.selectAllFromTable(category);
			LinkedList<Lamp> result = new LinkedList<Lamp> ();
			for(int i=0; i<temp.size(); i++) {
				if(temp.get(i).getType().toUpperCase().matches(type)) {
					result.add(temp.get(i));
				}
			}
			return result;
		}

		else if(category.matches("FILING")) {
			LinkedList<Filing> temp = this.selectAllFromTable(category);
			LinkedList<Filing> result = new LinkedList<Filing> ();
			for(int i=0; i<temp.size(); i++) {
				if(temp.get(i).getType().toUpperCase().matches(type)) {
					result.add(temp.get(i));
				}
			}
			return result;
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
						e.printStackTrace();
					}
				}
			}
		}
	}
}
