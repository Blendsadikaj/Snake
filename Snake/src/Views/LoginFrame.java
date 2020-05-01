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
	
	public LoginFrame()
	{
		setDesign();	
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		addActionEvent();
		setTitle("Login Form");
		setVisible(true);
		setBounds(10,10,400,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		lservice = new LoginService();
	}

	public void setLayoutManager()
	{
		container.setLayout(null);
	}
	
	public void setLocationAndSize()	
	{
		userLabel.setBounds(50,50,100,30);
		passwordLabel.setBounds(50,100,100,30);
		userTextField.setBounds(150,50,150,30);
		passwordField.setBounds(150,100,150,30);
		showPassword.setBounds(150,140,150,30);
		loginButton.setBounds(50,200,100,30);
		registerButton.setBounds(200,200,100,30);
	}

	public void addComponentsToContainer()
	{
		container.add(userLabel);
		container.add(passwordLabel);
		container.add(userTextField);
		container.add(passwordField);
		container.add(showPassword);
		container.add(loginButton);
		container.add(registerButton);
	}


	public void addActionEvent() {
		loginButton.addActionListener(e -> openGameFrame());
		registerButton.addActionListener(e -> registerUser());
		showPassword.addActionListener(e -> togglePassword());
	}
	
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