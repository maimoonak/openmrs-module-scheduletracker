package org.openmrs.module.scheduletracker.web.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openmrs.api.context.Context;
import org.openmrs.module.scheduletracker.Schedule;
import org.openmrs.module.scheduletracker.api.ScheduleService;
import org.openmrs.module.scheduletracker.web.util.ScheduleUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping("/module/scheduletracker/jsonschedule/")
public class JsonScheduleController {
	public final static String JSON_SCHEDULE_UPLOAD_FORM_VIEW = "/module/scheduletracker/view/jsonScheduleUploadForm";

	@RequestMapping(method = RequestMethod.GET, value = "uploadJsonSchedule.form")
	public String uploadIntervaOutputView() throws IOException{
		return JSON_SCHEDULE_UPLOAD_FORM_VIEW;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "uploadJsonSchedule.form")
	public String uploadJsonSchedule(HttpServletRequest request, HttpServletResponse response, Map model) throws IOException{
		String message = "File uploaded successfully.";
		try{
			Schedule s = parseUploadedFile(request);
			Context.getService(ScheduleService.class).saveSchedule(s);
		}
		catch(Exception e){
			e.printStackTrace();
			message = "Error parsing file: "+e.getMessage();
		}
		model.put("message", message);
		
		return JSON_SCHEDULE_UPLOAD_FORM_VIEW;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.POST, value = "saveJsonSchedule.form")
	public @ResponseBody Map saveJsonSchedule(HttpServletRequest request, HttpServletResponse response, Map model) throws IOException{
		String message = "SUCCESS: Schedule uploaded successfully.";
		try{
			Schedule s = ScheduleUtils.parseScheduleFromJson(request.getInputStream());
			Context.getService(ScheduleService.class).saveSchedule(s);
		}
		catch(Exception e){
			e.printStackTrace();
			message = "ERROR: Schedule invalid: "+e.getMessage();
		}
		model.put("message", message);
		
		return model;
	}
	
	private Schedule parseUploadedFile(HttpServletRequest request) throws IOException{
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile uploadedFile = multipartRequest.getFile("jsonScheduleFile");
		if (uploadedFile != null && !uploadedFile.isEmpty()) {
			return ScheduleUtils.parseScheduleFromJson(uploadedFile.getInputStream());
		}
		else {
			throw new IllegalArgumentException("No file specified");
		}
	}
}
