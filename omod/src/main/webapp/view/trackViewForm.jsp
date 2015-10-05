<%@page import="org.openmrs.module.scheduletracker.Utils"%>
<%@ include file="/WEB-INF/template/include.jsp"%>

<%@ include file="/WEB-INF/template/header.jsp"%>
<%@ include file="../include.jsp"%>

<h1>Schedule Track</h1>
<form method="post">
<table class="dataentry">
  <tr>
    <td>Person</td>
    <td><input type="text" name="person"></td>
    <td>Schedule</td>
    <td>
    <select name="schedule">
		<option></option>
		<c:forEach items="${schedules}" var="rl">
			<option>${rl.name}</option>
		</c:forEach>
		</select>
	</td>
    <td>Status</td>
    <td><input type="text" name="status"></td>
  </tr>
  <tr>
	<td>Enrollment Date</td>
    <td><input name="from" style="width:90px"> - <input name="to" style="width:90px"> (dd-MM-yyyy)</td>
	<td>Alert Date</td>
    <td><input name="alertfrom" style="width:90px"> - <input name="alertto" style="width:90px"> (dd-MM-yyyy)</td>
 	<td colspan="2"><input type="submit" value="Filter"></td>
  </tr>
</table>
</form>
<br>
<div>showing first 200 records. if your desired record not found refine your search</div>
<table class="dataview" width="95%">
  <tr>
   <th>Schedule</th>
   <th>Beneficiary</th>
   <th>Reference Datetime</th>
   <th>Enrollment Datetime</th>
   <th>Recipient</th>
   <th>Status</th>
   <th>Milestone</th>
   <th>Alert Start</th>
   <th>Alert End</th>
   <th>Fulfillment</th>
   <th>Alert Status</th>
  </tr>
  <c:forEach var="it" items="${datalist}">
      <tr>
        <td>${it.track.schedule.name}</td>
        <td><a href="${pageContext.request.contextPath}/patientDashboard.form?patientId=${it.track.beneficiary.personId}">${it.track.beneficiary.names}</a></td>
        <td><openmrs:formatDate date="${it.track.referenceDate}"/></td>
        <td><openmrs:formatDate date="${it.track.dateEnrolled}"/></td>
        <td><a href="${pageContext.request.contextPath}/admin/person/person.form?personId=${it.alertRecipient.personId}">${it.alertRecipient.names}</a></td>
        <td>${it.track.status}</td>
        <td>${it.milestone.name}</td>
        <td><openmrs:formatDate date="${it.alertStartDate}"/></td>
        <td><openmrs:formatDate date="${it.alertExpiryDate}"/></td>
        <td><openmrs:formatDate date="${it.fulfillmentDate}"/></td>
        <td>${it.status}</td>
      </tr>		
  </c:forEach>
</table>


<%@ include file="/WEB-INF/template/footer.jsp"%>