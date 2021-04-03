package edu.ucalgary.ensf409;


class Desk extends Furniture{

	private boolean Legs;
	private boolean Top;
	private boolean Drawer;

	private int Price;
	private String ManuID;
	
	/*
	* returns Legs
	*/
	public boolean getLegs() {
		return Legs;
	}
	
	/*
	* returns Top
	*/
	public boolean getTop() {
		return Top;
	}
	/*
	* returns Drawer
	*/
	public boolean getDrawer() {
		return Drawer;
	}
	
	/*
	* returns Price
	*/
	public int getPrice(){
		return Price;
	}
	
	/*
	* returns ManuID
	*/
	public String getManuID() {
		return ManuID;
	}
	/*
	*Receievs the Strings legs as an argument and if legs equals Y
	*Then, set the field Legs to true else set the field Legs to false
	*/

	public void setLegs(String legs) {
		if(legs.equals("Y")) {
			this.Legs = true;
		}
		else {
			this.Legs = false;
		}
	}
	/*
	*Receievs the Strings top as an argument and if top equals Y
	*Then, set the field Top to true else set the field Top to false
	*/

	public void setTop(String top) {
		if(top.equals("Y")) {
			this.Top = true;
		}
		else {
			this.Top = false;
		}
	}
	/*
	*Receievs the Strings drawer as an argument and if drawer equals Y
	*Then, set the field Drawer to true else set the field Drawer to false
	*/

	public void setDrawer(String drawer) {
		if(drawer.equals("Y")) {
			this.Drawer = true;
		}
		else {
			this.Drawer = false;
		}
	}
	/*
	 * Set the String value to Price
	 */

	public void setPrice(int price) {
		Price = price;
	}
	/*
	 * Set the String value to ManuID
	 */

	public void setManuID(String manuID) {
		ManuID = manuID;
	}

}
