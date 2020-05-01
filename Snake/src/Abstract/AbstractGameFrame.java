/**
 * 
 */
package Abstract;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Model.User;
import Service.UserService;
import Views.HistoryFrame;
import Views.LoginFrame;

/**
 * @author DEll
 *
 */
public abstract class AbstractGameFrame extends JFrame {

	User loggedUser;

	String column[]={"Username","Highest Score","Average Score"};   

	public static HistoryFrame hs;

	protected Container container=getContentPane();
	protected JButton playButton=new JButton("Play");
	protected JButton showHistory=new JButton("Show History");
	protected JButton logout = new JButton("Logut");
	protected String[] option = { "Highest Score","Average Score"};  
	protected JComboBox<Object> box = new JComboBox<Object>(option); 
	protected JLabel sortBy = new JLabel("Sort By:");
	protected JTable jt = new JTable(getBestPlayers(),column){
		@Override
		public boolean editCellAt(int row, int column, java.util.EventObject e) {
			return false;
		}
	};
	JScrollPane sp = new JScrollPane(jt);
	protected JPanel borderLayoutPanel = new JPanel(new BorderLayout());
    

	public AbstractGameFrame(User u) {
		this.loggedUser = u;
		borderLayoutPanel.setBorder(BorderFactory
		        .createTitledBorder("Leaderboard"));
		sp.setPreferredSize(new Dimension(370,150));
		 borderLayoutPanel.add(sp, BorderLayout.NORTH);
	}

	protected String[][] getBestPlayers() {
		String[][] data;
		List<User> users;
		users = AbstractUserService.showAllUsers();
		if(box.getSelectedItem().equals("Highest Score")) {
			users.sort(Comparator.comparingLong(User::getHighestScore));
		}else {
			users.sort(Comparator.comparingLong(User::getAverageScore));
		}

		Collections.reverse(users);

		int userSize = users.size() < 3 ? users.size() : 3;

		data = new String[userSize][3];

		for(int k = 0;k<userSize;k++) {
			data[k][0] = users.get(k).getUsername();
			data[k][1] = users.get(k).getHighestScore()+"";
			data[k][2] = users.get(k).getAverageScore()+"";
		}		
		return data;
	}

	protected void play() {
		this.loggedUser.play();
	}

	protected void showHistory() {
		try {
			User u = loggedUser;
			HistoryFrame.setUser(u);
			hs = new HistoryFrame();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	protected void logout() {
		setVisible(false);
		dispose();
		new LoginFrame();
	}

}
