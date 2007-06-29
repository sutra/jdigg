/**
 * 
 */
package com.redv.jdigg.dao.hibernate3;

import com.redv.jdigg.dao.VoteDao;
import com.redv.jdigg.domain.Vote;

/**
 * @author <a href="mailto:zhoushuqun@gmail.com">Sutra Zhou</a>
 * 
 */
public class VoteDaoHibernate3 extends BaseDaoHibernate3<Vote> implements
		VoteDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.redv.jdigg.dao.VoteDao#getVote(java.lang.String)
	 */
	public Vote getVote(String id) {
		return get(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.redv.jdigg.dao.VoteDao#saveVote(com.redv.jdigg.domain.Vote)
	 */
	public void saveVote(Vote vote) {
		this.getHibernateTemplate().saveOrUpdate(vote);
	}

}
