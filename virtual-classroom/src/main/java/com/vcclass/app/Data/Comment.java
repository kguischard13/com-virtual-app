package com.vcclass.app.Data;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
@Scope(WebApplicationContext.SCOPE_REQUEST)

public class Comment
{
	@JsonProperty(value="commentId")
	private int commentId; 
	
	@JsonProperty(value="userId")
	private int userId; 
	
	@JsonProperty(value="questionId")
	private int questionId; 
	
	@JsonProperty(value="dateCreated")
	private Date dateCreated; 
	
	@JsonProperty(value="contents")
	private String contents;
	
	@JsonProperty(value="filePath")
	private String filePath; 
	
	public Comment()
	{
		this.commentId = -1; 
		this.userId = -1; 
		this.questionId = -1;
		this.dateCreated = null;
		this.contents = "";
		this.filePath = ""; 
	}
	
	
//Getters & Setters
	public int GetId()
	{
		return this.commentId; 
	}
	
	public void SetId(int id)
	{
		this.commentId = id; 
	}
	
	public int GetUserId()
	{
		return this.userId;
	}
	
	public void SetUserId(int userId)
	{
		this.userId = userId; 
	}
	
	public int GetQuestionId()
	{
		return this.questionId;
	}
	
	public void SetQuestionId(int questionId)
	{
		this.questionId = questionId; 
	}
		
	public Date GetCreationDate()
	{
		return this.dateCreated; 
	}
	
	public void SetCreationDate(Date dateCreated)
	{
		this.dateCreated = dateCreated; 
	}
	
	public String GetContents()
	{
		return this.contents; 
	}
	
	public void SetContents(String contents)
	{
		this.contents = contents; 
	}
	
	public String GetFilePath()
	{
		return this.filePath; 
	}
	
	public void SetFilePath(String filePath)
	{
		this.filePath = filePath; 
	}
	
}