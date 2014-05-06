package com.vcclass.app.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;

import com.vcclass.app.Data.*;
import com.vcclass.app.Services.*;

import java.util.List;



@Controller
public class CommentController 
{
	ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	
	@Autowired
	CommentService commentService = (CommentService) context.getBean("commentService");
	
	private static final Logger logger = LoggerFactory.getLogger(CommentController.class); 

	//Add comment
	@RequestMapping(value = "/comment/createcomment/{userid}/", method = RequestMethod.POST)
	public @ResponseBody int CreateComment(@PathVariable int userid, @RequestParam(value = "data", required = false) Comment inccomment)
	{
		Comment comment = inccomment;
		int id = commentService.CreateComment(userid, inccomment);
		return id;
	}

	//Get comment
	@RequestMapping(value = "/comment/getcomment/comment/{commentid}/user/{userid}/question/{questionid}", 
			method = RequestMethod.GET)
	public @ResponseBody  Comment GetComment(@PathVariable int commentid, @PathVariable int userid,
			@PathVariable int questionid)
	{
		return commentService.GetComment(commentid, userid, questionid);
	}
	
	//Get all comments
	@RequestMapping(value = "/comment/getcomments/question/{questionid}", 
			method = RequestMethod.GET)
	public @ResponseBody List<Comment> GetComments( @PathVariable int questionid)
	{
		return commentService.GetComments(questionid);
	}
	
	//Update comment
	@RequestMapping(value = "/comment/updatecomment/", method = RequestMethod.POST)
	public @ResponseBody boolean UpdateComment(@RequestBody Comment inccomment)
	{
		return commentService.UpdateComment(inccomment);
	}
	
	//Delete comment
	@RequestMapping(value = "/comment/deletecomment/comment/{commentid}/user/{userid}",
			method = RequestMethod.GET)
	public @ResponseBody boolean DeleteComment(@PathVariable int commentid, @PathVariable int userid)
	{
		return commentService.DeleteComment(commentid, userid);
	}
	
}
