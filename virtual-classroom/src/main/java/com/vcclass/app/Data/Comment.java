package com.vcclass.app.Data;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

@Scope(WebApplicationContext.SCOPE_REQUEST)

public class Comment
{
	@JsonProperty(value="Id")
	private int Id; 
	
	@JsonProperty(value="QuestionId")
	private int QuestionId;
	
	@JsonProperty(value="UserId")
	private int UserId; 
	
	@JsonProperty(value="Content")
	private String Content;
	
	@JsonProperty(value="DateCreated")
	private Date DateCreated; 
	
	public Comment()
	{
		this.Id = -1;
		this.QuestionId = -1;
		this.UserId = -1;
		this.Content = "";
		this.DateCreated = null;
	}
	
	public Comment(int commentId, int questionId, int userId, String contents, Date dateCreated)
	{
		this.Id = commentId;
		this.QuestionId = questionId;
		this.UserId = userId; 
		this.Content = contents;
		this.DateCreated = dateCreated;
	}
	
	public Comment(int questionId, int userId, String contents, Date dateCreated)
	{
		this.QuestionId = questionId;
		this.UserId = userId; 
		this.Content = contents;
		this.DateCreated = dateCreated;
	}
	
			 
	
	
	//Getters & Setters
	public int GetCommentId()
	{
		return this.Id; 
	}
	
	public void SetCommentId(int id)
	{
		this.Id = id; 
	}
	
	public int GetQuestionId()
	{
		return this.QuestionId;
	}
	
	public void SetQuestionId(int questionId)
	{
		this.QuestionId = questionId; 
	}
	
	public int GetUserId()
	{
		return this.UserId;
	}
	
	public void SetUserId(int userId)
	{
		this.UserId = userId; 
	}
	
	public String GetContents()
	{
		return this.Content; 
	}
	
	public void SetContents(String content)
	{
		this.Content = content; 
	}	
	
	public Date GetDateCreated()
	{
		return this.DateCreated; 
	}
	
	public void SetDateCreated(Date dateCreated)
	{
		this.DateCreated = dateCreated; 
	}
}