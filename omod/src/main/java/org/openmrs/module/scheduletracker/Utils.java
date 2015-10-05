package org.openmrs.module.scheduletracker;

import com.mysql.jdbc.StringUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

public class Utils
{
	public static final String GLOBAL_DATE_FORMAT = "dd-MM-yyyy";
	public static final SimpleDateFormat GLOBAL_SDF = new SimpleDateFormat("dd-MM-yyyy");
	public static final String GLOBAL_DATETIME_FORMAT = "dd-MM-yyyy HH:mm";
	public static final SimpleDateFormat GLOBAL_SDTF = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	
	public static String getStringFilter(String filter, HttpServletRequest req)
	{
	  return StringUtils.isEmptyOrWhitespaceOnly(req.getParameter(filter)) ? null : req.getParameter(filter);
	}
	
	public static Enum getEnumFilter(String filter, Class enumType, HttpServletRequest req)
	{
	  String filterVal = getStringFilter(filter, req);
	  if (filterVal != null) {
	    return Enum.valueOf(enumType, filterVal);
	  }
	  return null;
	}
	
	public static Integer getIntegerFilter(String filter, HttpServletRequest req)
	{
	  String strval = getStringFilter(filter, req);
	  return strval == null ? null : Integer.valueOf(Integer.parseInt(strval));
	}
	
	public static Float getFloatFilter(String filter, HttpServletRequest req)
	{
	  String strval = getStringFilter(filter, req);
	  return strval == null ? null : Float.valueOf(Float.parseFloat(strval));
	}
	
	public static Date getDateFilter(String filter, HttpServletRequest req)
	  throws ParseException
	{
	  String strval = getStringFilter(filter, req);
	  return strval == null ? null : GLOBAL_SDF.parse(strval);
	}
	
	public static String setDateFilter(Date date)
	  throws ParseException
	{
	  return date == null ? null : GLOBAL_SDF.format(date);
	}
}
