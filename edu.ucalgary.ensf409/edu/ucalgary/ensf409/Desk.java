package edu.ucalgary.ensf409;

class Desk {
    private String ID;
    private String Type;
    private String Legs;
    private String Top;
    private String Drawer;
    private int Price;
    private String ManuID;

    public String getID() {
        return ID;
    }

    public String getType() {
        return Type;
    }

    public String getLegs() {
        return Legs;
    }

    public String getTop() {
        return Top;
    }

    public String getDrawer() {
        return Drawer;
    }

    public int getPrice(){
    	return Price;
    }

    public String getManuID() {
        return ManuID;
    }

	public void setID(String iD) {
		ID = iD;
	}

	public void setType(String type) {
		Type = type;
	}

	public void setLegs(String legs) {
		Legs = legs;
	}

	public void setTop(String top) {
		Top = top;
	}

	public void setDrawer(String drawer) {
		Drawer = drawer;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public void setManuID(String manuID) {
		ManuID = manuID;
	}

}
