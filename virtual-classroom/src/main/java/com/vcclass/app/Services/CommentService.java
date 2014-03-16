package com.vcclass.app.Services;

import java.sql.*;
import java.util.*;

import javax.sql.DataSource;

import com.vcclass.app.Repository.*;
import com.vcclass.app.Data.*;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


public class CommentService implements CommentDAO
{
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	
	public void setDataSource(DataSource ds)
	{
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	
	public int CreateComment(int studentId, Comment comment)
	{
		String sql = "INSERT INTO Comment (CommentID, Question_questionID, Student_StudID,"
				+ "Teacher_instrID, Contents, DateCreated) "
				+ "values (?, ?, ?, ?, ?, ?)";
		String sql2 = "select max(CommentID) from Comments";
		jdbcTemplateObject.update(sql, comment.GetCommentId(), comment.GetQuestionId(), 
				comment.GetStudentId(), comment.GetTeacherId(), comment.GetContents(), 
				comment.GetCreationDate());
		
		return jdbcTemplateObject.queryForInt(sql2);
		
	}
	
	public Comment GetComment(int commentId, int studentId, int questionId)
	{
		Comment comm = null;
		
		if (ValidateComment(commentId))
		{
			String sql = "SELECT * FROM Comments WHERE CommentID = ?";
			comm = jdbcTemplateObject.queryForObject(sql, new Object[]{commentId}, new RowMapper<Comment>()
					{
						public Comment mapRow(ResultSet rs, int rowNum) throws SQLException
						{
							return new Comment ( 
								rs.getInt("CommentId"),
								rs.getInt("Question_questionID"),
								rs.getInt("Student_StudID"),
								rs.getInt("Teacher_instrID"),
								rs.getString("Contents"),
								rs.getDate("DateCreated"));
							/*
							rs.getString("FilePath"), */
						}
					});
		}
		return comm;
	}
	
	
	
	public boolean UpdateComment(Comment comment)
	{
		if (this.ValidateComment(comment.GetCommentId()))
		{
			String sql = "UPDATE Comments SET Question_questionID = ?, Student_StudID = ?, Teacher_instrID = ?"
				+ "Contents = ?, DateCreated = ?"
					+ "WHERE CommentID = ?";
			jdbcTemplateObject.update(sql, comment.GetQuestionId(), comment.GetStudentId(), comment.GetTeacherId(),
					comment.GetContents(), comment.GetCreationDate());
			return true;
		}
		return false;
	}
	
	
	public boolean DeleteComment(int studentId, int commentId)
	{
		if (this.ValidateComment(commentId))
		{
			String sql = "DELETE FROM Comments WHERE CommentID = ?";
			jdbcTemplateObject.update(sql,commentId);
			return true;
		}
		return false;
	}
	
	private boolean ValidateComment(int id)
	{
		String sql = "SELECT count(*) FROM Comments WHERE CommentID = ?";
		if(jdbcTemplateObject.queryForInt(sql, id) == 0)
		{
			return false;
		}
		return true;
	}

	
	
	/*
	private boolean ValidateQuestion(int id)
	{
		String sql = "SELECT 1 FROM Question WHERE QuestionID = ?, ";
		if(jdbcTemplateObject.queryForInt(sql, id) == 0)
		{
			return false;
		}
		return true;
	}
	*/
	


}
