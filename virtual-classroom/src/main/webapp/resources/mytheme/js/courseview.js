/**
 * 
 */

$(document).ready(function () {
	
	
	var pnlCourseDisplay = $("#displayCourses");
	var pnlButtonContainer = $("#controlButtonContainer"); 
	var pnlDisplayQuestions = $("#displayQuestions").hide(); 
	var btnCancel = null; 
	
	var btnGetCourses_click = function ()
	{
		pnlCourseDisplay.html("<b>Loading...</b>"); 
		
		return $.ajax({
			type: "GET",
			url: "http://localhost:8080/app/course/getallcourses",
			accept: "application/json",
			async: true
		})
		.done(function (data, status, jqxhr)
		{
			pnlCourseDisplay.html(""); 
			Fill(data); 
		})
		.error(function (data, status, jqxhr)
		{
			console.log(status); 
		}); 
	}; 
	
	var btnBackToPortal_click = function ()
	{
		window.location.href = "http://localhost:8080/app/home/instructor-portal"; 
	}; 
		
	var courseCodeLink_click = function (e)
	{
		//e.preventDefault(); 
		if (e.target.nodeName == "LABEL")
		{
			var id = e.currentTarget.id;
			var tag = $("#" + id).prop("tag");
			
			//ShowQuestions(tag.Id); 
		}
	}; 
	
	var ShowQuestions = function (courseId)
	{
		var url = "http://localhost:8080/app/question/getquestions/course/{0}".replace("{0}", courseId); 
		
		return $.ajax({
			type: "GET",
			url: url, 
			accept: "application/json",
			async: true
		})
		.done(function (data, status, jqxhr) 
		{
			DisplayQuestions(data); 
		})
		.error(function (jqxhr, status, data)
		{
			console.log(status); 
		}); 
	};
	
	var DisplayQuestions = function (data)
	{
		pnlDisplayQuestions.show(); 
		
		$.each(data, function (i, item) 
		{
			var question = item; 
			var questionDivId = "question" + i; 
			
			var questionDiv = $("<div id='" + questionDivId + "'></div>")
			.addClass("course-record")
			.prop("tag", item);
		
			var questionId = "questionResult" + i; 
			questionDiv.append("<p>Question " + i + ": " + item.Contents + "</p>"); 	
			questionDiv.appendTo(pnlDisplayQuestions);			
		}); 
	}; 
	
	var Fill = function (data)
	{	
		var items = data; 

		$.each(items, function (i, item) 
		{
			var courseDivId = "course" + i; 
			
			var courseDiv = $("<div id='" + courseDivId + "'></div>")
				.addClass("course-record")
				.prop("tag", item);
			
			var courseCodeId = "courseCode" + i; 
			
			courseDiv.append("<p>Course Code: <b>" + "<label class='fake-link' id='" + courseCodeId + "'>" + item.CourseCode + "</label></b></p>" 
					+ "<p>Course Title: " + item.CourseTitle + "</p>"
					+ "<p>Start Date: " + item.StartTime + "</p>" 
					+ "<p>End Date: " + item.EndTime + "</p>"); 	
						
			courseDiv.appendTo(pnlCourseDisplay);
			
			// bind the click event and function to each hyperlink
			$("#displayCourses " + "#" + courseDivId).on("click", courseCodeLink_click); 
		}); 
	}; 
	
	var btnBackToPortal = $("<button>Back to Portal</button>")
		.click(btnBackToPortal_click)
		.appendTo(pnlButtonContainer); 
	
	var btnGetCourses = $("<button>GetCourses</button>")
		.addClass("display-courses")
		.click(btnGetCourses_click)
		.appendTo(pnlButtonContainer); 
}); 