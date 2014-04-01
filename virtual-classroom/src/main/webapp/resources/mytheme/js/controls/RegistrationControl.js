/*

\brief This is a jQuery widget written in JavaScript for Registration Control
\author Chris Forehand
\date 3/20/14
\verbatim
	Test Cases: 
	
\endverbatim

*/

var VirtualClass = window.VirtualClass || {}; 

(function ($, vc, undefined)
{
    //  ------------------------------------------------------------------------------------------------
    // Options for the widget
    //  ------------------------------------------------------------------------------------------------
    
    var _options = {
        DataManager: null,
        IsLoginControl: false
    };

    //  ------------------------------------------------------------------------------------------------
    // This function is called by the jQuery widget engine to create the widget.
    //  ------------------------------------------------------------------------------------------------
    var create = function ()
    {
        var self = this;
        var elm = self.element;
        
        var _strings = {
        	LabelFirstName: "First Name:",
        	LabelLastName: "Last Name:",
        	LabelEmail: "Email:",
        	LabelUserName: "Username:",
        	LabelPassword: "Password:",
        	ButtonRegister: "Register", 
        	ButtonCancel: "Cancel",
        	ButtonLogin: "Login"
        }; 

        //  ------------------------------------------------------------------------------------------------
        // Instance (global) variables.
        //  ------------------------------------------------------------------------------------------------
 
        var _isLoginControl = self.options.IsLoginControl; 
        var _dataManager = self.options.DataManager; 
        
        if(_dataManager == null)
    	{
    		throw new Error ("Data manager is required"); 
    	}
        
        //  ------------------------------------------------------------------------------------------------
        // UI elements.
        //  ------------------------------------------------------------------------------------------------        
        var pnlContainer = null;
        var txtFirstName = null; 
        var lblFirstName = null; 
        var txtLastName = null; 
        var lblLastName = null; 
        var txtEmail = null; 
        var lblEmail = null; 
        var txtUserName = null;
        var lblUserName = null; 
        var txtPassword = null; 
        var lblPassword = null; 
        var pnlButtonContainer = null; 
        var btnSubmit = null; 
        var btnCancel = null; 
        var pnlForgotPassword = null; 
        var lnkForgotPassword = null; 
        var lnkRegisterAccount = null; 
        
        //  ------------------------------------------------------------------------------------------------
        // Initialization code.
        //  ------------------------------------------------------------------------------------------------
        var Init = function ()
        {
            /// <summary>Initialize the widget's DOM elements.</summary>
			elm.addClass("vc-registration-control"); 
			
            pnlContainer = $("<div />")
                .addClass("pnl-container")
                .appendTo(elm);
                
            txtFirstName =$("<input type='text' />")
                .addClass("reg-form-input")
                .appendTo(pnlContainer);
                
            lblFirstName = $("<label class='reg-form-label' />")
            	.addClass("reg-form-label")
            	.html(_strings.LabelFirstName)
            	.appendTo(pnlContainer)
            	.append(txtFirstName);  
            	
            txtLastName =$("<input type='text' />")
                .addClass("reg-form-input")
                .appendTo(pnlContainer);
                
            lblLastName = $("<label class='reg-form-label' />")
            	.addClass("reg-form-label")
            	.html(_strings.LabelLastName)
            	.appendTo(pnlContainer)
            	.append(txtLastName);  
            
            txtEmail =$("<input type='text' />")
                .addClass("reg-form-input")
                .appendTo(pnlContainer);
                
            lblEmail = $("<label class='reg-form-label' />")
            	.addClass("reg-form-label")
            	.html(_strings.LabelEmail)
            	.appendTo(pnlContainer)
            	.append(txtEmail);  
            	
            txtUserName =$("<input type='text' />")
                .addClass("reg-form-input")
                .appendTo(pnlContainer);
                
            lblUserName = $("<label class='reg-form-label' />")
            	.addClass("reg-form-label")
            	.html(_strings.LabelUserName)
            	.appendTo(pnlContainer)
            	.append(txtUserName);      
            	
            txtPassword =$("<input type='password' />")
                .addClass("reg-form-input")
                .appendTo(pnlContainer);
                
            lblPassword = $("<label class='reg-form-label' />")
            	.addClass("reg-form-label")
            	.html(_strings.LabelPassword)
            	.appendTo(pnlContainer)
            	.append(txtPassword);        
            	
            pnlButtonContainer = $("<div />")
            	.addClass("pnl-button-container")
            	.appendTo(pnlContainer); 	
            
            btnSubmit = $("<button id ='btnSubmit' type='button' />")
            	.addClass("btn-form")
            	.click(btnSubmit_click)
            	.appendTo(pnlButtonContainer); 
            	
            btnCancel = $("<button id='btnCancel' type='button' />")
            	.addClass("btn-form")
            	.html(_strings.ButtonCancel)
            	.appendTo(pnlButtonContainer);  
            
            pnlForgotPassword = $("<div />")
            	.addClass("pnl-forgot-password")
            	.appendTo(pnlContainer); 
            
            lnkRegisterAccount = $("<a href='#'>Register Account</a>")
        	.addClass("lnk-register-account")
        	.appendTo(pnlForgotPassword)
        	.hide(); 
            
            lnkForgotPassword = $("<a href='#'>Forgot Password?</a>")
            	.addClass("lnk-forgot-password")
            	.appendTo(pnlForgotPassword)
            	.hide(); 
            
            if(_isLoginControl)
        	{
            	lblFirstName.hide();
            	lblLastName.hide(); 
            	lblEmail.hide(); 
            	lnkForgotPassword.show();
            	lnkRegisterAccount.show();
        	}
            
        	SetSubmitLabel(); 
        };

        var SetSubmitLabel = function ()
        {
        	if(_isLoginControl)
        	{
        		btnSubmit.html(_strings.ButtonLogin); 
        	}
        	else
        	{
        		btnSubmit.html(_strings.ButtonRegister); 
        	}
        }; 
        
        var btnSubmit_click = function ()
        {
            var username = txtUserName.val();
            var password = txtPassword.val(); 
        	
        	var data =  { 
            	Username: username,
            	Password: password 
            }; 
        	
        	var onSuccess = function (data, status)
        	{
        		console.log(data); 
        	}; 
        	
        	var onError = function (jqxhr, data, err)
        	{
        		console.log(err);
        	}; 
        	
        	
        	return $.ajax({
        		type: "POST", 
        		url: _dataManager,
        		data: data,
        		contentType: "application/json",
        		success: onSuccess, 
        		error: onError
        	}); 
        	        	
//        	var url = "http://localhost:8080/app/user/login/{0}/{1}"; 
//            url = url.replace("{0}", username).replace("{1}", password); 
//            window.location = url;  
        };

        var Value = function ()
        {
            /// <summary>Gets the selected media outlet.</summary>

            var value = null;

            if (txtFoo != null)
            {
                value = txtFoo.val();
            }

            return value;
        };
        
        var Clear = function ()
        {
            // Put the widget into some neutral state.
        };

        //  ------------------------------------------------------------------------------------------------
        // Public methods
        //  ------------------------------------------------------------------------------------------------
        self.Value = Value;
        self.Clear = Clear;
        
        Init();
    };

    //  ------------------------------------------------------------------------------------------------
    // This function is called by the jQuery widget engine to destroy the widget.
    //  ------------------------------------------------------------------------------------------------
    var destroy = function ()
    {
        /// <summary> Use the destroy method to clean up any modifications your widget has made to the DOM </summary>

        // clear things created by us
        this.element.children().remove();
        // invoke the destroy method from the base widget
        this.element.removeData(this.widgetName);
        $.Widget.prototype.destroy.call(this);
    };

    //  ------------------------------------------------------------------------------------------------
    // Create the jQuery widget class
    //  ------------------------------------------------------------------------------------------------
    $.widget("VirtualClass.RegistrationControl", {
        options: _options,
        _create: create,
        destroy: destroy
    });
})(jQuery, VirtualClass);