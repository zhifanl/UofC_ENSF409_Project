package edu.ucalgary.ensf409;

class Chair {
    private String ID;
    private String Type;
    private String Legs;
    private String Arms;
    private String Seat;
    private String Cushion;
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

    public String getLegs() {
        return Legs;
    }

    public String getArms() {
        return Arms;
    }

    public String getSeat() {
        return Seat;
    }

    public String getCushion() {
        return Cushion;
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

	public void setLegs(String legs) {
		Legs = legs;
	}

	public void setArms(String arms) {
		Arms = arms;
	}

	public void setSeat(String seat) {
		Seat = seat;
	}

	public void setCushion(String cushion) {
		Cushion = cushion;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public void setManuID(String manuID) {
		ManuID = manuID;
	}

}
