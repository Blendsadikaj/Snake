package Views;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import Abstract.AbstractLoginFrame;

import javax.swing.UnsupportedLookAndFeelException;

import Database.Database;
import Service.LoginService;

public class LoginFrame extends AbstractLoginFrame {
	
	/**
	 * Login's Frame constructor
	 */
	public LoginFrame(){
		setDesign();	
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		addActionEvent();
		setTextForButtons();
		setTitle("Login Form");
		setVisible(true);
		setBounds(10,10,400,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		lservice = new LoginService();
	}
	
	/**
	 * Sets text for buttons alongside icons
	 */
	private void setTextForButtons() {
		loginButton.setText("Login");
		registerButton.setText("Register");
	}

	/**
	 * Sets layout of login's frame to null
	 */
	private void setLayoutManager(){
		container.setLayout(null);
	}
	
	/**
	 * Sets location and size of the buttons and the icon
	 */
	private void setLocationAndSize(){
		icon.setBounds(200,0,50,50);
		userLabel.setBounds(50,50,100,30);
		passwordLabel.setBounds(50,100,100,30);
		userTextField.setBounds(150,50,150,30);
		passwordField.setBounds(150,100,150,30);
		showPassword.setBounds(150,140,150,30);
		loginButton.setBounds(50,200,100,30);
		registerButton.setBounds(200,200,105,30);
	}

	/**
	 * Adds the components to pane
	 */
	private void addComponentsToContainer(){
		container.add(userLabel);
		container.add(passwordLabel);
		container.add(userTextField);
		container.add(passwordField);
		container.add(showPassword);
		container.add(loginButton);
		container.add(registerButton);
		container.add(icon);
	}

	/**
	 * Adds the actions taken on buttons
	 */
	private void addActionEvent() {
		loginButton.addActionListener(e -> login());
		registerButton.addActionListener(e -> registerUser());
		showPassword.addActionListener(e -> togglePassword());
	}
	
	/**
	 * Sets design of the login frame
	 */
	private void setDesign() {
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public static void main(String[] a) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
		new Database();
		LoginFrame frame=new LoginFrame();		
	}
}