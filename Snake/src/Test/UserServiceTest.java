package Test;

import static org.junit.Assert.assertTrue;

import java.util.stream.Collectors;

import org.junit.BeforeClass;
import org.junit.Test;

import Database.Database;
import Model.User;
import Service.UserService;

/**
 * @author DEll
 *
 */
public class UserServiceTest {
	
	static UserService service = new UserService();
	
	@BeforeClass
	public static void init() {
		new Database();
	}
	
	
	/**
	 * Tests the ability of the UserService
	 * to insert data into database.
	 * @param a
	 */
	@Test
	public void testInsert() {
		User a = new User("Blend","123123");
		assertTrue(service.insert(a));
		service.delete(service.showAllUsers().stream()
				.filter(o -> o.getUsername().equals(a.getUsername()) && o.getId() != 40)
				.collect(Collectors.toList()).get(0).getId());
	}
	
	/**
	 * Tests the ability of the UserService to update
	 * a user.
	 */
	@Test
	public void testUpdate() {
		User u = new User(50,"123123");
		service.update(u);
		assertTrue(UserService.showAllUsers().
				stream().anyMatch(o -> o.getHighestScore() == u.getHighestScore()));
		assertTrue(UserService.showAllUsers().
				stream().anyMatch(o -> o.getAverageScore() == u.getAverageScore()));
	}
	
	/**
	 * Tests the ability of the UserService to delete
	 * a user.
	 */
	@Test
	public void testDelete() {
		User u = new User("Dummy","123123");
		service.insert(u);
		User a = service.findUser(u.getUsername());
		service.delete(a.getId());
		assertTrue(!UserService.showAllUsers().contains(u));
	}
	
	/**
	 * Tests the ability of the UserService to find
	 * a user.
	 */
	@Test
	public void testFind() {
		String username = "Blend";
		User u = service.findUser(username);
		assertTrue(u.getUsername().equals(username));
	}
}
