/**
 * 
 */
package Abstract;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Database.Database;
import Database.Helper;
import Model.User;

/**
 * @author DEll
 *
 */
public abstract class AbstractUserService {

	/**
	 * @return the list of all users.
	 */
	public static List<User> showAllUsers(){
		List<User> users = new ArrayList<>();
		Statement stmt;
		try {
			stmt = Database.con.createStatement();
			ResultSet res = stmt.executeQuery(Helper.getAllUsers);
			while(res.next()) {
				users.add(new User(res.getLong(1),res.getString(2)));
			}
			return users;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}	
}
