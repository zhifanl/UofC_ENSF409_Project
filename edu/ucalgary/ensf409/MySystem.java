package edu.ucalgary.ensf409;

/**
 * @author Tianfan Zhou, Zhifan Li, Manpreet Singh, Taimoor Abrar
 * @version 1.0
 * @since 1.0
 *
 */
public class MySystem{
	public  static void main(String[] args) {
//		
//		GUIApp app=new GUIApp();//create GUI
//
//		while(true) {
//			
//			if(app.getUsername()!=null&&app.getPassword()!=null) {
//				
//				System.out.println("Got username and password...");
//				break;
//				}
//			}
//		System.out.println(String.valueOf(app.getUsername()!=null)+String.valueOf(app.getPassword()!=null));
//		// wait GUI to get password and user name, then can use that later to connect the database.
//		
//		
//		SupplyChain obj=new SupplyChain(app.getUsername(),app.getPassword());
		SupplyChain obj=new SupplyChain("tianfan","Wenyan3524");

		obj.readInput(args[0],args[1]);//start executing the input order command.
	}
}
