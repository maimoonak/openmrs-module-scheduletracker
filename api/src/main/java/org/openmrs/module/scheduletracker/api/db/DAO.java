package org.openmrs.module.scheduletracker.api.db;

import java.io.Serializable;
import java.util.List;

public interface DAO <T>{
	
	long LAST_QUERY_TOTAL_ROWS();
	
	List<T> getAll(boolean readonly, int firstResult, int maxResults, String[] mappingsToJoin);

	T get(int id, boolean readonly);
	
	T getByUuid(String uuid, boolean readonly);

	Serializable save(T obj);

	void update(T obj);

	void delete(T obj);
}
