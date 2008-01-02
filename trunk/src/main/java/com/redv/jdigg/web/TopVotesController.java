/**
 * Created on 2008-1-2 下午12:49:51
 */
package com.redv.jdigg.web;

import java.util.List;

import com.redv.jdigg.domain.Story;

/**
 * @author sutra
 * 
 */
public class TopVotesController extends PopularStoriesController {
	/*
	 * （非 Javadoc）
	 * 
	 * @see com.redv.jdigg.web.PopularStoriesController#getStories(int, int)
	 */
	@Override
	protected List<Story> getStories(int firstResult, int maxResults) {
		return this.diggService.getVotingStories(firstResult, maxResults);
	}
}
