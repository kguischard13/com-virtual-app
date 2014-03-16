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
	
	@JsonProperty(value="QuestionId")
	private int QuestionId;
	
	@JsonProperty(value="StudentId")
	private int StudentId; 
	
	@JsonProperty(value="TeacherId")
	private int TeacherId; 
	
	@JsonProperty(value="DateCreated")
	private Date DateCreated; 
	
	@JsonProperty(value="Contents")
	private String Contents;
	
	@JsonProperty(value="FilePath")
	private String FilePath; 
	
	public Comment()
	{
		this.CommentId = -1;
		this.QuestionId = -1;
		this.StudentId = -1; 
		this.TeacherId = -1;
		this.Contents = "";
		this.DateCreated = null;
		//this.FilePath = ""; //Missing from db
	}
	
	public Comment(int commentId, int questionId, int studentId, int teacherID, String contents, Date dateCreated)
	{
		this.CommentId = commentId;
		this.QuestionId = questionId;
		this.StudentId = studentId; 
		this.TeacherId = teacherID;
		this.Contents = contents;
		this.DateCreated = dateCreated;
		//this.FilePath = ""; //Missing from db
		
	}
			 
	
	
//Getters & Setters
	public int GetCommentId()
	{
		return this.CommentId; 
	}
	
	public void SetCommentId(int id)
	{
		this.CommentId = id; 
	}
	
	public int GetQuestionId()
	{
		return this.QuestionId;
	}
	
	public void SetQuestionId(int questionId)
	{
		this.QuestionId = questionId; 
	}
	
	public int GetStudentId()
	{
		return this.StudentId;
	}
	
	public void SetStudentId(int studentId)
	{
		this.StudentId = studentId; 
	}
	
	public int GetTeacherId()
	{
		return this.TeacherId;
	}
	
	public void SetTeacherId(int teacherId)
	{
		this.TeacherId = teacherId; 
	}
	
	public String GetContents()
	{
		return this.Contents; 
	}
	
	public void SetContents(String contents)
	{
		this.Contents = contents; 
	}	
	
	public Date GetCreationDate()
	{
		return this.DateCreated; 
	}
	
	public void SetCreationDate(Date dateCreated)
	{
		this.DateCreated = dateCreated; 
	}
	
	
	/*// needs to be added to db
	public String GetFilePath()
	{
		return this.FilePath; 
	}
	
	public void SetFilePath(String filePath)
	{
		this.FilePath = filePath; 
	}
	*/
	
}