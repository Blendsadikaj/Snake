/**
 * 
 */
package Views;

import java.awt.Dimension;
import java.sql.SQLException;

import javax.swing.JSplitPane;

import Abstract.AbstractHistoryFrame;
import Model.User;

/**
 * @author DEll
 *
 */
public class HistoryFrame extends AbstractHistoryFrame {
		
	/**
	 * The constructor of History frame
	 */
	public HistoryFrame() throws SQLException {
		super();
		setTitle("History");
		setVisible(true);
		setBounds(10,10,450,400);
		setResizable(false);
		addTables();
	}
	
	/**
	 * Adds the tables to the frame
	 */
	private void addTables() {
		usersScrollPane.setMinimumSize(new Dimension(100,50));
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, usersScrollPane, historyScrollPane);
		getContentPane().add(splitPane);
	}
	
	/**
	 * Sets the logged user
	 */
	public static void setUser(User u) {
		loggedUser = u;
	}
	
	
}
