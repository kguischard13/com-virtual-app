package com.vcclass.app.Data;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
//import java.util.ListIterator;


import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
@Scope(WebApplicationContext.SCOPE_REQUEST)

public class Question
{
	@JsonProperty(value="questionId")
	private int questionId;
	
	@JsonProperty(value="studentId")
	private int studentId; 
	
	@JsonProperty(value="classId")
	private int classId; 
	
	@JsonProperty(value="likes")
	private int likes;
	
	@JsonProperty(value="comments")
	private int comments;
	
	@JsonProperty(value="questionType")
	private int questionType;
	
	@JsonProperty(value="flagAsInappropriate")
	private boolean flagAsInappropriate;
	
	@JsonProperty(value="anonymous")
	private boolean anonymous;
	
	@JsonProperty(value="dateCreated")
	private Date dateCreated; 
	
	@JsonProperty(value="contents")
	private String contents;
	
	@JsonProperty(value="filePath")
	private String filePath; 
	
	@JsonProperty(value="commentsList")
	private List<Comment> commentsList; 
	
	public Question()
	{
		this.questionId = -1; 
		this.studentId = -1; 
		this.classId = -1;
		this.likes = -1;
		this.comments = -1;
		this.questionType = -1;
		this.flagAsInappropriate = false;	
		this.anonymous = true;
		this.dateCreated = null;
		this.contents = "";
		this.filePath = ""; 
		this.commentsList = null;
	}
	
	
//Getters & Setters
	public int GetId()
	{
		return this.questionId; 
	}
	
	public void SetId(int id)
	{
		this.questionId = id; 
	}
	
	public int GetStudentId()
	{
		return this.studentId;
	}
	
	public void SetStudentId(int studentId)
	{
		this.studentId = studentId; 
	}
	
	public int GetClassId()
	{
		return this.classId;
	}
	
	public void SetClassId(int classId)
	{
		this.classId = classId; 
	}
	
	public int Likes()
	{
		return this.likes;
	}
	
	public void SetLikes(int likes)
	{
		this.likes = likes; 
	}
	
	public int GetComments()
	{
		return this.comments;
	}
	
	public void SetComments(int comments)
	{
		this.comments = comments; 
	}
	
	public int GetQuestionType()
	{
		return this.questionType;
	}
	
	public void SetQuestionType(int questionType)
	{
		this.questionType = questionType; 
	}
	
	public boolean GetFlag()
	{
		return this.flagAsInappropriate;
	}
	
	public void SetFlag(boolean flagAsInappropriate)
	{
		this.flagAsInappropriate = flagAsInappropriate; 
	}
	
	public boolean GetAnonymous()
	{
		return this.anonymous;
	}
	
	public void Setanonymous(boolean anonymous)
	{
		this.anonymous = anonymous; 
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
	
	public List<Comment> GetCommentsList()
	{
		return this.commentsList; 
	}
	
	public void SetCommentsList (List<Comment> list)
	{
		this.commentsList = list; 
	}
	
	
	
	
//Service methods	
	
	//Add comment to question
	public void AddComment(Comment comment)
	{
		this.commentsList.add(comment); 
	}
	

	//Get comment by ID
	public Comment GetCommentById(int commentId)
	{
		Iterator<Comment> itr = this.commentsList.iterator(); 
		
		while(itr.hasNext())
		{
			Comment comment = (Comment)itr.next(); 
			
			if(comment.GetId() == commentId)
			{
				return comment; 
			}
		}
		
		return null; 
	}
	
	
	//Delete a comment
	public boolean DeleteComment (int commentId)
	{
		Comment comment = this.GetCommentById(commentId); 
		return this.commentsList.remove(comment); 
	}

}
