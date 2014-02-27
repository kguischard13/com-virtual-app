package com.vcclass.app.Data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.codehaus.jackson.annotate.JsonProperty;

public class LiveDiscussion extends Note
{
	@JsonProperty(value = "OwnerId")
	private int OwnerId;
	
	@JsonProperty(value = "CourseId")
	private String CourseId;
	
	@JsonProperty(value = "Topic")
	private String Topic;
	
//	@JsonProperty(value="UserList")
//	private List<User> UserList; 
//	
//	public LiveDiscussion()
//	{
//		this.OwnerId = -1; 
//		this.UserList = new ArrayList<User>(); 
//	}
	
	public int GetOwnerId()
	{
		return this.OwnerId; 
	}
	
	public String GetTopic()
	{
		return this.Topic; 
	}
	
	public String GetCourseId()
	{
		return this.CourseId; 
	}
	
//	public List<T> GetUsers()
//	{
//		return this.UserList; 
//	}
//	
//	public void AddUser(User user)
//	{
//		this.UserList.add(user); 
//	}
//	
//	public User GetUserById(int id)
//	{
//		Iterator<User> itr = this.UserList.iterator(); 
//		
//		while(itr.hasNext())
//		{
//			User user = (User)itr.next(); 
//			
//			if(user.GetId() == id)
//			{
//				return user; 
//			}
//		}
//		
//		return null; 
//	}
//	
//	public boolean DeleteUserFromGroup (int id)
//	{
//		User user = this.GetUserById(id); 
//		return this.UserList.remove(user); 
//	}
//	
//	public int GetUserIndex(User user)
//	{
//		ListIterator<User> itr = this.UserList.listIterator(); 
//		
//		while(itr.hasNext())
//		{
//			int index = itr.nextIndex(); 
//			User inList = (User)itr.next(); 
//			
//			if(inList.GetId() == user.GetId())
//			{
//				return index; 
//			}
//		}
//		
//		return -1; 
//	}
}
