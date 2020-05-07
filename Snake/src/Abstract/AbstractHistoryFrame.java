/**
 * 
 */
package Abstract;

import java.awt.Graphics;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Model.GameHistory;
import Model.User;
import Service.GameHistoryService;

/**
 * @author DEll
 *
 */
public class AbstractHistoryFrame extends JFrame {
	
	protected static User loggedUser;
	
	private GameHistoryService ghs = new GameHistoryService();
	
	private Object column[]={"Date","Score","Time"}; 
	
	private JTable jt = new JTable(getHistoryOfUser(),column){
		 @Override
		public boolean editCellAt(int row, int column, java.util.EventObject e) {
	            return false;
	         }
	};
	
	private String column2[]={"Username","Highest Score","Average Score","Total time","Position"}; 
	
	private JTable jt2 = new JTable(getDatasOfUser(),column2){
		 @Override
		public boolean editCellAt(int row, int column, java.util.EventObject e) {
	            return false;
	         }
	};
	
	protected JScrollPane historyScrollPane = new JScrollPane(jt);
	protected JScrollPane usersScrollPane = new JScrollPane(jt2);
	
	/**
	 * 
	 */
	public AbstractHistoryFrame() throws SQLException {
	}
	
	private String[][] getHistoryOfUser() throws SQLException{
		List<GameHistory> data = ghs.getHistoryByUser(loggedUser);
		Collections.reverse(data);
		String[][] list = new String[data.size()][3];

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		for(int k = 0;k<data.size();k++) {
			list[k][0] = format.format(data.get(k).getDate());
			list[k][1] = data.get(k).getScore()+"";
			list[k][2] = data.get(k).getTime()+" seconds";
		}		
		return list;
	}
	
	private String[][] getDatasOfUser() throws SQLException{
		String[][] list = new String[1][5];
			list[0][0] = loggedUser.getUsername();
			list[0][1] = loggedUser.getHighestScore() +"";
			list[0][2] = loggedUser.getAverageScore() + "";
			list[0][3] = timePlayed();
			list[0][4] = positionInTable()+"";
		return list;
	}
	
	private String timePlayed() {
		long time = getTimePlayed();
		if(time < 60)
			return time+"s";
		else
			return time/60+"m "+time%60+"s";
	}
	
	private long getTimePlayed() {
		return ghs.getHistoryByUser(loggedUser).stream().mapToLong(o -> o.getTime()).sum();
	}
	
	private long positionInTable() throws SQLException {
			return AbstractUserService.showAllUsers().stream()
			.sorted(Comparator.comparingInt(User::getHighestScore).reversed())
			.mapToLong(o -> o.getId())
			.boxed()
			.collect(Collectors.toList()).indexOf(loggedUser.getId()) + 1;
	}

}
