package com.vcclass.app.RowMappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.vcclass.app.Data.LiveDiscussion;

public class LiveDiscussionRowMapper implements RowMapper<LiveDiscussion>
{
	@Override
	public LiveDiscussion mapRow(ResultSet rs, int row) throws SQLException 
	{
		LiveDiscussion discussion = new LiveDiscussion(); 
		discussion.Id = rs.getInt("LiveDiscussionID"); 
		discussion.CourseId = rs.getInt("Courses_CourseID"); 
		discussion.DateCreated = rs.getDate("DateCreated"); 
		discussion.FilePath = rs.getString("FilePath"); 
		discussion.OwnerId = rs.getInt("Student_StudentID"); 
		discussion.CourseSessionId = rs.getInt("Courses_CourseSessionID"); 
		discussion.FilePath = rs.getString("FilePath"); 
		discussion.Topic = rs.getString("Topic"); 
		
		return discussion; 
	}
}
