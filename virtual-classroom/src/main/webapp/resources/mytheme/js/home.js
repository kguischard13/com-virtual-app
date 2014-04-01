/*

\brief This is a JavaScript for the home view
\author Chris Forehand
\date 3/20/14
\verbatim
	Test Cases: 
	
\endverbatim

*/
$(document).ready(function(){
	
	var ctrlLogin = $("#ctrlLogin"); 
	ctrlLogin.RegistrationControl({
		IsLoginControl: true, 
		DataManager: "http://localhost:8080/app/user/login/"
	}); 
	
	
	
	
}); 
