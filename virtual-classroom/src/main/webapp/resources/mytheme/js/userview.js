/**
 * 
 */

$(document).ready(function () {
	
	var ctrlRegistration = $("#ctrlRegistration").hide(); 
	var pnlButtonContainer = $("#controlUserButtonContainer"); 
	var pnlUserDisplay = $("#displayUsers").hide(); 
	
	ctrlRegistration.RegistrationControl({
		DataManager: "http://localhost:8080/app/user/adduser"
	}); 
	
	var btnBackToPortal_click = function ()
	{
		window.location.href = "http://localhost:8080/app/home/instructor-portal"; 
	}; 
	
	var btnViewUsers_click = function ()
	{
		ctrlRegistration.hide();
		pnlUserDisplay.show(); 
		pnlUserDisplay.html("<b>Loading...</b>"); 
		
		return $.ajax({
			type: "GET",
			url: "http://localhost:8080/app/user/getallusers", 
			async: true, 
			accept: "application/json"
		})
		.done(function (data, status, jqhxr)
		{
			pnlUserDisplay.html(""); 
			Fill(data); 
		})
		.error(function (data, status, jqhxr) 
		{
			console.log(status); 
		}); 
	}; 
	
	var btnAddUser_click = function ()
	{
		pnlUserDisplay.hide(); 
		ctrlRegistration.show(); 
	}; 
	
	var Fill = function (data)
	{
		var items = data; 

		$.each(items, function (i, item) 
		{
			var userDiv = $("<div id='course" + i +"'></div>")
				.addClass("user-record")
				.prop("tag", item);
			
			userDiv.append("<p>First Name: " + item.FirstName + "</p>" + "<p>Last Name: " + item.LastName + "</p>"
					+ "<p>Email: " + item.Email + "</p>" + "<p>Phone Number: " + item.PhoneNumber + "</p>"); 
			
			userDiv.appendTo(pnlUserDisplay);
		}); 
	}; 
	
	var btnBackToPortal = $("<button>Back to Portal</button>")
		.click(btnBackToPortal_click)
		.appendTo(pnlButtonContainer); 
	
	var btnAddUser = $("<button>Add User</button>")
		.click(btnAddUser_click)
		.appendTo(pnlButtonContainer); 
	
	var btnViewUsers = $("<button>View Users</button>")
		.click(btnViewUsers_click)
		.appendTo(pnlButtonContainer); 
	
	
}); 