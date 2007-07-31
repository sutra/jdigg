/**
 * 
 */
package com.redv.jdigg.service;

import java.util.List;

import com.redv.jdigg.StoryAlreadyExistsException;
import com.redv.jdigg.domain.Story;
import com.redv.jdigg.domain.User;
import com.redv.jdigg.domain.Vote;

/**
 * @author <a href="mailto:zhoushuqun@gmail.com">Sutra Zhou</a>
 * 
 */
public interface DiggService {
	Story getStory(String id);

	List<Story> getRankingStories(int firstResult, int maxResults);

	void saveStory(Story story) throws StoryAlreadyExistsException;

	User getUser(String id);

	User getUserByOpenid(String openid);

	void saveUser(User user);

	void saveVote(Vote vote);

	Story digg(String storyId, String userId, String ip);

	Story bury(String storyId, String userId, String ip);
}
