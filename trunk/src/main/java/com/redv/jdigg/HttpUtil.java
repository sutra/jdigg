/**
 * 
 */
package com.redv.jdigg;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.support.WebContentGenerator;

/**
 * 
 * @author <a href="mailto:zhoushuqun@gmail.com">Sutra Zhou</a>s
 * 
 */
public class HttpUtil {

	private HttpUtil() {
	}

	@SuppressWarnings("unchecked")
	public static String buildOriginalURL(HttpServletRequest request) {
		StringBuffer originalURL = request.getRequestURL();
		Map parameters = request.getParameterMap();
		if (parameters != null && parameters.size() > 0) {
			originalURL.append("?");
			for (Iterator<Map.Entry<String, String[]>> iter = parameters
					.entrySet().iterator(); iter.hasNext();) {
				Map.Entry<String, String[]> entry = iter.next();
				for (int i = 0; i < entry.getValue().length; i++) {
					originalURL.append(entry.getKey()).append("=").append(
							entry.getValue()[i]).append("&");
				}
			}
		}
		return originalURL.toString();
	}

	public static String buildOriginalGETURL(HttpServletRequest request) {
		if (WebContentGenerator.METHOD_POST.equals(request.getMethod())) {
			return request.getRequestURL().toString();
		}
		return buildOriginalURL(request);
	}

	public static void printCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				System.out.print("cookie name = [" + cookies[i].getName()
						+ "]\t\t");
				System.out.println("cookie value = [" + cookies[i].getValue());
			}
		}
	}

	public static void printSession(Map session) {
		for (Iterator iterator = session.entrySet().iterator(); iterator
				.hasNext();) {
			Map.Entry entry = (Map.Entry) iterator.next();
			System.out.print("session key = [" + entry.getKey() + "]\t\t");
			System.out.println("session value = [" + entry.getValue() + "]");
		}
	}
}
