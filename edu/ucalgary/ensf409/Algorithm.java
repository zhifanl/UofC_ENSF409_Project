package edu.ucalgary.ensf409;


import java.util.Hashtable;
import java.util.LinkedList;

public class Algorithm {
	private LinkedList<Furniture>list=new LinkedList<>();
	private int requiredTimes=0;
	private String classType;
	private LinkedList<Furniture[]>results=new LinkedList<>();

	@SuppressWarnings("unchecked")
	public String[][] findCheapestSet(LinkedList<Furniture> list,int requiredTimes, String classType) {
		this.list=(LinkedList<Furniture>)list.clone();
		this.requiredTimes=requiredTimes;
		this.classType=classType;
		DFS(this.list);
		if(results.size()==0) {
			return null;
		}
		return findBestPrice();
	}

	public String[][] findBestPrice() {
		int bestPrice=Integer.MAX_VALUE;
		String[][]bestIDsPrice=null;
		int bestIndex=0;

		for(int i=0;i<results.size();i++) {
			int currentPrice=0;
			for(int j=0;j<results.get(i).length;j++) {
				currentPrice+=results.get(i)[j].getPrice();
			}
			if(currentPrice<bestPrice) {
				bestPrice=currentPrice;
				bestIndex=i;
			}
		}
		bestIDsPrice=new String[2][];
		bestIDsPrice[0]=new String[results.get(bestIndex).length];
		for(int i=0;i<results.get(bestIndex).length;i++) {
			bestIDsPrice[0][i]=results.get(bestIndex)[i].getID();
		}
		bestIDsPrice[1]=new String[1];
		bestIDsPrice[1][0]=String.valueOf(bestPrice);
		return bestIDsPrice;
	}

	public void DFS(LinkedList<Furniture>list) {
		if(list.size()==0) {
			return;
		}else if(isMatch(list,requiredTimes)) {
			Furniture[]temp=new Furniture[list.size()];
			for(int i=0;i<list.size();i++) {
				temp[i]=list.get(i);
			}
			results.add(temp);
			for(int i=0;i<list.size();i++) {
				Furniture e=list.remove(i);
				DFS(list);
				list.add(i,e);
			}
		}
	}
	public boolean isMatch(LinkedList<Furniture> list,int time) {
		Hashtable<Integer,Integer>map=new Hashtable<>();
		map.put(1, 0);
		int i=0;
		map.put(2, 0);
		int j=0;
		map.put(3, 0);
		int k=0;
		map.put(4, 0);
		int m=0;
		if(classType.equals("DESK")) {
			@SuppressWarnings("unchecked")
			LinkedList<Desk>temp=(LinkedList<Desk>)list.clone();
			for(int n=0;n<list.size();n++) {
				if(temp.get(n).getLegs()) {
					map.put(1, ++i);
				}
				if(temp.get(n).getTop()) {
					map.put(2, ++j);
				}
				if(temp.get(n).getDrawer()) {
					map.put(3, ++k);
				}
			}
			if(map.get(1)>=requiredTimes&&map.get(2)>=requiredTimes&&map.get(3)>=requiredTimes) {
				return true;
			}else {
				return false;
			}
		}
		if(classType.equals("FILING")) {
			@SuppressWarnings("unchecked")
			LinkedList<Filing>temp=(LinkedList<Filing>)list.clone();
			for(int n=0;n<list.size();n++) {
				if(temp.get(n).getRails()) {
					map.put(1, ++i);
				}
				if(temp.get(n).getDrawers()) {
					map.put(2, ++j);
				}
				if(temp.get(n).getCabinet()) {
					map.put(3, ++k);
				}
			}
			if(map.get(1)>=requiredTimes&&map.get(2)>=requiredTimes&&map.get(3)>=requiredTimes) {
				return true;
			}else {
				return false;
			}
		}
		if(classType.equals("LAMP")) {
			@SuppressWarnings("unchecked")
			LinkedList<Lamp>temp=(LinkedList<Lamp>)list.clone();
			for(int n=0;n<list.size();n++) {
				if(temp.get(n).getBase()) {
					map.put(1, ++i);
				}
				if(temp.get(n).getBulb()) {
					map.put(2, ++j);
				}
			}
			if(map.get(1)>=requiredTimes&&map.get(2)>=requiredTimes) {
				return true;
			}else {
				return false;
			}
		}
		if(classType.equals("CHAIR")) {
			@SuppressWarnings("unchecked")
			LinkedList<Chair>temp=(LinkedList<Chair>)list.clone();
			for(int n=0;n<list.size();n++) {
				if(temp.get(n).getLegs()) {
					map.put(1, ++i);
				}
				if(temp.get(n).getArms()) {
					map.put(2, ++j);
				}
				if(temp.get(n).getSeat()) {
					map.put(3, ++k);
				}
				if(temp.get(n).getCushion()) {
					map.put(4, ++m);
				}
			}
			if(map.get(1)>=requiredTimes&&map.get(2)>=requiredTimes&&map.get(3)>=requiredTimes&&map.get(4)>=requiredTimes) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
}

