package com.vcclass.app.Repository;

import javax.sql.DataSource;

import java.util.List;

import com.vcclass.app.Data.*;

public interface CourseDAO {
	public void setDataSource(DataSource dataSource);
	public int CreateCourseSession(CourseSession coursesession);
	public int CreateCourse(Course course);
	//public void EndCourseSession(int coursesessionid);
	public Course GetCourse(int courseid);
	public CourseSession GetCourseSession(int coursesessionid);
	public boolean DeleteCourse(int courseid);
	public boolean DeleteCourseSession(int coursesessionid);
	public boolean UpdateCourse(Course course);
	public boolean UpdateCourseSession(CourseSession coursesession);
	public List<Course> GetAllCourses();
	public List<CourseSession> GetAllCourseSessions();

}
