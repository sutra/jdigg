/**
 * Created on 2008-1-2 下午12:49:51
 */
package com.redv.jdigg.web;

import java.util.List;

import com.redv.jdigg.domain.Category;
import com.redv.jdigg.domain.Story;

/**
 * @author sutra
 * 
 */
public class LastSubmissionsController extends PopularStoriesController {
	/*
	 * （非 Javadoc）
	 * 
	 * @see com.redv.jdigg.web.PopularStoriesController#getStories(com.redv.jdigg.domain.Category,
	 *      int, int)
	 */
	@Override
	protected List<Story> getStories(Category category, int firstResult,
			int maxResults) {
		return this.diggService.getLastSubmissionsStories(category,
				firstResult, maxResults);
	}
}
