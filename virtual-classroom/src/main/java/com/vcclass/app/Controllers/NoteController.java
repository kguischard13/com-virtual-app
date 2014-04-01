/*
 * This class will handle all actions relating to the Note object
 * Chris Forehand
 * 2/2014
 * Test Cases: 
 * Major Modifications: The concept of Note Element has been abandoned
 * */

package com.vcclass.app.Controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vcclass.app.Data.Note;
import com.vcclass.app.Services.NoteService;

@Controller
public class NoteController 
{
	ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	private NoteService noteService = (NoteService) context.getBean("noteService");
	
	private static final Logger logger = LoggerFactory.getLogger(NoteController.class); 
	
	@RequestMapping(value = "/note/getnotes/{studentId}", method = RequestMethod.GET)
	public @ResponseBody List<Note> GetAllNotes(@PathVariable int studentId)
	{
		List<Note> noteList = noteService.GetStudentNotes(studentId); 
		return noteList; 
	}
	
	@RequestMapping(value = "/note/getnotes/{noteId}/student/{studentId}", method = RequestMethod.GET)
	public @ResponseBody Note GetNoteForStudent(@PathVariable int noteId, @PathVariable int studentId)
	{
		Note note = noteService.GetNote(studentId, noteId);
		return note;
	}
	
	@RequestMapping(value = "/note/addnote", method = RequestMethod.POST)
	public @ResponseBody int CreateNote(@RequestBody Note newNote)
	{
		Note note = newNote;  
		
		int id = noteService.AddNote(newNote.OwnerId, newNote, newNote.CourseId); 
		return id; 
	}
	
	@RequestMapping(value="/note/delete/{studentId}/note/{noteId}", method=RequestMethod.GET)
	public @ResponseBody boolean DeleteNote(@PathVariable int studentId, @PathVariable int noteId)
	{
		return noteService.DeleteNote(studentId, noteId);  
	}

}
