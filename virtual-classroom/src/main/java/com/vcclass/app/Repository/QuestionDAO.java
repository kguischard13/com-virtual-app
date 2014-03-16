package com.vcclass.app.Repository;

import com.vcclass.app.Data.Question;
import javax.sql.DataSource;

public interface QuestionDAO 
{
	public void setDataSource(DataSource ds);
	public int CreateQuestion(int studentId, Question question);
	public Question GetQuestion(int questionId, int studentId, int courseId);
	public boolean UpdateQuestion(Question question);
	public boolean DeleteQuestion(int studentId, int questionId);
}
