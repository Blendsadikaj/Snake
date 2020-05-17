package Service;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Database.Database;
import Database.Helper;
import Interface.GameHistoryInterface;
import Model.GameHistory;
import Model.User;


/**
 * @author DEll
 * GameHistoryService has the methods wich are
 * responsible for retrieving and inserting
 * datas into database.
 */
public class GameHistoryService implements GameHistoryInterface<GameHistory> {

	/**
	 * @param gh
	 *This method is used to insert GameHistory object
	 *into database
	 */
	@Override
	public boolean insert(GameHistory gh) {
		PreparedStatement stmt;
		if(validate(gh)) {
			try {
				stmt = Database.con.prepareStatement(Helper.insertToSnakes);
				stmt.setTimestamp(1,new java.sql.Timestamp(System.currentTimeMillis()));
				stmt.setLong(2, gh.getUserId());
				stmt.setInt(3, gh.getScore());
				stmt.setInt(4, gh.getTime());
				stmt.execute();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
		
	}
	
	private boolean validate(GameHistory gh) {
		return gh.getScore() >= 0 && gh.getTime() > 0 ?  true : false;
	}

	/**
	 *@param user
	 *This method is used to get the history of a user
	 */
	@Override
	public List<GameHistory> getHistoryByUser(User user){
		List<GameHistory> ghList = new ArrayList<>();
		Statement stmt;
		try {
			stmt = Database.con.createStatement();
			ResultSet res = stmt.executeQuery(Helper.getHistoryByUser + user.getId()+"'");
			while(res.next()) {
				ghList.add(new GameHistory(res.getTimestamp(1),res.getLong(4),res.getInt(2),res.getInt(5)));
			}
			return ghList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
