/*
 * This class will handle all actions relating to persisting the Live Discussion Object in the database
 * Chris Forehand
 * 2/2014
 * Test Cases: 
 * 
 * */

package com.vcclass.app.Services;

import java.sql.Date;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.mysql.jdbc.PreparedStatement;
import com.vcclass.app.Data.LiveDiscussion;
import com.vcclass.app.Data.Note;
import com.vcclass.app.Repository.LiveDiscussionDAO;
import com.vcclass.app.RowMappers.LiveDiscussionRowMapper;
import com.vcclass.app.RowMappers.NoteRowMapper;

public class LiveDiscussionService implements LiveDiscussionDAO
{
	private DataSource dataSource; 
	private JdbcTemplate jdbc; 

	@Override
	public void setDataSource(DataSource ds) 
	{
		this.dataSource = ds; 
		this.jdbc = new JdbcTemplate(ds); 
	}

	@Override
	public LiveDiscussion GetLiveDiscussion(int liveDiscussionId, int courseSessionId) 
	{
		String sql = "select * FROM LiveDiscussion WHERE Id = ? AND CourseSession_Id = ?"; 
		LiveDiscussion discussion = new LiveDiscussion();
		discussion = jdbc.queryForObject(sql, new Object[]{liveDiscussionId, courseSessionId}, new LiveDiscussionRowMapper());
		
		return discussion; 
	}

	@Override
	public int CreateLiveDiscussion(final int courseSessionId, final LiveDiscussion discussion) 
	{
		final String sql = "insert into LiveDiscussion (CourseSession_Id, DateCreated, FilePath, Topic) values (?, ?, ?, ?)";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
	        jdbc.update(
	        		new PreparedStatementCreator()  
	        		{	             
						@Override
						public java.sql.PreparedStatement createPreparedStatement(
								java.sql.Connection arg0) throws SQLException {
							   PreparedStatement ps =
			                            (PreparedStatement) arg0.prepareStatement(sql, new String[] {"id"});
			                        ps.setInt(1, courseSessionId);
			                        ps.setDate(2, (Date) discussion.DateCreated);
			                        ps.setString(3, discussion.FilePath); 
			                        ps.setString(4, discussion.Topic);
			                        return ps;
						}
	                }, keyHolder);
	        
        return keyHolder.getKey().intValue();
	}

	@Override
	public boolean DeleteLiveDiscussion(int courseSessionId, int liveDiscussionId) 
	{
		String sql = "delete FROM LiveDiscussion WHERE Id = ? AND CourseSession_Id = ?"; 
		jdbc.update(sql, liveDiscussionId, courseSessionId); 
		return true;
	}

	@Override
	public boolean UpdateLiveDiscussion(int studentId, int liveDiscussionId) 
	{
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
