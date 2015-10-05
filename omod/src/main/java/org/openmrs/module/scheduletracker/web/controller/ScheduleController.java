package org.openmrs.module.scheduletracker.web.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.openmrs.api.context.Context;
import org.openmrs.module.scheduletracker.Schedule;
import org.openmrs.module.scheduletracker.Utils;
import org.openmrs.module.scheduletracker.api.ScheduleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/module/scheduletracker/schedule/"})
public class ScheduleController
{
  private static final String VIEW_SCHEDULE = "/module/scheduletracker/view/scheduleViewForm";

	@RequestMapping({ "viewSchedule.form" })
	public String viewTrack(HttpServletRequest request, Model model) throws ParseException {
		String name = Utils.getStringFilter("name", request);
		
		List<Schedule> dl = Context.getService(ScheduleService.class).searchSchedule(name, null, null, true, 0, 200, new String[]{"dependencies", "milestones"});		
		model.addAttribute("datalist", dl);

		return VIEW_SCHEDULE;
	}
}
