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

	Story getStoryByUrl(String url);

	List<Story> getRankingStories(int firstResult, int maxResults);

	void saveStory(Story story);
}