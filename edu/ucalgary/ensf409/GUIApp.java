package edu.ucalgary.ensf409;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;
/**
 * This class creates GUI for user sign-in to the database they want and handles its functionality.
 * @author  Taimoor Abrar, Manpreet Singh 
 *
 */
public class GUIApp extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * JPanel
	 */
	private JPanel panel;
	/**
	 * JLabels usernameLabel, passwordLabel, message
	 */
	private JLabel usernameLabel, passwordLabel, message;
	/**
	 * Text field to get user name
	 */
	private JTextField usernameText;
	/**
	 * Text field to get password
	 */
	private JPasswordField passwordText;
	/**
	 * JButton submit
	 */
	private JButton submit;
	/**
	 * object of GUIAppClient
	 */
	private String username;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String password;
	
	/**
	 * Constructor of LoginForm
	 * @param rc RegsitrationClient
	 */
    public GUIApp() {
    	
    	usernameLabel = new JLabel();
    	usernameLabel.setText("User Name:");
        usernameText = new JTextField();
        passwordLabel = new JLabel();
        passwordLabel.setText("Password:");
        passwordText = new JPasswordField();
        submit = new JButton("SUBMIT");
        panel = new JPanel(new GridLayout(3, 1));
        panel.add(usernameLabel);
        panel.add(usernameText);
        panel.add(passwordLabel);
        panel.add(passwordText);
        message = new JLabel();
        panel.add(message);
        panel.add(submit);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel, BorderLayout.CENTER);
        setTitle("Please Login Here!");
        setSize(300,150);
        
        submit.addActionListener((ActionEvent e) ->{
    	   String username = usernameText.getText();
    	   char[] password = passwordText.getPassword();
           usernameText.setText("");
           passwordText.setText("");
           String passwordString = new String(password);
           this.username=username;
           this.password=passwordString;
           System.out.println(passwordString);
          
        });
        setVisible(true);
    }
   
   
}