package edu.ucalgary.ensf409;


class Filing extends Furniture{

	private boolean Rails;
	private boolean Drawers;
	private boolean Cabinet;
	
	/*
	* returns Rails
	*/
	public boolean getRails() {
		return Rails;
	}
	
	/*
	* returns Drawers
	*/
	public boolean getDrawers() {
		return Drawers;
	}
	
	/*
	* returns Cabinet
	*/
	public boolean getCabinet() {
		return Cabinet;
	}
	/*
	*Receives the String rails as an argument and if rails equals Y
	*Then, set the field Rails to true else set the field Rails to false
	*/

	public void setRails(String rails) {
		if(rails.equals("Y")) {
			this.Rails = true;
		}
		else {
			this.Rails = false;
		}
	}
	/*
	*Receives the String drawers as an argument and if drawers equals Y
	*Then, set the field Drawers to true else set the field Drawers to false
	*/

	public void setDrawers(String drawers) {
		if(drawers.equals("Y")) {
			this.Drawers = true;
		}
		else {
			this.Drawers = false;
		}
	}
	/*
	*Receives the String cabinet as an argument and if cabinet equals Y
	*Then, set the field Cabinet to true else set the field Cabinet to false
	*/

	public void setCabinet(String cabinet) {
		if(cabinet.equals("Y")) {
			this.Cabinet = true;
		}
		else {
			this.Cabinet = false;
		}
	}

}
