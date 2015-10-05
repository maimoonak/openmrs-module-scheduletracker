package org.openmrs.module.scheduletracker.api.impl;

import java.io.Serializable;
import java.util.List;

import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.scheduletracker.Dependency;
import org.openmrs.module.scheduletracker.DependencyType;
import org.openmrs.module.scheduletracker.Milestone;
import org.openmrs.module.scheduletracker.Schedule;
import org.openmrs.module.scheduletracker.api.ScheduleService;
import org.openmrs.module.scheduletracker.api.db.DependencyDAO;
import org.openmrs.module.scheduletracker.api.db.DependencyTypeDAO;
import org.openmrs.module.scheduletracker.api.db.MilestoneDAO;
import org.openmrs.module.scheduletracker.api.db.ScheduleDAO;

public class ScheduleServiceImpl extends BaseOpenmrsService implements ScheduleService{
	private DependencyDAO dependencyDAO;
	private DependencyTypeDAO dependencyTypeDAO;
	private MilestoneDAO milestoneDAO;
	private ScheduleDAO scheduleDAO;
	
	public DependencyDAO getDependencyDAO() {
		return dependencyDAO;
	}

	public void setDependencyDAO(DependencyDAO dependencyDAO) {
		this.dependencyDAO = dependencyDAO;
	}

	public DependencyTypeDAO getDependencyTypeDAO() {
		return dependencyTypeDAO;
	}

	public void setDependencyTypeDAO(DependencyTypeDAO dependencyTypeDAO) {
		this.dependencyTypeDAO = dependencyTypeDAO;
	}

	public MilestoneDAO getMilestoneDAO() {
		return milestoneDAO;
	}

	public void setMilestoneDAO(MilestoneDAO milestoneDAO) {
		this.milestoneDAO = milestoneDAO;
	}

	public ScheduleDAO getScheduleDAO() {
		return scheduleDAO;
	}

	public void setScheduleDAO(ScheduleDAO scheduleDAO) {
		this.scheduleDAO = scheduleDAO;
	}

	public Long LAST_QUERY_TOTAL_ROWS(Class<?> clazz) {
		if(clazz.getName().equals(Dependency.class.getName())){
			return dependencyDAO.LAST_QUERY_TOTAL_ROWS();
		}
		
		if(clazz.getName().equals(DependencyType.class.getName())){
			return dependencyTypeDAO.LAST_QUERY_TOTAL_ROWS();
		}
		
		if(clazz.getName().equals(Milestone.class.getName())){
			return milestoneDAO.LAST_QUERY_TOTAL_ROWS();
		}
		
		if(clazz.getName().equals(Schedule.class.getName())){
			return scheduleDAO.LAST_QUERY_TOTAL_ROWS();
		}
		return null;
	}

	public void deleteDependency(Dependency dependency) {
		dependencyDAO.delete(dependency);
	}

	public Dependency getDependency(int id, boolean readonly) {
		return dependencyDAO.get(id, readonly);
	}

	public List<Dependency> getAllDependency(boolean readonly, int firstResult, int maxResults, String[] mappingsToJoin) {
		return dependencyDAO.getAll(readonly, firstResult, maxResults, mappingsToJoin);
	}

	public Serializable saveDependency(Dependency dependency) {
		return dependencyDAO.save(dependency);
	}

	public void updateDependency(Dependency dependency) {
		dependencyDAO.update(dependency);
	}

	public List<Dependency> getDependencyBySchedule(String schedule, boolean readonly) {
		return dependencyDAO.get(schedule, readonly);
	}

	public List<DependencyType> getAllDependencyType(boolean readonly, int firstResult, int maxResults, String[] mappingsToJoin) {
		return dependencyTypeDAO.getAll(readonly, firstResult, maxResults, mappingsToJoin);
	}

	public DependencyType getDependencyType(int id, boolean readonly) {
		return dependencyTypeDAO.get(id, readonly);
	}

	public Serializable saveDependencyType(DependencyType dependencyType) {
		return dependencyTypeDAO.save(dependencyType);
	}

	public void updateDependencyType(DependencyType dependencyType) {
		dependencyTypeDAO.update(dependencyType);
	}

	public void deleteDependencyType(DependencyType dependencyType) {
		dependencyTypeDAO.delete(dependencyType);
	}

	public DependencyType getDependencyType(String name, boolean readonly) {
		return dependencyTypeDAO.get(name, readonly);
	}

	public List<Milestone> getAllMilestone(boolean readonly, int firstResult, int maxResults, String[] mappingsToJoin) {
		return milestoneDAO.getAll(readonly, firstResult, maxResults, mappingsToJoin);
	}

	public Milestone getMilestone(int id, boolean readonly) {
		return milestoneDAO.get(id, readonly);
	}

	public Serializable saveMilestone(Milestone milestone) {
		return milestoneDAO.save(milestone);
	}

	public void updateMilestone(Milestone milestone) {
		milestoneDAO.update(milestone);
	}

	public void deleteMilestone(Milestone milestone) {
		milestoneDAO.delete(milestone);
	}

	public Milestone getMilestone(String name, boolean readonly) {
		return milestoneDAO.get(name, readonly);
	}

	public List<Milestone> searchMilestone(String schedule, boolean readonly,
			int firstResult, int maxResults, String[] mappingsToJoin) {
		return milestoneDAO.search(schedule, readonly, firstResult, maxResults, mappingsToJoin);
	}

	public List<Schedule> getAllSchedule(boolean readonly, int firstResult, int maxResults, String[] mappingsToJoin) {
		return scheduleDAO.getAll(readonly, firstResult, maxResults, mappingsToJoin);
	}

	public Schedule getSchedule(int id, boolean readonly) {
		return scheduleDAO.get(id, readonly);
	}

	public Serializable saveSchedule(Schedule schedule) {
		return scheduleDAO.save(schedule);
	}

	public void updateSchedule(Schedule schedule) {
		scheduleDAO.update(schedule);
	}

	public void deleteSchedule(Schedule schedule) {
		scheduleDAO.delete(schedule);
	}

	public Schedule getSchedule(String name, boolean readonly) {
		return scheduleDAO.get(name, readonly);
	}

	public List<Schedule> searchSchedule(String nameLike, String type, String recipientType,
			boolean readonly, int firstResult, int maxResults, String[] mappingsToJoin) {
		return scheduleDAO.search(nameLike, type, recipientType, readonly, firstResult, maxResults, mappingsToJoin);
	}

	public Dependency getDependencyByUuid(String uuid, boolean readonly) {
		return dependencyDAO.getByUuid(uuid, readonly);
	}

	public DependencyType getDependencyTypeByUuid(String uuid, boolean readonly) {
		return dependencyTypeDAO.getByUuid(uuid, readonly);
	}

	public Milestone getMilestoneByUuid(String uuid, boolean readonly) {
		return milestoneDAO.getByUuid(uuid, readonly);
	}

	public Schedule getScheduleByUuid(String uuid, boolean readonly) {
		return scheduleDAO.getByUuid(uuid, readonly);
	}
	
}
