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
import org.openmrs.module.scheduletracker.Schedule;
import org.openmrs.module.scheduletracker.api.db.ScheduleDAO;

public class HibernateScheduleDAO implements ScheduleDAO{

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
	public List<Schedule> getAll(boolean readonly, int firstResult, int maxResults, String[] mappingsToJoin) {
		Criteria cri = this.sessionFactory.getCurrentSession().createCriteria(Schedule.class)
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

		List<Schedule> list = cri.setFirstResult(firstResult).setMaxResults(maxResults).list();
	    return list;
	}

	@SuppressWarnings("unchecked")
	public Schedule get(int id, boolean readonly) {
		Criteria cri = this.sessionFactory.getCurrentSession().createCriteria(Schedule.class)
			      .setReadOnly(readonly);
	    
		cri.add(Restrictions.eq("scheduleId", id));
		
	    totalRows = (Long)cri.setProjection(Projections.rowCount()).uniqueResult();
	    
		cri.setProjection(null).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

		List<Schedule> list = cri.list();
	    return list.size()>0?list.get(0):null;
	}

	public Serializable save(Schedule obj) {
		return sessionFactory.getCurrentSession().save(obj);
	}

	public void update(Schedule obj) {
		sessionFactory.getCurrentSession().update(obj);
	}

	public void delete(Schedule obj) {
		sessionFactory.getCurrentSession().delete(obj);
	}

	@SuppressWarnings("unchecked")
	public Schedule get(String name, boolean readonly) {
		Criteria cri = this.sessionFactory.getCurrentSession().createCriteria(Schedule.class)
			      .setReadOnly(readonly);
	    
		cri.add(Restrictions.eq("name", name));
		
	    totalRows = (Long)cri.setProjection(Projections.rowCount()).uniqueResult();
	    
		cri.setProjection(null).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

		List<Schedule> list = cri.list();
	    return list.size()>0?list.get(0):null;
	}

	@SuppressWarnings("unchecked")
	public List<Schedule> search(String type, String recipientType,
			boolean readonly, int firstResult, int maxResults, String[] mappingsToJoin) {
		Criteria cri = this.sessionFactory.getCurrentSession().createCriteria(Schedule.class)
			      .setReadOnly(readonly);
	    
		if(type != null) {
			cri.add(Restrictions.eq("type", type));
		}

		if(recipientType != null){
			cri.add(Restrictions.eq("recipientType", recipientType));
		}

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

		List<Schedule> list = cri.setFirstResult(firstResult).setMaxResults(maxResults).list();
	    return list;
	}

	@SuppressWarnings("unchecked")
	public Schedule getByUuid(String uuid, boolean readonly) {
		Criteria cri = this.sessionFactory.getCurrentSession().createCriteria(Schedule.class)
			      .setReadOnly(readonly);
	    
		cri.add(Restrictions.eq("uuid", uuid));
		
	    totalRows = (Long)cri.setProjection(Projections.rowCount()).uniqueResult();
	    
		cri.setProjection(null).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

		List<Schedule> list = cri.list();
	    return list.size()>0?list.get(0):null;
	}
}
