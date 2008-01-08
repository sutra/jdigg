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

	private String loginPath;

	/**
	 * Set the login path.
	 * 
	 * @param loginPath
	 *            the login path
	 */
	public void setLoginPath(String loginPath) {
		this.loginPath = loginPath;
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
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute(Constants.CURRENT_USER);
		if (loginUser != null) {
			return true;
		} else {
			session.setAttribute(Constants.ORIGINAL_URL, HttpUtil
					.buildOriginalGETURL(request));
			String loginUrl = request.getContextPath() + loginPath;
			response.sendRedirect(response.encodeRedirectURL(loginUrl));
			return false;
		}
	}
}
