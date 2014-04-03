/*
 * This class will handle mapping relational database rows to the Note Object
 * Chris Forehand
 * 2/2014
 * Test Cases: 
 * 
 * */

package com.vcclass.app.RowMappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.vcclass.app.Data.Note;

public class NoteRowMapper implements RowMapper<Note>
{
	@Override
	public Note mapRow(ResultSet rs, int row) throws SQLException 
	{
		Note note = new Note(); 
		note.Id = rs.getInt("Note Id"); 
		note.CourseId = rs.getInt("Courses_CourseID"); 
		note.DateCreated = rs.getDate("DateCreated"); 
		//note.CourseCode = rs.getString("CourseCode"); 
		note.FilePath = rs.getString("FilePath"); 
		//note.CourseName = rs.getString("CourseName"); 
		note.OwnerId = rs.getInt("Student_StudentID"); 
		
		return note; 
	}
}
