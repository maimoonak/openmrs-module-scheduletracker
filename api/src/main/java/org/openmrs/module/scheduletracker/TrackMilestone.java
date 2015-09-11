package org.openmrs.module.scheduletracker;

import java.util.Date;

import org.openmrs.BaseOpenmrsData;

public class TrackMilestone extends BaseOpenmrsData {
	private int trackMilestoneId;
	private Track track;
	private Milestone milestone;
	private Date fulfillmentDate;
	private String status;
	private String reasonClosed;
	private Date alertStartDate;
	private Date alertExpiryDate;
	private Boolean isActive;
	private String actionType;
	
	public TrackMilestone() {

	}
	
	public int getTrackMilestoneId() {
		return trackMilestoneId;
	}

	public void setTrackMilestoneId(int trackMilestoneId) {
		this.trackMilestoneId = trackMilestoneId;
	}

	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}

	public Milestone getMilestone() {
		return milestone;
	}

	public void setMilestone(Milestone milestone) {
		this.milestone = milestone;
	}

	public Date getFulfillmentDate() {
		return fulfillmentDate;
	}

	public void setFulfillmentDate(Date fulfillmentDate) {
		this.fulfillmentDate = fulfillmentDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReasonClosed() {
		return reasonClosed;
	}

	public void setReasonClosed(String reasonClosed) {
		this.reasonClosed = reasonClosed;
	}

	public Date getAlertStartDate() {
		return alertStartDate;
	}

	public void setAlertStartDate(Date alertStartDate) {
		this.alertStartDate = alertStartDate;
	}

	public Date getAlertExpiryDate() {
		return alertExpiryDate;
	}

	public void setAlertExpiryDate(Date alertExpiryDate) {
		this.alertExpiryDate = alertExpiryDate;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public Integer getId() {
		return trackMilestoneId;
	}
	public void setId(Integer id) {
		trackMilestoneId = id;
	}
}
