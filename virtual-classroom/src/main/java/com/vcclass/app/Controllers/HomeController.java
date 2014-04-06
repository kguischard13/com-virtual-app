package com.vcclass.app.Controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vcclass.app.Data.*;
import com.vcclass.app.Services.*;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	private UserService userService = (UserService) context.getBean("userService");
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) 
	{		
		return "home";
	}
	
	@RequestMapping(value = "/home/registration", method = RequestMethod.GET)
	public String registration() 
	{		
		return "registration";
	}
	
	@RequestMapping(value = "/home/instructor-portal", method = RequestMethod.GET)
	public String instructorPortal() 
	{		
		return "instructor-portal";
	}
	
	@RequestMapping(value="/home/login", method=RequestMethod.POST)
	public String LoginUser(@RequestBody LoginCredentials creds, HttpServletResponse response)
	{
		String email = creds.Email; 
		String password = creds.Password; 
		
		User user = userService.LoginUser(email, password); 
		
		if(user == null)
		{
			return "unauthorized"; 
		}
		else
		{
			String url = ServletUriComponentsBuilder.fromCurrentContextPath().path("/home/instructor-portal").build().toUriString();
			response.setHeader("Location", url);
			return "instructor-portal"; 
		}
	}
}
