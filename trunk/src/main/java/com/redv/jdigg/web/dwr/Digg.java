/**
 * 
 */
package com.redv.jdigg.web.dwr;

import java.util.List;

import com.redv.jdigg.domain.Story;
import com.redv.jdigg.service.DiggService;

/**
 * @author <a href="mailto:zhoushuqun@gmail.com">Sutra Zhou</a>
 * 
 */
public class Digg {
	private DiggService diggService;

	/**
	 * @param diggService
	 *            要设置的 diggService
	 */
	public void setDiggService(DiggService diggService) {
		this.diggService = diggService;
	}

	public Story getStory(String id) {
		return diggService.getStory(id);
	}

	public List<Story> getRankingStories(Story exampleStory, int firstResult,
			int maxResults) {
		return diggService.getRankingStories(exampleStory, firstResult,
				maxResults);
	}
}
