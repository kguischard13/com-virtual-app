package com.vcclass.app;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vcclass.app.Data.Note;
import com.vcclass.app.Services.NoteService;

public class NoteServiceTest {

	ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	private NoteService noteService = (NoteService) context.getBean("noteService");
	
	@Test
	public void TestNoteServiceGetStudentNotesReturnsRows() 
	{
		List<Note> noteList = noteService.GetStudentNotes(0); 
		assertNotNull(noteList); 
	}
}
