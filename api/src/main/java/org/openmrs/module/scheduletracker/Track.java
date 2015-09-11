package org.openmrs.module.scheduletracker;

import java.sql.Time;
import java.util.Date;
import java.util.Set;

import org.openmrs.BaseOpenmrsData;
import org.openmrs.Person;

public class Track extends BaseOpenmrsData {
	private int trackId;
	private Schedule schedule;
	private Person recipient;
	private Person beneficiary;
	private Time preferredAlertTime;
	private Date referenceDate;
	private String referenceDateType;
	private Date dateEnrolled;
	private Milestone startingMilestone;
	private Date earlyStartDate;
	private Date dueStartDate;
	private Date lateStartDate;
	private Date maxStartDate;
	private Milestone currentMilestone;
	private String status;
	private Set<TrackMilestone> milestones;
	private String beneficiaryRole;
	private String recipientRole;
	
	public Track() {

	}
	
	public int getTrackId() {
		return trackId;
	}

	public void setTrackId(int trackId) {
		this.trackId = trackId;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public Person getRecipient() {
		return recipient;
	}

	public void setRecipient(Person recipient) {
		this.recipient = recipient;
	}

	public Person getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(Person beneficiary) {
		this.beneficiary = beneficiary;
	}

	public Time getPreferredAlertTime() {
		return preferredAlertTime;
	}

	public void setPreferredAlertTime(Time preferredAlertTime) {
		this.preferredAlertTime = preferredAlertTime;
	}

	public Date getReferenceDate() {
		return referenceDate;
	}

	public void setReferenceDate(Date referenceDate) {
		this.referenceDate = referenceDate;
	}

	public String getReferenceDateType() {
		return referenceDateType;
	}

	public void setReferenceDateType(String referenceDateType) {
		this.referenceDateType = referenceDateType;
	}

	public Date getDateEnrolled() {
		return dateEnrolled;
	}

	public void setDateEnrolled(Date dateEnrolled) {
		this.dateEnrolled = dateEnrolled;
	}

	public Milestone getStartingMilestone() {
		return startingMilestone;
	}

	public void setStartingMilestone(Milestone startingMilestone) {
		this.startingMilestone = startingMilestone;
	}

	public Date getEarlyStartDate() {
		return earlyStartDate;
	}

	public void setEarlyStartDate(Date earlyStartDate) {
		this.earlyStartDate = earlyStartDate;
	}

	public Date getDueStartDate() {
		return dueStartDate;
	}

	public void setDueStartDate(Date dueStartDate) {
		this.dueStartDate = dueStartDate;
	}

	public Date getLateStartDate() {
		return lateStartDate;
	}

	public void setLateStartDate(Date lateStartDate) {
		this.lateStartDate = lateStartDate;
	}

	public Date getMaxStartDate() {
		return maxStartDate;
	}

	public void setMaxStartDate(Date maxStartDate) {
		this.maxStartDate = maxStartDate;
	}

	public Milestone getCurrentMilestone() {
		return currentMilestone;
	}

	public void setCurrentMilestone(Milestone currentMilestone) {
		this.currentMilestone = currentMilestone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<TrackMilestone> getMilestones() {
		return milestones;
	}

	public void setMilestones(Set<TrackMilestone> milestones) {
		this.milestones = milestones;
	}

	public String getBeneficiaryRole() {
		return beneficiaryRole;
	}

	public void setBeneficiaryRole(String beneficiaryRole) {
		this.beneficiaryRole = beneficiaryRole;
	}

	public String getRecipientRole() {
		return recipientRole;
	}

	public void setRecipientRole(String recipientRole) {
		this.recipientRole = recipientRole;
	}

	public Integer getId() {
		return trackId;
	}
	public void setId(Integer id) {
		trackId = id;
	}
}
