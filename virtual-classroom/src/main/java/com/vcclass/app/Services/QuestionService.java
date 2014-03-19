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

@Service("questionService")
public class QuestionService implements QuestionDAO
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
	public int CreateQuestion(final int userId, final Question question)
	{
		final String sql = "INSERT INTO Question (QuestionID, Courses_courseID, User_userID, "
				+ "DateCreated, Contents, QuestionType, Public, Flag, AmtOfLikes, Anonymous) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		/*
		KeyHolder keyHolder = new GeneratedKeyHolder();
        	jdbc.update(
        		new PreparedStatementCreator()  
        		{	             
					@Override
					public java.sql.PreparedStatement createPreparedStatement(
							java.sql.Connection arg0) throws SQLException {
						   PreparedStatement ps =
		                            (PreparedStatement) arg0.prepareStatement(sql, new String[] {"id"});
		                        ps.setInt(1, questionId);
		                        ps.setInt(2, courseId); 
		                        ps.setDate(3, (Date) note.DateCreated);
		                        ps.setString(4, note.FilePath);
		                        return ps;
					}
                }, keyHolder);
        
        return keyHolder.getKey().intValue();
		*/
		
		String sql2 = "select max(Id) from Question";
		jdbcTemplateObject.update(sql, question.GetQuestionId(), question.GetCourseId(), 
				question.GetUserId(), question.GetCreationDate(), question.GetContents(),
				question.GetQuestionType(), question.GetPublic(), question.GetFlag(), question.GetLikes(),
				question.GetAnonymous());
		
		return jdbcTemplateObject.queryForInt(sql2);
		
	}
	
	@Override
	public Question GetQuestion(int questionId, int userId, int classId)
	{
		Question quest = null;
		
		if (ValidateQuestion(questionId))
		{
			String sql = "SELECT * FROM Question WHERE Id = ?";
			quest = jdbcTemplateObject.queryForObject(sql, new Object[]{questionId}, new RowMapper<Question>()
					{
						public Question mapRow(ResultSet rs, int rowNum) throws SQLException
						{
							return new Question ( 
								rs.getInt("Id"),
								rs.getInt("Course_Id"),
								rs.getInt("User_Id"),
								rs.getDate("DateCreated"),
								rs.getString("Contents"),
								rs.getInt("QuestionType"),
								rs.getBoolean("Public"),
								rs.getBoolean("Flag"),
								rs.getInt("AmtOfLikes"),
								rs.getBoolean("Anonymous"));
						}
					});
		}
		return quest;
	}
	
	
	@Override
	public boolean UpdateQuestion(Question question)
	{
		if (this.ValidateQuestion(question.GetQuestionId()))
		{
			String sql = "UPDATE Question SET Course_Id = ?, User_Id = ?, "
				+ "DateCreated = ?, Contents = ?, QuestionType = ?, Public = ?, Flag = ?, AmtOfLikes = ?, Anonymous = ?"
					+ "WHERE Id = ?";
			jdbcTemplateObject.update(sql, question.GetCourseId(), question.GetUserId(), question.GetCreationDate(),
					question.GetContents(), question.GetQuestionType(), question.GetPublic(), question.GetFlag(),
					question.GetLikes(), question.GetAnonymous());
			return true;
		}
		return false;
	}
	
	@Override
	public boolean DeleteQuestion(int userId, int questionId)
	{
		if (this.ValidateQuestion(questionId))
		{
			String sql = "DELETE FROM Question WHERE Id = ?";
			String sql2 = "DELETE FROM Comment WHERE Question_Id = ?";
			jdbcTemplateObject.update(sql,questionId);
			jdbcTemplateObject.update(sql2,questionId);
			return true;
		}
		return false;
	}
	
	private boolean ValidateQuestion(int id)
	{
		String sql = "SELECT count(*) FROM Question WHERE Id = ?";
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
