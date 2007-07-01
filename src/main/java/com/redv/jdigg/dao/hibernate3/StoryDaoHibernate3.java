/**
 * 
 */
package com.redv.jdigg.dao.hibernate3;

import java.util.List;

import com.redv.jdigg.dao.StoryDao;
import com.redv.jdigg.domain.Story;

/**
 * @author <a href="mailto:zhoushuqun@gmail.com">Sutra Zhou</a>
 * 
 */
public class StoryDaoHibernate3 extends BaseDaoHibernate3<Story> implements
		StoryDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.redv.jdigg.dao.StoryDao#getStory(java.lang.String)
	 */
	public Story getStory(String id) {
		return get(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.redv.jdigg.dao.StoryDao#saveStory(com.redv.jdigg.domain.Story)
	 */
	public void saveStory(Story story) {
		this.getHibernateTemplate().save(story);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.redv.jdigg.dao.StoryDao#getRankingStories(com.redv.jdigg.domain.Story,
	 *      int, int)
	 */
	public List<Story> getRankingStories(Story exampleStory, int firstResult,
			int maxResults) {
		return findByExample(exampleStory, firstResult, maxResults);
	}

}
