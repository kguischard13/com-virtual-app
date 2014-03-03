package com.vcclass.app.Data;

import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

@Scope(WebApplicationContext.SCOPE_REQUEST)
public class PositionInfo 
{
	@JsonProperty(value="X")
	private int X; 
	
	@JsonProperty(value="Y")
	private int Y; 
	
	@JsonProperty(value="Height")
	private int Height;
	
	@JsonProperty(value="Width")
	private int Width; 
	
	
	public int GetX()
	{
		return this.X;
	}
	
	public int GetY()
	{
		return this.Y; 
	}
	
	public int GetHeight()
	{
		return this.Height; 
	}
	
	public int GetWidth()
	{
		return this.Width; 
	}
	
	public void SetX(int x)
	{
		this.X = x; 
	}
	
	public void SetY(int y)
	{
		this.Y = y; 
	}
	
	public void SetHeight(int height)
	{
		this.Height = height; 
	}
	
	public void SetWidth(int width)
	{
		this.Width = width; 
	}
}
