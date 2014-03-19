package com.vcclass.app.Services;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import javax.sql.DataSource;

import com.mysql.jdbc.PreparedStatement;
import com.vcclass.app.Repository.*;
import com.vcclass.app.Data.*;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

@Service("commentService")
public class CommentService implements CommentDAO
{
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	@Override
	public void setDataSource(DataSource ds)
	{
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	@Override
	public int CreateComment(int userId, Comment comment)
	{
		String sql = "INSERT INTO Comment (Id, Question_Id, User_Id,"
				+ "Contents, DateCreated) "
				+ "values (?, ?, ?, ?, ?, ?)";
		String sql2 = "select max(Id) from Comments";
		jdbcTemplateObject.update(sql, comment.GetCommentId(), comment.GetQuestionId(), 
				comment.GetUserId(), comment.GetContents(), 
				comment.GetDateCreated());
		
		return jdbcTemplateObject.queryForInt(sql2);
		
	}
	
	@Override
	public Comment GetComment(int commentId, int studentId, int questionId)
	{
		Comment comm = null;
		
		if (ValidateComment(commentId))
		{
			String sql = "SELECT * FROM Comment WHERE Id = ?";
			comm = jdbcTemplateObject.queryForObject(sql, new Object[]{commentId}, new RowMapper<Comment>()
					{
						public Comment mapRow(ResultSet rs, int rowNum) throws SQLException
						{
							return new Comment( 
								rs.getInt("Id"),
								rs.getInt("Question_Id"),
								rs.getInt("User_Id"),
								rs.getString("Content"),
								rs.getDate("DateCreated"));
						}
					});
		}
		return comm;
	}
	
	
	@Override
	public boolean UpdateComment(Comment comment)
	{
		if (this.ValidateComment(comment.GetCommentId()))
		{
			String sql = "UPDATE Comment SET Question_Id = ?, User_Id = ?"
				+ "Content = ?, DateCreated = ?"
					+ "WHERE CommentID = ?";
			jdbcTemplateObject.update(sql, comment.GetQuestionId(), comment.GetUserId(),
					comment.GetContents(), comment.GetDateCreated());
			return true;
		}
		return false;
	}
	
	@Override
	public boolean DeleteComment(int userId, int commentId)
	{
		if (this.ValidateComment(commentId))
		{
			String sql = "DELETE FROM Comment WHERE Id = ?";
			jdbcTemplateObject.update(sql,commentId);
			return true;
		}
		return false;
	}
	
	
	private boolean ValidateComment(int id)
	{
		String sql = "SELECT count(*) FROM Comment WHERE Id = ?";
		if(jdbcTemplateObject.queryForInt(sql, id) == 0)
		{
			return false;
		}
		return true;
	}
}
