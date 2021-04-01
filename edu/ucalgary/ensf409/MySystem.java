package edu.ucalgary.ensf409;


public class MySystem {
public  static void main(String[] args) {
	GUIApp app=new GUIApp();
	while(true) {
		if(app.getUsername()!=null&&app.getPassword()!=null) {
			break;
		}
	}
	SupplyChain obj=new SupplyChain(app.getUsername(),app.getPassword());
	
	obj.readInput(args[0],args[1]);
}
}
