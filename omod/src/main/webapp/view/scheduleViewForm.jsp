<%@page import="org.openmrs.module.scheduletracker.Utils"%>
<%@ include file="/WEB-INF/template/include.jsp"%>

<%@ include file="/WEB-INF/template/header.jsp"%>
<%@ include file="../include.jsp"%>

<h1>Schedule</h1>
<form method="post">
<table class="dataentry">
  <tr>
    <td>Name</td>
    <td><input type="text" name="person"></td>
 	<td colspan="2"><input type="submit" value="Filter"></td>
  </tr>
</table>
</form>
<br>
<div>showing first 200 records. if your desired record not found refine your search</div>
<table class="dataview" width="95%">
  <tr>
   <th>Name</th>
   <th>Recipient Type</th>
   <th>Reference Date Type</th>
   <th>Type</th>
   <th>Description</th>
  </tr>
  <c:forEach var="it" items="${datalist}">
      <tr>
        <td>${it.name}</td>
        <td>${it.recipientType}</td>
        <td>${it.referenceDateType}</td>
        <td>${it.type}</td>
        <td>${it.description}</td>
      </tr>		
  </c:forEach>
</table>


<%@ include file="/WEB-INF/template/footer.jsp"%>