package org.openmrs.module.scheduletracker.web.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.openmrs.Patient;
import org.openmrs.Person;
import org.openmrs.api.context.Context;
import org.openmrs.module.scheduletracker.TrackMilestone;
import org.openmrs.module.scheduletracker.Utils;
import org.openmrs.module.scheduletracker.api.ScheduleService;
import org.openmrs.module.scheduletracker.api.TrackerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/module/scheduletracker/track/"})
public class TrackController
{
  private static final String VIEW_TRACK = "/module/scheduletracker/view/trackViewForm";

	@RequestMapping({ "viewTrack.form" })
	public String viewTrack(HttpServletRequest request, Model model) throws ParseException {
		String person = Utils.getStringFilter("person", request);
		String schedule = Utils.getStringFilter("schedule", request);
		Date from = Utils.getDateFilter("from", request);
		Date to = Utils.getDateFilter("to", request);
		Date alertfrom = Utils.getDateFilter("alertfrom", request);
		Date alertto = Utils.getDateFilter("alertto", request);
		String status = Utils.getStringFilter("status", request);
		
		Integer[] personIds = null;
		if(person != null){
			List<Integer> pIds = new ArrayList<Integer>();
			try {
				List<Person> pl = Context.getPersonService().getPeople(person, null);
				for (Person pr : pl) {
					pIds.add(pr.getPersonId());
				}
				
				List<Patient> ptl = Context.getPatientService().getPatients(person);
				for (Patient pt : ptl) {
					pIds.add(pt.getPatientId());
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			personIds = pIds.toArray(new Integer[]{});
		}
		
		List<TrackMilestone> dl = Context.getService(TrackerService.class).searchTrackMilestone(schedule, personIds, personIds, alertfrom, alertto, from, to, status, null, true, 0, 200, new String[]{"track"});		
		model.addAttribute("datalist", dl);
		model.addAttribute("schedules", Context.getService(ScheduleService.class).getAllSchedule(true, 0, 200, null));

		return VIEW_TRACK;
	}
}
