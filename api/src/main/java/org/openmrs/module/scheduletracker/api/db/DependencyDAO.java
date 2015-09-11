package org.openmrs.module.scheduletracker.api.db;

import java.util.List;

import org.openmrs.module.scheduletracker.Dependency;

public interface DependencyDAO extends DAO<Dependency>{
	List<Dependency> get(String schedule, boolean readonly);
}
