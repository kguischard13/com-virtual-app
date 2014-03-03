package com.vcclass.app.Repository;

import javax.sql.DataSource;
import com.vcclass.app.Data.*;

public interface CourseDAO {
	public void CreateCourseSession(int courseid);
	//public void EndCourseSession(int coursesessionid);
	public Course GetCourse(int courseid);
	public CourseSession GetCourseSession(int coursesessionid);
	public void AddNewCourse(int teacher, Course courseid);
	public void DeleteCourse(int courseid);
	public void DeleteCourseSession(int coursesessionid);
	public void UpdateCourse(int courseid);
	public void UpdateCourseSession(int coursesessionid);

}
