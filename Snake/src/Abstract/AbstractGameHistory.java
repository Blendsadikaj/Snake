package Abstract;
import java.sql.Timestamp;


/**
 * @author DEll
 */
public abstract class AbstractGameHistory {
	
	protected Timestamp date;
	protected long userId;
	protected int score;
	protected int time;
	
	
	/**
	 * @param date
	 * @param userId
	 * @param score
	 * @param time
	 */
	public AbstractGameHistory(Timestamp date,long userId,int score,int time) {
		setDate(date);
		setUserId(userId);
		setScore(score);
		setTime(time);
	}

	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	/**
	 * @return the date
	 */
	public Timestamp getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Timestamp date) {
		this.date = date;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @return the time
	 */
	public int getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(int time) {
		this.time = time;
	}
}
