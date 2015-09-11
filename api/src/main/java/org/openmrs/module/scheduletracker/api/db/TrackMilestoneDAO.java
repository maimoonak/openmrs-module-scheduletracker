package org.openmrs.module.scheduletracker.api.db;

import java.util.Date;
import java.util.List;

import org.openmrs.module.scheduletracker.TrackMilestone;

public interface TrackMilestoneDAO extends DAO<TrackMilestone>{
	List<TrackMilestone> getBySchedule(int schedule, boolean readonly, int firstResult, int maxResults, String[] mappingsToJoin);

	List<TrackMilestone> getByTrack(int track, boolean readonly);

	List<TrackMilestone> getByMilestone(int milestone, boolean readonly, int firstResult, int maxResults, String[] mappingsToJoin);

	List<TrackMilestone> search(String schedule, Integer[] beneficiary,
			Integer[] recipient, Date from, Date to, String status,
			boolean readonly, int firstResult, int maxResults, String[] mappingsToJoin);
}
