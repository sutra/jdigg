/**
 * Created on 2008-1-6 上午04:15:50
 */
package com.redv.jdigg.web;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.redv.jdigg.domain.Category;
import com.redv.jdigg.service.DiggService;

/**
 * @author sutra
 * 
 */
public class DiggContextListener implements
		javax.servlet.ServletContextListener {
	private static final String DIGG_SERVICE_BEAN_NAME = "diggService";

	public static final String CATEGORIES_NAME = "categories";

	public static final String CATEGORY_COUNT = "categoryCount";

	public static final String WEBSITE_COUNT = "websiteCount";

	/*
	 * （非 Javadoc）
	 * 
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();
		sc.removeAttribute(CATEGORIES_NAME);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();
		refreshCategoryStatistics(sc);
		refreshStoryStatistics(sc);
	}

	public static void refreshCategoryStatistics(ServletContext sc) {
		DiggService diggService = (DiggService) WebApplicationContextUtils
				.getRequiredWebApplicationContext(sc).getBean(
						DIGG_SERVICE_BEAN_NAME);
		List<Category> categories = diggService.getCategories();
		sc.setAttribute(CATEGORIES_NAME, categories);
		sc.setAttribute(CATEGORY_COUNT, categories.size());
	}

	public static void refreshStoryStatistics(ServletContext sc) {
		DiggService diggService = (DiggService) WebApplicationContextUtils
				.getRequiredWebApplicationContext(sc).getBean(
						DIGG_SERVICE_BEAN_NAME);
		sc.setAttribute(WEBSITE_COUNT, diggService.getStoryCount(null));
	}
}
