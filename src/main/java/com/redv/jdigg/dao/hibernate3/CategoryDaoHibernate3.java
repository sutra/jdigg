/**
 * Created on 2008-1-5 下午04:43:25
 */
package com.redv.jdigg.dao.hibernate3;

import java.util.List;

import com.redv.jdigg.dao.CategoryDao;
import com.redv.jdigg.domain.Category;

/**
 * @author sutra
 * 
 */
public class CategoryDaoHibernate3 extends BaseDaoHibernate3<Category>
		implements CategoryDao {

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.redv.jdigg.dao.CategoryDao#getCategory(java.lang.String)
	 */
	public Category getCategory(String id) {
		return get(id);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.redv.jdigg.dao.CategoryDao#getCategoryByName(java.lang.String)
	 */
	public Category getCategoryByName(String name) {
		List<Category> categories = find("from Category where name = ?", name);
		if (categories.isEmpty()) {
			return null;
		} else {
			return categories.get(0);
		}
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.redv.jdigg.dao.CategoryDao#getCategories()
	 */
	public List<Category> getCategories() {
		return find("from Category", null);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.redv.jdigg.dao.CategoryDao#saveCategory(com.redv.jdigg.domain.Category)
	 */
	public void saveCategory(Category category) {
		this.getHibernateTemplate().saveOrUpdate(category);
	}

}
