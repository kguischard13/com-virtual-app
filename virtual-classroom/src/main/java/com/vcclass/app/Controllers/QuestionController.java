package com.vcclass.app.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;

import com.vcclass.app.Data.*;
import com.vcclass.app.Services.*;

import java.util.List;


@Controller
public class QuestionController 
{
	ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	QuestionService questionService = (QuestionService) context.getBean("questionService");
	
	private static final Logger logger = LoggerFactory.getLogger(QuestionController.class); 

	//Add question
	@RequestMapping(value = "/question/createquestion", method = RequestMethod.POST)
	public @ResponseBody int CreateQuestion(@PathVariable int userid, @RequestBody Question incquestion)
	{
		Question question = incquestion;
		int id = questionService.CreateQuestion(userid, incquestion);
		return id;
	}

	//Get question
	@RequestMapping(value = "/question/getquestion/question/{questionid}/user/{userid}/course/{courseid}", 
			method = RequestMethod.GET)
	public @ResponseBody  Question GetQuestion(@PathVariable int questionid, @PathVariable int userid,
			@PathVariable int courseid)
	{
		return questionService.GetQuestion(questionid, userid, courseid);
	}
	
	//Get all student questions
	@RequestMapping(value = "/question/getquestions/user/{userid}/course/{courseid}", 
			method = RequestMethod.GET)
	public @ResponseBody List<Question> GetStudentQuestions(@PathVariable int userid, @PathVariable int courseid)
	{
		return questionService.GetStudentQuestions(userid, courseid);
	}
	
	//Get all public course questions
		@RequestMapping(value = "/question/getquestions/course/{courseid}", 
				method = RequestMethod.GET)
		public @ResponseBody List<Question> GetAllQuestions(@PathVariable int courseid)
		{
			return questionService.GetAllQuestions(courseid);
		}
	
	
	//Update question
	@RequestMapping(value = "/question/updatequestion/", method = RequestMethod.POST)
	public @ResponseBody boolean UpdateQuestion(@RequestBody Question incquestion)
	{
		return questionService.UpdateQuestion(incquestion);
	}
	
	//Delete question
	@RequestMapping(value = "/question/deletequestion/question/{questionid}/user/{userid}",
			method = RequestMethod.GET)
	public @ResponseBody boolean DeleteQuestion(@PathVariable int questionid, @PathVariable int userid)
	{
		return questionService.DeleteQuestion(questionid, userid);
	}

}
