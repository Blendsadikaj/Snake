/**
 * 
 */
package Test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import Database.Database;
import Model.User;

/**
 * @author DEll
 *
 */
public class UserTest {
	
	@BeforeClass
	public static void init() {
		new Database();
	}
	
	/**
	 * Tests the methods of User
	 * @param u
	 * @return true or false based on the test
	 */
	@Test
	public void testUser() {
		User u = new User(50,"Blend");
		assertTrue(u.getId() == 50);
		assertTrue(u.getUsername().equals("Blend"));
	}
	
}
