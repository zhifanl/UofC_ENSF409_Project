package edu.ucalgary.ensf409;


class Manufacturer {

    private String ManuID;
    private String Name;
    private String Phone;
    private String Province;
    /*
    * Set the String value to ManuID
    */
    public void setManuID(String manuID) {
		ManuID = manuID;
	}
    /*
    * Set the String value to Name
    */
	public void setName(String name) {
		Name = name;
	}

    /*
    * Set the String value to Phone
    */
	public void setPhone(String phone) {
		Phone = phone;
	}
    /*
    * Set the String value to Province
    */
	public void setProvince(String province) {
		Province = province;
	}
    /*
    * returns ManuID
    */
	public String getManuID() {
        return ManuID;
    }
    /*
    * returns Name
    */
    public String getName() {
        return Name;
    }
    /*
    * returns Phone
    */
    public String getPhone() {
        return Phone;
    }
    /*
    * returns Province
    */
    public String getProvince() {
        return Province;
    }

}

