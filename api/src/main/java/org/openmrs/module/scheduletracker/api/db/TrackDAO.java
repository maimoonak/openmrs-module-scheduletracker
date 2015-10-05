package org.openmrs.module.scheduletracker.api.db;

import java.util.Date;
import java.util.List;

import org.openmrs.module.scheduletracker.Track;

public interface TrackDAO extends DAO<Track> {
	List<Track> search(String schedule, Integer[] beneficiary, Date from, Date to, String status,
			  boolean readonly, int firstResult, int maxResults, String[] mappingsToJoin);
}
