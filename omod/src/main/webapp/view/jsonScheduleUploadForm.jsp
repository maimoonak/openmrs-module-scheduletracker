<%@ include file="/WEB-INF/template/include.jsp"%>

<%@ include file="/WEB-INF/template/header.jsp"%>

<h2>Upload JSON Schedule</h2>
<h4>${message}</h4>

<form method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<td>Select JSON Schedule file</td>
			<td><input type="file" name="jsonScheduleFile" /> <input type="submit" value='Upload' /> </td>
		</tr>
	</table>
</form>

<%@ include file="/WEB-INF/template/footer.jsp"%>
