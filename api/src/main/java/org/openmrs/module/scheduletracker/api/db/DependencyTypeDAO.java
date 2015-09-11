package org.openmrs.module.scheduletracker.api.db;

import org.openmrs.module.scheduletracker.DependencyType;

public interface DependencyTypeDAO extends DAO<DependencyType>{
	DependencyType get(String name, boolean readonly);

}
