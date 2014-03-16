package com.vcclass.app.Repository;

import com.vcclass.app.Data.Comment;
import javax.sql.DataSource;

public interface CommentDAO 
{
	//All 'students' to be changed to 'user'
	public void setDataSource(DataSource ds);
	public int CreateComment(int studentId, Comment comment);
	public Comment GetComment(int commentId, int studentId, int questionId);
	public boolean UpdateComment(Comment comment);
	public boolean DeleteComment(int studentId, int commentId);
}