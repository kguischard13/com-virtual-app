package com.vcclass.app.Controllers;

import java.sql.Date;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vcclass.app.Data.Note;
import com.vcclass.app.Data.NoteElement;
import com.vcclass.app.Data.Student;
import com.vcclass.app.Services.NoteService;
import com.vcclass.app.Services.UserService;

@Controller
public class NoteController 
{
	ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	private NoteService noteService = (NoteService) context.getBean("noteService");
	
	private static final Logger logger = LoggerFactory.getLogger(NoteController.class); 
	
	@RequestMapping(value = "/note/getnotes", method = RequestMethod.GET)
	public @ResponseBody List<Note> GetNotes(Model model)
	{
		List<Note> noteList = noteService.GetStudentNotes(0); 
		return noteList; 
	}
	
	@RequestMapping(value = "/note/addnote", method = RequestMethod.GET)
	public @ResponseBody int AddNote()
	{
		int courseId = 1; 
		int studentId = 0; 
		Note note = new Note(); 
		note.DateCreated = new Date(System.currentTimeMillis());
		note.FilePath = "/src/documents/newNote.png"; 
		
		int id = noteService.AddNote(studentId, note, courseId); 
		return id; 
	}

}
