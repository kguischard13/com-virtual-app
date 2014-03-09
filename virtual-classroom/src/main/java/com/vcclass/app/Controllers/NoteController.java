package com.vcclass.app.Controllers;

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
	private DataSource ds = (DataSource) context.getBean("dataSource"); 
	private NoteService noteService = (NoteService) context.getBean("noteService");
	
	private static final Logger logger = LoggerFactory.getLogger(NoteController.class); 
	
	@RequestMapping(value = "/note", method = RequestMethod.GET)
	public @ResponseBody Note GetNote(Model model)
	{
		noteService.setDataSource(ds);
		Note note = noteService.GetNote(0); 
		return note; 
		
/*		Note note = new Note(); 
		
		note.SetId(10);
		note.CourseCode = "CS230"; 
		
		
		NoteElement element = new NoteElement(); 
		element.SetId(22);
		element.SetMessage("Hello World");
		
		note.AddNoteElement(element);
		model.addAttribute("Note", note.GetCourseId()); 
		
		logger.info("About to return the note");
		
		return note;*/
	}
}
