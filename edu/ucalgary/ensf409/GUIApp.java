package edu.ucalgary.ensf409;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;
/**
 * This class creates GUI for user sign-in to the database they want and handles its functionality.
 * @author  Taimoor Abrar, Manpreet Singh 
 * @version 1.0
 * @since 1.0
 *
 */
public class GUIApp extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * JLabels usernameLabel, passwordLabel, message
	 */
	private JLabel usernameLabel, passwordLabel, message,requestLabel;

	/**
	 * Text field to get user name
	 */
	private JTextField usernameText, requestText;

	/**
	 * Text field to get password
	 */
	private JPasswordField passwordText;

	/**
	 * JButton submit
	 */
	private JButton submit;


	/**
	 * username as a String
	 */
	private String username;

	/**
	 * password as a String
	 */
	private String password;
	
	/*
	 * request order input as a String
	 */
	private String inputRequest;

	/**
	 * @return inputRequest
	 */
	public String getInputRequest() {
		return inputRequest;
	}

	/**
	 * @param inputRequest
	 */
	public void setInputRequest(String inputRequest) {
		this.inputRequest = inputRequest;
	}

	/**
	 * GotUsernameAndPassword=1 if user click the submit button, and this will tell main thread to move forward to execute.
	 */
	 static int GotUsernameAndPassword=0;

	/**
	 * @return username
	 */
	 public String getUsername() {
		return username;
	}

	/**
	 * @param username username that GUI gets
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return password 
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password set the password
	 */
	public void setPassword(String password) {
		this.password = password;
	}



	/**
	 * Constructor of GUIApp ( used for the start of the program, pop the winodw and wait for user input.
	 * @param No parameter
	 */
	public GUIApp() {

		message = new JLabel("Please enter your username and password");

		usernameLabel = new JLabel("User Name:");

		passwordLabel = new JLabel("Password:");

		usernameText = new JTextField(15);

		passwordText = new JPasswordField(15);
		
		requestText  =  new  JTextField(20);
		
	    requestLabel = new JLabel("User request: ");
	    
	    

		submit = new JButton("SUBMIT");

		JPanel headerPanel=new JPanel();
		headerPanel.setLayout(new FlowLayout());
		JPanel clientPanel=new JPanel();
		clientPanel.setLayout(new FlowLayout());
		JPanel submitPanel=new JPanel();
		submitPanel.setLayout(new FlowLayout());

		headerPanel.add(message);

		clientPanel.add(usernameLabel);
		clientPanel.add(usernameText);
		clientPanel.add(passwordLabel);
		clientPanel.add(passwordText);
		clientPanel.add(requestLabel);
		clientPanel.add(requestText);

		submitPanel.add(submit);

		this.add(headerPanel,BorderLayout.NORTH);
		this.add(clientPanel,BorderLayout.CENTER);
		this.add(submitPanel,BorderLayout.PAGE_END);


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Please Login and Order Here!");

		setSize(300,300);

		submit.addActionListener((ActionEvent e) ->{
			String username = usernameText.getText();
			char[] password = passwordText.getPassword();
			String request=requestText.getText();
			usernameText.setText("");
			passwordText.setText("");
			requestText.setText("");
			String passwordString = new String(password);
			this.username=username;
			this.password=passwordString;
			this.inputRequest=request;
			System.out.println("password you typed: "+passwordString);
			GotUsernameAndPassword=1; // set the GotUsernameAndPassword=1, this can be checked in main that if the GUIApp has completed task for submitting user name and password

		});
		setVisible(true);
	}

	/**
	 * Constructor of GUIApp for pop a window for output.
	 * @param output 
	 */
	public GUIApp(String output) {
		JFrame frame=new JFrame("Output information"); 
		JPanel jp=new JPanel();    
		JTextField outputObj=new JTextField(output);
		jp.add(outputObj);
		frame.add(jp);
		frame.setSize(600,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocation(400, 125);
	}
}