package com.vcclass.app.Controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vcclass.app.Data.*;
import com.vcclass.app.Services.*;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
<<<<<<< HEAD
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		//UserService student = (UserService) context.getBean("userservice");
		CourseService course = (CourseService) context.getBean("courseService");
		CourseSession cour = course.GetCourseSession(4);
		
		QuestionService question = (QuestionService) context.getBean("questionService");
		CommentService comment = (CommentService) context.getBean("commentService");
		
		//int a = 2;
		//Student stud = student.GetUser(a);
		
=======
>>>>>>> FETCH_HEAD
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		String c = "Class 784 - Web App Web Dev";

		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("Class", c);
		
		
		return "home";
	}
}
