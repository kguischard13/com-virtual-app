package com.vcclass.app.Repository;

import javax.sql.DataSource;

import java.util.List;

import com.vcclass.app.Data.*;

public interface CourseDAO {
	public void setDataSource(DataSource dataSource);
	public int CreateCourseSession(CourseSession coursesession);
	public int CreateCourse(Course course);
	public Course GetCourse(int courseid);
	public CourseSession GetCourseSession(int coursesessionid);
	//public void EndCourseSession(int coursesessionid);
	
	public boolean DeleteCourse(int courseid);
	public boolean DeleteCourseSession(int coursesessionid);
	public boolean UpdateCourse(Course course);
	public boolean UpdateCourseSession(CourseSession coursesession);
	
	public boolean AddStudentToCourse(int stud, int course);
	public List<Course> GetAllCourses();
	public List<CourseSession> GetAllCourseSessions();
	public List<User> GetStudentsOfCourse(int course);
	public List<Course> GetCoursesOfStudent(int stud);
	public List<CourseSession> GetSessionsOfCourse(int course);

}
