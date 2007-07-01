/**
 * 
 */
package com.redv.jdigg.web;

import org.springframework.web.servlet.mvc.SimpleFormController;

import com.redv.jdigg.domain.Story;
import com.redv.jdigg.service.DiggService;

/**
 * @author <a href="mailto:zhoushuqun@gmail.com">Sutra Zhou</a>
 * 
 */
public class SubmitController extends SimpleFormController {
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
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#doSubmitAction(java.lang.Object)
	 */
	@Override
	protected void doSubmitAction(Object command) throws Exception {
		diggService.saveStory((Story) command);
	}

}
