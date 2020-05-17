package Interface;

import Model.User;

/**
 * @author DEll
 *
 * @param <T>
 */
public interface UserServiceInterface<T extends Object> extends BaseInterface<T>{
	
	/**
	 * @param user
	 * Updates user.
	 */
	public void update(T user);
	
	/**
	 * @param id of the user
	 * Deletes user.
	 */
	public boolean delete(Long id);
	
	/**
	 * @param username of the user
	 * Finds user by username.
	 */
	public User findUser(String username);
}
