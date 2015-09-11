package org.openmrs.module.scheduletracker;

import java.util.Set;

import org.openmrs.BaseOpenmrsData;

public class Schedule extends BaseOpenmrsData {
	
	public enum ScheduleType{
		MILESTONE_BASED,
		REFERENCE_DATE_BASED
	}

	private int scheduleId;
	private String name;
	private String referenceDateType;
	private String recipientType;
	private Set<Dependency> dependencies;
	private Set<Milestone> milestones;
	private String type;
	private String description;
	
	public Schedule() {

	}
	
	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReferenceDateType() {
		return referenceDateType;
	}

	public void setReferenceDateType(String referenceDateType) {
		this.referenceDateType = referenceDateType;
	}

	public String getRecipientType() {
		return recipientType;
	}

	public void setRecipientType(String recipientType) {
		this.recipientType = recipientType;
	}

	public Set<Dependency> getDependencies() {
		return dependencies;
	}

	public void setDependencies(Set<Dependency> dependencies) {
		this.dependencies = dependencies;
	}

	public Set<Milestone> getMilestones() {
		return milestones;
	}

	public void setMilestones(Set<Milestone> milestones) {
		this.milestones = milestones;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getId() {
		return scheduleId;
	}
	public void setId(Integer id) {
		scheduleId = id;
	}
}
