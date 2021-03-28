package edu.ucalgary.ensf409;

import java.util.LinkedList;

public class Algorithm {
	public Combination findCheapestSet(LinkedList<Chair> list) {
		Combination result = null;
		for(int i=0; i<list.size(); i++) {
			if(isMatch(list.get(i)) && result != null) {
				if(result.getPrice() > list.get(i).getPrice()) {
					result = new Combination(list.get(i).getID(), list.get(i).getPrice());
				}
			}
			else if (isMatch(list.get(i)) && result == null){
				result = new Combination(list.get(i).getID(), list.get(i).getPrice());
			}
		}
		
		for(int i=0; i<list.size();i++) {
			for(int j=i+1; j<list.size(); j++) {
				if(isMatch(list.get(i),list.get(j)) && result != null) {
					if(result.getPrice() > list.get(i).getPrice() + list.get(j).getPrice()) {
						result = new Combination(list.get(i).getID(),list.get(j).getID(), list.get(i).getPrice() + list.get(j).getPrice());
					}
				}
				else if (isMatch(list.get(i)) && result == null){
					result = new Combination(list.get(i).getID(),list.get(j).getID(), list.get(i).getPrice() + list.get(j).getPrice());
				}
			}
		}
		
		for(int i=0; i<list.size();i++) {
			for(int j=i+1; j<list.size(); j++) {
				for(int k=j+1; k<list.size(); k++) {
					if(isMatch(list.get(i),list.get(j),list.get(k)) && result != null) {
						if(result.getPrice() > list.get(i).getPrice() + list.get(j).getPrice() + list.get(k).getPrice()) {
							result = new Combination(list.get(i).getID(),list.get(j).getID(),list.get(k).getID(), list.get(i).getPrice() + list.get(j).getPrice() +list.get(k).getPrice());
						}
					}
					else if (isMatch(list.get(i)) && result == null){
						result = new Combination(list.get(i).getID(),list.get(j).getID(), list.get(k).getID(), list.get(i).getPrice() + list.get(j).getPrice() + list.get(k).getPrice());
					}
				}
			}
		}
		
		for(int i=0; i<list.size();i++) {
			for(int j=i+1; j<list.size(); j++) {
				for(int k=j+1; k<list.size(); k++) {
					for(int m=k+1; m<list.size();m++) {
						if(isMatch(list.get(i),list.get(j),list.get(k), list.get(m)) && result != null) {
							if(result.getPrice() > list.get(i).getPrice() + list.get(j).getPrice() + list.get(k).getPrice() +list.get(m).getPrice()) {
								result = new Combination(list.get(i).getID(),list.get(j).getID(),list.get(k).getID(), list.get(m).getID(), list.get(i).getPrice() + list.get(j).getPrice() +list.get(k).getPrice() + list.get(m).getPrice());
							}
						}
						else if (isMatch(list.get(i)) && result == null){
							result = new Combination(list.get(i).getID(),list.get(j).getID(),list.get(k).getID(), list.get(m).getID(), list.get(i).getPrice() + list.get(j).getPrice() +list.get(k).getPrice() + list.get(m).getPrice());
						}
					}
				}
			}
		}
		
		return result;
	}
	
	private boolean isMatch(Chair chair1) {
		if(chair1.getArms().equals("Y") && chair1.getLegs().equals("Y") && chair1.getSeat().equals("Y") && chair1.getCushion().equals("Y")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean isMatch(Chair chair1,Chair chair2) {
		if((chair1.getArms().equals("Y") || chair2.getArms().equals("Y"))
			&& (chair1.getLegs().equals("Y") || chair2.getLegs().equals("Y"))
			&& (chair1.getSeat().equals("Y") || chair2.getSeat().equals("Y"))
			&& (chair1.getCushion().equals("Y") || chair2.getCushion().equals("Y"))) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean isMatch(Chair chair1,Chair chair2,Chair chair3) {
		if((chair1.getArms().equals("Y") || chair2.getArms().equals("Y") || chair3.getArms().equals("Y"))
			&& (chair1.getLegs().equals("Y") || chair2.getLegs().equals("Y") || chair3.getLegs().equals("Y"))
			&& (chair1.getSeat().equals("Y") || chair2.getSeat().equals("Y") || chair3.getSeat().equals("Y"))
			&& (chair1.getCushion().equals("Y") || chair2.getCushion().equals("Y") || chair3.getCushion().equals("Y"))) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean isMatch(Chair chair1,Chair chair2,Chair chair3, Chair chair4) {
		if((chair1.getArms().equals("Y") || chair2.getArms().equals("Y") || chair3.getArms().equals("Y") ||chair4.getArms().equals("Y"))
			&& (chair1.getLegs().equals("Y") || chair2.getLegs().equals("Y") || chair3.getLegs().equals("Y") || chair4.getLegs().equals("Y"))
			&& (chair1.getSeat().equals("Y") || chair2.getSeat().equals("Y") || chair3.getSeat().equals("Y") || chair4.getSeat().equals("Y")) 
			&& (chair1.getCushion().equals("Y") || chair2.getCushion().equals("Y") || chair3.getCushion().equals("Y") || chair4.getCushion().equals("Y"))) {
			return true;
		}
		else {
			return false;
		}
	}
}
