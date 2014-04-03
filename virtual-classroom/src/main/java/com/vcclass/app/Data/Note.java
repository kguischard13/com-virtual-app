/*
 * This class is the Note data object
 * Chris Forehand
 * 2/2014
 * Test Cases: 
 * 
 * */

package com.vcclass.app.Data;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class Note
{
	@JsonProperty(value="Id")
	public int Id; 
	
	@JsonProperty(value="CourseId")
	public int CourseId; 
	
	@JsonProperty(value="OwnerId")
	public int OwnerId; 
	
//	@JsonProperty(value="CourseCode")
//	public String CourseCode; 
//	
//	@JsonProperty(value="CourseName")
//	public String CourseName; 
	
	@JsonProperty(value="DateCreated")
	public Date DateCreated; 
	
	@JsonProperty(value="FilePath")
	public String FilePath; 
	
	public Note()
	{
		this.Id = -1; 
		this.CourseId = -1; 
		this.DateCreated = null; 
		this.FilePath = null; 
		//this.CourseCode = null; 
		//this.CourseName = null; 
		this.OwnerId = -1; 
	}
	
//	public List<NoteElement> GetNoteElementList()
//	{
//		return this.NoteElementList; 
//	}
//	
//	public void SetNoteElementList (List<NoteElement> list)
//	{
//		this.NoteElementList = list; 
//	}
//	
//	public void AddNoteElement(NoteElement element)
//	{
//		this.NoteElementList.add(element); 
//	}
//	
//	public NoteElement GetNoteElementById(int noteElementId)
//	{
//		Iterator<NoteElement> itr = this.NoteElementList.iterator(); 
//		
//		while(itr.hasNext())
//		{
//			NoteElement element = (NoteElement)itr.next(); 
//			
//			if(element.GetId() == noteElementId)
//			{
//				return element; 
//			}
//		}
//		
//		return null; 
//	}
//	
//	public boolean DeleteNoteElement (int id)
//	{
//		NoteElement element = this.GetNoteElementById(id); 
//		return this.NoteElementList.remove(element); 
//	}
//	
//	public int GetNoteElementIndex(NoteElement element)
//	{
//		ListIterator<NoteElement> itr = this.NoteElementList.listIterator(); 
//		
//		while(itr.hasNext())
//		{
//			int index = itr.nextIndex(); 
//			NoteElement elm = (NoteElement)itr.next(); 
//			
//			if(elm.GetId() == element.GetId())
//			{
//				return index; 
//			}
//		}
//		
//		return -1; 
//	}
}
