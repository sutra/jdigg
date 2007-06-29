/**
 * 
 */
package com.redv.jdigg.service;

import com.redv.jdigg.domain.Story;
import com.redv.jdigg.domain.User;
import com.redv.jdigg.domain.Vote;

/**
 * @author <a href="mailto:zhoushuqun@gmail.com">Sutra Zhou</a>
 * 
 */
public interface DiggService {
	Story getStory(String id);

	void saveStory(Story story);

	User getUser(String id);

	User getUserByOpenid(String openid);

	void saveUser(User user);

	Vote getVote(String id);

	void saveVote(Vote vote);
}
