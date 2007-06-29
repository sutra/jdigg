/**
 * 
 */
package com.redv.jdigg.dao;

import com.redv.jdigg.domain.User;

/**
 * @author <a href="mailto:zhoushuqun@gmail.com">Sutra Zhou</a>
 * 
 */
public interface UserDao {
	User getUser(String id);

	User getUserByOpenid(String openid);

	void saveUser(User user);
}
