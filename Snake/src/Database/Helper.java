/**
 * 
 */
package Database;

/**
 * @author DEll
 * This class is used to keep some values away from the main code.
 */
public class Helper {

	//The query used to insert history
	public static final String insertToSnakes = "INSERT INTO `snake`.`history` (`date`, `user_id`,`score`,`time`) VALUES (?, ?, ?, ?);";
	
	//The query used to get the history of the user
	public static final String getHistoryByUser = "SELECT * FROM history WHERE user_id like '";
	
	//The query used to update the user
	public static final String updateUser = "UPDATE `snake`.`users` SET `average_score` = ?, `highest_score` = ? WHERE (`id` = ?)";
	
	//The query used to get all users
	public static final String getAllUsers = "SELECT * FROM users";
	
	//The query used to insert a user
	public static final String insertUser = "INSERT INTO `snake`.`users` (`name`, `password`,`highest_score`,`average_score`) VALUES (?, ?, ?, ?);";

	//The message when a successful login occurs
	public static final String loginSuccessful = "Login Successful";
	
	//The message when a failed loggin occurs
	public static final String invalidCredentials = "Invalid Username or Password";
	
	//The messsage of a successful registration
	public static final String registeredSuccesfully = "Registered successfully";
	
	//The message of a failed registration
	public static final String notRegistered = "Username taken or password less than 4 characters";
}
