/**
 * 
 */
package com.redv.jdigg.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.redv.jdigg.Constants;
import com.redv.jdigg.domain.User;
import com.redv.jdigg.service.DiggService;

/**
 * @author <a href="mailto:zhoushuqun@gmail.com">Sutra Zhou</a>
 * 
 */
public class ProfileController extends SimpleFormController {
	private static final Log log = LogFactory.getLog(ProfileController.class);

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
	 * @see org.springframework.web.servlet.mvc.AbstractFormController#formBackingObject(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		return diggService.getUser(((User) request.getSession().getAttribute(
				Constants.CURRENT_USER)).getId());
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#doSubmitAction(java.lang.Object)
	 */
	@Override
	protected void doSubmitAction(Object command) throws Exception {
		User user = (User) command;
		log.debug("user.id: " + user.getId());
		diggService.saveUser(user);
	}
}
