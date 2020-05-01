/**
 * 
 */
package Test;

import Database.Database;
import Model.GameHistory;
import Model.User;

/**
 * @author DEll
 *
 */
public class GameHistoryTest {
	
	/**
	 * Test the methods of GameHistory
	 * @param gh
	 * @return true or false based on the test
	 */
	private static boolean testGH(GameHistory gh) {
		if(gh.getScore()==18 && gh.getTime()==17 && gh.getUserId()==14)
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		new Database();
		GameHistory gh = new GameHistory(new User(40,"Blend"),28,48);
		gh.setUserId(14);
		gh.setTime(17);
		gh.setScore(18);
		System.out.println(testGH(gh)+": must be true");
	}

}
