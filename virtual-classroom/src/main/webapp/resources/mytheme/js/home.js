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
		DataManager: "http://vcr-env.elasticbeanstalk.com/home/Login"
	}); 
	
	// make this so that it's included in a jsp so that we can use c:url to link to a resource
	
	
}); 
