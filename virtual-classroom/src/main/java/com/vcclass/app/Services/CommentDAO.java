package com.vcclass.app.Services;

import com.vcclass.app.Data.Comment;
import javax.sql.DataSource;

public interface CommentDAO 
{
	public void SetDataSource(DataSource ds);
	
	public Comment GetComment(int commentId, int userId, int questionId);
	public boolean CreateComment(int userId, Comment comment);
	public boolean UpdateComment(int userId, int commentId);
	public boolean DeleteComment(int userId, int commentId);

	

}