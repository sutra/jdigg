/**
 * 
 */
package com.redv.jdigg.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.redv.jdigg.service.DiggService;

/**
 * @author <a href="mailto:zhoushuqun@gmail.com">Sutra Zhou</a>
 * 
 */
public class PopularStoriesController implements Controller {
	private DiggService diggService;

	/**
	 * @param diggService
	 *            要设置的 diggService
	 */
	public void setDiggService(DiggService diggService) {
		this.diggService = diggService;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see org.springframework.web.servlet.mvc.Controller#handleRequest(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int firstResult = NumberUtils.toInt(
				request.getParameter("firstResult"), 0);
		int maxResults = NumberUtils.toInt(request.getParameter("maxResults"),
				15);
		return new ModelAndView("popular-stories", "stories", diggService
				.getRankingStories(firstResult, maxResults));
	}

}
