package com.vcclass.app.Data;


import java.util.Date;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.codehaus.jackson.annotate.JsonProperty;



@Service
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class Course {
	
	@JsonProperty(value="Id")
	private int Id;
	
	@JsonProperty(value="User_Id")
	private int User_Id;
	
	@JsonProperty(value="StartTime")
	private Date StartTime;
	
	@JsonProperty(value="EndTime")
	private Date EndTime;
	
	@JsonProperty(value="CourseTitle")
	private String CourseTitle;
	
	@JsonProperty(value="CourseCode")
	private String CourseCode;
	
	public Course(){
		this.Id = -1;
		this.User_Id = -1;
		this.StartTime = null;
		this.EndTime = null;
		this.CourseTitle = null;
		this.CourseCode = null;
	}
	
	public Course(int incomingId, int teacherId, Date sD, Date eD, String title, String code){
		this.Id = incomingId;
		this.User_Id = teacherId;
		this.StartTime = sD;
		this.EndTime = eD;
		this.CourseTitle = title;
		this.CourseCode = code;
	}
	
	public Course(int teacherId, Date sD, Date eD, String title, String code){
		this.Id = -1;
		this.User_Id = teacherId;
		this.StartTime = sD;
		this.EndTime = eD;
		this.CourseTitle = title;
		this.CourseCode = code;
	}
	public Course(Course course){
		this.Id = course.GetCourseId();
		this.User_Id = course.GetUserId();
		this.StartTime = course.GetStartTime();
		this.EndTime = course.GetEndTime();
		this.CourseTitle = course.GetCourseTitle();
		this.CourseCode = course.GetCourseCode();
	}
	public int GetCourseId(){
		return this.Id;
	}
	
	public void SetCourseId(int incomingid){
		this.Id = incomingid;
	}
	
	public int GetUserId(){
		return this.User_Id;
	}
	
	public void SetUserId(int incomingid){
		this.User_Id = incomingid;
	}
	
	public Date GetStartTime(){
		return this.StartTime;
	}
	
	public void SetStartTime(Date time){
		this.StartTime = time;
	}
	
	public Date GetEndTime(){
		return this.EndTime;
	}
	
	public void SetEndTime(Date time){
		this.EndTime = time;
	}
	
	public String GetCourseTitle(){
		return this.CourseTitle;
	}
	
	public void SetCourseTitle(String title){
		this.CourseTitle = title;
	}
	
	public String GetCourseCode(){
		return this.CourseCode;
	}
	
	public void SetCourseCode(String code){
		this.CourseCode = code;
	}

}
