package com.vcclass.app.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vcclass.app.Data.Question;
import com.vcclass.app.Data.Comment;



@Controller
public class QuestionController 
{
	private static final Logger logger = LoggerFactory.getLogger(QuestionController.class); 

	@RequestMapping(value = "/question", method = RequestMethod.GET)
	public @ResponseBody  Question GetQuestion(Model model)
	{
		Question question = new Question(); 
		
		question.SetQuestionId(11);
		question.SetContents("What question is this?");
		
		Comment comment = new Comment();
		
		comment.SetCommentId(22);
		comment.SetContents("My comment is that I like this question");
		
		question.AddComment(comment);
		model.addAttribute("Question", question.GetContents()); 
		model.addAttribute("Comment", comment.GetContents());
		
		logger.info("Return the question");
		
		return question;
	}

}
