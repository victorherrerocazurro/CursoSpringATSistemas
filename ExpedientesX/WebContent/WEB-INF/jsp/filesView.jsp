<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value='/css/styles.css'/>"	type="text/css" />
<title>X Files</title>
</head>
<body>
	<div id="content">

		<h1>
			X Files for	<sec:authentication property="principal.username" />
		</h1>
		<a href="<c:url value='/index.jsp'/>">Index</a><br> <br>

		<table>
			<tr>
				<td><b>ID</b></td>
				<td align="center"><b>Image</b></td>
				<td align="right"><b>Title</b></td>
				<td width="40%"><b>Report</b></td>
				<td align="right"><b>Investigator</b></td>
				<td align="center"><b>Classified</b></td>
				<td><b>Operations</b></td>
			</tr>
			<c:forEach var="file" items="${files}">
				<tr valign="top">
					<td>${file.id}</td>
					<td align="center"><img src="<c:url value='/${file.image}'/>" height="100px" /></td>
					<td align="right"><b>${file.title}</b></td>
					<td width="40%"><font size="-1">${file.report}</font></td>
					<td align="right"><b>${file.investigator}</b></td>
					<td align="center"><b>${file.classified}</b></td>
					<td>
						<a href="<c:url value='/xfiles/show/${file.id}'/>">show</a>
						<sec:authorize access="hasAnyRole('ROLE_ESPECIAL_AGENT','ROLE_ASSISTANT_DIRECTOR')">
							<a href="<c:url value='/xfiles/classify?id=${file.id}'/>">classify</a>
							<a href="<c:url value='/xfiles/declassify?id=${file.id}'/>">declassify</a>
						</sec:authorize>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>













