<!-- 
\brief This is the client-side home view
\author Chris Forehand
\date 3/20/14
\verbatim
	Test Cases: 
	
\verbatim

 -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>
	<title>VirtualClass - Login</title>
	<script src="<c:url value="/resources/mytheme/js/jquery-ui-1.10.4/jquery-1.10.2.js" />"></script>
	<script src="<c:url value="/resources/mytheme/js/jquery-ui-1.10.4/ui/jquery-ui.js" />"></script>
	<script src="<c:url value="/resources/mytheme/js/main.js" />"></script>
	<script src="<c:url value="/resources/mytheme/js/home.js" />"></script>
	<script src="<c:url value="/resources/mytheme/js/controls/RegistrationControl.js" />"></script>
	<link href="<c:url value="/resources/mytheme/css/main.css" />" rel="stylesheet">	
	<link href="<c:url value="/resources/mytheme/css/home.css" />" rel="stylesheet">	
	<link href="<c:url value="/resources/mytheme/css/Controls/RegistrationControl.css" />" rel="stylesheet">
	
</head>
<body>

<div id="navigation-panel">
</div>

<div id="container">

	<h1 class="header-text">The Virtual Classroom</h1>

	<div id="ctrlLogin"></div>
	
</div>

<div id="footer">Copyright 2014 - Virtual Classroom</div>



</body>
</html>
