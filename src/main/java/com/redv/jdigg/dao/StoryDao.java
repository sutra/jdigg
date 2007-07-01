/**
 * 
 */
package com.redv.jdigg.dao;

import java.util.List;

import com.redv.jdigg.domain.Story;

/**
 * @author <a href="mailto:zhoushuqun@gmail.com">Sutra Zhou</a>
 * 
 */
public interface StoryDao {
	Story getStory(String id);

	List<Story> getRankingStories(Story exampleStory, int firstResult,
			int maxResults);

	void saveStory(Story story);
}
