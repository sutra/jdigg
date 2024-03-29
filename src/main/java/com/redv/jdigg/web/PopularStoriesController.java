/**
 * 
 */
package com.redv.jdigg.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.redv.jdigg.domain.Category;
import com.redv.jdigg.domain.Story;
import com.redv.jdigg.service.DiggService;

/**
 * @author <a href="mailto:zhoushuqun@gmail.com">Sutra Zhou</a>
 * 
 */
public abstract class PopularStoriesController implements Controller {
	protected DiggService diggService;

	protected String view;

	/**
	 * @param diggService
	 *            要设置的 diggService
	 */
	public void setDiggService(DiggService diggService) {
		this.diggService = diggService;
	}

	/**
	 * @param view
	 *            要设置的 view
	 */
	public void setView(String view) {
		this.view = view;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see org.springframework.web.servlet.mvc.Controller#handleRequest(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();

		int firstResult = NumberUtils.toInt(
				request.getParameter("firstResult"), 0);
		int maxResults = NumberUtils.toInt(request.getParameter("maxResults"),
				15);

		model.put("firstResult", firstResult);
		model.put("maxResults", maxResults);

		Category category = null;
		String categoryName = request.getParameter("categoryName");
		if (categoryName != null) {
			category = this.diggService.getCategoryByName(categoryName);
			model.put("category", category);
		}
		model.put("stories", getStories(category, firstResult, maxResults));
		return new ModelAndView(this.getView(), model);
	}

	protected String getView() {
		return view;
	}

	protected abstract List<Story> getStories(Category category,
			int firstResult, int maxResults);
}
