package edu.ucalgary.ensf409;


import java.util.LinkedList;

public class Algorithm {

	private Combination loop2Times (LinkedList<Furniture> list) {
		Combination result = null;
		for(int i=0; i<list.size(); i++) {
			Furniture tem1 = list.get(i);
			if(isMatch(tem1) && result != null) {
				if(result.getPrice() > tem1.getPrice()) {
					result = new Combination(tem1.getID(), tem1.getPrice());
				}
			}
			else if (isMatch(tem1) && result == null){
				result = new Combination(tem1.getID(), tem1.getPrice());
			}
		}
		
		for(int i=0; i<list.size();i++) {
			for(int j=i+1; j<list.size(); j++) {
				Furniture tem1 = list.get(i);
				Furniture tem2 = list.get(j);
				int totalPrice = tem1.getPrice() + tem2.getPrice();
				if(isMatch(tem1,tem2) && result != null) {
					if(result.getPrice() > totalPrice) {
						result = new Combination(tem1.getID(),tem2.getID(), totalPrice);
					}
				}
				else if (isMatch(tem1,tem2) && result == null){
					result = new Combination(tem1.getID(),tem2.getID(), totalPrice);
				}
			}
		}
		return result;
	}
	
	private Combination loop3Times (LinkedList<Furniture> list) {
		Combination result = null;
		for(int i=0; i<list.size(); i++) {
			Furniture tem1 = list.get(i);
			if(isMatch(tem1) && result != null) {
				if(result.getPrice() > tem1.getPrice()) {
					result = new Combination(tem1.getID(), tem1.getPrice());
				}
			}
			else if (isMatch(tem1) && result == null){
				result = new Combination(tem1.getID(), tem1.getPrice());
			}
		}
		
		for(int i=0; i<list.size();i++) {
			for(int j=i+1; j<list.size(); j++) {
				Furniture tem1 = list.get(i);
				Furniture tem2 = list.get(j);
				int totalPrice = tem1.getPrice() + tem2.getPrice();
				if(isMatch(tem1,tem2) && result != null) {
					if(result.getPrice() > totalPrice) {
						result = new Combination(tem1.getID(),tem2.getID(), totalPrice);
					}
				}
				else if (isMatch(tem1,tem2) && result == null){
					result = new Combination(tem1.getID(),tem2.getID(), totalPrice);
				}
			}
		}
		
		for(int i=0; i<list.size();i++) {
			for(int j=i+1; j<list.size(); j++) {
				for(int k=j+1; k<list.size(); k++) {
					Furniture tem1 = list.get(i);
					Furniture tem2 = list.get(j);
					Furniture tem3 = list.get(k);
					int totalPrice = tem1.getPrice() + tem2.getPrice() + tem3.getPrice();
					if(isMatch(tem1,tem2,tem3) && result != null) {
						if(result.getPrice() > totalPrice) {
							result = new Combination(tem1.getID(),tem2.getID(),tem3.getID(), totalPrice);
						}
					}
					else if (isMatch(tem1,tem2,tem3) && result == null){
						result = new Combination(tem1.getID(),tem2.getID(), tem3.getID(), totalPrice);
					}
				}
			}
		}
		return result;
	}
	
