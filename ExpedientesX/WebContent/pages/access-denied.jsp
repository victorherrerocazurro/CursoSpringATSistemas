<%@page session="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
      <meta http-equiv="content-type" content="text/html; charset=UTF-8">
      <link rel="stylesheet" href="<c:url value='/css/styles.css'/>" type="text/css" />
      <title>Access Denied</title>
  </head>
<body>
<div id="content">
<img src="<c:url value='/images/xfiles.jpg'/>" align="right"/>
<h2>Access Denied</h2>

<p>
You don't have enough credentials. Please, 
<a href="<c:url value='/'/>">start again</a> ó <a href="<c:url value='/xfiles/show/all'/>">back to list</a><br><br>.
</p>
</div>
</body>
</html>
