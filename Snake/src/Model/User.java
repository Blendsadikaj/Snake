package Model;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

import Abstract.AbstractUser;
import Main.StartGame;
import Service.GameHistoryService;
import Service.UserService;

/**
 * @author DEll
 *
 */
public class User extends AbstractUser{
	
	private UserService us = new UserService();
	private GameHistoryService ghs = new GameHistoryService();
	
	/**
	 * This constructor is used to register
	 * a user.
	 * @param username
	 * @param password
	 */
	public User(String username,String password) {
		this.username = username;
		this.password = password;
	}	

	/**
	 * This constructor is used when retrieving 
	 * datas from database.
	 * @param id
	 * @param username
	 */
	public User(long id,String username) {
		this.id = id;
		this.username = username;
		compute();
		us.update(this);
	}
	
	/**
	 * Play method is used to 
	 * initialize the game.
	 */
	public void play() {
		new StartGame(this);
	}
	
	/**
	 * getHistory method is used to transform
	 * data of the history from List type to
	 * 2 dimensional array. It is called from
	 * HistoryFrame.
	 * @param u
	 * @return two dimensional array
	 */
	public String[][] getHistory(User u){
		List<GameHistory> data = ghs.getHistoryByUser(u);
		Collections.reverse(data);
		String[][] list = new String[data.size()][3];

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		for(int k = 0;k<data.size();k++) {
			list[k][0] = format.format(data.get(k).getDate());
			list[k][1] = data.get(k).getScore()+"";
			list[k][2] = data.get(k).getTime()+" seconds";
		}		
		return list;
	}
	
	
	/**
	 *
	 */
	@Override
	public String toString() {
		return "User's id: "+id+", with username: "+username + "score: "+highestScore;
	}

	/**
	 * @return the us
	 */
	public UserService getUs() {
		return us;
	}
	
	
	
}
