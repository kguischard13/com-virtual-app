package com.vcclass.app.Controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vcclass.app.Data.*;
import com.vcclass.app.Services.*;


@Controller
public class UserController {
	
	ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	private UserService userService = (UserService) context.getBean("userService");
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class); 
	
	@RequestMapping(value = "/user/getuser/{userid}", method = RequestMethod.GET)
	public @ResponseBody User GetUser(@PathVariable int userid){
		return userService.GetUser(userid); 
	}
	
	@RequestMapping(value = "/user/getallusers", method = RequestMethod.GET)
	public @ResponseBody List<User> GetAllUsers(){
		return userService.GetAllUsers();
	}
	
	@RequestMapping(value = "/user/getteachers", method = RequestMethod.GET)
	public @ResponseBody List<User> GetTeachers(){
		return userService.GetTeachers();
	}
	
	@RequestMapping(value="/user/getstudents", method=RequestMethod.GET)
	public @ResponseBody List<User> GetStudents(){
		return userService.GetStudents();  
	}
	
	@RequestMapping(value="/user/adduser", method=RequestMethod.POST)
	public @ResponseBody int AddUser(@RequestBody User user){
		return userService.AddUser(user);  
	}
	
	@RequestMapping(value="/user/deleteuser/{userid}", method=RequestMethod.GET)
	public @ResponseBody boolean DeleteUser(@PathVariable int userid){
		return userService.DeleteUser(userid);  
	}
	
	@RequestMapping(value="/user/updateuser", method=RequestMethod.POST)
	public @ResponseBody boolean UpdateUser(@RequestBody User user){
		return userService.UpdateUser(user); 
	}
	
	@RequestMapping(value="/user/{userid}", method=RequestMethod.GET)
	public @ResponseBody boolean ValidateUser(@PathVariable int userid){
		return userService.ValidateUser(userid);  
	}
	
	@RequestMapping(value="/user/login/{email}/{password}", method=RequestMethod.GET)
	public String LoginUser(@PathVariable String email, @PathVariable String password)
	{
		User user = userService.LoginUser(email, password); 
		
		if(user == null)
		{
			return "unauthorized"; 
		}
		else
		{
			return "registration"; 
		}
	}
}
