package com.vcclass.app.Data;


import java.util.Date;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.codehaus.jackson.annotate.JsonProperty;

@Service
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class CourseSession extends Course{
	
	@JsonProperty(value="Id")
	private int Id;
	
	@JsonProperty(value="MeetingDate")
	private Date MeetingDate;
	
	@JsonProperty(value="ClassTopic")
	private String ClassTopic;

	public CourseSession(){
		super();
		this.Id = -1;
		this.MeetingDate = null;
		this.ClassTopic = null;
	}
	
	public CourseSession(int courseid, int teacherid, Date sd, Date ed, String title, String code,int sessionid,
			Date meetdate, String topic){
		super(courseid, teacherid, sd, ed, title, code);
		this.Id = sessionid;
		this.MeetingDate = meetdate;
		this.ClassTopic = topic;
	}
	public CourseSession(int courseid, int teacherid, Date sd, Date ed, String title, String code,
			Date meetdate, String topic){
		super(courseid, teacherid, sd, ed, title, code);
		this.Id = -1;
		this.MeetingDate = meetdate;
		this.ClassTopic = topic;
	}
	
	public CourseSession(Course course, int coursesessionid,
			Date meetdate, String topic){
		super(course);
		this.Id = coursesessionid;
		this.MeetingDate = meetdate;
		this.ClassTopic = topic;
	}
	public CourseSession(Course course, Date meetdate, String topic){
		super(course);
		this.Id = -1;
		this.MeetingDate = meetdate;
		this.ClassTopic = topic;
	}
	
	public int GetId(){
		return this.Id;
	}
	
	public void setId(int id){
		this.Id = id;
	}
	
	public Date getMeetingDate(){
		return this.MeetingDate;
	}
	
	public void setMeetingDate(Date meet){
		this.MeetingDate = meet;
	}
	
	public String getClassTopic(){
		return this.ClassTopic;
	}
	
	public void setClassTopic(String topic){
		this.ClassTopic = topic;
	}
	
	

}
