<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
      <meta http-equiv="content-type" content="text/html; charset=UTF-8">
      <link rel="stylesheet" href="<c:url value='/css/styles.css'/>" type="text/css" />
      <title>Welcome to FBI X Files App</title>
  </head>
<body>
<img src="images/xfiles.jpg" align="right"/>
<div id="content">

<h1>Main Page</h1>
<p>
Only agents can see this resource. Welcome <%= (request.getUserPrincipal() != null)?request.getUserPrincipal().getName():null %>
<a href="<c:url value='/j_spring_security_logout'/>">logout</a>
</p>
<hr/>
<%= request.getUserPrincipal() %>
<p>
<a href="<c:url value='/xfiles/show/all'/>">show files</a>
</p>
</div>
</body>
</html>
