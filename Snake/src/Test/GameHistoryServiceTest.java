/**
 * 
 */
package Test;

import java.sql.SQLException;

import Database.Database;
import Model.GameHistory;
import Model.User;
import Service.GameHistoryService;

/**
 * @author DEll
 *
 */
public class GameHistoryServiceTest {
	
	static GameHistoryService service = new GameHistoryService();
	
	/**
	 * Tests the ability of the GameHistoryService
	 * to insert into database.
	 * @param ghs
	 * @param u
	 * @return
	 */
	private static boolean testInsert(GameHistory ghs,User u) {
		service.insert(ghs);
		for(GameHistory a : service.getHistoryByUser(u)) {
			if(a.getUserId()==u.getId())
				return true;
		}
		return false;
	}
	
	
	public static void main(String[] args) throws SQLException {
		new Database();
		User u = new User(50,"Sadikaj123");
		System.out.println(testInsert(new GameHistory(u,12,28),u)+": must be true");
	}
}
