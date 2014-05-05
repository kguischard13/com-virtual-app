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
					<li class="sub-navigation-item"><a href="<c:url value='/' />" id="login" title="Log in if you already have an account.">Login</a></li>
					<li class="sub-navigation-item"><a href="<c:url value='/registration' />" id="new-user" title="New users, register here">Sign up</a></li>
					<li class="sub-navigation-item"><a href="#" id="forgot-password" title="Forgot your password?">Forgot my password</a></li>
				</ul>
		</ul>
</div>

<div id="container">

	<h1 class="header-text">Course View</h1>

	<div id="displayCourses"></div>
	
</div>

<div id="footer">Copyright 2014 - Virtual Classroom</div>



</body>
</html>
