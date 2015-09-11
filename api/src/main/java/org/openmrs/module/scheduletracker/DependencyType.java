package org.openmrs.module.scheduletracker;

import org.openmrs.BaseOpenmrsData;

public class DependencyType extends BaseOpenmrsData {

	private int dependencyTypeId;
	private String name;
	private String description;
	
	public DependencyType() {

	}
	
	public int getDependencyTypeId() {
		return dependencyTypeId;
	}

	public void setDependencyTypeId(int dependencyTypeId) {
		this.dependencyTypeId = dependencyTypeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getId() {
		return dependencyTypeId;
	}
	public void setId(Integer id) {
		dependencyTypeId = id;
	}
	
}
