package org.openmrs.module.scheduletracker.web.resource;

import org.openmrs.api.context.Context;
import org.openmrs.module.scheduletracker.Track;
import org.openmrs.module.scheduletracker.api.TrackerService;
import org.openmrs.module.scheduletracker.web.controller.ScheduleTrackerRestController;
import org.openmrs.module.webservices.rest.web.RequestContext;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.annotation.Resource;
import org.openmrs.module.webservices.rest.web.representation.DefaultRepresentation;
import org.openmrs.module.webservices.rest.web.representation.FullRepresentation;
import org.openmrs.module.webservices.rest.web.representation.Representation;
import org.openmrs.module.webservices.rest.web.resource.impl.DataDelegatingCrudResource;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingResourceDescription;
import org.openmrs.module.webservices.rest.web.response.ResponseException;

@Resource(name =RestConstants.VERSION_1 +ScheduleTrackerRestController.ST_NAMESPACE+"/track", 
	supportedClass = Track.class, supportedOpenmrsVersions = { "1.8.*", "1.9.*, 1.10.*, 1.11.*","1.12.*" })
public class TrackResource extends DataDelegatingCrudResource<Track>{

	public DelegatingResourceDescription getRepresentationDescription(Representation rep) {
		if (rep instanceof DefaultRepresentation) {
			DelegatingResourceDescription description = new DelegatingResourceDescription();
			description.addProperty("uuid");
			description.addProperty("display");
			description.addProperty("beneficiary", Representation.REF);
			description.addProperty("recipient", Representation.REF);
			description.addProperty("schedule", Representation.REF);
			description.addProperty("preferredAlertTime");
			description.addProperty("referenceDate");
			description.addProperty("dateEnrolled");
			description.addProperty("startingMilestone", Representation.REF);
			description.addProperty("currentMilestone", Representation.REF);
			description.addProperty("status");
			description.addProperty("voided");
			description.addSelfLink();
			description.addLink("full", ".?v=" + RestConstants.REPRESENTATION_FULL);
			return description;
		} else if (rep instanceof FullRepresentation) {
			DelegatingResourceDescription description = new DelegatingResourceDescription();
			description.addProperty("uuid");
			description.addProperty("display");
			description.addProperty("beneficiary", Representation.REF);
			description.addProperty("recipient", Representation.REF);
			description.addProperty("schedule", Representation.REF);
			description.addProperty("beneficiaryRole");
			description.addProperty("recipientRole");
			description.addProperty("preferredAlertTime");
			description.addProperty("referenceDate");
			description.addProperty("referenceDateType");
			description.addProperty("dateEnrolled");
			description.addProperty("startingMilestone", Representation.REF);
			description.addProperty("earlyStartDate");
			description.addProperty("dueStartDate");
			description.addProperty("lateStartDate");
			description.addProperty("maxStartDate");
			description.addProperty("currentMilestone", Representation.REF);
			description.addProperty("status");
			description.addProperty("milestones", Representation.REF);
			description.addProperty("voided");
			description.addProperty("auditInfo", findMethod("getAuditInfo"));
			description.addSelfLink();
			return description;
		}
		return null;
	}

	public Track newDelegate() {
		return new Track();
	}

	@Override
	public DelegatingResourceDescription getCreatableProperties()  {
		DelegatingResourceDescription description = new DelegatingResourceDescription();
		description.addProperty("beneficiary");
		description.addProperty("recipient");
		description.addProperty("schedule");//
		description.addProperty("beneficiaryRole");
		description.addProperty("recipientRole");
		description.addProperty("preferredAlertTime");//
		description.addProperty("referenceDate");//
		description.addProperty("referenceDateType");//
		description.addProperty("dateEnrolled");//
		description.addProperty("startingMilestone");//
		description.addProperty("earlyStartDate");//
		description.addProperty("dueStartDate");//
		description.addProperty("lateStartDate");//
		description.addProperty("maxStartDate");//
		description.addProperty("currentMilestone");//
		description.addRequiredProperty("status");
		description.addProperty("milestones");
		return description;
	}
	
	public Track save(Track track) {
		//TODO
		Context.getService(TrackerService.class).saveTrack(track);
		return track;
	}

	@Override
	protected void delete(Track track, String reason, RequestContext context) throws ResponseException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Track getByUniqueId(String uniqueid) {
		return Context.getService(TrackerService.class).getTrackByUuid(uniqueid, true);
	}

	@Override
	public void purge(Track track, RequestContext context) throws ResponseException {
		// TODO Auto-generated method stub
		
	}

	
}
