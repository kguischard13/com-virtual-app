package com.vcclass.app.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.vcclass.app.Data.Note;
import com.vcclass.app.Data.NoteElement;

@Controller
public class NoteController 
{
	private static final Logger logger = LoggerFactory.getLogger(NoteController.class); 
		
	@RequestMapping(value = "/note", method = RequestMethod.GET)
	public @ResponseBody  Note GetNote(Model model)
	{
		Note note = new Note(); 
		
		note.SetId(10);
		note.SetCourseId("CS230");
		
		NoteElement element = new NoteElement(); 
		element.SetId(22);
		element.SetMessage("Hello World");
		
		note.AddNoteElement(element);
		model.addAttribute("Note", note.GetCourseId()); 
		
		logger.info("About to return the note");
		
		return note;
	}
}
