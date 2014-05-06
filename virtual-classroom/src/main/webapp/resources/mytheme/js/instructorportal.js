/**
 * 
 */

$(document).ready(function () {
	
	var btnGetCourseView = $("#getCourseView"); 
	
	var btnGetCourseView_click = function ()
	{
		window.location.href = "http://vcr-env.elasticbeanstalk.com/course/"; 
	}; 
	
	btnGetCourseView.click(btnGetCourseView_click); 
}); 