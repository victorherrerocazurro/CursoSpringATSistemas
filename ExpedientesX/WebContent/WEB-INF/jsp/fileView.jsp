<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <meta http-equiv="content-type" content="text/html; charset=UTF-8">
      <link rel="stylesheet" href="<c:url value='/css/styles.css'/>" type="text/css" />
      <title>X Files</title>
  </head>
<body>
<div id="content">

<h1>X Files</h1>
<a href="<c:url value='/xfiles/show/all'/>">BACK</a><br><br>

<table>
<tr><td colspan="2"><img src="<c:url value='/${file.image}'/>" height="200px"/></td></tr>
<tr><td><b>Title:</b></td><td>${file.title}</td></tr>
<tr><td><b>Teport:</b></td><td>${file.report}</td></tr>
<tr><td><b>Investigator:</b></td><td>${file.investigator}</td>
<tr><td><b>Classified:</b></td><td>${file.classified}</td></tr>
</table>
</div>
</body>
</html>













