package org.openmrs.module.scheduletracker.api.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.scheduletracker.Track;
import org.openmrs.module.scheduletracker.TrackMilestone;
import org.openmrs.module.scheduletracker.api.TrackerService;
import org.openmrs.module.scheduletracker.api.db.TrackDAO;
import org.openmrs.module.scheduletracker.api.db.TrackMilestoneDAO;

public class TrackerServiceImpl extends BaseOpenmrsService implements TrackerService{

	private TrackDAO trackDAO;
	private TrackMilestoneDAO trackMilestoneDAO;
	
	public TrackDAO getTrackDAO() {
		return trackDAO;
	}
	public void setTrackDAO(TrackDAO trackDAO) {
		this.trackDAO = trackDAO;
	}
	public TrackMilestoneDAO getTrackMilestoneDAO() {
		return trackMilestoneDAO;
	}
	public void setTrackMilestoneDAO(TrackMilestoneDAO trackMilestoneDAO) {
		this.trackMilestoneDAO = trackMilestoneDAO;
	}
	
	public Long LAST_QUERY_TOTAL_ROWS(Class<?> clazz) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Track> getAllTrack(boolean readonly, int firstResult, int maxResults, String[] mappingsToJoin) {
		return trackDAO.getAll(readonly, firstResult, maxResults, mappingsToJoin);
	}
	public Track getTrack(int id, boolean readonly) {
		return trackDAO.get(id, readonly);
	}

	public Serializable saveTrack(Track track) {
		return trackDAO.save(track);
	}
	public void updateTrack(Track track) {
		trackDAO.update(track);
	}
	public void deleteTrack(Track track) {
		trackDAO.delete(track);
	}
	public List<Track> searchTrack(String schedule, Integer[] beneficiary, Date from, Date to, String status,
			boolean readonly, int firstResult, int maxResults, String[] mappingsToJoin) {
		return trackDAO.search(schedule, beneficiary, from, to, status, readonly, firstResult, maxResults, mappingsToJoin);
	}
	
	public List<TrackMilestone> getAllTrackMilestone(boolean readonly, int firstResult, int maxResults, String[] mappingsToJoin) {
		return trackMilestoneDAO.getAll(readonly, firstResult, maxResults, mappingsToJoin);
	}
	public TrackMilestone getTrackMilestone(int id, boolean readonly) {
		return trackMilestoneDAO.get(id, readonly);
	}
	public Serializable saveTrackMilestone(TrackMilestone trackMilestone) {
		return trackMilestoneDAO.save(trackMilestone);
	}
	public void updateTrackMilestone(TrackMilestone trackMilestone) {
		trackMilestoneDAO.update(trackMilestone);
	}
	public void deleteTrackMilestone(TrackMilestone trackMilestone) {
		trackMilestoneDAO.delete(trackMilestone);
	}
	public List<TrackMilestone> searchTrackMilestone(String schedule, Integer[] recipient, Integer[] beneficiary, Date from, Date to, 
			Date enrollfrom, Date enrollto, String enrollStatus, String alertStatus, boolean readonly, int firstResult, int maxResults, String[] mappingsToJoin) {
		//TODO
		return trackMilestoneDAO.search(schedule, recipient, beneficiary, from, to, enrollfrom, enrollto, enrollStatus, alertStatus, readonly, firstResult, maxResults, mappingsToJoin);
	}
	public List<TrackMilestone> getTrackMilestoneBySchedule(int schedule,
			boolean readonly, int firstResult, int maxResults, String[] mappingsToJoin) {
		return trackMilestoneDAO.getBySchedule(schedule, readonly, firstResult, maxResults, mappingsToJoin);
	}
	public List<TrackMilestone> getTrackMilestoneByTrack(int track, boolean readonly) {
		return trackMilestoneDAO.getByTrack(track, readonly);
	}
	public List<TrackMilestone> getTrackMilestoneByMilestone(int milestone,
			boolean readonly, int firstResult, int maxResults, String[] mappingsToJoin) {
		return trackMilestoneDAO.getByMilestone(milestone, readonly, firstResult, maxResults, mappingsToJoin);
	}
	public Track getTrackByUuid(String uuid, boolean readonly) {
		return trackDAO.getByUuid(uuid, readonly);
	}
	public TrackMilestone getTrackMilestoneByUuid(String uuid, boolean readonly) {
		return trackMilestoneDAO.getByUuid(uuid, readonly);
	}
}
