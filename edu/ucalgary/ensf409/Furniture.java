package edu.ucalgary.ensf409;


public abstract class Furniture {
	private String ID;
	private String Type;
	private int Price;
	private String ManuID;

	/*
	 * returns ManuID
	 */
	public String getManuID() {
		return ManuID;
	}
	/*
	 * returns ID
	 */
	public String getID() {
		return ID;
	}
	/*
	 * returns Type
	 */
	public String getType() {
		return Type;
	}
	/*
	 * returns Price
	 */
	public int getPrice(){
		return Price;
	}
	/*
	 * Set the String value to ID
	 */
	public void setID(String iD) {
		this.ID = iD;
	}
	/*
	 * Set the String value to Type
	 */
	public void setType(String type) {
		this.Type = type;
	}
	/*
	 * Set the String value to Price
	 */
	public void setPrice(int price) {
		this.Price = price;
	}
	/*
	 * Set the String value to ManuID
	 */
	public void setManuID(String manuID) {
		this.ManuID = manuID;
	}

}
