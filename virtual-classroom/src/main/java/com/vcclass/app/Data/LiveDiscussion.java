/*
 * This class is the Live Discussion data object
 * Chris Forehand
 * 2/2014
 * Test Cases: 
 * 
 * */

package com.vcclass.app.Data;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class LiveDiscussion extends Note
{	
	@JsonProperty(value = "Topic")
	public String Topic;
	
	@JsonProperty(value="UserList")
	public List<User> UserList; 
	
	@JsonProperty(value="CourseSessionId")
	public int CourseSessionId; 
	
	public LiveDiscussion()
	{
		this.Topic = null; 
		this.UserList = null; 
		this.CourseSessionId = -1; 
	}
}
