/**
 * 
 */
package Abstract;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Database.Database;
import Model.User;
import Service.UserService;

/**
 * @author DEll
 *
 */
public abstract class AbstractLoginService {
	
	static Statement stmt;
	protected UserService us;
	

	public AbstractLoginService() {
		try {
			stmt = Database.con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		us = new UserService();
	}
	
	/**
	 * @param username
	 * @param password
	 * @return
	 */
	public ResultSet verifyLogin(String username,String password) {
		ResultSet res;
		try {
			res = stmt.executeQuery("SELECT * FROM users WHERE name like '"+username+"'");
			while(res.next()) {
				if(res.getString(3).equals(passwordEncryption(password)))
					return res;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param name
	 * @param pass
	 * @return
	 */
	protected boolean register(String name,String pass) {
		User user = new User(name,pass);
		boolean usernametaken = false;
		boolean passNotOkay = false;
		for(User u : AbstractUserService.showAllUsers()) {
			usernametaken = u.getUsername().equals(name) ? true : false;
			if(usernametaken)
				break;
		}
		passNotOkay = pass.length() < 4 ? true : false;

		if(!usernametaken && !passNotOkay) {
			us.insert(user);
			return true;
		}
		
		return false;
	}
	
	/**
	 * @param password
	 * @return
	 */
	public static String passwordEncryption(String password) {
		String generatedPassword = "";
		 try {
	            // Create MessageDigest instance for MD5
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            //Add password bytes to digest
	            md.update(password.getBytes());
	            //Get the hash's bytes 
	            byte[] bytes = md.digest();
	            //This bytes[] has bytes in decimal format;
	            //Convert it to hexadecimal format
	            StringBuilder sb = new StringBuilder();
	            for(int i=0; i< bytes.length ;i++)
	            {
	                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	            }
	            //Get complete hashed password in hex format
	            generatedPassword = sb.toString();
	        } 
	        catch (NoSuchAlgorithmException e) 
	        {
	            e.printStackTrace();
	        }
		 return generatedPassword;
	}

}
