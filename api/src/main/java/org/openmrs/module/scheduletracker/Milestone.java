package org.openmrs.module.scheduletracker;

import org.openmrs.BaseOpenmrsData;

public class Milestone extends BaseOpenmrsData {
	private int milestoneId;
	private Schedule schedule;
	private String name;
	private String early;
	private String earlyAlertOffset;
	private String earlyAlertInterval;
	private Integer earlyAlertCount;
	private String due;
	private String dueAlertOffset;
	private String dueAlertInterval;
	private Integer dueAlertCount;
	private String late;
	private String lateAlertOffset;
	private String lateAlertInterval;
	private Integer lateAlertCount;
	private String max;
	private String maxAlertOffset;
	private String maxAlertInterval;
	private Integer maxAlertCount;
	private String description;
	
	public Milestone() {

	}
	
	public int getMilestoneId() {
		return milestoneId;
	}

	public void setMilestoneId(int milestoneId) {
		this.milestoneId = milestoneId;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEarly() {
		return early;
	}

	public void setEarly(String early) {
		this.early = early;
	}

	public String getEarlyAlertOffset() {
		return earlyAlertOffset;
	}

	public void setEarlyAlertOffset(String earlyAlertOffset) {
		this.earlyAlertOffset = earlyAlertOffset;
	}

	public String getEarlyAlertInterval() {
		return earlyAlertInterval;
	}

	public void setEarlyAlertInterval(String earlyAlertInterval) {
		this.earlyAlertInterval = earlyAlertInterval;
	}

	public Integer getEarlyAlertCount() {
		return earlyAlertCount;
	}

	public void setEarlyAlertCount(Integer earlyAlertCount) {
		this.earlyAlertCount = earlyAlertCount;
	}

	public String getDue() {
		return due;
	}

	public void setDue(String due) {
		this.due = due;
	}

	public String getDueAlertOffset() {
		return dueAlertOffset;
	}

	public void setDueAlertOffset(String dueAlertOffset) {
		this.dueAlertOffset = dueAlertOffset;
	}

	public String getDueAlertInterval() {
		return dueAlertInterval;
	}

	public void setDueAlertInterval(String dueAlertInterval) {
		this.dueAlertInterval = dueAlertInterval;
	}

	public Integer getDueAlertCount() {
		return dueAlertCount;
	}

	public void setDueAlertCount(Integer dueAlertCount) {
		this.dueAlertCount = dueAlertCount;
	}

	public String getLate() {
		return late;
	}

	public void setLate(String late) {
		this.late = late;
	}

	public String getLateAlertOffset() {
		return lateAlertOffset;
	}

	public void setLateAlertOffset(String lateAlertOffset) {
		this.lateAlertOffset = lateAlertOffset;
	}

	public String getLateAlertInterval() {
		return lateAlertInterval;
	}

	public void setLateAlertInterval(String lateAlertInterval) {
		this.lateAlertInterval = lateAlertInterval;
	}

	public Integer getLateAlertCount() {
		return lateAlertCount;
	}

	public void setLateAlertCount(Integer lateAlertCount) {
		this.lateAlertCount = lateAlertCount;
	}

	public String getMax() {
		return max;
	}

	public void setMax(String max) {
		this.max = max;
	}

	public String getMaxAlertOffset() {
		return maxAlertOffset;
	}

	public void setMaxAlertOffset(String maxAlertOffset) {
		this.maxAlertOffset = maxAlertOffset;
	}

	public String getMaxAlertInterval() {
		return maxAlertInterval;
	}

	public void setMaxAlertInterval(String maxAlertInterval) {
		this.maxAlertInterval = maxAlertInterval;
	}

	public Integer getMaxAlertCount() {
		return maxAlertCount;
	}

	public void setMaxAlertCount(Integer maxAlertCount) {
		this.maxAlertCount = maxAlertCount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getId() {
		return milestoneId;
	}
	public void setId(Integer id) {
		milestoneId = id;
	}
}
