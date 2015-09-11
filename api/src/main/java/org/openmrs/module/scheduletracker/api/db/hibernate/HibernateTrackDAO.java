package org.openmrs.module.scheduletracker.api.db.hibernate;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.openmrs.module.scheduletracker.Track;
import org.openmrs.module.scheduletracker.api.db.TrackDAO;

public class HibernateTrackDAO implements TrackDAO{

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
	public List<Track> getAll(boolean readonly, int firstResult, int maxResults, String[] mappingsToJoin) {
		Criteria cri = this.sessionFactory.getCurrentSession().createCriteria(Track.class)
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

		List<Track> list = cri.setFirstResult(firstResult).setMaxResults(maxResults).list();
	    return list;
	}

	@SuppressWarnings("unchecked")
	public Track get(int id, boolean readonly) {
		Criteria cri = this.sessionFactory.getCurrentSession().createCriteria(Track.class)
			      .setReadOnly(readonly);
	    
		cri.add(Restrictions.eq("trackId", id));
		
	    totalRows = (Long)cri.setProjection(Projections.rowCount()).uniqueResult();
	    
		cri.setProjection(null).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

		List<Track> list = cri.list();
	    return list.size()>0?list.get(0):null;
	}

	public Serializable save(Track obj) {
		return sessionFactory.getCurrentSession().save(obj);
	}

	public void update(Track obj) {
		sessionFactory.getCurrentSession().update(obj);
	}

	public void delete(Track obj) {
		sessionFactory.getCurrentSession().delete(obj);
	}

	@SuppressWarnings("unchecked")
	public List<Track> search(String schedule, Integer[] beneficiary,
			Integer[] recipient, Date from, Date to, String status,
			boolean readonly, int firstResult, int maxResults, String[] mappingsToJoin) {
		Criteria cri = this.sessionFactory.getCurrentSession().createCriteria(Track.class)
			      .setReadOnly(readonly);
	    
		if(schedule != null){
			cri.createAlias("schedule", "sch").add(Restrictions.eq("sch.name", schedule));
		}

		if(beneficiary != null) {
			cri.createAlias("beneficiary", "b").add(Restrictions.in("b.personId", beneficiary));
		}

		if(recipient != null) {
			cri.createAlias("recipient", "r").add(Restrictions.in("r.personId", recipient));
		}

		if(from != null && to != null){
			cri.add(Restrictions.disjunction()
					.add(Restrictions.between("dateEnrolled", from, to))
					.add(Restrictions.between("earlyStartDate", from, to))
					.add(Restrictions.between("dueStartDate", from, to))
					.add(Restrictions.between("lateStartDate", from, to))
					.add(Restrictions.between("maxStartDate", from, to)));
		}
		if(status != null){
			cri.add(Restrictions.eq("status", status));
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

		List<Track> list = cri.setFirstResult(firstResult).setMaxResults(maxResults).list();
	    return list;
	}

	@SuppressWarnings("unchecked")
	public Track getByUuid(String uuid, boolean readonly) {
		Criteria cri = this.sessionFactory.getCurrentSession().createCriteria(Track.class)
			      .setReadOnly(readonly);
	    
		cri.add(Restrictions.eq("uuid", uuid));
		
	    totalRows = (Long)cri.setProjection(Projections.rowCount()).uniqueResult();
	    
		cri.setProjection(null).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

		List<Track> list = cri.list();
	    return list.size()>0?list.get(0):null;
	}
}
