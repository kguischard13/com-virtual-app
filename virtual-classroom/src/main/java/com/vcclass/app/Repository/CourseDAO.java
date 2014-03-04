package com.vcclass.app.Repository;

import javax.sql.DataSource;
import java.util.List;
import com.vcclass.app.Data.*;

public interface CourseDAO {
	public boolean CreateCourseSession(int courseid);
	public boolean CreateCourse(int teacher, Course courseid);
	//public void EndCourseSession(int coursesessionid);
	public Course GetCourse(int courseid);
	public CourseSession GetCourseSession(int coursesessionid);
	public boolean DeleteCourse(int courseid);
	public boolean DeleteCourseSession(int coursesessionid);
	public boolean UpdateCourse(int courseid);
	public boolean UpdateCourseSession(int coursesessionid);

}
