package edu.ucalgary.ensf409;


class Desk extends Furniture{

	private boolean Legs;
	private boolean Top;
	private boolean Drawer;

	private int Price;
	private String ManuID;

	public boolean getLegs() {
		return Legs;
	}

	public boolean getTop() {
		return Top;
	}

	public boolean getDrawer() {
		return Drawer;
	}

	public int getPrice(){
		return Price;
	}

	public String getManuID() {
		return ManuID;
	}

	public void setLegs(String legs) {
		if(legs.equals("Y")) {
			this.Legs = true;
		}
		else {
			this.Legs = false;
		}
	}

	public void setTop(String top) {
		if(top.equals("Y")) {
			this.Top = true;
		}
		else {
			this.Top = false;
		}
	}

	public void setDrawer(String drawer) {
		if(drawer.equals("Y")) {
			this.Drawer = true;
		}
		else {
			this.Drawer = false;
		}
	}

	public void setPrice(int price) {
		Price = price;
	}

	public void setManuID(String manuID) {
		ManuID = manuID;
	}

}
