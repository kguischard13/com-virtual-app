/*
 * This class is an interface for the Note API
 * Chris Forehand
 * 2/2014
 * Test Cases: 
 * Major Modifications: Not using the class
 * */

package com.vcclass.app.Repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.vcclass.app.Data.Note;

@Repository
public interface NoteDAO 
{
	public void setDataSource(DataSource ds); 
	public List<Note> GetStudentNotes(int studentId); 
	public int AddNote(int studentId, Note note, int courseId); 
	public boolean DeleteNote(int studentId, int noteId); 
	public Note GetNote(int studentId, int noteId); 
}
