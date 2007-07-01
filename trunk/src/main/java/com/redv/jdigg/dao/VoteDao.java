/**
 * 
 */
package com.redv.jdigg.dao;

import com.redv.jdigg.domain.Vote;

/**
 * @author <a href="mailto:zhoushuqun@gmail.com">Sutra Zhou</a>
 * 
 */
public interface VoteDao {
	Vote getVote(String storyId, String voterId);

	void saveVote(Vote vote);
}
