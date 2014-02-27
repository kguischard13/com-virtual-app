package com.vcclass.app.Data;


import java.util.Date;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.codehaus.jackson.annotate.JsonProperty;

@Service
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class Course {
	
	@JsonProperty(value="CourseId")
	private int CourseId;
	
	@JsonProperty(value="InstructorId")
	private int InstructorId;
	
	@JsonProperty(value="StartTime")
	private Date StartTime;
	
	@JsonProperty(value="EndTime")
	private Date EndTime;
	
	@JsonProperty(value="CourseTitle")
	private String CourseTitle;
	
	public Course(){
		this.CourseId = -1;
		this.InstructorId = -1;
		this.StartTime = null;
		this.EndTime = null;
		this.CourseTitle = null;
	}
	
	public Course(int incomingId, int teacherId, Date sD, Date eD, String title){
		this.CourseId = incomingId;
		this.InstructorId = teacherId;
		this.StartTime = sD;
		this.EndTime = eD;
		this.CourseTitle = title;
	}
	
	public int GetCourseId(){
		return this.CourseId;
	}
	
	public void SetCourseId(int incomingid){
		this.CourseId = incomingid;
	}
	
	public int GetInstructorId(){
		return this.InstructorId;
	}
	
	public void SetInstructorId(int incomingid){
		this.InstructorId = incomingid;
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

}
