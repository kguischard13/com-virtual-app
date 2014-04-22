package com.vcclass.app.Services;


import java.sql.*;
import java.util.*;
import java.util.Date;
import com.vcclass.app.Repository.*;
import com.vcclass.app.Data.*;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class CourseService implements CourseDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	
	public void setDataSource(DataSource dataSource){
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	public int CreateCourseSession(CourseSession coursesession){
		
		String sql = "insert into CourseSession (Course_Id, MeetingDate, Topic) values (?, ?, ?)";
		String sql2 = "select max(Id) from `CourseSession`";
		jdbcTemplateObject.update(sql, coursesession.GetCourseId() , coursesession.getMeetingDate(), coursesession.getClassTopic());
		
		return jdbcTemplateObject.queryForInt(sql2);
	}
	public int CreateCourse(Course course){
		String sql = "insert into Course (User_Id, StartDate, EndDate, CourseTitle, CourseCode) values (?, ?, "
				+ "?,?,?)";
		String sql2 = "select max(Id) from `Course`";
		jdbcTemplateObject.update(sql, course.GetUserId() , course.GetStartTime(), course.GetEndTime(),
				course.GetCourseTitle(), course.GetCourseCode());
		
		
		return jdbcTemplateObject.queryForInt(sql2);
	}
	
	public Course GetCourse(int courseid){
		Course cours = null;
		
		if(ValidateCourse(courseid)){
			String sql = "select * from Course where Id = ?";
			cours = jdbcTemplateObject.queryForObject(sql, new Object[]{courseid}, new RowMapper<Course>(){
				@Override
				public Course mapRow(ResultSet rs, int rowNum) throws SQLException{
					return new Course (rs.getInt("Id"), rs.getInt("User_Id"),
							rs.getDate("StartDate"),rs.getDate("EndDate"), rs.getString("CourseTitle"), rs.getString("CourseCode"));
				}
			});
		}
		return cours;
	}
	public CourseSession GetCourseSession(int coursesessionid){
		CourseSession session = null;
		
		if(ValidateCourseSess(coursesessionid)){
			String sql = "select * from CourseSession where Id = ?";
			session = jdbcTemplateObject.queryForObject(sql, new Object[]{coursesessionid}, new RowMapper<CourseSession>(){
				@Override
				public CourseSession mapRow(ResultSet rs, int rowNum) throws SQLException{
					Course course = GetCourse(rs.getInt("Course_Id") );
					
					return new CourseSession (course,rs.getInt("Id"), rs.getDate("MeetingDate"),
							rs.getString("Topic"));
				}
			});
		}
		return session;
		
	}
	public boolean DeleteCourse(int id){
		if(this.ValidateCourse(id)){
			String sql = "delete from Course where Id = ?";
			String sql2 = "delete from CourseSession where Course_Id = ?";
			
			jdbcTemplateObject.update(sql,id);
			jdbcTemplateObject.update(sql2,id);
			return true;
		}
		return false;
	}
	public boolean DeleteCourseSession(int id){
		if(this.ValidateCourseSess(id)){
			String sql = "delete from CourseSession where Id = ?";
			String sql2 = "delete from LiveDiscussion where CourseSession_Id = ?";
			jdbcTemplateObject.update(sql,id);
			jdbcTemplateObject.update(sql2,id);
			return true;
		}
		return false;
	}
	public boolean UpdateCourse(Course course){
		if(this.ValidateCourse(course.GetCourseId())){
			String sql = "update Course set User_Id = ?, StartDate = ?, EndDate= ?, CourseTitle = ?, CourseCode =? "
					+ "where Id = ?";
			jdbcTemplateObject.update(sql, course.GetUserId(), course.GetStartTime(), course.GetEndTime(),course.GetCourseTitle(),
					course.GetCourseCode(),course.GetCourseId());
			return true;
		}
		return false;
	}
	public boolean UpdateCourseSession(CourseSession session){
		if(this.ValidateCourseSess(session.GetId())){
			String sql = "update CourseSession set MeetingDate = ?, Topic= ? "
					+ "where Id = ?";
			jdbcTemplateObject.update(sql, session.getMeetingDate(), session.getClassTopic(), session.GetId());
			return true;
		}
		return false;
	}

	public List<Course> GetAllCourses(){
		
		String sql = "select * from Course";
		List<Course> course = jdbcTemplateObject.query(sql, new RowMapper<Course>(){
			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException{
				return new Course (rs.getInt("Id"), rs.getInt("User_Id"),
						rs.getDate("StartDate"),rs.getDate("EndDate"), rs.getString("CourseTitle"),rs.getString("CourseCode") );
			}
		});
		return course;
	}
	public List<CourseSession> GetAllCourseSessions(){
		String sql = "select * from CourseSession";
		List<CourseSession> session = jdbcTemplateObject.query(sql, new RowMapper<CourseSession>(){
			@Override
			public CourseSession mapRow(ResultSet rs, int rowNum) throws SQLException{
				Course course = GetCourse(rs.getInt("Course_Id") );
				
				return new CourseSession (course,rs.getInt("Id"), rs.getDate("MeetingDate"),
						rs.getString("Topic"));
			}
		});
		return session;
	}
	public boolean AddStudentToCourse(int stud, int course){
		String sql = "insert into Student_has_Course (User_Id, Course_Id) values (?,?)";
		
		if(this.ValidateCourse(course)){
			jdbcTemplateObject.update(sql, stud, course);
			return true;
		}
		return false;
	}
	public List<User> GetStudentsOfCourse(int course){
		List<User> user = null;
		
		if(this.ValidateCourse(course)){
			String sql = "SELECT * FROM Student_Has_Course Join User on User_Id = User.`Id` "
				+ "where Student_Has_Course.Course_Id = ?";
		
			user = jdbcTemplateObject.query(sql,new Object[]{course} ,new RowMapper<User>(){
				@Override
				public User mapRow(ResultSet rs, int rowNum) throws SQLException{
					return new User (rs.getInt("Id"), rs.getString("AccountType"),
							rs.getString("FirstName"),rs.getString("LastName"), rs.getString("PhoneNumber"),rs.getString("Email"),
							rs.getString("Password"));
				}
			});
		}
		return user;
	}
	public List<Course> GetCoursesOfStudent(int stud){
		
		String sql = "SELECT * FROM Course Join Student_has_Course on Student_has_Course.`Course_Id` = Course.`Id` where "
				+ "Student_has_Course.`User_Id` = ?";
		
		List<Course> course = jdbcTemplateObject.query(sql,new Object[]{stud} ,new RowMapper<Course>(){
			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException{
				return new Course (rs.getInt("Id"), rs.getInt("Course.User_Id"),
						rs.getDate("StartDate"),rs.getDate("EndDate"), rs.getString("CourseTitle"), rs.getString("CourseCode"));
			}
		});
		
		
		return course;
	}
	public List<CourseSession> GetSessionsOfCourse(int course){
		List<CourseSession> session = null;
		
		if(ValidateCourse(course)){
			String sql = "select * from CourseSession where Course_Id = ?";
			session = jdbcTemplateObject.query(sql, new Object[]{course}, new RowMapper<CourseSession>(){
				@Override
				public CourseSession mapRow(ResultSet rs, int rowNum) throws SQLException{
					Course course = GetCourse(rs.getInt("Course_Id"));
					
					return new CourseSession (course,rs.getInt("Id"), rs.getDate("MeetingDate"),
							rs.getString("Topic"));
				}
			});
		}
		return session;
	}
	
	private boolean ValidateCourse(int id){
		String sql = "select count(*) from Course where Id = ?";
	
		if(jdbcTemplateObject.queryForInt(sql, id) == 0){
			return false;
		}

		return true;
	}
	private boolean ValidateCourseSess(int id){
		String sql = "select count(*) from CourseSession where Id = ?";
		if(jdbcTemplateObject.queryForInt(sql, id) == 0){
			return false;
		}
		return true;
	}

}
