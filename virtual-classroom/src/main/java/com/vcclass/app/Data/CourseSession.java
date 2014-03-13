package com.vcclass.app.Data;


import java.util.Date;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.codehaus.jackson.annotate.JsonProperty;

@Service
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class CourseSession extends Course{
	
	@JsonProperty(value="CourseSessionId")
	private int CourseSessionId;
	
	@JsonProperty(value="MeetingDate")
	private Date MeetingDate;
	
	@JsonProperty(value="ClassTopic")
	private String ClassTopic;

	public CourseSession(){
		super();
		this.CourseSessionId = -1;
		this.MeetingDate = null;
		this.ClassTopic = null;
	}
	
	public CourseSession(int courseid, int teacherid, Date sd, Date ed, String title,int sessionid,
			Date meetdate, String topic){
		super(courseid, teacherid, sd, ed, title);
		this.CourseSessionId = sessionid;
		this.MeetingDate = meetdate;
		this.ClassTopic = topic;
	}
	public CourseSession(int courseid, int teacherid, Date sd, Date ed, String title,
			Date meetdate, String topic){
		super(courseid, teacherid, sd, ed, title);
		this.CourseSessionId = -1;
		this.MeetingDate = meetdate;
		this.ClassTopic = topic;
	}
	
	public CourseSession(Course course, int coursesessionid,
			Date meetdate, String topic){
		super(course);
		this.CourseSessionId = coursesessionid;
		this.MeetingDate = meetdate;
		this.ClassTopic = topic;
	}
	
	
	public int GetCourseSessionId(){
		return this.CourseSessionId;
	}
	
	public void setCourseSession(int id){
		this.CourseSessionId = id;
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
