/*
 * This class is the Note Elemenet data object
 * Chris Forehand
 * 2/2014
 * Test Cases: 
 * Major Modifications: Not using the class
 * */

package com.vcclass.app.Data;

import java.util.Date;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

@Scope(WebApplicationContext.SCOPE_REQUEST)
public class NoteElement
{
	@JsonProperty(value="Id")
	private int Id;
	
	@JsonProperty(value="ParentId")
	private int ParentId; 
	
	@JsonProperty(value="ElementType")
	private String ElementType; 
	
	@JsonProperty(value="DateCreated")
	private Date DateCreated; 
	
	@JsonProperty(value="DateModified")
	private Date DateModified; 
	
	@JsonProperty(value="Message")
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
