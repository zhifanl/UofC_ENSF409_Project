package edu.ucalgary.ensf409;

class Chair {
    private final String ID;
    private final String Type;
    private final String Legs;
    private final String Arms;
    private final String Seat;
    private final String Cushion;
    private final int Price;
    private final String ManuID;

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

    public int getPrice(){return Price};

}
