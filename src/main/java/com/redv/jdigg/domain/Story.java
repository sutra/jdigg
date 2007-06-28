/**
 * 
 */
package com.redv.jdigg.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author <a href="mailto:zhoushuqun@gmail.com">Sutra Zhou</a>
 * 
 */
public class Story implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6701809656199379709L;

	private String url;

	private String title;

	private String body;

	private User digger;

	private Date date;

	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * @param body
	 *            the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the digger
	 */
	public User getDigger() {
		return digger;
	}

	/**
	 * @param digger
	 *            the digger to set
	 */
	public void setDigger(User digger) {
		this.digger = digger;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

}