	private Combination loop4Times (LinkedList<Furniture> list) {
		Combination result = null;
		for(int i=0; i<list.size(); i++) {
			Furniture tem1 = list.get(i);
			if(isMatch(tem1) && result != null) {
				if(result.getPrice() > tem1.getPrice()) {
					result = new Combination(tem1.getID(), tem1.getPrice());
				}
			}
			else if (isMatch(tem1) && result == null){
				result = new Combination(tem1.getID(), tem1.getPrice());
			}
		}
		
		for(int i=0; i<list.size();i++) {
			for(int j=i+1; j<list.size(); j++) {
				Furniture tem1 = list.get(i);
				Furniture tem2 = list.get(j);
				int totalPrice = tem1.getPrice() + tem2.getPrice();
				if(isMatch(tem1,tem2) && result != null) {
					if(result.getPrice() > totalPrice) {
						result = new Combination(tem1.getID(),tem2.getID(), totalPrice);
					}
				}
				else if (isMatch(tem1,tem2) && result == null){
					result = new Combination(tem1.getID(),tem2.getID(), totalPrice);
				}
			}
		}
		
		for(int i=0; i<list.size();i++) {
			for(int j=i+1; j<list.size(); j++) {
				for(int k=j+1; k<list.size(); k++) {
					Furniture tem1 = list.get(i);
					Furniture tem2 = list.get(j);
					Furniture tem3 = list.get(k);
					int totalPrice = tem1.getPrice() + tem2.getPrice() + tem3.getPrice();
					if(isMatch(tem1,tem2,tem3) && result != null) {
						if(result.getPrice() > totalPrice) {
							result = new Combination(tem1.getID(),tem2.getID(),tem3.getID(), totalPrice);
						}
					}
					else if (isMatch(tem1,tem2,tem3) && result == null){
						result = new Combination(tem1.getID(),tem2.getID(), tem3.getID(), totalPrice);
					}
				}
			}
		}
		
		for(int i=0; i<list.size();i++) {
			for(int j=i+1; j<list.size(); j++) {
				for(int k=j+1; k<list.size(); k++) {
					for(int m=k+1; m<list.size();m++) {
						Furniture tem1 = list.get(i);
						Furniture tem2 = list.get(j);
						Furniture tem3 = list.get(k);
						Furniture tem4 = list.get(m);
						int totalPrice = tem1.getPrice() + tem2.getPrice() + tem3.getPrice() +tem4.getPrice();
						if(isMatch(tem1,tem2,tem3,tem4) && result != null) {
							if(result.getPrice() > totalPrice) {
								result = new Combination(tem1.getID(),tem2.getID(),tem3.getID(), tem4.getID(), totalPrice);
							}
						}
						else if (isMatch(tem1,tem2,tem3,tem4) && result == null){
							result = new Combination(tem1.getID(),tem2.getID(),tem3.getID(), tem4.getID(), totalPrice);
						}
					}
				}
			}
		}
		return result;
	}
	
	public Combination findCheapestSet(LinkedList<Furniture> list) {
		Combination result = null;
		if(list.size()!=0) {
			if(list.get(0) instanceof Lamp) {
				result = loop2Times(list);
			}
			else if((list.get(0) instanceof Desk || list.get(0) instanceof Filing)) {
				result = loop3Times(list);
			}
			else if (list.get(0) instanceof Chair) {
				result = loop4Times(list);
			}
		}
		return result;
	}
	
