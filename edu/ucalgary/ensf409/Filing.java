package edu.ucalgary.ensf409;


class Filing extends Furniture{

	private boolean Rails;
	private boolean Drawers;
	private boolean Cabinet;

	public boolean getRails() {
		return Rails;
	}

	public boolean getDrawers() {
		return Drawers;
	}

	public boolean getCabinet() {
		return Cabinet;
	}

	public void setRails(String rails) {
		if(rails.equals("Y")) {
			this.Rails = true;
		}
		else {
			this.Rails = false;
		}
	}

	public void setDrawers(String drawers) {
		if(drawers.equals("Y")) {
			this.Drawers = true;
		}
		else {
			this.Drawers = false;
		}
	}

	public void setCabinet(String cabinet) {
		if(cabinet.equals("Y")) {
			this.Cabinet = true;
		}
		else {
			this.Cabinet = false;
		}
	}

}