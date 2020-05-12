package Service;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.stream.Collectors;

import Abstract.AbstractLoginService;
import Abstract.AbstractUserService;
import Database.Database;
import Database.Helper;
import Interface.UserServiceInterface;
import Model.User;

/**
 * @author DEll
 */
public class UserService extends AbstractUserService implements UserServiceInterface<User> {
	
	/**
	 * Insert method is used to insert
	 * a user into database.
	 */
	@Override
	public boolean insert(User obj) {
		PreparedStatement stmt;
		try {
			stmt = Database.con.prepareStatement(Helper.insertUser);
			stmt.setString(1, obj.getUsername());
			stmt.setString(2, AbstractLoginService.passwordEncryption(obj.getPassword()));
			stmt.setInt(3, 0);
			stmt.setInt(4, 0);
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * update method is used to update
	 * the datas of the user.
	 */
	@Override
	public void update(User user){
		user.compute();
		PreparedStatement stmt;
		try {
			stmt = Database.con.prepareStatement(Helper.updateUser);
			stmt.setInt(1, user.getAverageScore());
			stmt.setInt(2, user.getHighestScore());
			stmt.setFloat(3, user.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * delete method is used to delete
	 * a user.
	 */
	@Override
	public boolean delete(Long id) {
	    PreparedStatement preparedStmt;
		try {
			preparedStmt = Database.con.prepareStatement(Helper.deleteUser);
			preparedStmt.setFloat(1, id);
			preparedStmt.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}   
	}
	
	public User findUser(String username) {
		return showAllUsers().stream().
				filter(o -> o.getUsername()
				.equals(username))
				.collect(Collectors.toList()).get(0);
	}
}
