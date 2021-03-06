package edu.ucalgary.ensf409;
/**
 * @author  Tianfan Zhou, Manpreet Singh
 * @version 1.0
 * @since 1.0
 *
 */

class Manufacturer {

	private String ManuID;
	private String Name;
	private String Phone;
	private String Province;
	/*
	 * Set the String value to ManuID
	 */
	public void setManuID(String manuID) {
		this.ManuID = manuID;
	}
	/*
	 * Set the String value to Name
	 */
	public void setName(String name) {
		this.Name = name;
	}

	/*
	 * Set the String value to Phone
	 */
	public void setPhone(String phone) {
		this.Phone = phone;
	}
	/*
	 * Set the String value to Province
	 */
	public void setProvince(String province) {
		this.Province = province;
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

