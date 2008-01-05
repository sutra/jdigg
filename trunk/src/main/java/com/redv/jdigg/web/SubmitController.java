/**
 * 
 */
package com.redv.jdigg.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.redv.jdigg.Constants;
import com.redv.jdigg.StoryAlreadyExistsException;
import com.redv.jdigg.domain.Category;
import com.redv.jdigg.domain.Story;
import com.redv.jdigg.domain.User;
import com.redv.jdigg.service.DiggService;

/**
 * @author <a href="mailto:zhoushuqun@gmail.com">Sutra Zhou</a>
 * 
 */
public class SubmitController extends SimpleFormController {
	private static final Log log = LogFactory.getLog(SubmitController.class);

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
	 * @see org.springframework.web.servlet.mvc.BaseCommandController#initBinder(javax.servlet.http.HttpServletRequest,
	 *      org.springframework.web.bind.ServletRequestDataBinder)
	 */
	@Override
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Category.class, new CategoryEditor(
				this.diggService));
		super.initBinder(request, binder);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see org.springframework.web.servlet.mvc.AbstractFormController#formBackingObject(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		Story story = (Story) super.formBackingObject(request);
		story.setDigger((User) request.getSession().getAttribute(
				Constants.CURRENT_USER));

		request.setAttribute("categories", this.diggService.getCategories());

		return story;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see org.springframework.web.servlet.mvc.BaseCommandController#onBindAndValidate(javax.servlet.http.HttpServletRequest,
	 *      java.lang.Object, org.springframework.validation.BindException)
	 */
	@Override
	protected void onBindAndValidate(HttpServletRequest request,
			Object command, BindException errors) throws Exception {
		super.onBindAndValidate(request, command, errors);
		Story story = (Story) command;
		if (story.getCategory() == null) {
			errors.rejectValue("category", "CategoryRequired",
					"Category is required.");
		}
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(java.lang.Object,
	 *      org.springframework.validation.BindException)
	 */
	@Override
	protected ModelAndView onSubmit(Object command, BindException errors)
			throws Exception {
		Story story = (Story) command;
		log.debug("story.digger: " + story.getDigger().getOpenid());
		try {
			diggService.saveStory(story);
		} catch (StoryAlreadyExistsException ex) {
			errors.rejectValue("url", "StoryAlreadyExistsException",
					"This story already exists.");
		}
		return super.onSubmit(command, errors);
	}

}
