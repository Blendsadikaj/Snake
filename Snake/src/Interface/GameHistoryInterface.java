package Interface;

import java.util.List;

import Model.User;

/**
 * @param <T>
 * GameHistoryInterface has only one method, getHistoryByUser.
 * It's impl is on GameHistoryService.
 */
public interface GameHistoryInterface<T extends Object> extends BaseInterface<T> {
	
	/**
	 * @param user
	 * @return the list of history per user
	 */
	public List<T> getHistoryByUser(User user);
	
}
