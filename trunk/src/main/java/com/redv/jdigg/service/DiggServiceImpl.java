/**
 * 
 */
package com.redv.jdigg.service;

import java.util.List;

import com.redv.jdigg.dao.StoryDao;
import com.redv.jdigg.dao.UserDao;
import com.redv.jdigg.dao.VoteDao;
import com.redv.jdigg.domain.Story;
import com.redv.jdigg.domain.User;
import com.redv.jdigg.domain.Vote;

/**
 * @author <a href="mailto:zhoushuqun@gmail.com">Sutra Zhou</a>
 * 
 */
public class DiggServiceImpl implements DiggService {
	private UserDao userDao;

	private StoryDao storyDao;

	private VoteDao voteDao;

	/**
	 * @param storyDao
	 *            要设置的 storyDao
	 */
	public void setStoryDao(StoryDao storyDao) {
		this.storyDao = storyDao;
	}

	/**
	 * @param userDao
	 *            要设置的 userDao
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * @param voteDao
	 *            要设置的 voteDao
	 */
	public void setVoteDao(VoteDao voteDao) {
		this.voteDao = voteDao;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.redv.jdigg.service.DiggService#getStory(java.lang.String)
	 */
	public Story getStory(String id) {
		return storyDao.getStory(id);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.redv.jdigg.service.DiggService#getRankingStories(com.redv.jdigg.domain.Story,
	 *      int, int)
	 */
	public List<Story> getRankingStories(Story exampleStory, int firstResult,
			int maxResults) {
		return storyDao
				.getRankingStories(exampleStory, firstResult, maxResults);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.redv.jdigg.service.DiggService#getUser(java.lang.String)
	 */
	public User getUser(String id) {
		return userDao.getUser(id);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.redv.jdigg.service.DiggService#getUserByOpenid(java.lang.String)
	 */
	public User getUserByOpenid(String openid) {
		return userDao.getUserByOpenid(openid);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.redv.jdigg.service.DiggService#getVote(java.lang.String)
	 */
	public Vote getVote(String id) {
		return voteDao.getVote(id);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.redv.jdigg.service.DiggService#saveStory(com.redv.jdigg.domain.Story)
	 */
	public void saveStory(Story story) {
		storyDao.saveStory(story);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.redv.jdigg.service.DiggService#saveUser(com.redv.jdigg.domain.User)
	 */
	public void saveUser(User user) {
		userDao.saveUser(user);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.redv.jdigg.service.DiggService#saveVote(com.redv.jdigg.domain.Vote)
	 */
	public void saveVote(Vote vote) {
		voteDao.saveVote(vote);
	}

}
