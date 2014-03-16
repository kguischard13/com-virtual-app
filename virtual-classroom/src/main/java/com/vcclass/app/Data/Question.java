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
	
	@JsonProperty(value="CourseId")
	private int CourseId; 
	
	@JsonProperty(value="Likes")
	private int Likes;
	
	@JsonProperty(value="Comments")
	private int Comments;
	
	@JsonProperty(value="QuestionType")
	private int QuestionType;
	
	@JsonProperty(value="FlagAsInappropriate")
	private boolean FlagAsInappropriate;
	
	@JsonProperty(value="IsPublic")
	private boolean IsPublic;
	
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
		this.CourseId = -1;
		this.StudentId = -1; 
		this.DateCreated = null;
		this.Contents = null;
		this.QuestionType = -1;
		this.IsPublic = true;
		this.FlagAsInappropriate = false;
		this.Likes = 0;
		this.Anonymous = true;
		this.Comments = 0;
	}
	
	public Question(int questionId, int courseId, int studentId, Date dateCreated, String contents,
			int questionType, boolean isPublic, boolean flagAsInappropriate, int numOfLikes, boolean isAnonymous)
	{
		this.QuestionId = questionId;
		this.CourseId = courseId;
		this.StudentId = studentId;
		this.DateCreated = dateCreated;
		this.Contents = contents;
		this.QuestionType = questionType;
		this.IsPublic = isPublic;
		this.FlagAsInappropriate = false;
		this.Likes = numOfLikes;
		this.Anonymous = isAnonymous;
		this.Comments = 0;

		this.FilePath = ""; 
		this.CommentsList = null;
		
	}
	
	
//Getters & Setters
	public int GetQuestionId()
	{
		return this.QuestionId; 
	}
	
	public void SetQuestionId(int id)
	{
		this.QuestionId = id; 
	}
	
	public int GetCourseId()
	{
		return this.CourseId;
	}
	
	public void SetCourseId(int courseId)
	{
		this.CourseId = courseId; 
	}
	
	public int GetStudentId()
	{
		return this.StudentId;
	}
	
	public void SetStudentId(int studentId)
	{
		this.StudentId = studentId; 
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
	
	public int GetQuestionType()
	{
		return this.QuestionType;
	}
	
	public void SetQuestionType(int questionType)
	{
		this.QuestionType = questionType; 
	}
	
	public boolean GetPublic()
	{
		return this.IsPublic;
	}
	
	public void SetPublic(boolean isPublic)
	{
		this.IsPublic = isPublic; 
	}
	
	public boolean GetFlag()
	{
		return this.FlagAsInappropriate;
	}
	
	public void SetFlag(boolean flagAsInappropriate)
	{
		this.FlagAsInappropriate = flagAsInappropriate; 
	}
	
	public int GetLikes()
	{
		return this.Likes;
	}
	
	public void SetLikes(int likes)
	{
		this.Likes = likes; 
	}
	
	public boolean GetAnonymous()
	{
		return this.Anonymous;
	}
	
	public void Setanonymous(boolean anonymous)
	{
		this.Anonymous = anonymous; 
	}
	
	
	
	
	
	public int GetComments()
	{
		return this.Comments;
	}
	
	public void SetComments(int comments)
	{
		this.Comments = comments; 
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
			
			if(comment.GetCommentId() == commentId)
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
