package com.vcclass.app.Services;

import java.sql.*;
import java.util.*;

import javax.sql.DataSource;

import com.vcclass.app.Repository.*;
import com.vcclass.app.Data.*;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


public class QuestionService implements QuestionDAO
{
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	
	public void setDataSource(DataSource ds)
	{
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	
	public int CreateQuestion(int studentId, Question question)
	{
		String sql = "INSERT INTO Question (QuestionID, Courses_courseID, Student_StudID, "
				+ "DateCreated, Contents, QuestionType, Public, Flag, AmtOfLikes, Anonymous) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		String sql2 = "select max(QuestionID) from Question";
		jdbcTemplateObject.update(sql, question.GetQuestionId(), question.GetCourseId(), 
				question.GetStudentId(), question.GetCreationDate(), question.GetContents(),
				question.GetQuestionType(), question.GetPublic(), question.GetFlag(), question.GetLikes(),
				question.GetAnonymous());
		
		return jdbcTemplateObject.queryForInt(sql2);
		
	}
	
	public Question GetQuestion(int questionId, int studentId, int classId)
	{
		Question quest = null;
		
		if (ValidateQuestion(questionId))
		{
			String sql = "SELECT * FROM Question WHERE QuestionID = ?";
			quest = jdbcTemplateObject.queryForObject(sql, new Object[]{questionId}, new RowMapper<Question>()
					{
						public Question mapRow(ResultSet rs, int rowNum) throws SQLException
						{
							return new Question ( 
								rs.getInt("QuestionID"),
								rs.getInt("Courses_courseID"),
								rs.getInt("StudentId"),
								rs.getDate("DateCreated"),
								rs.getString("Contents"),
								rs.getInt("QuestionType"),
								rs.getBoolean("Public"),
								rs.getBoolean("Flag"),
								rs.getInt("AmtOfLikes"),
								rs.getBoolean("Anonymous"));
							
							/*// Currently no place for comment list or filepath in db
							rs.getInt("Comments"),
							rs.getString("FilePath"), */
						}
					});
		}
		return quest;
	}
	
	
	
	public boolean UpdateQuestion(Question question)
	{
		if (this.ValidateQuestion(question.GetQuestionId()))
		{
			String sql = "UPDATE Question SET Courses_courseID = ?, Student_StudID = ?, "
				+ "DateCreated = ?, Contents = ?, QuestionType = ?, Public = ?, Flag = ?, AmtOfLikes = ?, Anonymous = ?"
					+ "WHERE QuestionID = ?";
			jdbcTemplateObject.update(sql, question.GetCourseId(), question.GetStudentId(), question.GetCreationDate(),
					question.GetContents(), question.GetQuestionType(), question.GetPublic(), question.GetFlag(),
					question.GetLikes(), question.GetAnonymous());
			return true;
		}
		return false;
	}
	
	
	public boolean DeleteQuestion(int studentId, int questionId)
	{
		if (this.ValidateQuestion(questionId))
		{
			String sql = "DELETE FROM Question WHERE QuestionID = ?";
			String sql2 = "DELETE FROM Comments WHERE Question_questionID = ?";
			jdbcTemplateObject.update(sql,questionId);
			jdbcTemplateObject.update(sql2,questionId);
			return true;
		}
		return false;
	}
	
	private boolean ValidateQuestion(int id)
	{
		String sql = "SELECT count(*) FROM Question WHERE QuestionID = ?";
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
