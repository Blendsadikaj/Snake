/**
 * 
 */
package Abstract;

import java.awt.Container;
import java.awt.HeadlessException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Database.Helper;
import Model.User;
import Service.LoginService;
import Views.GameFrame;

/**
 * @author DEll
 *
 */
public abstract class AbstractLoginFrame extends JFrame {
	
	protected LoginService lservice;
	
	public static GameFrame gameframe;
	
	protected Container container=getContentPane();
	protected JLabel userLabel=new JLabel("USERNAME");
	protected JLabel passwordLabel=new JLabel("PASSWORD");
	protected JTextField userTextField=new JTextField();
	protected JPasswordField passwordField=new JPasswordField();
	protected JButton loginButton=new JButton("LOGIN");
	protected JButton registerButton=new JButton("REGISTER");
	protected JCheckBox showPassword=new JCheckBox("Show Password");
	
	protected void openGameFrame() {
		String userText;
		String pwdText;
		userText = userTextField.getText();
		pwdText = passwordField.getText();
	
		try {
			User u = lservice.Login(userText, pwdText);
			if (u != null) {
				JOptionPane.showMessageDialog(this, Helper.loginSuccessful );
				gameframe = new GameFrame(u);
				this.setVisible(false);
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(this,Helper.invalidCredentials,
						   "Error",JOptionPane.ERROR_MESSAGE);
			}
		} catch (HeadlessException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	protected void registerUser() {
		String userText;
		String pwdText;
		userText = userTextField.getText();
		pwdText = passwordField.getText();
		if(lservice.Register(userText, pwdText)) {
			JOptionPane.showMessageDialog(this, Helper.registeredSuccesfully);
		}else {
			JOptionPane.showMessageDialog(this,Helper.notRegistered,
					   "Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	protected void togglePassword() {
		if (showPassword.isSelected()) {
			passwordField.setEchoChar((char) 0);
		} else {
			passwordField.setEchoChar('*');
		}
	}

}
