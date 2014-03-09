package com.vcclass.app.Data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.codehaus.jackson.annotate.JsonProperty;

public class LiveDiscussion extends Note
{	
	@JsonProperty(value = "Topic")
	public String Topic;
	
	@JsonProperty(value="UserList")
	public List<User> UserList; 
	
	public LiveDiscussion()
	{
		this.Topic = null; 
		this.UserList = null; 
	}
}
