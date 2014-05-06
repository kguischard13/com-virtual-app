package com.vcclass.app.Controllers;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.vcclass.app.Data.*;
import com.vcclass.app.Services.*;


@Controller
public class CourseController {
	
	ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	private CourseService courseService = (CourseService) context.getBean("courseService");
	
	private static final Logger logger = LoggerFactory.getLogger(CourseController.class); 

	@RequestMapping(value = "/course", method = RequestMethod.GET)
	public String course()
	{
		return "courseview";  
	}
	
	@RequestMapping(value = "/course/createcoursesession", method = RequestMethod.POST)
	public @ResponseBody int CreateCourseSession(@RequestBody CourseSession coursesession){
		return courseService.CreateCourseSession(coursesession); 
	}
	
	@RequestMapping(value = "/course/createcourse", method = RequestMethod.POST)
	public @ResponseBody int CreateCourse(@RequestBody Course course){
		return courseService.CreateCourse(course); 
	}
	
	@RequestMapping(value = "/course/getcourse/{courseid}", method = RequestMethod.GET)
	public @ResponseBody Course GetCourse(@PathVariable int courseid){
		return courseService.GetCourse(courseid);
	}
	
	@RequestMapping(value = "/course/getcoursesession/{coursesessionid}", method = RequestMethod.GET)
	public @ResponseBody CourseSession GetCourseSession(@PathVariable int coursesessionid){
		return courseService.GetCourseSession(coursesessionid);
	}
	
	@RequestMapping(value="/course/deletecourse/{courseid}", method=RequestMethod.GET)
	public @ResponseBody boolean DeleteCourse(@PathVariable int courseid){
		return courseService.DeleteCourse(courseid);  
	}
	
	@RequestMapping(value="/course/deletecoursesession/{coursesessionid}", method=RequestMethod.GET)
	public @ResponseBody boolean DeleteCourseSession(@PathVariable int coursesessionid){
		return courseService.DeleteCourseSession(coursesessionid);  
	}
	
	@RequestMapping(value="/course/updatecourse", method=RequestMethod.POST)
	public @ResponseBody boolean UpdateCourse(@RequestBody Course course){
		return courseService.UpdateCourse(course); 
	}
	
	@RequestMapping(value="/course/updatecoursesession", method=RequestMethod.POST)
	public @ResponseBody boolean UpdateCourseSession(@RequestBody CourseSession coursesession){
		return courseService.UpdateCourseSession(coursesession); 
	}
	
	@RequestMapping(value="/course/addstudenttocourse/{stud}/course/{courseid}", method=RequestMethod.POST)
	public @ResponseBody boolean AddStudentToCourse(@PathVariable int stud, @PathVariable int courseid){
		return courseService.AddStudentToCourse(stud, courseid);  
	}
	
	@RequestMapping(value="/course/getallcourses", method=RequestMethod.GET)
	public @ResponseBody List<Course> GetAllCourses(){
		return courseService.GetAllCourses();  
	}
	
	@RequestMapping(value="/course/getallcoursesessions", method=RequestMethod.GET)
	public @ResponseBody List<CourseSession> GetAllCourseSessions(){
		return courseService.GetAllCourseSessions();  
	}
	
	@RequestMapping(value="/course/getstudentsofcourse/{courseid}", method=RequestMethod.GET)
	public @ResponseBody List<User> GetStudentsOfCourse(@PathVariable int courseid){
		return courseService.GetStudentsOfCourse(courseid);  
	}
	
	@RequestMapping(value="/course/getcoursesofstudent/{stud}", method=RequestMethod.GET)
	public @ResponseBody List<Course> GetCoursesOfStudent(@PathVariable int stud){
		return courseService.GetCoursesOfStudent(stud);  
	}
	
	@RequestMapping(value="/course/getsessionsofcourse/{courseid}", method=RequestMethod.GET)
	public @ResponseBody List<CourseSession> GetSessionsOfCourse(@PathVariable int courseid){
		return courseService.GetSessionsOfCourse(courseid);  
	}

}
