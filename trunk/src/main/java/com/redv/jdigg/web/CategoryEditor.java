/**
 * Created on 2008-1-6 上午01:02:15
 */
package com.redv.jdigg.web;

import java.beans.PropertyEditorSupport;

import com.redv.jdigg.domain.Category;
import com.redv.jdigg.service.DiggService;

/**
 * @author sutra
 * 
 */
public class CategoryEditor extends PropertyEditorSupport {
	private DiggService diggService;

	/**
	 * @param diggService
	 */
	public CategoryEditor(DiggService diggService) {
		this.diggService = diggService;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.beans.PropertyEditorSupport#getAsText()
	 */
	@Override
	public String getAsText() {
		if (getValue() == null) {
			return "";
		}
		return ((Category) getValue()).getId();
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.beans.PropertyEditorSupport#setAsText(java.lang.String)
	 */
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(this.diggService.getCategory(text));
	}

}
