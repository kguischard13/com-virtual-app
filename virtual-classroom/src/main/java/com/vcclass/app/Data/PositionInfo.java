package com.vcclass.app.Data;

import org.codehaus.jackson.annotate.JsonProperty;

public class PositionInfo 
{
	@JsonProperty(value="X")
	private int x; 
	
	@JsonProperty(value="Y")
	private int y; 
	
	@JsonProperty(value="Height")
	private int height;
	
	@JsonProperty(value="Width")
	private int width; 
	
	
	public int GetX()
	{
		return this.x;
	}
	
	public int GetY()
	{
		return this.y; 
	}
	
	public int GetHeight()
	{
		return this.height; 
	}
	
	public int GetWidth()
	{
		return this.width; 
	}
	
	public void SetX(int x)
	{
		this.x = x; 
	}
	
	public void SetY(int y)
	{
		this.y = y; 
	}
	
	public void SetHeight(int height)
	{
		this.height = height; 
	}
	
	public void SetWidth(int width)
	{
		this.width = width; 
	}
}
