package org.openmrs.module.scheduletracker.web.resource;

import org.openmrs.api.context.Context;
import org.openmrs.module.scheduletracker.Schedule;
import org.openmrs.module.scheduletracker.api.ScheduleService;
import org.openmrs.module.scheduletracker.web.controller.ScheduleTrackerRestController;
import org.openmrs.module.webservices.rest.web.RequestContext;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.annotation.PropertyGetter;
import org.openmrs.module.webservices.rest.web.annotation.Resource;
import org.openmrs.module.webservices.rest.web.representation.DefaultRepresentation;
import org.openmrs.module.webservices.rest.web.representation.FullRepresentation;
import org.openmrs.module.webservices.rest.web.representation.Representation;
import org.openmrs.module.webservices.rest.web.resource.impl.DataDelegatingCrudResource;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingResourceDescription;
import org.openmrs.module.webservices.rest.web.response.ResponseException;

@Resource(name =RestConstants.VERSION_1 +ScheduleTrackerRestController.ST_NAMESPACE+"/schedule", 
	supportedClass = Schedule.class, supportedOpenmrsVersions = { "1.8.*", "1.9.*, 1.10.*, 1.11.*","1.12.*" })
public class ScheduleResource extends DataDelegatingCrudResource<Schedule>{

	public DelegatingResourceDescription getRepresentationDescription(Representation rep) {
		if (rep instanceof DefaultRepresentation) {
			DelegatingResourceDescription description = new DelegatingResourceDescription();
			description.addProperty("uuid");
			description.addProperty("name");
			description.addProperty("type");
			description.addProperty("display");
			description.addProperty("voided");
			description.addSelfLink();
			description.addLink("full", ".?v=" + RestConstants.REPRESENTATION_FULL);
			return description;
		} else if (rep instanceof FullRepresentation) {
			DelegatingResourceDescription description = new DelegatingResourceDescription();
			description.addProperty("uuid");
			description.addProperty("name");
			description.addProperty("referenceDateType");
			description.addProperty("recipientType");
			description.addProperty("dependencies", Representation.REF);
			description.addProperty("milestones", Representation.REF);
			description.addProperty("type");
			description.addProperty("description");
			description.addProperty("display");
			description.addProperty("voided");
			description.addProperty("auditInfo", findMethod("getAuditInfo"));
			description.addSelfLink();
			return description;
		}
		return null;
	}

	public Schedule newDelegate() {
		return new Schedule();
	}

	@Override
	public DelegatingResourceDescription getCreatableProperties()  {
		DelegatingResourceDescription description = new DelegatingResourceDescription();
		description.addProperty("name");
		description.addProperty("referenceDateType");
		description.addProperty("recipientType");
		description.addProperty("dependencies", Representation.REF);
		description.addProperty("milestones", Representation.REF);
		description.addProperty("type");
		description.addProperty("description");
		return description;
	}
	
	public Schedule save(Schedule schedule) {
		//TODO
		Context.getService(ScheduleService.class).saveSchedule(schedule);
		return schedule;
	}

	@Override
	protected void delete(Schedule schedule, String reason, RequestContext context) throws ResponseException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Schedule getByUniqueId(String uniqueid) {
		Schedule s = Context.getService(ScheduleService.class).getScheduleByUuid(uniqueid, false);
		if(s == null){
			s = Context.getService(ScheduleService.class).getSchedule(uniqueid, false);
		}
		return s;
	}

	@Override
	public void purge(Schedule schedule, RequestContext context) throws ResponseException {
		// TODO Auto-generated method stub
		
	}

	@PropertyGetter("display")
	public String getDisplayString(Schedule schedule){
		return schedule.getName();
	}
	
}
