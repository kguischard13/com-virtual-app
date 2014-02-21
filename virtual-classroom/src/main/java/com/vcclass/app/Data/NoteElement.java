package com.vcclass.app.Data;

import java.util.Date;

public class NoteElement 
{
	private int Id; 
	private int ParentId; 
	private String ElementType; 
	// change.
	private Date DateCreated; 
	private Date DateModified; 
	private String Message; 

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
	
}
