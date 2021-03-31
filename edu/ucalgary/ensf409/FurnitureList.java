package edu.ucalgary.ensf409;


import java.util.HashSet;
import java.util.LinkedList;

public class FurnitureList {
	private LinkedList <Furniture> furnitureList = new LinkedList<Furniture> ();
	private LinkedList <Combination> combinationList = new LinkedList <Combination> ();
	
	public LinkedList<String> findAllID () {
		LinkedList<String> result = new LinkedList<String> ();
		for(int i = 0; i < combinationList.size(); i++) {
			String temp1 = combinationList.get(i).getID1();
			String temp2 = combinationList.get(i).getID2();
			String temp3 = combinationList.get(i).getID3();
			String temp4 = combinationList.get(i).getID4();
			if(!result.contains(temp1) && temp1 != null) {
				result.add(temp1);
			}
			if(!result.contains(temp2) && temp2 != null) {
				result.add(temp2);
			}
			if(!result.contains(temp3) && temp3 != null) {
				result.add(temp3);
			}
			if(!result.contains(temp4) && temp4 != null) {
				result.add(temp4);
			}
		}
		return result;
		
	}
	


	public int findTotalPrice () {
		int totalPrice = 0;
		LinkedList<String> allID = this.findAllID();
		for (int i=0; i<allID.size(); i++) {
			for(int j=0; j<furnitureList.size(); j++) {
				if(furnitureList.get(j).getID().equals(allID.get(i))) {
					totalPrice += furnitureList.get(j).getPrice();
				}
			}
		}

		return totalPrice;
	}
	public void updateQuantity (Combination a){
		if(furnitureList!=null) {
			if(furnitureList.get(0) instanceof Chair) {
				LinkedList <Chair> chairList=new LinkedList<>();;
//				chairList = (LinkedList<Chair>) furnitureList.clone();
//				
				
				for(int i=0;i<furnitureList.size();i++) {
					chairList.add((Chair)furnitureList.get(i));
				}
				for(int i=0; i<chairList.size(); i++) {
					String id = chairList.get(i).getID();
					if(chairList.get(i).getArms() == true && (id.equals(a.getID1()) || id.equals(a.getID2())
							|| id.equals(a.getID3()) || id.equals(a.getID4()))){
						chairList.get(i).setArms("N");
						break;

					}
				}
				for(int i=0; i<chairList.size(); i++) {
					String id = chairList.get(i).getID();
					if(chairList.get(i).getCushion() == true && (id.equals(a.getID1()) || id.equals(a.getID2())
							|| id.equals(a.getID3()) || id.equals(a.getID4()))){
						chairList.get(i).setCushion("N");
						break;

					}
				}
				for(int i=0; i<chairList.size(); i++) {
					String id = chairList.get(i).getID();
					if(chairList.get(i).getSeat() == true && (id.equals(a.getID1()) || id.equals(a.getID2())
							|| id.equals(a.getID3()) || id.equals(a.getID4()))){
						chairList.get(i).setSeat("N");
						break;

					}
				}
				for(int i=0; i<chairList.size(); i++) {
					String id = chairList.get(i).getID();
					if(chairList.get(i).getLegs() == true && (id.equals(a.getID1()) || id.equals(a.getID2())
							|| id.equals(a.getID3()) || id.equals(a.getID4()))){
						chairList.get(i).setLegs("N");
						break;

					}
				}
				this.furnitureList = new LinkedList<Furniture> (chairList);
			}
		
		
		else if(furnitureList.get(0) instanceof Desk) {
			LinkedList <Desk> deskList=new LinkedList<>();
			deskList = (LinkedList<Desk>) furnitureList.clone();
			for(int i=0; i<deskList.size(); i++) {
				String id = deskList.get(i).getID();
				if(deskList.get(i).getDrawer() == true && (id.equals(a.getID1()) || id.equals(a.getID2())
						|| id.equals(a.getID3()) || id.equals(a.getID4()))){
					deskList.get(i).setDrawer("N");
					break;
				}
			}
			for(int i=0; i<deskList.size(); i++) {
				String id = deskList.get(i).getID();
				if(deskList.get(i).getLegs() == true && (id.equals(a.getID1()) || id.equals(a.getID2())
						|| id.equals(a.getID3()) || id.equals(a.getID4()))){
					deskList.get(i).setLegs("N");
					break;

				}
			}
			for(int i=0; i<deskList.size(); i++) {
				String id = deskList.get(i).getID();
				if(deskList.get(i).getTop() == true && (id.equals(a.getID1()) || id.equals(a.getID2())
						|| id.equals(a.getID3()) || id.equals(a.getID4()))){
					deskList.get(i).setTop("N");
					break;

				}
			}
			this.furnitureList = new LinkedList<Furniture> (deskList);
		}
		
		else if(furnitureList.get(0) instanceof Filing) {
			LinkedList <Filing> filingList=new LinkedList<>();
			filingList = (LinkedList<Filing>) furnitureList.clone();
			for(int i=0; i<filingList.size(); i++) {
				String id = filingList.get(i).getID();
				if(filingList.get(i).getCabinet() == true && (id.equals(a.getID1()) || id.equals(a.getID2())
						|| id.equals(a.getID3()) || id.equals(a.getID4()))){
					filingList.get(i).setCabinet("N");
					break;

					
				}
			}
			for(int i=0; i<filingList.size(); i++) {
				String id = filingList.get(i).getID();
				if(filingList.get(i).getDrawers() == true && (id.equals(a.getID1()) || id.equals(a.getID2())
						|| id.equals(a.getID3()) || id.equals(a.getID4()))){
					filingList.get(i).setDrawers("N");
					break;

				}
			}
			for(int i=0; i<filingList.size(); i++) {
				String id = filingList.get(i).getID();
				if(filingList.get(i).getRails() == true && (id.equals(a.getID1()) || id.equals(a.getID2())
						|| id.equals(a.getID3()) || id.equals(a.getID4()))){
					filingList.get(i).setRails("N");
					break;

				}
			}
			this.furnitureList = new LinkedList<Furniture> (filingList);
		}
	
	
	
	else{
		LinkedList <Lamp> lampList=new LinkedList<>();
		lampList = (LinkedList<Lamp>) furnitureList.clone();
		for(int i=0; i<lampList.size(); i++) {
			String id = lampList.get(i).getID();
			if(lampList.get(i).getBase() == true && (id.equals(a.getID1()) || id.equals(a.getID2())
					|| id.equals(a.getID3()) || id.equals(a.getID4()))){
				lampList.get(i).setBase("N");
				break;

			}
		}
		for(int i=0; i<lampList.size(); i++) {
			String id = lampList.get(i).getID();
			if(lampList.get(i).getBulb() == true && (id.equals(a.getID1()) || id.equals(a.getID2())
					|| id.equals(a.getID3()) || id.equals(a.getID4()))){
				lampList.get(i).setBulb("N");
				break;

			}
		}
		this.furnitureList = new LinkedList<Furniture> (lampList);
	}
	}
}

	public LinkedList<Furniture> getFurnitureList() {
		return furnitureList;
	}

	public void setFurnitureList(LinkedList<Furniture> furnitureList) {
		this.furnitureList = furnitureList;
	}

	public LinkedList<Combination> getCombinationList() {
		return combinationList;
	}

	public void setCombinationList(LinkedList<Combination> combinationList) {
		this.combinationList = combinationList;
	}
	
	public void addToCombinationList(Combination a) {
		this.combinationList.add(a);
	}
	



}
