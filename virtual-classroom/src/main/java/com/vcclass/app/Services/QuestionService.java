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
		final String sql = "INSERT INTO Question (Course_Id, User_Id, "
				+ "DateCreated, Contents, QuestionType, Public, Flag, AmtOfLikes, Anonymous) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		jdbcTemplateObject.update(
	        		new PreparedStatementCreator()  
	        		{	             
						@Override
						public java.sql.PreparedStatement createPreparedStatement(
								java.sql.Connection arg0) throws SQLException {
							   PreparedStatement ps =
			                            (PreparedStatement) arg0.prepareStatement(sql, new String[] {"id"});
			                        ps.setInt(1, question.GetCourseId());
			                        ps.setInt(2, userId); 
			                        ps.setDate(3, (Date) question.GetCreationDate());
			                        ps.setString(4, question.GetContents());
			                        ps.setInt(5, question.GetQuestionType());
			                        ps.setBoolean(6, question.GetPublic());
			                        ps.setBoolean(7, question.GetFlag());
			                        ps.setInt(8, question.GetLikes());
			                        ps.setBoolean(9, question.GetAnonymous());
			                        return ps;
						}
	                }, keyHolder);
	        
        return keyHolder.getKey().intValue();
		
        /*
		final String sql = "INSERT INTO Question (Course_Id, User_Id, "
				+ "DateCreated, Contents, QuestionType, Public, Flag, AmtOfLikes, Anonymous) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		String sql2 = "select max(Id) from Question";
		jdbcTemplateObject.update(sql, question.GetCourseId(), 
				question.GetUserId(), question.GetCreationDate(), question.GetContents(),
				question.GetQuestionType(), question.GetPublic(), question.GetFlag(), question.GetLikes(),
				question.GetAnonymous());
		
		return jdbcTemplateObject.queryForInt(sql2);
		*/
		
		
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
						@Override
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
	public List<Question> GetStudentQuestions(int studentId, int courseId) 
	{			
		String sql = "SELECT * FROM Question WHERE User_Id = ? AND Course_Id = ?"; 
		List<Question> questionList = new ArrayList<Question>();
		
		Object [] parameters = new Object[]{new Integer(studentId), new Integer(courseId)};  
		
		List<Map<String, Object>> rows = jdbcTemplateObject.queryForList(sql, parameters);
		
		for(Map row: rows)
		{
			Question question = new Question(); 
			question.SetQuestionId((Integer)row.get("Id")); 
			question.SetCourseId((Integer)row.get("Course_Id"));
			question.SetUserId((Integer)row.get("User_Id"));
			question.SetCreationDate((java.util.Date)row.get("DateCreated"));
			question.SetContents((String)row.get("Contents"));
			question.SetQuestionType((Integer)row.get("QuestionType"));
			question.SetPublic((Boolean)row.get("Public"));
			question.SetFlag((Boolean)row.get("Flag"));
			question.SetLikes((Integer)row.get("AmtOfLikes"));
			question.SetAnonymous((Boolean)row.get("Anonymous"));
			//question.SetFilePath((String)row.get("FilePath"));
			
			questionList.add(question); 
		}
				
		return questionList;
	}
	
	@Override
	public List<Question> GetAllQuestions(int courseId)
	{
		String sql = "SELECT * FROM Question WHERE Course_Id = ? AND Public = true"; 
		List<Question> questionList = new ArrayList<Question>();
		
		Object [] parameters = new Object[]{new Integer(courseId)};  
		
		List<Map<String, Object>> rows = jdbcTemplateObject.queryForList(sql, parameters);
		
		for(Map row: rows)
		{
			Question question = new Question(); 
			question.SetQuestionId((Integer)row.get("Id")); 
			question.SetCourseId((Integer)row.get("Course_Id"));
			question.SetUserId((Integer)row.get("User_Id"));
			question.SetCreationDate((java.util.Date)row.get("DateCreated"));
			question.SetContents((String)row.get("Contents"));
			question.SetQuestionType((Integer)row.get("QuestionType"));
			question.SetPublic((Boolean)row.get("Public"));
			question.SetFlag((Boolean)row.get("Flag"));
			question.SetLikes((Integer)row.get("AmtOfLikes"));
			question.SetAnonymous((Boolean)row.get("Anonymous"));
			//question.SetFilePath((String)row.get("FilePath"));
			
			questionList.add(question); 
		}
		
		return questionList;
	}
	
	
	
	
	@Override
	public boolean UpdateQuestion(Question question)
	{
		if (this.ValidateQuestion(question.GetQuestionId()))
		{
			String sql = "UPDATE Question SET Course_Id = ?, User_Id = ?, "
				+ "DateCreated = ?, Contents = ?, QuestionType = ?, Public = ?, Flag = ?, AmtOfLikes = ?, Anonymous = ?"
					+ " WHERE Id = ?";
			jdbcTemplateObject.update(sql, question.GetCourseId(), question.GetUserId(), question.GetCreationDate(),
					question.GetContents(), question.GetQuestionType(), question.GetPublic(), question.GetFlag(),
					question.GetLikes(), question.GetAnonymous(), question.GetQuestionId());
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
