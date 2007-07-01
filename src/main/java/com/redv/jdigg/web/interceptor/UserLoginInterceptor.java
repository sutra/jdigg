/**
 * 
 */
package com.redv.jdigg.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.redv.jdigg.Constants;
import com.redv.jdigg.HttpUtil;
import com.redv.jdigg.domain.User;

/**
 * @author <a href="mailto:zhoushuqun@gmail.com">Sutra Zhou</a>
 */
public class UserLoginInterceptor extends HandlerInterceptorAdapter {

	private String login;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String path = "";
		if (request.getContextPath().equals("/")) {
			path = login;
		} else {
			path = request.getContextPath() + login;
		}
		HttpSession session = request.getSession();
		if (session == null) {
			response.sendRedirect(path);
			return false;
		} else {
			User loginUser = (User) session
					.getAttribute(Constants.CURRENT_USER);
			if (loginUser != null) {
				return true;
			}
			session.setAttribute(Constants.ORIGINAL_URL, HttpUtil
					.buildOriginalGETURL(request));
		}
		response.sendRedirect(path);
		return false;
	}
}
