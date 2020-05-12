package Test;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;

import Model.GameHistory;

/**
 * @author DEll
 *
 */
public class GameHistoryTest {
	
	/**
	 * Test the methods of GameHistory
	 */
	@Test
	public void testModel() {
		GameHistory gh = new GameHistory(new Timestamp(new Date().getTime()),50,20,12);
		assertTrue(gh.getTime()==12);
		assertTrue(gh.getScore()==20);
		assertTrue(gh.getUserId()==50);
		assertTrue(gh.getDate().getMinutes() == (new Timestamp(new Date().getTime()).getMinutes()));
	}

}
