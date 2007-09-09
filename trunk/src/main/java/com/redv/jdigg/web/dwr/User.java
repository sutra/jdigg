/**
 * 
 */
package com.redv.jdigg.web.dwr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.redv.jdigg.Constants;
import com.redv.jdigg.StoryNotFoundException;
import com.redv.jdigg.UserNotFoundException;
import com.redv.jdigg.UserNotLoginException;
import com.redv.jdigg.domain.Story;
import com.redv.jdigg.service.DiggService;

/**
 * @author sutra
 * 
 */
public class User {
	private DiggService diggService;

	private WebContext webContext;

	private HttpSession session;

	private HttpServletRequest request;

	private com.redv.jdigg.domain.User currentUser;

	public User() throws UserNotLoginException {
		webContext = WebContextFactory.get();
		WebApplicationContext wac = WebApplicationContextUtils
				.getRequiredWebApplicationContext(webContext
						.getServletContext());
		diggService = (DiggService) wac.getBean("diggService");
		session = webContext.getSession(true);
		request = webContext.getHttpServletRequest();

		currentUser = (com.redv.jdigg.domain.User) session
				.getAttribute(Constants.CURRENT_USER);
		if (currentUser == null) {
			throw new UserNotLoginException();
		}
	}

	public Story digg(String storyId) throws StoryNotFoundException,
			UserNotFoundException {
		String ip = request.getRemoteAddr();
		return diggService.digg(storyId, currentUser.getId(), ip);
	}

	public Story bury(String storyId) throws StoryNotFoundException,
			UserNotFoundException {
		String ip = request.getRemoteAddr();
		return diggService.bury(storyId, currentUser.getId(), ip);
	}
}
