/**
 * 
 */
package com.redv.jdigg.dao.hibernate3;

import java.util.List;

import org.hibernate.Query;

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
		this.getHibernateTemplate().saveOrUpdate(story);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.redv.jdigg.dao.StoryDao#getRankingStories(int, int)
	 */
	@SuppressWarnings("unchecked")
	public List<Story> getRankingStories(int firstResult, int maxResults) {
		Query query = this.getSession().createQuery(
				"from Story order by rank desc");
		query.setFirstResult(firstResult);
		query.setMaxResults(maxResults);
		return query.list();
	}

}
