/**
 * 
 */

$(document).ready(function () {
	
	var btnGetCourseView = $("#getCourseView")
		.click(btnGetCourseView_click); 
	
	
	var btnGetCourseView_click = function ()
	{
		window.location.href = "http://vcr-env.elasticbeanstalk.com/course/"; 
	}; 
}); 