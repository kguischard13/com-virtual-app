package com.vcclass.app.Data;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;


@Service
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class Note
{
	private int Id; 
	private String CourseId; 
	private Date DateCreated; 
	private String FilePath; 
	private List<NoteElement> NoteElementList; 
	
	public Note()
	{
		this.Id = -1; 
		this.CourseId = null; 
		this.DateCreated = null; 
		this.FilePath = null; 
		this.NoteElementList = null; 
	}
	
	public int GetId()
	{
		return this.Id; 
	}
	
	public void SetId(int id)
	{
		this.Id = id; 
	}
	
	public String GetCourseId()
	{
		return this.CourseId;
	}
	
	public void SetCourseId(String courseId)
	{
		this.CourseId = courseId; 
	}
	
	public String GetFilePath()
	{
		return this.FilePath; 
	}
	
	public void SetFilePath(String filePath)
	{
		this.FilePath = filePath; 
	}
	
	public Date GetCreationDate()
	{
		return this.DateCreated; 
	}
	
	public void SetCreationDate(Date creationDate)
	{
		this.DateCreated = creationDate; 
	}
	
	public List<NoteElement> GetNoteElementList()
	{
		return this.NoteElementList; 
	}
	
	public void SetNoteElementList (List<NoteElement> list)
	{
		this.NoteElementList = list; 
	}
	
	public void AddNoteElement(NoteElement element)
	{
		this.NoteElementList.add(element); 
	}
	
	public NoteElement GetNoteElementById(int noteElementId)
	{
		Iterator<NoteElement> itr = this.NoteElementList.iterator(); 
		
		while(itr.hasNext())
		{
			NoteElement element = (NoteElement)itr.next(); 
			
			if(element.GetId() == noteElementId)
			{
				return element; 
			}
		}
		
		return null; 
	}
	
	public boolean DeleteNoteElement (int id)
	{
		NoteElement element = this.GetNoteElementById(id); 
		return this.NoteElementList.remove(element); 
	}
	
	public int GetNoteElementIndex(NoteElement element)
	{
		ListIterator<NoteElement> itr = this.NoteElementList.listIterator(); 
		
		while(itr.hasNext())
		{
			int index = itr.nextIndex(); 
			NoteElement elm = (NoteElement)itr.next(); 
			
			if(elm.GetId() == element.GetId())
			{
				return index; 
			}
		}
		
		return -1; 
	}
}
