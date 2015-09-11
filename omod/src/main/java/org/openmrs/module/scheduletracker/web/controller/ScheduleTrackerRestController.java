package org.openmrs.module.scheduletracker.web.controller;

import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.v1_0.controller.MainResourceController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rest/" + RestConstants.VERSION_1 +ScheduleTrackerRestController.ST_NAMESPACE)
public class ScheduleTrackerRestController extends MainResourceController {

	public static final String ST_NAMESPACE = "/scheduletracker";
	
	@Override
	public String getNamespace() {
		return RestConstants.VERSION_1 + ST_NAMESPACE;
	}
}