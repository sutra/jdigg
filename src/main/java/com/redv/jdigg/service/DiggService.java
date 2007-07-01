/**
 * 
 */
package com.redv.jdigg.service;

import java.util.List;

import com.redv.jdigg.domain.Story;
import com.redv.jdigg.domain.User;
import com.redv.jdigg.domain.Vote;

/**
 * @author <a href="mailto:zhoushuqun@gmail.com">Sutra Zhou</a>
 * 
 */
public interface DiggService {
	Story getStory(String id);

	List<Story> getRankingStories(Story exampleStory, int firstResult,
			int maxResults);

	void saveStory(Story story);

	User getUser(String id);

	User getUserByOpenid(String openid);

	void saveUser(User user);

	void saveVote(Vote vote);

	void digg(String storyId, String userId, String ip);
}
