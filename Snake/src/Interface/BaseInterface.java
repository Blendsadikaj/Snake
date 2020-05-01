/**
 * 
 */
package Interface;

import java.sql.SQLException;
/**
 * @author DEll
 * This interface is the base of other interfaces
 * since it has the method wich will be implemented
 * in all services
 * @param <T>
 */
public interface BaseInterface<T extends Object> {

	/**
	 * @param obj
	 * @throws SQLException
	 * Method wich inserts @param<T> into database
	 */
	public void insert(T obj) throws SQLException;
}
