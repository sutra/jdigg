/**
 * Created on 2008-1-6 上午02:13:14
 */
package com.redv.jdigg.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.redv.jdigg.StoryNotFoundException;
import com.redv.jdigg.service.DiggService;

/**
 * @author sutra
 * 
 */
public class HomepageController extends MultiActionController {
	private DiggService diggService;

	/**
	 * @param diggService
	 *            要设置的 diggService
	 */
	public void setDiggService(DiggService diggService) {
		this.diggService = diggService;
	}

	/**
	 * Homepage.
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView homepage(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();
		model
				.put("stories", diggService.getLastSubmissionsStories(null, 0,
						10));

		return new ModelAndView("homepage", model);
	}

	/**
	 * All categories.
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView categories(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();
		return new ModelAndView("categories", model);
	}

	/**
	 * Hit the story.
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws StoryNotFoundException
	 */
	public ModelAndView hit(HttpServletRequest request,
			HttpServletResponse response) throws StoryNotFoundException {
		String storyId = request.getParameter("id");
		if (storyId != null) {
			this.diggService.hit(storyId);
		}
		return null;
	}
}
