package org.openmrs.module.scheduletracker.web.resource;

import java.util.ArrayList;
import java.util.List;

import org.openmrs.api.context.Context;
import org.openmrs.module.scheduletracker.Track;
import org.openmrs.module.scheduletracker.TrackMilestone;
import org.openmrs.module.scheduletracker.api.TrackerService;
import org.openmrs.module.scheduletracker.web.controller.ScheduleTrackerRestController;
import org.openmrs.module.webservices.rest.web.RequestContext;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.annotation.PropertyGetter;
import org.openmrs.module.webservices.rest.web.annotation.Resource;
import org.openmrs.module.webservices.rest.web.representation.DefaultRepresentation;
import org.openmrs.module.webservices.rest.web.representation.FullRepresentation;
import org.openmrs.module.webservices.rest.web.representation.Representation;
import org.openmrs.module.webservices.rest.web.resource.api.PageableResult;
import org.openmrs.module.webservices.rest.web.resource.impl.DataDelegatingCrudResource;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingResourceDescription;
import org.openmrs.module.webservices.rest.web.resource.impl.NeedsPaging;
import org.openmrs.module.webservices.rest.web.response.ResponseException;

import com.mysql.jdbc.StringUtils;

@Resource(name =RestConstants.VERSION_1 +ScheduleTrackerRestController.ST_NAMESPACE+"/trackmilestone", 
	supportedClass = TrackMilestone.class, supportedOpenmrsVersions = { "1.8.*", "1.9.*, 1.10.*, 1.11.*","1.12.*" })
public class TrackMilestoneResource extends DataDelegatingCrudResource<TrackMilestone>{

	public DelegatingResourceDescription getRepresentationDescription(Representation rep) {
		if (rep instanceof DefaultRepresentation) {
			DelegatingResourceDescription description = new DelegatingResourceDescription();
			description.addProperty("uuid");
			description.addProperty("display");
			description.addProperty("track", Representation.REF);
			description.addProperty("milestone", Representation.REF);
			description.addProperty("alertRecipient", Representation.REF);
			description.addProperty("fulfillmentDate");
			description.addProperty("status");
			description.addProperty("isActive");
			description.addProperty("voided");
			description.addSelfLink();
			description.addLink("full", ".?v=" + RestConstants.REPRESENTATION_FULL);
			return description;
		} else if (rep instanceof FullRepresentation) {
			DelegatingResourceDescription description = new DelegatingResourceDescription();
			description.addProperty("uuid");
			description.addProperty("display");
			description.addProperty("track", Representation.REF);
			description.addProperty("milestone", Representation.REF);
			description.addProperty("alertRecipient", Representation.REF);
			description.addProperty("alertRecipientRole");
			description.addProperty("fulfillmentDate");
			description.addProperty("status");
			description.addProperty("reasonClosed");
			description.addProperty("alertStartDate");
			description.addProperty("alertExpiryDate");
			description.addProperty("isActive");
			description.addProperty("actionType");
			description.addProperty("voided");
			description.addProperty("auditInfo", findMethod("getAuditInfo"));
			description.addSelfLink();
			return description;
		}
		return null;
	}

	public TrackMilestone newDelegate() {
		return new TrackMilestone();
	}

	@Override
	public DelegatingResourceDescription getCreatableProperties()  {
		DelegatingResourceDescription description = new DelegatingResourceDescription();
		description.addProperty("track");
		description.addProperty("milestone");
		description.addProperty("alertRecipient", Representation.REF);
		description.addProperty("alertRecipientRole");
		description.addProperty("fulfillmentDate");
		description.addProperty("status");
		description.addProperty("reasonClosed");
		description.addProperty("alertStartDate");
		description.addProperty("alertExpiryDate");
		description.addProperty("isActive");
		description.addProperty("actionType");
		return description;
	}
	
	@Override
	public DelegatingResourceDescription getUpdatableProperties()  {
		DelegatingResourceDescription description = new DelegatingResourceDescription();
		description.addProperty("fulfillmentDate");
		description.addProperty("status");
		description.addProperty("reasonClosed");
		description.addProperty("alertStartDate");
		description.addProperty("alertExpiryDate");
		description.addProperty("isActive");
		description.addProperty("actionType");
		return description;
	}
	
	public TrackMilestone save(TrackMilestone trackmilestone) {
		if(trackmilestone.getTrackMilestoneId() > 0){
			Context.getService(TrackerService.class).updateTrackMilestone(trackmilestone);
			return trackmilestone;
		}
		Context.getService(TrackerService.class).saveTrackMilestone(trackmilestone);
		return trackmilestone;
	}

	@Override
	protected void delete(TrackMilestone trackmilestone, String reason, RequestContext context) throws ResponseException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TrackMilestone getByUniqueId(String uniqueid) {
		return Context.getService(TrackerService.class).getTrackMilestoneByUuid(uniqueid, false);
	}

	@Override
	public void purge(TrackMilestone trackmilestone, RequestContext context) throws ResponseException {
		// TODO Auto-generated method stub
		
	}
	
	@PropertyGetter("display")
	public String getDisplayString(TrackMilestone trackmilestone){
		return trackmilestone.getMilestone().getName()+"-"+trackmilestone.getStatus();
	}

	@Override
	protected PageableResult doSearch(RequestContext context) {
		String trackid = context.getParameter("track");
		String milestone = context.getParameter("milestone");
		List<TrackMilestone> responsel = new ArrayList<TrackMilestone>();
		if(!StringUtils.isEmptyOrWhitespaceOnly(trackid)){
			Track track = Context.getService(TrackerService.class).getTrackByUuid(trackid, true);
			List<TrackMilestone> tml = Context.getService(TrackerService.class).getTrackMilestoneByTrack(track.getTrackId(), true);
			if(!StringUtils.isEmptyOrWhitespaceOnly(milestone)){
				for (TrackMilestone tm : tml) {
					if(tm.getMilestone().getName().equalsIgnoreCase(milestone)){
						responsel.add(tm);
					}
				}
			}
			else{
				responsel.addAll(tml);
			}
		}
		return new NeedsPaging<TrackMilestone>(responsel, context);
	}
}
