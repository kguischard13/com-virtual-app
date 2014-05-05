/**
 * 
 */

$(document).ready(function () {
	
	
	var courseDisplay = $("#displayCourses"); 
	
	var btnGetCourses = $("<button>GetCourses</button>")
		.addClass("display-courses")
		.click()
		.appendTo("body"); 
	
	
	var btnGetCourses_click = function ()
	{
		return $.ajax({
			type: "GET",
			url: "http://vcr-env.elasticbeanstalk.com/course/getallcourses",
			accepts: "application/json"
		})
		.done(function (data, status, jqxhr)
		{
			console.log(data); 
		}); 
	}; 
}); 