package edu.ucalgary.ensf409;


class Lamp extends Furniture{

    private boolean Base;
    private boolean Bulb;

    public boolean getBase() {
        return Base;
    }

    public boolean getBulb() {
        return Bulb;
    }

	public void setBase(String base) {
		if(base.equals("Y")) {
			this.Base = true;
		}
		else {
			this.Base = false;
		}
	}

	public void setBulb(String bulb) {
		if(bulb.equals("Y")) {
			this.Bulb = true;
		}
		else {
			this.Bulb = false;
		}
	}

}
