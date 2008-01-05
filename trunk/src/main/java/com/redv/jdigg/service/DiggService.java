/**
 * 
 */
package com.redv.jdigg.service;

import java.util.List;

import com.redv.jdigg.StoryAlreadyExistsException;
import com.redv.jdigg.StoryNotFoundException;
import com.redv.jdigg.UserNotFoundException;
import com.redv.jdigg.domain.Category;
import com.redv.jdigg.domain.Story;
import com.redv.jdigg.domain.User;
import com.redv.jdigg.domain.Vote;

/**
 * @author <a href="mailto:zhoushuqun@gmail.com">Sutra Zhou</a>
 * 
 */
public interface DiggService {
	// User.
	/**
	 * Get a user by id.
	 * 
	 * @param id
	 * @return
	 */
	User getUser(String id);

	/**
	 * Get a user by <a href="http://openid.net/">OpenID</a>.
	 * 
	 * @param openid
	 * @return
	 */
	User getUserByOpenid(String openid);

	/**
	 * Save a user.
	 * 
	 * @param user
	 */
	void saveUser(User user);

	// Category.
	/**
	 * Get a category by id.
	 * 
	 * @param id
	 * @return
	 */
	Category getCategory(String id);

	/**
	 * Get a category by name.
	 * 
	 * @param name
	 * @return
	 */
	Category getCategoryByName(String name);

	/**
	 * Get all categories.
	 * 
	 * @return
	 */
	List<Category> getCategories();

	/**
	 * Save a category.
	 * 
	 * @param category
	 */
	void saveCategory(Category category);

	// Story.
	/**
	 * Get a story by id.
	 * 
	 * @param id
	 * @return
	 */
	Story getStory(String id);

	/**
	 * Get the last submissions stories.
	 * 
	 * @param category
	 * @param firstResult
	 * @param maxResults
	 * @return
	 */
	List<Story> getLastSubmissionsStories(Category category, int firstResult,
			int maxResults);

	/**
	 * Get the top hits stories.
	 * 
	 * @param category
	 * @param firstResult
	 * @param maxResults
	 * @return
	 */
	List<Story> getHitingStories(Category category, int firstResult,
			int maxResults);

	/**
	 * Get the top votes stories.
	 * 
	 * @param category
	 * @param firstResult
	 * @param maxResults
	 * @return
	 */
	List<Story> getVotingStories(Category category, int firstResult,
			int maxResults);

	/**
	 * Get the top rank stories.
	 * 
	 * @param category
	 * @param firstResult
	 * @param maxResults
	 * @return
	 */
	List<Story> getRankingStories(Category category, int firstResult,
			int maxResults);

	/**
	 * Save a story.
	 * 
	 * @param story
	 * @throws StoryAlreadyExistsException
	 */
	void saveStory(Story story) throws StoryAlreadyExistsException;

	/**
	 * Get story count of all categories.
	 * 
	 * @return
	 */
	long getStoryCount();

	/**
	 * Get story count.
	 * 
	 * @return
	 */
	long getStoryCount(Category category);

	// Vote.
	/**
	 * Save a note.
	 * 
	 * @param vote
	 */
	void saveVote(Vote vote);

	/**
	 * Digg a story.
	 * 
	 * @param storyId
	 * @param userId
	 * @param ip
	 * @return
	 * @throws StoryNotFoundException
	 * @throws UserNotFoundException
	 */
	Story digg(String storyId, String userId, String ip)
			throws StoryNotFoundException, UserNotFoundException;

	/**
	 * Bury a story.
	 * 
	 * @param storyId
	 * @param userId
	 * @param ip
	 * @return
	 * @throws StoryNotFoundException
	 * @throws UserNotFoundException
	 */
	Story bury(String storyId, String userId, String ip)
			throws StoryNotFoundException, UserNotFoundException;

	/**
	 * Hit a story.
	 * 
	 * @param storyId
	 * @throws StoryNotFoundException
	 */
	void hit(String storyId) throws StoryNotFoundException;
}
