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
	public int CreateComment(final int userId, final Comment comment)
	{
		final String sql = "INSERT INTO Comment (Question_Id, User_Id,"
				+ "Content, DateCreated) "
				+ "values (?, ?, ?, ?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplateObject.update(
	        		new PreparedStatementCreator()  
	        		{	             
						@Override
						public java.sql.PreparedStatement createPreparedStatement(
								java.sql.Connection arg0) throws SQLException {
							   PreparedStatement ps =
			                            (PreparedStatement) arg0.prepareStatement(sql, new String[] {"id"});
			                        ps.setInt(1, comment.GetQuestionId());
			                        ps.setInt(2, userId); 
			                        ps.setString(3, comment.GetContents());
			                        ps.setDate(4, (Date) comment.GetDateCreated());
			                        return ps;
						}
	                }, keyHolder);
	        
        return keyHolder.getKey().intValue();
		
		
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
	
	
	public List<Comment> GetComments(int questionId) 
	{			
		String sql = "select * FROM Comment WHERE Question_Id = ?"; 
		List<Comment> commentList = new ArrayList<Comment>();
		
		Object [] parameters = new Object[]{new Integer(questionId)};  
		List<Map<String, Object>> rows = jdbcTemplateObject.queryForList(sql, parameters);
		
		for(Map row: rows)
		{
			Comment comment = new Comment(); 
			comment.SetCommentId((Integer)row.get("Id")); 
			comment.SetQuestionId((Integer)row.get("Question_Id"));
			comment.SetUserId((Integer)row.get("User_Id"));
			comment.SetDateCreated((java.util.Date) row.get("DateCreated"));
			comment.SetContents((String) row.get("Content"));			
			commentList.add(comment); 
		}
				
		return commentList;
	}
	
	
	
	@Override
	public boolean UpdateComment(Comment comment)
	{
		if (this.ValidateComment(comment.GetCommentId()))
		{
			String sql = "UPDATE Comment SET Question_Id = ?, User_Id = ?,"
				+ " Content = ?, DateCreated = ?"
					+ " WHERE Id = ?";
			jdbcTemplateObject.update(sql, comment.GetQuestionId(), comment.GetUserId(),
					comment.GetContents(), comment.GetDateCreated(), comment.GetCommentId());
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
