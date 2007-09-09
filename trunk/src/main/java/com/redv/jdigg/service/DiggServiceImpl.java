/**
 * 
 */
package com.redv.jdigg.service;

import java.util.Date;
import java.util.List;

import com.redv.jdigg.StoryAlreadyExistsException;
import com.redv.jdigg.StoryNotFoundException;
import com.redv.jdigg.UserNotFoundException;
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
	 * @see com.redv.jdigg.service.DiggService#getRankingStories(int, int)
	 */
	public List<Story> getRankingStories(int firstResult, int maxResults) {
		return storyDao.getRankingStories(firstResult, maxResults);
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
	 * @see com.redv.jdigg.service.DiggService#saveStory(com.redv.jdigg.domain.Story)
	 */
	public void saveStory(Story story) throws StoryAlreadyExistsException {
		if (storyDao.getStoryByUrl(story.getUrl()) == null) {
			storyDao.saveStory(story);
		} else {
			throw new StoryAlreadyExistsException();
		}
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

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.redv.jdigg.service.DiggService#digg(java.lang.String,
	 *      java.lang.String, java.lang.String)
	 */
	public Story digg(String storyId, String userId, String ip)
			throws StoryNotFoundException, UserNotFoundException {
		return vote(storyId, userId, ip, (short) 1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.redv.jdigg.service.DiggService#bury(java.lang.String,
	 *      java.lang.String, java.lang.String)
	 */
	public Story bury(String storyId, String userId, String ip)
			throws StoryNotFoundException, UserNotFoundException {
		return vote(storyId, userId, ip, (short) -1);
	}

	private Story vote(String storyId, String userId, String ip, short voteValue)
			throws StoryNotFoundException, UserNotFoundException {
		Vote vote = voteDao.getVote(storyId, userId);
		if (vote == null) {
			vote = new Vote();
			Story story = storyDao.getStory(storyId);
			if (story == null) {
				throw new StoryNotFoundException();
			}
			User user = userDao.getUser(userId);
			if (user == null) {
				throw new UserNotFoundException();
			}
			vote.setStory(story);
			vote.setVoter(user);
		}
		long rank = vote.getStory().getRank();
		rank -= vote.getValue();
		rank += voteValue;
		vote.getStory().setRank(rank);
		storyDao.saveStory(vote.getStory());

		vote.setDate(new Date());
		vote.setIp(ip);
		vote.setValue(voteValue);
		voteDao.saveVote(vote);

		return vote.getStory();
	}
}