	//method for list of Chair
	private boolean isMatch (Chair chair1) {
		if(chair1.getArms() && chair1.getLegs() && chair1.getCushion() && chair1.getSeat()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean isMatch(Chair chair1,Chair chair2) {
		if((chair1.getArms() || chair2.getArms())
			&& (chair1.getLegs() || chair2.getLegs())
			&& (chair1.getSeat() || chair2.getSeat())
			&& (chair1.getCushion() || chair2.getCushion())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean isMatch(Chair chair1,Chair chair2,Chair chair3) {
		if((chair1.getArms() || chair2.getArms() || chair3.getArms())
			&& (chair1.getLegs() || chair2.getLegs() || chair3.getLegs())
			&& (chair1.getSeat() || chair2.getSeat() || chair3.getSeat())
			&& (chair1.getCushion() || chair2.getCushion() || chair3.getCushion())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean isMatch(Chair chair1,Chair chair2,Chair chair3, Chair chair4) {
		if((chair1.getArms() || chair2.getArms() || chair3.getArms() ||chair4.getArms())
			&& (chair1.getLegs() || chair2.getLegs() || chair3.getLegs() || chair4.getLegs())
			&& (chair1.getSeat() || chair2.getSeat() || chair3.getSeat() || chair4.getSeat()) 
			&& (chair1.getCushion() || chair2.getCushion() || chair3.getCushion() || chair4.getCushion())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//method for list of Filing
		private boolean isMatch (Filing filing1) {
			if(filing1.getCabinet() && filing1.getDrawers() && filing1.getRails()) {
				return true;
			}
			else {
				return false;
			}
		}
		
		private boolean isMatch(Filing filing1, Filing filing2) {
			if((filing1.getCabinet() || filing2.getCabinet())
				&& (filing1.getDrawers() || filing2.getDrawers())
				&& (filing1.getRails() || filing2.getRails())) {
				return true;
			}
			else {
				return false;
			}
		}
		
		private boolean isMatch(Filing filing1, Filing filing2, Filing filing3) {
			if((filing1.getCabinet() || filing2.getCabinet() || filing3.getCabinet())
					&& (filing1.getDrawers() || filing2.getDrawers() || filing3.getDrawers())
					&& (filing1.getRails() || filing2.getRails()) || filing3.getRails()) {
					return true;
			}
			else {
				return false;
			}
		}
		
		//method for list of Desk	
				private boolean isMatch (Desk desk1) {
					if(desk1.getDrawer() && desk1.getLegs() && desk1.getTop()) {
						return true;
					}
					else {
						return false;
					}
				}
				
				private boolean isMatch(Desk desk1,Desk desk2) {
					if((desk1.getDrawer() || desk2.getDrawer())
						&& (desk1.getLegs() || desk2.getLegs())
						&& (desk1.getTop() || desk2.getTop())) {
						return true;
					}
					else {
						return false;
					}
				}
				
				private boolean isMatch(Desk desk1, Desk desk2, Desk desk3) {
					if((desk1.getDrawer() || desk2.getDrawer() || desk3.getDrawer())
							&& (desk1.getLegs() || desk2.getLegs() || desk3.getLegs())
							&& (desk1.getTop() || desk2.getTop() || desk3.getTop())) { 
						return true;
					}
					else {
						return false;
					}
				}

				//method for list of Lamp	
				private boolean isMatch (Lamp lamp1) {
					if(lamp1.getBase() && lamp1.getBulb()) {
						return true;
					}
					else {
						return false;
					}
				}
				
				private boolean isMatch(Lamp lamp1, Lamp lamp2) {
					if((lamp1.getBase() || lamp2.getBase())
						&& (lamp1.getBulb() || lamp2.getBulb())) {
						return true;
					}
					else {
						return false;
					}
				}
				
			//method for list of Furniture
				
			private boolean isMatch(Furniture f1) {
				if(f1 instanceof Chair) {
					Chair temp = (Chair)f1;
					return isMatch(temp);
				}
				else if(f1 instanceof Desk) {
					Desk temp = (Desk)f1;
					return isMatch(temp);
				}
				else if(f1 instanceof Filing) {
					Filing temp = (Filing)f1;
					return isMatch(temp);
				}
				else{
					Lamp temp = (Lamp)f1;
					return isMatch(temp);
				}
			}
			
			private boolean isMatch(Furniture f1, Furniture f2) {
				if(f1 instanceof Chair) {
					Chair temp1 = (Chair)f1;
					Chair temp2 = (Chair)f2;
					return isMatch(temp1,temp2);
				}
				else if(f1 instanceof Desk) {
					Desk temp1 = (Desk)f1;
					Desk temp2 = (Desk)f2;
					return isMatch(temp1, temp2);
				}
				else if(f1 instanceof Filing) {
					Filing temp1 = (Filing)f1;
					Filing temp2 = (Filing)f2;
					return isMatch(temp1,temp2);
				}
				else{
					Lamp temp1 = (Lamp)f1;
					Lamp temp2 = (Lamp)f2;
					return isMatch(temp1, temp2);
				}
			}
			
			private boolean isMatch(Furniture f1, Furniture f2,Furniture f3) {
				if(f1 instanceof Chair) {
					Chair temp1 = (Chair)f1;
					Chair temp2 = (Chair)f2;
					Chair temp3 = (Chair)f3;
					return isMatch(temp1,temp2,temp3);
				}
				else if(f1 instanceof Desk) {
					Desk temp1 = (Desk)f1;
					Desk temp2 = (Desk)f2;
					Desk temp3 = (Desk)f3;
					return isMatch(temp1, temp2,temp3);
				}
				else{
					Filing temp1 = (Filing)f1;
					Filing temp2 = (Filing)f2;
					Filing temp3 = (Filing)f3;
					return isMatch(temp1,temp2,temp3);
				}
			}
			
			private boolean isMatch(Furniture f1, Furniture f2,Furniture f3,Furniture f4) {
					Chair temp1 = (Chair)f1;
					Chair temp2 = (Chair)f2;
					Chair temp3 = (Chair)f3;
					Chair temp4 = (Chair)f4;
					return isMatch(temp1,temp2,temp3,temp4);

			}
}
