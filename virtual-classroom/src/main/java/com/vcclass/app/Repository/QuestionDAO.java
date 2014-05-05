package com.vcclass.app.Repository;

import java.util.List;

import com.vcclass.app.Data.Question;

import javax.sql.DataSource;

public interface QuestionDAO 
{
	public void setDataSource(DataSource ds);
	public int CreateQuestion(int userId, Question question);
	public Question GetQuestion(int questionId, int userId, int courseId);
	public List<Question> GetStudentQuestions(int studentId, int courseId);
	public List<Question> GetAllQuestions(int courseId);
	public boolean UpdateQuestion(Question question);
	public boolean DeleteQuestion(int userId, int questionId);
}
