/**
 * 
 */
package com.redv.jdigg.service;

import java.util.List;

import com.redv.jdigg.StoryAlreadyExistsException;
import com.redv.jdigg.StoryNotFoundException;
import com.redv.jdigg.UserNotFoundException;
import com.redv.jdigg.domain.Story;
import com.redv.jdigg.domain.User;
import com.redv.jdigg.domain.Vote;

/**
 * @author <a href="mailto:zhoushuqun@gmail.com">Sutra Zhou</a>
 * 
 */
public interface DiggService {
	Story getStory(String id);

	/**
	 * Get the last submissions stories.
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @return
	 */
	List<Story> getLastSubmissionsStories(int firstResult, int maxResults);

	/**
	 * Get the top hits stories.
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @return
	 */
	List<Story> getHitingStories(int firstResult, int maxResults);

	/**
	 * Get the top votes stories.
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @return
	 */
	List<Story> getVotingStories(int firstResult, int maxResults);

	/**
	 * Get the top rank stories.
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @return
	 */
	List<Story> getRankingStories(int firstResult, int maxResults);

	void saveStory(Story story) throws StoryAlreadyExistsException;

	User getUser(String id);

	User getUserByOpenid(String openid);

	void saveUser(User user);

	void saveVote(Vote vote);

	Story digg(String storyId, String userId, String ip)
			throws StoryNotFoundException, UserNotFoundException;

	Story bury(String storyId, String userId, String ip)
			throws StoryNotFoundException, UserNotFoundException;
}
