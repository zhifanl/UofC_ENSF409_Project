package edu.ucalgary.ensf409;


import java.util.Hashtable;
import java.util.LinkedList;

/**
 * @author Zhifan Li, Tianfan Zhou
 * @version 1.0
 * @since 1.0
 *
 */

/**
 * Class Algorithm
 * @author Zhifan Li
 *
 */
public class Algorithm {
	private LinkedList<Furniture>list=new LinkedList<>(); //private field for storing the searched list
	private int requiredTimes=0;//required number of order
	private String classType;//required type of order
	private LinkedList<Furniture[]>results=new LinkedList<>();//results is a linked list that stored all the combination of furnitures that can satisfy the required number of order with type and category.

	/**
	 * @param list the searched list
	 * @param requiredTimes required number of order
	 * @param classType required type of order
	 * @return best combination of furnitures and its price is in the 2-D array of String
	 * First if requiredTimes is <=0, throw an exception and quit.
	 * then getting these values to private fields of this class object.
	 * Call DFS to get all the potential complete order into the list "results"
	 * if cannot find any, return null
	 * otherwise call findBestPrice, and it will find best price among these complete orders
	 * and return a String[][] back for further use.
	 */
	@SuppressWarnings("unchecked")
	public String[][] findCheapestSet(LinkedList<Furniture> list,int requiredTimes, String classType) {
		if(requiredTimes<=0) {
			throw new IllegalArgumentException("The number you ordered is less than or equals to zero...");
		}
		this.list=(LinkedList<Furniture>)list.clone();
		this.requiredTimes=requiredTimes;
		this.classType=classType;
		DFS(this.list);
		if(results.size()==0) {
			return null;
		}
		return findBestPrice();
	}
	

	/**
	 * In the results, find the index where the furniture array has least price among all the potential complete orders.
	 * store the array of these cheapest and completed furniture's ID in bestIDsPrice[0], and store the price of them in bestIDsPrice[1] as String.
	 * @return best combination (with least price) of furnitures and its price is in the 2-D array of String.
	 */
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

	/**
	 * Depth first search algorithm
	 * Base case: If the list size is 0, return
	 * else, call isMatch to see if the current list matches the expected number of required items, 
	 * if greater or equals to requiredTimes, it is true.
	 * if true, get these furniture from the list into an array of furniture, 
	 * and add this array of furniture into results for further comparision.
	 * then, there is a for loop, from 0 to its size-1, remove the element of list at that index first, and call DFS recursively, 
	 * if the DFS size==0, or isMatch is false, return back and add that element back to the list.
	 * and index++, it tries with the next index, and remove and DFS and add back once it returns from DFS.
	 * This is depth first algorithm, and it will get all the potential furniture array that can fulfill the required order.
	 * After that, results have all the completed order with different number of furniture inside, and we can find the expected one from them.
	 * @param list list the searched list, private field member
	 */
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
	/**
	 * @param list list the searched list, private field member
	 * @param time required number of order
	 * @return boolean
	 * receives a list and integer, and create a Hashtable for counting the number of Y in each component depends on its category.
	 * Hashtable have keys as 1,2,3,4 represents the component for the furnitures.
	 * And Hashtable's value is number of Y in each key. For further use.
	 * Category: Desk, 3 components to be counted
	 * Category Filing: 3 components to be counted
	 * Category Lamp: 2 components to be counted
	 * Category Chair: 4 components to be counted
	 * Each category will have a for loop to go through each furniture of that category and count the number of Y in that component.
	 * After that, if each key in Hashtable's value is greater or equal to the required time for the order, it will return true
	 * else it will return false.
	 */
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
		//if class in the list is Desk
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
		//if class in the list is Filing
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
		//if class in the list is Lamp
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
		//if class in the list is Chair
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
		//default return false.
		return false;
	}
}

