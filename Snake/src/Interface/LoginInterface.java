/**
 * 
 */
package Interface;

import java.sql.SQLException;

import Model.User;

/**
 * @author DEll
 *
 */
public interface LoginInterface {
	
	/**
	 * @param username
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public User Login(String username,String password) throws SQLException;
	
	/**
	 * @param username
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public boolean Register(String username,String password) throws SQLException;

}
