package Model;
import java.sql.Timestamp;

import Abstract.AbstractGameHistory;
import Service.GameHistoryService;

/**
 * @author DEll
 * GameHistory object is used to store the data of a 
 * user.
 */
public class GameHistory extends AbstractGameHistory {
	
	/**
	 * @param date
	 * @param userId
	 * @param score
	 * @param time
	 * This constructor is used to retrieve data from database
	 */
	public GameHistory(Timestamp date,long userId,int score,int time) {
		super(date,userId,score,time);
	}
	
	/**
	 * @param user
	 * @param score
	 * @param time
	 * This constructor is used to insert data into database
	 */
	public GameHistory(User user,int score,int time) {
		super(new Timestamp(System.currentTimeMillis()), user.getId(),score,time);	
		user.getUs().update(user);
	}	
}
