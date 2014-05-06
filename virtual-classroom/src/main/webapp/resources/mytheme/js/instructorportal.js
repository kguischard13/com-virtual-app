/**
 * 
 */

$(document).ready(function () {
	
	var btnGetCourseView = $("#getCourseView"); 
	var btnGetUserView = $("#getUserView"); 
	
	var btnGetCourseView_click = function ()
	{
		window.location.href = "http://vcr-env.elasticbeanstalk.com/course/"; 
	}; 
	
	var btnGetUserView_click = function ()
	{
		window.location.href = "http://vcr-env.elasticbeanstalk.com/user"; 
	}; 
	
	btnGetCourseView.click(btnGetCourseView_click); 
	btnGetUserView.click(btnGetUserView_click); 
}); 