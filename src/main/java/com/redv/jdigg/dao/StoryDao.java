/**
 * 
 */
package com.redv.jdigg.dao;

import com.redv.jdigg.domain.Story;

/**
 * @author <a href="mailto:zhoushuqun@gmail.com">Sutra Zhou</a>
 * 
 */
public interface StoryDao {
	Story getStory(String id);

	void saveStory(Story story);
}
