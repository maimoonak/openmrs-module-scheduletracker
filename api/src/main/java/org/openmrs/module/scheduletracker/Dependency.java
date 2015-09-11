package org.openmrs.module.scheduletracker;

import org.openmrs.BaseOpenmrsData;

public class Dependency extends BaseOpenmrsData {
	private int dependencyId;
	private Schedule schedule;
	private DependencyType dependencyType;
	private String dependencyKey;
	private String dependencyValue;
	private String complexRule;
	private String description;
	
	public Dependency() {
		
	}
	
	public int getDependencyId() {
		return dependencyId;
	}
	public void setDependencyId(int dependencyId) {
		this.dependencyId = dependencyId;
	}
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	public DependencyType getDependencyType() {
		return dependencyType;
	}
	public void setDependencyType(DependencyType dependencyType) {
		this.dependencyType = dependencyType;
	}
	public String getDependencyKey() {
		return dependencyKey;
	}
	public void setDependencyKey(String dependencyKey) {
		this.dependencyKey = dependencyKey;
	}
	public String getDependencyValue() {
		return dependencyValue;
	}
	public void setDependencyValue(String dependencyValue) {
		this.dependencyValue = dependencyValue;
	}
	public String getComplexRule() {
		return complexRule;
	}
	public void setComplexRule(String complexRule) {
		this.complexRule = complexRule;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getId() {
		return dependencyId;
	}
	public void setId(Integer id) {
		dependencyId = id;
	}
}
