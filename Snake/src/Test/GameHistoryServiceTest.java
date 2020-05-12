/**
 * 
 */
package Test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import Database.Database;
import Model.GameHistory;
import Model.User;
import Service.GameHistoryService;
import Service.LoginService;

/**
 * @author DEll
 *
 */
public class GameHistoryServiceTest {
	
	static GameHistoryService service = new GameHistoryService();
	private LoginService loginService = new LoginService();
	
	@BeforeClass
	public static void init() {
		new Database();
	}
	
	private User loggedUser() {
		return loginService.Login("Sadikaj123", "123123");
	}
	
	/**
	 * Tests the ability of the GameHistoryService
	 * to insert into database.
	 */
	@Test
	public void testInsert() {
		GameHistory ghs = new GameHistory(loggedUser(), 20, 12);
		assertTrue(service.insert(ghs));
		ghs.setScore(-10);
		assertTrue(!service.insert(ghs));
	}
	
	/**
	 * Tests the ability of the GameHistoryService
	 * to retrieve history by user.
	 */
	@Test
	public void testGetHistoryByUser() {
		assertTrue(service.getHistoryByUser(loggedUser())
				.stream().allMatch(o -> o.getUserId() == loggedUser().getId()));
	}
}
