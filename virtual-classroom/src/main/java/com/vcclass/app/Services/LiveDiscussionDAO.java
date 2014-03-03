package com.vcclass.app.Services;

import javax.sql.DataSource;

import com.vcclass.app.Data.LiveDiscussion;

public interface LiveDiscussionDAO 
{
	public void SetDataSource(DataSource ds); 
	public LiveDiscussion GetLiveDiscussion(int studentId, int liveDiscussionId, int courseId); 
	public int CreateLiveDiscussion(int studentId, LiveDiscussion discussion); 
	public boolean DeleteLiveDiscussion(int studentId, int liveDiscussionId); 
	public boolean UpdateLiveDiscussion(int studentId, int liveDiscussionId); 
}
