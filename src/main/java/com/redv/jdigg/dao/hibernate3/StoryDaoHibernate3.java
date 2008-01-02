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
	 * @see com.redv.jdigg.dao.StoryDao#getLastSubmissionsStories(int, int)
	 */
	@SuppressWarnings("unchecked")
	public List<Story> getLastSubmissionsStories(int firstResult, int maxResults) {
		Query query = this.getSession().createQuery(
				"from Story order by date desc");
		query.setFirstResult(firstResult);
		query.setMaxResults(maxResults);
		return query.list();
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.redv.jdigg.dao.StoryDao#getVotingStories(int, int)
	 */
	@SuppressWarnings("unchecked")
	public List<Story> getVotingStories(int firstResult, int maxResults) {
		Query query = this.getSession().createQuery(
				"from Story order by votes desc");
		query.setFirstResult(firstResult);
		query.setMaxResults(maxResults);
		return query.list();
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.redv.jdigg.dao.StoryDao#getHitingStories(int, int)
	 */
	@SuppressWarnings("unchecked")
	public List<Story> getHitingStories(int firstResult, int maxResults) {
		Query query = this.getSession().createQuery(
				"from Story order by hits desc");
		query.setFirstResult(firstResult);
		query.setMaxResults(maxResults);
		return query.list();
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

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.redv.jdigg.dao.StoryDao#getStoryByUrl(java.lang.String)
	 */
	public Story getStoryByUrl(String url) {
		List<Story> stories = this.find("from Story where url = ?", url);
		if (stories.isEmpty()) {
			return null;
		} else {
			return stories.get(0);
		}
	}

}
