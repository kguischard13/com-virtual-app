package com.vcclass.app.Data;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

@Scope(WebApplicationContext.SCOPE_REQUEST)

public class Comment
{
	@JsonProperty(value="CommentId")
	private int CommentId; 
	
	@JsonProperty(value="UserId")
	private int UserId; 
	
	@JsonProperty(value="QuestionId")
	private int QuestionId; 
	
	@JsonProperty(value="DateCreated")
	private Date DateCreated; 
	
	@JsonProperty(value="Contents")
	private String Contents;
	
	@JsonProperty(value="FilePath")
	private String FilePath; 
	
	public Comment()
	{
		this.CommentId = -1; 
		this.UserId = -1; 
		this.QuestionId = -1;
		this.DateCreated = null;
		this.Contents = "";
		this.FilePath = ""; 
	}
	
	
//Getters & Setters
	public int GetId()
	{
		return this.CommentId; 
	}
	
	public void SetId(int id)
	{
		this.CommentId = id; 
	}
	
	public int GetUserId()
	{
		return this.UserId;
	}
	
	public void SetUserId(int userId)
	{
		this.UserId = userId; 
	}
	
	public int GetQuestionId()
	{
		return this.QuestionId;
	}
	
	public void SetQuestionId(int questionId)
	{
		this.QuestionId = questionId; 
	}
		
	public Date GetCreationDate()
	{
		return this.DateCreated; 
	}
	
	public void SetCreationDate(Date dateCreated)
	{
		this.DateCreated = dateCreated; 
	}
	
	public String GetContents()
	{
		return this.Contents; 
	}
	
	public void SetContents(String contents)
	{
		this.Contents = contents; 
	}
	
	public String GetFilePath()
	{
		return this.FilePath; 
	}
	
	public void SetFilePath(String filePath)
	{
		this.FilePath = filePath; 
	}
	
}