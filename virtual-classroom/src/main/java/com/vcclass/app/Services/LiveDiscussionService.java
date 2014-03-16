package com.vcclass.app.Services;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.vcclass.app.Data.LiveDiscussion;
import com.vcclass.app.Repository.LiveDiscussionDAO;

public class LiveDiscussionService implements LiveDiscussionDAO
{
	private DataSource dataSource; 
	private JdbcTemplate jdbc; 

	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = ds; 
		this.jdbc = new JdbcTemplate(ds); 
	}

	@Override
	public LiveDiscussion GetLiveDiscussion(int studentId,
			int liveDiscussionId, int courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int CreateLiveDiscussion(int studentId, LiveDiscussion discussion) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean DeleteLiveDiscussion(int studentId, int liveDiscussionId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean UpdateLiveDiscussion(int studentId, int liveDiscussionId) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
