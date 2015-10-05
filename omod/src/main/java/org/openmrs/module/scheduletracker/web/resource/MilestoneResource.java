package org.openmrs.module.scheduletracker.web.resource;

import org.openmrs.api.context.Context;
import org.openmrs.module.scheduletracker.Milestone;
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

@Resource(name =RestConstants.VERSION_1 +ScheduleTrackerRestController.ST_NAMESPACE+"/milestone", 
	supportedClass = Milestone.class, supportedOpenmrsVersions = { "1.8.*", "1.9.*, 1.10.*, 1.11.*","1.12.*" })
public class MilestoneResource extends DataDelegatingCrudResource<Milestone>{

	public DelegatingResourceDescription getRepresentationDescription(Representation rep) {
		if (rep instanceof DefaultRepresentation) {
			DelegatingResourceDescription description = new DelegatingResourceDescription();
			description.addProperty("uuid");
			description.addProperty("display");
			description.addProperty("schedule", Representation.REF);
			description.addProperty("name");
			description.addProperty("early");
			description.addProperty("due");
			description.addProperty("late");
			description.addProperty("max");
			description.addProperty("voided");
			description.addSelfLink();
			description.addLink("full", ".?v=" + RestConstants.REPRESENTATION_FULL);
			return description;
		} else if (rep instanceof FullRepresentation) {
			DelegatingResourceDescription description = new DelegatingResourceDescription();
			description.addProperty("uuid");
			description.addProperty("display");
			description.addProperty("schedule", Representation.REF);
			description.addProperty("name");
			description.addProperty("early");
			description.addProperty("earlyAlertOffset");
			description.addProperty("earlyAlertInterval");
			description.addProperty("earlyAlertCount");
			description.addProperty("due");
			description.addProperty("dueAlertOffset");
			description.addProperty("dueAlertInterval");
			description.addProperty("dueAlertCount");
			description.addProperty("late");
			description.addProperty("lateAlertOffset");
			description.addProperty("lateAlertInterval");
			description.addProperty("lateAlertCount");
			description.addProperty("max");
			description.addProperty("maxAlertOffset");
			description.addProperty("maxAlertInterval");
			description.addProperty("maxAlertCount");
			description.addProperty("description");
			description.addProperty("voided");
			description.addProperty("auditInfo", findMethod("getAuditInfo"));
			description.addSelfLink();
			return description;
		}
		return null;
	}

	public Milestone newDelegate() {
		return new Milestone();
	}

	@Override
	public DelegatingResourceDescription getCreatableProperties()  {
		DelegatingResourceDescription description = new DelegatingResourceDescription();
		description.addProperty("schedule");
		description.addProperty("name");
		description.addProperty("early");
		description.addProperty("earlyAlertOffset");
		description.addProperty("earlyAlertInterval");
		description.addProperty("earlyAlertCount");
		description.addProperty("due");
		description.addProperty("dueAlertOffset");
		description.addProperty("dueAlertInterval");
		description.addProperty("dueAlertCount");
		description.addProperty("late");
		description.addProperty("lateAlertOffset");
		description.addProperty("lateAlertInterval");
		description.addProperty("lateAlertCount");
		description.addProperty("max");
		description.addProperty("maxAlertOffset");
		description.addProperty("maxAlertInterval");
		description.addProperty("maxAlertCount");
		description.addProperty("description");
		return description;
	}
	
	public Milestone save(Milestone schedule) {
		//TODO
		Context.getService(ScheduleService.class).saveMilestone(schedule);
		return schedule;
	}

	@Override
	protected void delete(Milestone schedule, String reason, RequestContext context) throws ResponseException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Milestone getByUniqueId(String uniqueid) {
		Milestone s = Context.getService(ScheduleService.class).getMilestoneByUuid(uniqueid, false);
		if(s == null){
			s = Context.getService(ScheduleService.class).getMilestone(uniqueid, false);
		}
		return s;
	}

	@Override
	public void purge(Milestone schedule, RequestContext context) throws ResponseException {
		// TODO Auto-generated method stub
		
	}

	@PropertyGetter("display")
	public String getDisplayString(Milestone milestone){
		return milestone.getName();
	}
}
