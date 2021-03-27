package edu.ucalgary.ensf409;

class Lamp {
    private String ID;
    private String Type;
    private String Base;
    private String Bulb;
    private int Price;
    private String ManuID;

    public String getID() {
        return ID;
    }

    public String getType() {
        return Type;
    }

    public String getBase() {
        return Base;
    }

    public String getBulb() {
        return Bulb;
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

	public void setBase(String base) {
		Base = base;
	}

	public void setBulb(String bulb) {
		Bulb = bulb;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public void setManuID(String manuID) {
		ManuID = manuID;
	}

}
