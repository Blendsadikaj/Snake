package Main;
import java.awt.Color;

import javax.swing.JFrame;

import Model.User;

/**
 * 
 */

/**
 * @author DEll
 *
 */ 
public class StartGame {
	
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
