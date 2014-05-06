/**
 * 
 */

$(document).ready(function () {
	
	
	var courseDisplay = $("#displayCourses"); 
	
	var btnGetCourses_click = function ()
	{
		return $.ajax({
			type: "GET",
			url: "http://vcr-env.elasticbeanstalk.com/course/getallcourses",
			accepts: "application/json",
			async: true
		})
		.done(function (data, status, jqxhr)
		{
			console.log(data); 
		})
		.error(function (data, status, jqxhr)
		{
			console.log(status); 
		}); 
	}; 
	
	var btnGetCourses = $("<button>GetCourses</button>")
		.addClass("display-courses")
		.click(btnGetCourses_click)
		.appendTo("body"); 
	
	

}); 