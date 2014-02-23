package com.vcclass.app.Data;

import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class NoteElement 
{
	private int Id; 
	private int ParentId; 
	private String ElementType; 
	private Date DateCreated; 
	private Date DateModified; 
	private String Message; 
	
	public NoteElement()
	{
		this.Id = -1; 
		this.ParentId = -1; 
		this.ElementType = null; 
		this.DateCreated = null; 
		this.DateModified = null; 
		this.Message = null; 
	}
	
	public int GetId()
	{
		return this.Id; 
	}
	
	public void SetId(int id)
	{
		this.Id = id; 
	}
	
	public int GetParentId()
	{
		return this.ParentId; 
	}
	
	public void SetParentId(int id)
	{
		this.ParentId = id; 
	}
	
	public String GetElementType()
	{
		return this.ElementType; 
	}
	
	public void SetElementType(String type)
	{
		this.ElementType = type; 
	}
	
	public Date GetCreationDate ()
	{
		return this.DateCreated; 
	}
	
	public void SetCreationDate (Date date)
	{
		this.DateCreated = date; 
	}
	
	public Date GetModifiedDate ()
	{
		return this.DateModified; 
	}
	
	public void SetModifiedDate (Date date)
	{
		this.DateModified = date; 
	}
	
	public String GetMessasge()
	{
		return this.Message; 
	}
	
	public void SetMessage (String message)
	{
		this.Message = message; 
	}
}
