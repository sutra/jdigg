/**
 * 
 */
package com.redv.jdigg.domain;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * @author <a href="mailto:zhoushuqun@gmail.com">Sutra Zhou</a>
 * 
 */
public class Story implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6701809656199379709L;

	private String id;

	private String url;

	private String title;

	private String body;

	private Category category;

	private User digger;

	private Date date;

	private long votes;

	private long hits;

	private long rank;

	/**
	 * 
	 */
	public Story() {
		category = new Category();
		digger = new User();
		date = new Date();
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

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
	 * @return category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            要设置的 category
	 */
	public void setCategory(Category category) {
		this.category = category;
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
		return this.date == null ? null : (Date) this.date.clone();
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date == null ? null : (Date) date.clone();
	}

	/**
	 * @return votes
	 */
	public long getVotes() {
		return votes;
	}

	/**
	 * @param votes
	 *            要设置的 votes
	 */
	public void setVotes(long votes) {
		this.votes = votes;
	}

	/**
	 * @return hits
	 */
	public long getHits() {
		return hits;
	}

	/**
	 * @param hits
	 *            要设置的 hits
	 */
	public void setHits(long hits) {
		this.hits = hits;
	}

	/**
	 * @return the rank
	 */
	public long getRank() {
		return rank;
	}

	/**
	 * @param rank
	 *            the rank to set
	 */
	public void setRank(long rank) {
		this.rank = rank;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(this.id).toHashCode();
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Story == false) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		Story rhs = (Story) obj;
		return new EqualsBuilder().append(id, rhs.id).isEquals();
	}

}
