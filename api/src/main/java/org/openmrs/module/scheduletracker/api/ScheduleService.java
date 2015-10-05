package org.openmrs.module.scheduletracker.api;

import java.io.Serializable;
import java.util.List;

import org.openmrs.api.OpenmrsService;
import org.openmrs.module.scheduletracker.Dependency;
import org.openmrs.module.scheduletracker.DependencyType;
import org.openmrs.module.scheduletracker.Milestone;
import org.openmrs.module.scheduletracker.Schedule;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ScheduleService extends OpenmrsService{
	Long LAST_QUERY_TOTAL_ROWS(Class<?> clazz);

	void deleteDependency(Dependency dependency);
	Dependency getDependency(int id, boolean readonly);
	Dependency getDependencyByUuid(String uuid, boolean readonly);
	List<Dependency> getAllDependency(boolean readonly, int firstResult, int maxResults, String[] mappingsToJoin);
	Serializable saveDependency(Dependency dependency);
	void updateDependency(Dependency dependency);
	List<Dependency> getDependencyBySchedule(String schedule, boolean readonly);
	
	List<DependencyType> getAllDependencyType(boolean readonly, int firstResult, int maxResults, String[] mappingsToJoin);
	DependencyType getDependencyType(int id, boolean readonly);
	DependencyType getDependencyTypeByUuid(String uuid, boolean readonly);
	Serializable saveDependencyType(DependencyType dependencyType) ;
	void updateDependencyType(DependencyType dependencyType);
	void deleteDependencyType(DependencyType dependencyType);
	DependencyType getDependencyType(String name, boolean readonly);

	List<Milestone> getAllMilestone(boolean readonly, int firstResult, int maxResults, String[] mappingsToJoin);
	Milestone getMilestone(int id, boolean readonly);
	Milestone getMilestoneByUuid(String uuid, boolean readonly);
	Serializable saveMilestone(Milestone milestone);
	void updateMilestone(Milestone milestone);
	void deleteMilestone(Milestone milestone);
	Milestone getMilestone(String name, boolean readonly);
	List<Milestone> searchMilestone(String schedule, boolean readonly, int firstResult, int maxResults, String[] mappingsToJoin);
	
	List<Schedule> getAllSchedule(boolean readonly, int firstResult, int maxResults, String[] mappingsToJoin);
	Schedule getSchedule(int id, boolean readonly);
	Schedule getScheduleByUuid(String uuid, boolean readonly);
	Serializable saveSchedule(Schedule schedule);
	void updateSchedule(Schedule schedule);
	void deleteSchedule(Schedule schedule);
	Schedule getSchedule(String name, boolean readonly);
	List<Schedule> searchSchedule(String nameLike, String type, String recipientType,
			boolean readonly, int firstResult, int maxResults, String[] mappingsToJoin);
}
