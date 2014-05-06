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
	<title>VirtualClass - User View</title>
	<script src="<c:url value="/resources/mytheme/js/jquery-ui-1.10.4/jquery-1.10.2.js" />"></script>
	<script src="<c:url value="/resources/mytheme/js/jquery-ui-1.10.4/ui/jquery-ui.js" />"></script>
	<script src="<c:url value="/resources/mytheme/js/main.js" />"></script>
	<script src="<c:url value="/resources/mytheme/js/userview.js" />"></script>
	<script src="<c:url value="/resources/mytheme/js/controls/RegistrationControl.js" />"></script>
	<link href="<c:url value="/resources/mytheme/css/Controls/RegistrationControl.css" />" rel="stylesheet">	
	<link href="<c:url value="/resources/mytheme/css/userview.css" />" rel="stylesheet">	


	<link href="<c:url value="/resources/mytheme/css/main.css" />" rel="stylesheet">	
	<link href="<c:url value="/resources/mytheme/css/home.css" />" rel="stylesheet">
	
	
</head>
<body>

<div id="navigation-panel">
		<ul>
			<li class="navigation-item"><a href="<c:url value='/' />">Home</a></li>
			<li class="navigation-item"><a href="#">Courses</a></li>
			<li class="navigation-item"><a href="#">Students</a></li>
			<li class="navigation-item"><a href="#">Reports</a></li>
			<li class="navigation-item" id="myAccount"><a href="#">My Account</a></li>
				<ul id="sub-menu">
					<li class="sub-navigation-item"><a href="<c:url value='/' />" id="login">Logout</a></li>
				</ul>
		</ul>
</div>

<div id="container">

	<h1 class="header-text">User View</h1>
	<div class="control-button-container" id="controlUserButtonContainer"></div>
	<div id="ctrlRegistration"></div>
	<div id="displayUsers"></div>
	
</div>

<div id="footer">Copyright 2014 - Virtual Classroom</div>



</body>
</html>
