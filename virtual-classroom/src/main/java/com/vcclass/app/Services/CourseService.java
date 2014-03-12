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
		
		String sql = "insert into CourseSession (Courses_courseID, MeetingDate, Topic) values (?, ?, ?)";
		String sql2 = "select max(CourseSessionID) from `CourseSession`";
		jdbcTemplateObject.update(sql, coursesession.GetCourseId() , coursesession.getMeetingDate(), coursesession.getClassTopic());
		
		return jdbcTemplateObject.queryForInt(sql2);
	}
	public int CreateCourse(Course course){
		String sql = "insert into Course (Teacher_instrID, StartDate, EndDate, CourseTitle) values (?, ?, "
				+ "?,?)";
		String sql2 = "select max(CourseID) from `Course`";
		jdbcTemplateObject.update(sql, course.GetInstructorId() , course.GetStartTime(), course.GetEndTime(),
				course.GetCourseTitle());
		
		
		return jdbcTemplateObject.queryForInt(sql2);
	}
	
	public Course GetCourse(int courseid){
		Course cours = null;
		
		if(ValidateCourse(courseid)){
			String sql = "select * from Course where CourseID = ?";
			cours = jdbcTemplateObject.queryForObject(sql, new Object[]{courseid}, new RowMapper<Course>(){
				@Override
				public Course mapRow(ResultSet rs, int rowNum) throws SQLException{
					return new Course (rs.getInt("CourseID"), rs.getInt("Teacher_instrID"),
							rs.getDate("StartDate"),rs.getDate("EndDate"), rs.getString("CourseTitle"));
				}
			});
		}
		return cours;
	}
	public CourseSession GetCourseSession(int coursesessionid){
		CourseSession session = null;
		
		if(ValidateCourseSess(coursesessionid)){
			String sql = "select * from CourseSession where CourseSessionID = ?";
			session = jdbcTemplateObject.queryForObject(sql, new Object[]{coursesessionid}, new RowMapper<CourseSession>(){
				@Override
				public CourseSession mapRow(ResultSet rs, int rowNum) throws SQLException{
					Course course = GetCourse(rs.getInt("Courses_courseID") );
					
					return new CourseSession (course,rs.getInt("CourseSessionID"), rs.getDate("MeetingDate"),
							rs.getString("Topic"));
				}
			});
		}
		return session;
		
	}
	public boolean DeleteCourse(int id){
		if(this.ValidateCourse(id)){
			String sql = "delete from Course where CourseID = ?";
			String sql2 = "delete from CourseSession where Courses_courseID = ?";
			
			// delete coursesessions in the live discussion table
			jdbcTemplateObject.update(sql,id);
			jdbcTemplateObject.update(sql2,id);
			return true;
		}
		return false;
	}
	public boolean DeleteCourseSession(int id){
		if(this.ValidateCourseSess(id)){
			String sql = "delete from CourseSession where CourseSessionID = ?";
			String sql2 = "delete from LiveDiscussion where CourseSession_CourseSessionID = ?";
			jdbcTemplateObject.update(sql,id);
			jdbcTemplateObject.update(sql2,id);
			return true;
		}
		return false;
	}
	public boolean UpdateCourse(Course course){
		if(this.ValidateCourse(course.GetCourseId())){
			String sql = "update Course set Teacher_instrID = ?, StartDate = ?, EndDate= ?, CourseTitle = ? "
					+ "where CourseID = ?";
			jdbcTemplateObject.update(sql, course.GetInstructorId(), course.GetStartTime(), course.GetEndTime(),course.GetCourseTitle(),
					course.GetCourseId());
			return true;
		}
		return false;
	}
	
	public boolean UpdateCourseSession(CourseSession session){
		if(this.ValidateCourseSess(session.GetCourseSessionId())){
			String sql = "update CourseSession set MeetingDate = ?, Topic= ? "
					+ "where CourseSessionID = ?";
			jdbcTemplateObject.update(sql, session.getMeetingDate(), session.getClassTopic());
			return true;
		}
		return false;
	}
	public List<Course> GetAllCourses(){
		String sql = "select * from Course";
		List<Course> course = jdbcTemplateObject.query(sql, new RowMapper<Course>(){
			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException{
				return new Course (rs.getInt("CourseID"), rs.getInt("Teacher_instrID"),
						rs.getDate("StartDate"),rs.getDate("EndDate"), rs.getString("CourseTitle"));
			}
		});
		return course;
	}
	
	public List<CourseSession> GetAllCourseSessions(){
		String sql = "select * from CourseSession";
		List<CourseSession> session = jdbcTemplateObject.query(sql, new RowMapper<CourseSession>(){
			@Override
			public CourseSession mapRow(ResultSet rs, int rowNum) throws SQLException{
				Course course = GetCourse(rs.getInt("Courses_courseID") );
				
				return new CourseSession (course,rs.getInt("CourseSessionID"), rs.getDate("MeetingDate"),
						rs.getString("Topic"));
			}
		});
		return session;
	}
	
	
	private boolean ValidateCourse(int id){
		String sql = "select count(*) from Course where CourseID = ?";
	
		if(jdbcTemplateObject.queryForInt(sql, id) == 0){
			return false;
		}

		return true;
	}
	private boolean ValidateCourseSess(int id){
		String sql = "select count(*) from CourseSession where CourseSessionID = ?";
		if(jdbcTemplateObject.queryForInt(sql, id) == 0){
			return false;
		}
		return true;
	}

}
