package com.vcclass.app.Services;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import com.mysql.jdbc.PreparedStatement;
import com.vcclass.app.Data.Note;
import com.vcclass.app.Repository.NoteDAO;
import com.vcclass.app.RowMappers.NoteRowMapper;

@Service("noteService")
public class NoteService implements NoteDAO
{
	private DataSource dataSource; 
	private JdbcTemplate jdbc;
	
	@Override
	public void setDataSource(DataSource ds) 
	{
		this.dataSource = ds;
		this.jdbc = new JdbcTemplate(dataSource); 
	}
	
	@Override
	public List<Note> GetStudentNotes(int studentId) 
	{			
		String sql = "select * FROM Note WHERE Student_StudentId = ?"; 
		List<Note> noteList = new ArrayList<Note>();
		
		Object [] parameters = new Object[]{new Integer(studentId)};  
		List<Map<String, Object>> rows = jdbc.queryForList(sql, parameters);
		
		for(Map row: rows)
		{
			Note note = new Note(); 
			note.Id = (Integer) row.get("Note Id"); 
			note.CourseId = (Integer)row.get("Courses_CourseID");
			note.DateCreated = (Date)row.get("DateCreated"); 
			note.CourseCode = (String)row.get("CourseCode"); 
			note.CourseName = (String)row.get("CourseName"); 
			note.FilePath = (String)row.get("FilePath"); 
			note.OwnerId = (Integer)row.get("Student_StudentID"); 
			noteList.add(note); 
		}
				
		return noteList;
	}
	
	@Override
	public Note GetNote(int studentId, int noteId)
	{
		String sql = "select * FROM Note WHERE Student_StudentID = ? AND NoteId = ?"; 
		Note note = new Note();
		note = jdbc.queryForObject(sql, new Object[]{studentId, noteId}, new NoteRowMapper());
		
		return note; 
	}
	
	@Override
	public int AddNote(final int studentId, final Note note, final int courseId) 
	{
		final String sql = "insert into Note (Student_StudentID, Courses_CourseID, DateCreated, FilePath) values (?, ?, ?, ?)";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
	        jdbc.update(
	        		new PreparedStatementCreator()  
	        		{	             
						@Override
						public java.sql.PreparedStatement createPreparedStatement(
								java.sql.Connection arg0) throws SQLException {
							   PreparedStatement ps =
			                            (PreparedStatement) arg0.prepareStatement(sql, new String[] {"id"});
			                        ps.setInt(1, studentId);
			                        ps.setInt(2, courseId); 
			                        ps.setDate(3, (Date) note.DateCreated);
			                        ps.setString(4, note.FilePath);
			                        return ps;
						}
	                }, keyHolder);
	        
        return keyHolder.getKey().intValue();
	}
	
	@Override
	public boolean DeleteNote(int studentId, int noteId) 
	{
		String sql = "delete FROM Note WHERE NoteId = ?"; 
		jdbc.update(sql, noteId); 
		return true;
	}
}
