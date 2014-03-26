package com.vcclass.app.Repository;

import javax.sql.DataSource;

import com.vcclass.app.Data.LiveDiscussion;

public interface LiveDiscussionDAO 
{
	public void setDataSource(DataSource ds); 
	public LiveDiscussion GetLiveDiscussion(int liveDiscussionId, int courseSessionId); 
	public int CreateLiveDiscussion(int courseSessionId, LiveDiscussion discussion); 
	public boolean DeleteLiveDiscussion(int courseSessionId, int liveDiscussionId); 
	public boolean UpdateLiveDiscussion(int courseSessionId, int liveDiscussionId); 
}
