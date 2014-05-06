/**
 * 
 */

$(document).ready(function () {
	
	var btnGetCourseView = $("#getCourseView"); 
	var btnGetUserView = $("#getUserView"); 
	
	var btnGetCourseView_click = function ()
	{
		window.location.href = "http://localhost:8080/app/course/"; 
	}; 
	
	var btnGetUserView_click = function ()
	{
		window.location.href = "http://localhost:8080/app/user"; 
	}; 
	
	btnGetCourseView.click(btnGetCourseView_click); 
	btnGetUserView.click(btnGetUserView_click); 
}); 