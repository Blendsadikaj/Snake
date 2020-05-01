package Interface;

/**
 * @author DEll
 *
 * @param <T>
 */
public interface UserServiceInterface<T extends Object> extends BaseInterface<T>{
	
	/**
	 * @param user
	 */
	public void update(T user);
}
