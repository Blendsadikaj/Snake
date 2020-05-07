package Service;

import java.sql.ResultSet;
import java.sql.SQLException;

import Abstract.AbstractLoginService;
import Interface.LoginInterface;
import Model.User;

/**
 * @author DEll
 *
 */
public class LoginService extends AbstractLoginService implements LoginInterface {
	
	private User loggeduser;
	
	/**
	 * Constructor of LoginService
	 */
	public LoginService() {
		us  = new UserService();
	}
	
	/**
	 * @param username
	 * @param password
	 * Login method is used to log into user's account
	 */
	@Override
	public User Login(String username,String password) throws SQLException{
		ResultSet res = verifyLogin(username, password);
		if(res != null) {
			loggeduser = new User(res.getInt(1),res.getString(2));
			return loggeduser;
		}
		else
			return null;
	}
	
	/**
	 * @param username
	 * @param password
	 * @return wether the user was able to register.
	 */
	@Override
	public boolean Register(String username,String password) {
		if(register(username, password))
			return true;
		else
			return false;
	}

	/**
	 * @return the user
	 */
	public User getLoggedUser() {
		return loggeduser;
	}
}
