package com.vcclass.app.Services;

import com.vcclass.app.Data.Question;
import javax.sql.DataSource;

public interface QuestionDAO 
{
	public void SetDataSource(DataSource ds);
	
	public Question GetQuestion(int questionId, int studentId, int classId);
	public boolean CreateQuestion(int studentId, Question question);
	public boolean UpdateQuestion(int studentId, int questionId);
	public boolean DeleteQuestion(int studentId, int questionId);

	

}
