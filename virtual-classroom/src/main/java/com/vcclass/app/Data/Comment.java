package com.vcclass.app.Data;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
@Scope(WebApplicationContext.SCOPE_REQUEST)

public class Comment
{
	private int commentId; 
	private int userId; 
	private int questionId; 
	private Date dateCreated; 
	private String contents;
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