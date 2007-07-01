/**
 * 
 */
package com.redv.jdigg.dao.hibernate3;

import java.util.List;

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
	 * @see com.redv.jdigg.dao.VoteDao#saveVote(com.redv.jdigg.domain.Vote)
	 */
	public void saveVote(Vote vote) {
		this.getHibernateTemplate().saveOrUpdate(vote);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.redv.jdigg.dao.VoteDao#getVote(java.lang.String,
	 *      java.lang.String)
	 */
	public Vote getVote(String storyId, String voterId) {
		List<Vote> votes = find(
				"from Vote where story.id = ? and voter.id = ?", new String[] {
						storyId, voterId });
		if (votes.isEmpty()) {
			return null;
		} else {
			return votes.get(0);
		}
	}

}
