package Abstract;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Database.Database;

/**
 * @author DEll
 *
 */
public abstract class AbstractUser {
	
	protected long id;
	protected String username;
	protected int highestScore;
	protected int averageScore;
	protected String password;
	
	/**
	 * Computes the average and the highest score
	 * of the user.
	 */
	public void compute() {
		int scores = 0;
		int count = 0;
		Statement stmt;
		try {
			stmt = Database.con.createStatement();
			ResultSet res = stmt.executeQuery("SELECT * FROM history where user_id like '"+id+"'");
			while(res.next()) {
				scores += res.getInt(2);
				count++;
				if(res.getInt(2) > this.highestScore) {
					setHighestScore(res.getInt(2));
				}	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(count != 0)
			setAverageScore(scores/count);
		else
			setAverageScore(0);;
	}

	/**
	 * @return the averageScore
	 */
	public int getAverageScore() {
		return averageScore;
	}

	/**
	 * @param averageScore the averageScore to set
	 */
	public void setAverageScore(int averageScore) {
		this.averageScore = averageScore;
	}

	/**
	 * @return the highestScore
	 */
	public int getHighestScore() {
		return highestScore;
	}

	/**
	 * @param highestScore the highestScore to set
	 */
	public void setHighestScore(int highestScore) {
		this.highestScore = highestScore;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
}
