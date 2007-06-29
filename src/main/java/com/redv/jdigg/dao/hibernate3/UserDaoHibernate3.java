/**
 * 
 */
package com.redv.jdigg.dao.hibernate3;

import java.util.List;

import com.redv.jdigg.dao.UserDao;
import com.redv.jdigg.domain.User;

/**
 * @author <a href="mailto:zhoushuqun@gmail.com">Sutra Zhou</a>
 * 
 */
public class UserDaoHibernate3 extends BaseDaoHibernate3<User> implements
		UserDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.redv.jdigg.dao.UserDao#getUser(java.lang.String)
	 */
	public User getUser(String id) {
		return get(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.redv.jdigg.dao.UserDao#getUserByOpenid(java.lang.String)
	 */
	public User getUserByOpenid(String openid) {
		List<User> users = find("from User where openid = ?", openid);
		if (users == null || users.isEmpty()) {
			return null;
		} else {
			return users.get(0);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.redv.jdigg.dao.UserDao#saveUser(com.redv.jdigg.domain.User)
	 */
	public void saveUser(User user) {
		getHibernateTemplate().saveOrUpdate(user);
	}

}
