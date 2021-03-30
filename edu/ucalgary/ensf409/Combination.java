package edu.ucalgary.ensf409;


public class Combination {
	String ID1 = null;
	String ID2 = null;
	String ID3 = null;
	String ID4 = null;
	int price;
	
	public Combination() {
		
	}
	
	public Combination (String id1, int price) {
		ID1 = id1;
		this.price = price;
	}
	public Combination (String id1,String id2, int price) {
		ID1 = id1;
		ID2 = id2;
		this.price = price;
	}
	public Combination (String id1, String id2, String id3, int price) {
		ID1 = id1;
		ID2 = id2;
		ID3 = id3;
		this.price = price;
	}
	public Combination (String id1, String id2, String id3, String id4, int price) {
		ID1 = id1;
		ID2 = id2;
		ID3 = id3;
		ID4 = id4;
		this.price = price;
	}
	public String getID1() {
		return ID1;
	}
	public void setID1(String iD1) {
		ID1 = iD1;
	}
	public String getID2() {
		return ID2;
	}
	public void setID2(String iD2) {
		ID2 = iD2;
	}
	public String getID3() {
		return ID3;
	}
	public void setID3(String iD3) {
		ID3 = iD3;
	}
	public String getID4() {
		return ID4;
	}
	public void setID4(String iD4) {
		ID4 = iD4;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
