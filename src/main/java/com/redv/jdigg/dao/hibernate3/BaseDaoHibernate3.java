/**
 * 
 */
package com.redv.jdigg.dao.hibernate3;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author <a href="mailto:zhoushuqun@gmail.com">Sutra Zhou</a>
 * 
 */
public abstract class BaseDaoHibernate3<T> extends HibernateDaoSupport {
	protected final Log log = LogFactory.getLog(this.getClass());

	private Class<T> entityClass;

	public BaseDaoHibernate3() {
		entityClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@SuppressWarnings("unchecked")
	public T get(Serializable id) {
		return (T) getHibernateTemplate().get(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> find(String queryString, Object value) {
		return (List<T>) getHibernateTemplate().find(queryString, value);
	}

	@SuppressWarnings("unchecked")
	public List<T> find(String queryString, Object[] values) {
		return (List<T>) getHibernateTemplate().find(queryString, values);
	}

	@SuppressWarnings("unchecked")
	public List<T> findByExample(Object exampleEntity, int firstResult,
			int maxResults) {
		return (List<T>) getHibernateTemplate().findByExample(exampleEntity,
				firstResult, maxResults);
	}
}
