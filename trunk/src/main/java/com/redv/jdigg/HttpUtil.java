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

	public static String buildOriginalURL(HttpServletRequest request) {
		StringBuffer originalURL = request.getRequestURL();
		Map parameters = request.getParameterMap();
		if (parameters != null && parameters.size() > 0) {
			originalURL.append("?");
			for (Iterator iter = parameters.keySet().iterator(); iter.hasNext();) {
				String key = (String) iter.next();
				String[] values = (String[]) parameters.get(key);
				for (int i = 0; i < values.length; i++) {
					originalURL.append(key).append("=").append(values[i])
							.append("&");
				}
			}
		}
		return originalURL.toString();
	}

	public static String buildOriginalGETURL(HttpServletRequest request) {
		StringBuffer originalURL = request.getRequestURL();
		if (WebContentGenerator.METHOD_POST.equals(request.getMethod())) {
			return originalURL.toString();
		}
		Map parameters = request.getParameterMap();
		if (parameters != null && parameters.size() > 0) {
			originalURL.append("?");
			for (Iterator iter = parameters.keySet().iterator(); iter.hasNext();) {
				String key = (String) iter.next();
				String[] values = (String[]) parameters.get(key);
				for (int i = 0; i < values.length; i++) {
					originalURL.append(key).append("=").append(values[i])
							.append("&");
				}
			}
		}
		return originalURL.toString();
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
