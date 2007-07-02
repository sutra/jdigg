/**
 * Created on 2007-3-20 下午11:46:02
 */
package com.redv.jdigg.web.openid;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openid4java.consumer.ConsumerException;
import org.openid4java.consumer.ConsumerManager;
import org.openid4java.discovery.Identifier;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.redv.jdigg.Constants;
import com.redv.jdigg.domain.User;
import com.redv.jdigg.service.DiggService;

/**
 * @author <a href="mailto:zhoushuqun@gmail.com">Sutra Zhou</a>
 * 
 */
public class LoginController implements Controller {
	private final Log log = LogFactory.getLog(this.getClass());

	private DiggService diggService;

	private Consumer consumer;

	public LoginController() {
		ConsumerManager manager;
		try {
			manager = new ConsumerManager();
		} catch (ConsumerException e) {
			throw new RuntimeException(e);
		}
		consumer = new Consumer(manager);
	}

	/**
	 * @param diggService
	 *            the diggService to set
	 */
	public void setDiggService(DiggService diggService) {
		this.diggService = diggService;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.web.servlet.mvc.Controller#handleRequest(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (StringUtils.equalsIgnoreCase("post", request.getMethod())) {
			log.debug("A http post start.");
			this.consumer.authRequest(request.getParameter("openid_url"),
					request, response);
			return null;
		} else {
			log.debug("A http get start.");
			Identifier id = this.consumer.verifyResponse(request);
			String redirectUrl = (String) request.getSession().getAttribute(
					Constants.ORIGINAL_URL);
			log.debug("redirectUrl: " + redirectUrl);

			if (id != null && StringUtils.isNotEmpty(id.getIdentifier())) {
				User user = diggService.getUserByOpenid(id.getIdentifier());
				// If user is not in our system, add it.
				if (user == null) {
					log.debug("User is not in our system, add it.");
					user = new User();
					user.setOpenid(id.getIdentifier());
					diggService.saveUser(user);
				}
				request.getSession().setAttribute(Constants.CURRENT_USER, user);
				if (StringUtils.isNotBlank(redirectUrl)) {
					response.sendRedirect(redirectUrl);
				} else {
					response.sendRedirect(request.getContextPath());
				}
				return null;
			} else {
				return new ModelAndView("login-fail");
			}
		}
	}
}
