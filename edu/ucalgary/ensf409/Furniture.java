package edu.ucalgary.ensf409;

public abstract class Furniture {
	private String ID;
    private String Type;
    private int Price;
    private String ManuID;

    public String getManuID() {
        return ManuID;
    }

    public String getID() {
        return ID;
    }

    public String getType() {
        return Type;
    }

    public int getPrice(){
    	return Price;
    }

	public void setID(String iD) {
		ID = iD;
	}

	public void setType(String type) {
		Type = type;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public void setManuID(String manuID) {
		ManuID = manuID;
	}

}
