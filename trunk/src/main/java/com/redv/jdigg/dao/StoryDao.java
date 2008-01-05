/**
 * 
 */
package com.redv.jdigg.dao;

import java.util.List;

import com.redv.jdigg.domain.Category;
import com.redv.jdigg.domain.Story;

/**
 * @author <a href="mailto:zhoushuqun@gmail.com">Sutra Zhou</a>
 * 
 */
public interface StoryDao {
	Story getStory(String id);

	Story getStoryByUrl(String url);

	List<Story> getLastSubmissionsStories(Category category, int firstResult,
			int maxResults);

	List<Story> getVotingStories(Category category, int firstResult,
			int maxResults);

	List<Story> getHitingStories(Category category, int firstResult,
			int maxResults);

	List<Story> getRankingStories(Category category, int firstResult,
			int maxResults);

	void saveStory(Story story);

	long getStoryCount(Category category);
}
