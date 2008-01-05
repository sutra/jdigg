/**
 * Created on 2008-1-5 下午04:41:53
 */
package com.redv.jdigg.dao;

import java.util.List;

import com.redv.jdigg.domain.Category;

/**
 * @author sutra
 * 
 */
public interface CategoryDao {
	Category getCategory(String id);

	Category getCategoryByName(String name);

	List<Category> getCategories();

	void saveCategory(Category category);
}
