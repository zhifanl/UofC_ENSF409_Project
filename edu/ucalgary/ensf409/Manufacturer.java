package edu.ucalgary.ensf409;

class Manufacturer {

    private String ManuID;
    private String Name;
    private String Phone;
    private String Province;

    public void setManuID(String manuID) {
		ManuID = manuID;
	}

	public void setName(String name) {
		Name = name;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public void setProvince(String province) {
		Province = province;
	}

	public String getManuID() {
        return ManuID;
    }

    public String getName() {
        return Name;
    }

    public String getPhone() {
        return Phone;
    }

    public String getProvince() {
        return Province;
    }

}

