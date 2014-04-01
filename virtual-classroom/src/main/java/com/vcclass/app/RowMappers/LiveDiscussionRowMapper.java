/*
 * This class will handle mapping relational database rows to the Live Discussion Object
 * Chris Forehand
 * 2/2014
 * Test Cases: 
 * 
 * */

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
		discussion.Id = rs.getInt("Id"); 
		discussion.CourseSessionId = rs.getInt("CourseSession_Id"); 
		discussion.DateCreated = rs.getDate("DateCreated"); 
		discussion.FilePath = rs.getString("FilePath"); 
		discussion.Topic = rs.getString("Topic"); 
		
		return discussion; 
	}
}
