package edu.ucalgary.ensf409;


class Chair extends Furniture {
	private boolean Legs;
	private boolean Arms;
	private boolean Seat;
	private boolean Cushion;

	public boolean getLegs() {
		return Legs;
	}

	public boolean getArms() {
		return Arms;
	}

	public boolean getSeat() {
		return Seat;
	}

	public boolean getCushion() {
		return Cushion;
	}

	public void setLegs(String legs) {
		if(legs.equals("Y")) {
			this.Legs = true;
		}
		else {
			this.Legs = false;
		}
	}

	public void setArms(String arms) {
		if(arms.equals("Y")) {
			this.Arms = true;
		}
		else {
			this.Arms = false;
		}
	}

	public void setSeat(String seat) {
		if(seat.equals("Y")) {
			this.Seat = true;
		}
		else {
			this.Seat = false;
		}
	}

	public void setCushion(String cushion) {
		if(cushion.equals("Y")) {
			this.Cushion = true;
		}
		else {
			this.Cushion = false;
		}
	}


}
