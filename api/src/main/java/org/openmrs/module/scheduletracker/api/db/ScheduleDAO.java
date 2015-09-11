package org.openmrs.module.scheduletracker.api.db;

import java.util.List;

import org.openmrs.module.scheduletracker.Schedule;

public interface ScheduleDAO extends DAO<Schedule>
{
  Schedule get(String name, boolean readonly);
  
  List<Schedule> search(String type, String recipientType, 
		  boolean readonly, int firstResult, int maxResults, String[] mappingsToJoin);
}
