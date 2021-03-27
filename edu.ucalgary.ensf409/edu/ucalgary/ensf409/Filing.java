package edu.ucalgary.ensf409;

class Filing {

    private String ID;
    private String Type;
    private String Rails;
    private String Drawers;
    private String Cabinet;
    private int Price;
    private String ManuID;

    public String getID() {
        return ID;
    }

    public String getType() {
        return Type;
    }

    public String getRails() {
        return Rails;
    }

    public String getDrawers() {
        return Drawers;
    }

    public String getCabinet() {
        return Cabinet;
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

	public void setRails(String rails) {
		Rails = rails;
	}

	public void setDrawers(String drawers) {
		Drawers = drawers;
	}

	public void setCabinet(String cabinet) {
		Cabinet = cabinet;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public void setManuID(String manuID) {
		ManuID = manuID;
	}

}