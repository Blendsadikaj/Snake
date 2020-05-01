package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author DEll
 * This class is responsible to create
 * the connection to database
 */
public class Database {
	
	public static Connection con;
	
	/**
	 * Constructor calls createConnection() method
	 * to initialize the connection with database. 
	 */
	public Database() {
		con = createConnection();
	}
	
	/**
	 * @return the Connection object used to
	 * create queries.
	 */
	public Connection createConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/snake","root","root");
			return con;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
