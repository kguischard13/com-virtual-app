package com.vcclass.app.Services;

import java.util.List;

import com.vcclass.app.Data.Note;
import com.vcclass.app.Data.NoteElement;


public interface NoteDAO 
{
	public List<Note> GetStudentNotes(int studentId); 
	public boolean AddNote(int studentId, Note note); 
	public boolean DeleteNote(int studentId, int noteId); 
	public void EditNote(int studentId, int noteId); 
	
	
	//public void AddNoteElement(int studentId, Note note); 
	//public NoteElement GetNoteElementById(int noteId, int noteElementId); 
	//public List<NoteElement> GetNoteElements(Note note);
}
