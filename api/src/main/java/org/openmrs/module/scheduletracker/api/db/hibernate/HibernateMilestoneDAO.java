package org.openmrs.module.scheduletracker.api.db.hibernate;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.openmrs.module.scheduletracker.Milestone;
import org.openmrs.module.scheduletracker.api.db.MilestoneDAO;

public class HibernateMilestoneDAO implements MilestoneDAO{

	protected final Log log = LogFactory.getLog(getClass());
	private SessionFactory sessionFactory;
	private long totalRows;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}
	  
	public long LAST_QUERY_TOTAL_ROWS() {
		return totalRows;
	}

	@SuppressWarnings("unchecked")
	public List<Milestone> getAll(boolean readonly, int firstResult, int maxResults, String[] mappingsToJoin) {
		Criteria cri = this.sessionFactory.getCurrentSession().createCriteria(Milestone.class)
			      .setReadOnly(readonly);
	    if (mappingsToJoin != null)
	    {
	      String[] arrayOfString;
	      int j = (arrayOfString = mappingsToJoin).length;
	      for (int i = 0; i < j; i++)
	      {
	        String mapping = arrayOfString[i];
	        cri.setFetchMode(mapping, FetchMode.JOIN);
	      }
	    }
	    
	    totalRows = (Long)cri.setProjection(Projections.rowCount()).uniqueResult();
	    
		cri.setProjection(null).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

		List<Milestone> list = cri.setFirstResult(firstResult).setMaxResults(maxResults).list();
	    return list;
	}

	@SuppressWarnings("unchecked")
	public Milestone get(int id, boolean readonly) {
		Criteria cri = this.sessionFactory.getCurrentSession().createCriteria(Milestone.class)
			      .setReadOnly(readonly);
	    
		cri.add(Restrictions.eq("milestoneId", id));
		
	    totalRows = (Long)cri.setProjection(Projections.rowCount()).uniqueResult();
	    
		cri.setProjection(null).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

		List<Milestone> list = cri.list();
	    return list.size()>0?list.get(0):null;
	}

	public Serializable save(Milestone obj) {
		return sessionFactory.getCurrentSession().save(obj);
	}

	public void update(Milestone obj) {
		sessionFactory.getCurrentSession().update(obj);
	}

	public void delete(Milestone obj) {
		sessionFactory.getCurrentSession().delete(obj);
	}

	@SuppressWarnings("unchecked")
	public Milestone get(String name, boolean readonly) {
		Criteria cri = this.sessionFactory.getCurrentSession().createCriteria(Milestone.class)
			      .setReadOnly(readonly);
	    
		cri.add(Restrictions.eq("name", name));
		
	    totalRows = (Long)cri.setProjection(Projections.rowCount()).uniqueResult();
	    
		cri.setProjection(null).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

		List<Milestone> list = cri.list();
	    return list.size()>0?list.get(0):null;
	}

	@SuppressWarnings("unchecked")
	public List<Milestone> search(String schedule, boolean readonly, int firstResult, int maxResults, String[] mappingsToJoin) {
		Criteria cri = this.sessionFactory.getCurrentSession().createCriteria(Milestone.class)
			      .setReadOnly(readonly);
	    
		cri.createAlias("schedule", "sch").add(Restrictions.eq("sch.name", schedule));
		
		if (mappingsToJoin != null)
	    {
	      String[] arrayOfString;
	      int j = (arrayOfString = mappingsToJoin).length;
	      for (int i = 0; i < j; i++)
	      {
	        String mapping = arrayOfString[i];
	        cri.setFetchMode(mapping, FetchMode.JOIN);
	      }
	    }
		
	    totalRows = (Long)cri.setProjection(Projections.rowCount()).uniqueResult();
	    
		cri.setProjection(null).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

		List<Milestone> list = cri.setFirstResult(firstResult).setMaxResults(maxResults).list();
	    return list;
	}

	@SuppressWarnings("unchecked")
	public Milestone getByUuid(String uuid, boolean readonly) {
		Criteria cri = this.sessionFactory.getCurrentSession().createCriteria(Milestone.class)
			      .setReadOnly(readonly);
	    
		cri.add(Restrictions.eq("uuid", uuid));
		
	    totalRows = (Long)cri.setProjection(Projections.rowCount()).uniqueResult();
	    
		cri.setProjection(null).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

		List<Milestone> list = cri.list();
	    return list.size()>0?list.get(0):null;
	}
}
