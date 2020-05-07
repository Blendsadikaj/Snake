package Main;
import java.awt.Color;

import javax.swing.JFrame;

import Model.User;


/**
 * @author DEll
 * This class is the controller of the game
 */ 
public class StartGame {
	
	
	/**
	 * @param user
	 * This constructor is used to draw the frame and
	 * add the Gameplay component to it
	 */
	public StartGame(User user) {
		JFrame obj = new JFrame();
		Gameplay gameplay = new Gameplay(user);
		obj.setBounds(10,10,905,700);
		obj.setBackground(Color.DARK_GRAY);
		obj.setResizable(false);
		obj.setVisible(true);
		obj.add(gameplay);
	}

}
