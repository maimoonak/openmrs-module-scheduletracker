package org.openmrs.module.scheduletracker.api.db;

import java.util.List;

import org.openmrs.module.scheduletracker.Milestone;

public interface MilestoneDAO extends DAO<Milestone>
{
  Milestone get(String name, boolean readonly);
  
  List<Milestone> search(String schedule, 
		  boolean readonly, int firstResult, int maxResults, String[] mappingsToJoin);
}
