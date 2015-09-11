package org.openmrs.module.scheduletracker.api;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.openmrs.api.OpenmrsService;
import org.openmrs.module.scheduletracker.Track;
import org.openmrs.module.scheduletracker.TrackMilestone;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TrackerService extends OpenmrsService{
	Long LAST_QUERY_TOTAL_ROWS(Class<?> clazz);

	List<Track> getAllTrack(boolean readonly, int firstResult, int maxResults, String[] mappingsToJoin);
	Track getTrack(int id, boolean readonly);
	Track getTrackByUuid(String uuid, boolean readonly);
	Serializable saveTrack(Track track);
	void updateTrack(Track track);
	void deleteTrack(Track track);
	List<Track> searchTrack(String schedule, Integer[] beneficiary,
			Integer[] recipient, Date from, Date to, String status,
			boolean readonly, int firstResult, int maxResults, String[] mappingsToJoin);
	
	List<TrackMilestone> getAllTrackMilestone(boolean readonly, int firstResult, int maxResults, String[] mappingsToJoin);
	TrackMilestone getTrackMilestone(int id, boolean readonly);
	TrackMilestone getTrackMilestoneByUuid(String uuid, boolean readonly);
	Serializable saveTrackMilestone(TrackMilestone trackMilestone);
	void updateTrackMilestone(TrackMilestone trackMilestone);
	void deleteTrackMilestone(TrackMilestone trackMilestone);
	List<TrackMilestone> searchTrackMilestone(String schedule, Integer[] beneficiary,
			Integer[] recipient, Date from, Date to, String status,
			boolean readonly, int firstResult, int maxResults, String[] mappingsToJoin);
	List<TrackMilestone> getTrackMilestoneBySchedule(int schedule, boolean readonly,
			int firstResult, int maxResults, String[] mappingsToJoin);
	List<TrackMilestone> getTrackMilestoneByTrack(int track, boolean readonly);
	List<TrackMilestone> getTrackMilestoneByMilestone(int milestone, boolean readonly,
			int firstResult, int maxResults, String[] mappingsToJoin);
}
