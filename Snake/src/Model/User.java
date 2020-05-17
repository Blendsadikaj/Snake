package Model;

import Abstract.AbstractUser;
import Main.StartGame;
import Service.UserService;

/**
 * @author DEll
 *
 */
public class User extends AbstractUser{
	
	private UserService us = new UserService();
	
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
	 * @return the us
	 */
	public UserService getUs() {
		return us;
	}
	
	
	
}
