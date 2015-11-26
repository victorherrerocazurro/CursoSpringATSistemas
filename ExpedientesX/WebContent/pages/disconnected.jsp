<%@page session="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
      <meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="<c:url value='/css/styles.css'/>" type="text/css" />
      <title>Disconnected</title>
  </head>
<body>
<div id="content">
<h2>Disconnected.</h2>
<p>
You have been disconnected. <a href="<c:url value='/'/>">Begin again</a>.
</p>
</div>
</body>
</html>
