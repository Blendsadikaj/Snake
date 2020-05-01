/**
 * 
 */
package Test;

import java.sql.SQLException;

import Abstract.AbstractUserService;
import Database.Database;
import Model.User;
import Service.UserService;

/**
 * @author DEll
 *
 */
public class UserServiceTest {
	static UserService service = new UserService();
	
	/**
	 * Tests the ability of the UserService
	 * to insert data into database.
	 * @param a
	 * @return true or false based on the test
	 */
	private static boolean testInsert(User a) {
		service.insert(a);
		for(User u : AbstractUserService.showAllUsers()) {
			if(u.getUsername().equals("Sadikaj123"))
				return true;
		}
		return false;
	}
	
	/**
	 * Tests the ability of the UserService to update
	 * a user.
	 * @param u
	 * @return true or false based on the test
	 */
	private static boolean testUpdate(User u) {
		service.update(u);
		for(User user : AbstractUserService.showAllUsers()) {
			if(user.getUsername().equals(u.getUsername()))
				if(u.getHighestScore() != 30 && u.getAverageScore() != 40) 
					return true;				
		}
		return false;
	}
	
	public static void main(String[] args) throws SQLException {
		new Database();
		System.out.println(testInsert(new User("Sadikaj123","123123"))+": must be true");
		User u = new User(42,"Sadikaj2");
		u.setHighestScore(30);
		u.setAverageScore(40);
		System.out.println(testUpdate(u)+": must be true");
	}

}
