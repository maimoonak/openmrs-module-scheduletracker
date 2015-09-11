package org.openmrs.module.scheduletracker.web.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.openmrs.api.context.Context;
import org.openmrs.module.scheduletracker.Dependency;
import org.openmrs.module.scheduletracker.DependencyType;
import org.openmrs.module.scheduletracker.Milestone;
import org.openmrs.module.scheduletracker.Schedule;
import org.openmrs.module.scheduletracker.Schedule.ScheduleType;
import org.openmrs.module.scheduletracker.api.ScheduleService;

import com.mysql.jdbc.StringUtils;

public class ScheduleUtils {

	public static Schedule parseScheduleFromJson(String json) throws IOException {
		return parseScheduleFromJson(new ObjectMapper().readTree(json));
	}
	
	public static Schedule parseScheduleFromJson(InputStream json) throws IOException {
		return parseScheduleFromJson(new ObjectMapper().readTree(json));
	}
	
	public static Schedule parseScheduleFromJson(JsonNode json) {
		Schedule s = new Schedule();
		s.setName(findTextValue(json, "name", false));
		s.setDateCreated(new Date());
		if(json.get("dependencies") != null){
			Set<Dependency> dl = new HashSet<Dependency>();
			Iterator<JsonNode> dar = json.get("dependencies").getElements();
			while (dar.hasNext()) {
				JsonNode dobj = (JsonNode) dar.next();
				
				Dependency d = new Dependency();
				d.setSchedule(s);
				d.setDateCreated(new Date());
				d.setDescription(findTextValue(dobj, "description", true));
				DependencyType dt = Context.getService(ScheduleService.class).getDependencyType(findTextValue(dobj, "type", false), true);
				d.setDependencyType(dt);
				d.setDependencyKey("name");
				d.setDependencyValue(findTextValue(dobj, "scheduleName", false));
				
				dl.add(d);
			}
			
			s.setDependencies(dl);
		}
		s.setDescription(findTextValue(json, "description", true));
		Set<Milestone> ml = new HashSet<Milestone>();
		Iterator<JsonNode> mar = json.get("milestones").getElements();
		while (mar.hasNext()) {
			JsonNode mobj = (JsonNode) mar.next();
			Milestone m = new Milestone();
			m.setSchedule(s);
			m.setDateCreated(new Date());
			m.setDescription(findTextValue(mobj, "description", true));
			m.setName(findTextValue(mobj, "name", false));
			m.setEarly(getWindowProperty(mobj, "earliest", "window"));
			m.setEarlyAlertCount(convertToInt(getWindowProperty(mobj, "earliest", "count")));
			m.setEarlyAlertInterval(getWindowProperty(mobj, "earliest", "interval"));
			m.setEarlyAlertOffset(getWindowProperty(mobj, "earliest", "offset"));
			m.setDue(getWindowProperty(mobj, "due", "window"));
			m.setDueAlertCount(convertToInt(getWindowProperty(mobj, "due", "count")));
			m.setDueAlertInterval(getWindowProperty(mobj, "due", "interval"));
			m.setDueAlertOffset(getWindowProperty(mobj, "due", "offset"));
			m.setLate(getWindowProperty(mobj, "late", "window"));
			m.setLateAlertCount(convertToInt(getWindowProperty(mobj, "late", "count")));
			m.setLateAlertInterval(getWindowProperty(mobj, "late", "interval"));
			m.setLateAlertOffset(getWindowProperty(mobj, "late", "offset"));
			m.setMax(getWindowProperty(mobj, "max", "window"));
			m.setMaxAlertCount(convertToInt(getWindowProperty(mobj, "max", "count")));
			m.setMaxAlertInterval(getWindowProperty(mobj, "max", "interval"));
			m.setMaxAlertOffset(getWindowProperty(mobj, "max", "offset"));
			
			ml.add(m);
		}
		s.setMilestones(ml);
		s.setRecipientType(findTextValue(json, "recipientType", true));
		s.setReferenceDateType(findTextValue(json, "referenceDateType", true));
		String typ = findTextValue(json, "type", true);
		if(StringUtils.isEmptyOrWhitespaceOnly(typ)){
			Boolean abso = findBooleanValue(json, "absolute", true);
			if(abso == null || abso == false){
				typ = ScheduleType.MILESTONE_BASED.name();
			}
			else {
				typ = ScheduleType.REFERENCE_DATE_BASED.name();
			}
		}
		s.setType(typ);
		
		
		return s;
	}
	
	private static Integer convertToInt(String v) {
		if(v != null){
			return Integer.parseInt(v);
		}
		return null;
	}

	private static String findTextValue(JsonNode node, String field, boolean nullable){
		JsonNode fl = node.get(field);
		if(fl == null){
			if(nullable){
				return null;
			}
			else throw new IllegalArgumentException("No value found required property "+field);
		}
		
		return fl.getTextValue();
	}
	
	private static Boolean findBooleanValue(JsonNode node, String field, boolean nullable){
		JsonNode fl = node.get(field);
		if(fl == null){
			if(nullable){
				return null;
			}
			else throw new IllegalArgumentException("No value found required property "+field);
		}
		
		return fl.getBooleanValue();
	}
	
	private static String getWindowProperty(JsonNode milestone, String window, String property) {
		if(property.equalsIgnoreCase("window")){
			return milestone.get("scheduleWindows").get(window).toString();
		}
		Iterator<JsonNode> al = milestone.get("alerts").getElements();
		while (al.hasNext()) {
			JsonNode jsonNode = al.next();
			if(jsonNode.get("window").getTextValue().equalsIgnoreCase(window)){
				JsonNode p = jsonNode.get(property);
				String v = p.isArray()?p.toString():p.getTextValue();
				return v;
			}
		}
		return null;
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		System.out.println(parseScheduleFromJson(new FileInputStream(new File("D:\\opensrpThriveMaster\\opensrp-server\\assets\\schedules\\mother-anc-normal.json"))));
	}
}
