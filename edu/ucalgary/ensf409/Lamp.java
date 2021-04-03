package edu.ucalgary.ensf409;


class Lamp extends Furniture{

	private boolean Base;
	private boolean Bulb;
	
	/*
	* returns Base
	*/
	public boolean getBase() {
		return Base;
	}
	
	/*
	* returns Bulb
	*/
	public boolean getBulb() {
		return Bulb;
	}
	
	/*
	*Receives the String base as an argument and if base equals Y
	*Then, set the field Base to true else set the field Base to false
	*/
	public void setBase(String base) {
		if(base.equals("Y")) {
			this.Base = true;
		}
		else {
			this.Base = false;
		}
	}
	
	/*
	*Receives the String bulb as an argument and if bulb equals Y
	*Then, set the field Bulb to true else set the field Bulb to false
	*/
	public void setBulb(String bulb) {
		if(bulb.equals("Y")) {
			this.Bulb = true;
		}
		else {
			this.Bulb = false;
		}
	}

}
