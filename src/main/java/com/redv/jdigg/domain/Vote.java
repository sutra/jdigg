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
public class Vote implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5953372209844099655L;

	private Story story;

	private User voter;

	private Date date;

	private short value;

	private String ip;

	/**
	 * 
	 */
	public Vote() {
		story = new Story();
		voter = new User();
		date = new Date();
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

	/**
	 * @return the story
	 */
	public Story getStory() {
		return story;
	}

	/**
	 * @param story
	 *            the story to set
	 */
	public void setStory(Story story) {
		this.story = story;
	}

	/**
	 * @return the voter
	 */
	public User getVoter() {
		return voter;
	}

	/**
	 * @param voter
	 *            the voter to set
	 */
	public void setVoter(User voter) {
		this.voter = voter;
	}

	/**
	 * @return the value
	 */
	public short getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(short value) {
		this.value = value;
	}

	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * @param ip
	 *            the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(this.story)
				.append(this.voter).toHashCode();
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Vote == false) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		Vote rhs = (Vote) obj;
		return new EqualsBuilder().append(story, rhs.story).append(voter,
				rhs.voter).isEquals();
	}

}
