package com.vcclass.app.Services;

import com.vcclass.app.Data.LiveDiscussion;

public interface LiveDiscussionDAO 
{
	public LiveDiscussion GetLiveDiscussion(int studentId, int liveDiscussionId, int courseId); 
	public boolean CreateLiveDiscussion(int studentId, LiveDiscussion discussion); 
	public boolean DeleteLiveDiscussion(int studentId, int liveDiscussionId); 
	public boolean UpdateLiveDiscussion(int studentId, int liveDiscussionId); 
}
