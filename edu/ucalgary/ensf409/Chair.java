package edu.ucalgary.ensf409;


class Chair extends Furniture {
	private boolean Legs;
	private boolean Arms;
	private boolean Seat;
	private boolean Cushion;
	
	/*
	* returns Legs
	*/

	public boolean getLegs() {
		return Legs;
	}
	/*
	* returns Arms
	*/

	public boolean getArms() {
		return Arms;
	}
	/*
	* returns Seat
	*/

	public boolean getSeat() {
		return Seat;
	}
	/*
	* returns Cushion
	*/

	public boolean getCushion() {
		return Cushion;
	}
	/*
	*Receives the String legs as an argument and if legs equals Y
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
	*Receives the String arms as an argument and if arms equals Y
	*Then, set the field Arms to true else set the field Arms to false
	*/
	public void setArms(String arms) {
		if(arms.equals("Y")) {
			this.Arms = true;
		}
		else {
			this.Arms = false;
		}
	}
	/*
	*Receives the String seat as an argument and if seat equals Y
	*Then, set the field Seat to true else set the field Seat to false
	*/

	public void setSeat(String seat) {
		if(seat.equals("Y")) {
			this.Seat = true;
		}
		else {
			this.Seat = false;
		}
	}
	/*
	*Receives the String cushion as an argument and if cushion equals Y
	*Then, set the field Cushion to true else set the field Cushion to false
	*/

	public void setCushion(String cushion) {
		if(cushion.equals("Y")) {
			this.Cushion = true;
		}
		else {
			this.Cushion = false;
		}
	}


}
