/**
 * 
 */
package Test;

import java.sql.SQLException;

import Database.Database;
import Model.User;

/**
 * @author DEll
 *
 */
public class UserTest {
	
	/**
	 * Tests the methods of User
	 * @param u
	 * @return true or false based on the test
	 */
	private static boolean testUser(User u) {
		if(u.getId()==15 && u.getAverageScore() == 12 && u.getHighestScore() == 12)
			return true;
		return false;
	}
	
	public static void main(String[] args) throws SQLException {
		new Database();
		User u = new User(15,"Blend");
		u.setAverageScore(12);
		u.setHighestScore(12);
		System.out.println(testUser(u)+": must be true");
	}
}
