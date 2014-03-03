package com.vcclass.app.Data;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
//import java.util.ListIterator;

import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

@Scope(WebApplicationContext.SCOPE_REQUEST)

public class Question
{
	@JsonProperty(value="QuestionId")
	private int QuestionId;
	
	@JsonProperty(value="StudentId")
	private int StudentId; 
	
	@JsonProperty(value="ClassId")
	private int ClassId; 
	
	@JsonProperty(value="Likes")
	private int Likes;
	
	@JsonProperty(value="Comments")
	private int Comments;
	
	@JsonProperty(value="QuestionType")
	private int QuestionType;
	
	@JsonProperty(value="FlagAsInappropriate")
	private boolean FlagAsInappropriate;
	
	@JsonProperty(value="Anonymous")
	private boolean Anonymous;
	
	@JsonProperty(value="DateCreated")
	private Date DateCreated; 
	
	@JsonProperty(value="Contents")
	private String Contents;
	
	@JsonProperty(value="FilePath")
	private String FilePath; 
	
	@JsonProperty(value="CommentsList")
	private List<Comment> CommentsList; 
	
	public Question()
	{
		this.QuestionId = -1; 
		this.StudentId = -1; 
		this.ClassId = -1;
		this.Likes = 0;
		this.Comments = 0;
		this.QuestionType = -1;
		this.FlagAsInappropriate = false;	
		this.Anonymous = true;
		this.DateCreated = null;
		this.Contents = "";
		this.FilePath = ""; 
		this.CommentsList = null;
	}
	
	
//Getters & Setters
	public int GetId()
	{
		return this.QuestionId; 
	}
	
	public void SetId(int id)
	{
		this.QuestionId = id; 
	}
	
	public int GetStudentId()
	{
		return this.StudentId;
	}
	
	public void SetStudentId(int studentId)
	{
		this.StudentId = studentId; 
	}
	
	public int GetClassId()
	{
		return this.ClassId;
	}
	
	public void SetClassId(int classId)
	{
		this.ClassId = classId; 
	}
	
	public int Likes()
	{
		return this.Likes;
	}
	
	public void SetLikes(int likes)
	{
		this.Likes = likes; 
	}
	
	public int GetComments()
	{
		return this.Comments;
	}
	
	public void SetComments(int comments)
	{
		this.Comments = comments; 
	}
	
	public int GetQuestionType()
	{
		return this.QuestionType;
	}
	
	public void SetQuestionType(int questionType)
	{
		this.QuestionType = questionType; 
	}
	
	public boolean GetFlag()
	{
		return this.FlagAsInappropriate;
	}
	
	public void SetFlag(boolean flagAsInappropriate)
	{
		this.FlagAsInappropriate = flagAsInappropriate; 
	}
	
	public boolean GetAnonymous()
	{
		return this.Anonymous;
	}
	
	public void Setanonymous(boolean anonymous)
	{
		this.Anonymous = anonymous; 
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
	
	public List<Comment> GetCommentsList()
	{
		return this.CommentsList; 
	}
	
	public void SetCommentsList (List<Comment> list)
	{
		this.CommentsList = list; 
	}
	
	
	
	

	//Add comment to question
	public void AddComment(Comment comment)
	{
		this.CommentsList.add(comment); 
	}
	

	//Get comment by ID
	public Comment GetCommentById(int commentId)
	{
		Iterator<Comment> itr = this.CommentsList.iterator(); 
		
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
		return this.CommentsList.remove(comment); 
	}

}
