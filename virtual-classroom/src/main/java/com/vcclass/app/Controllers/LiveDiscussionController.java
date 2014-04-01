/*
 * This class will handle all actions relating to the Live Discussion Object
 * Chris Forehand
 * 2/2014
 * Test Cases: 
 * 
 * */

package com.vcclass.app.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vcclass.app.Data.LiveDiscussion;
import com.vcclass.app.Services.LiveDiscussionService;

@Controller
public class LiveDiscussionController 
{
	ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	private LiveDiscussionService liveDiscussionService = (LiveDiscussionService) context.getBean("liveDiscussionService");
	
	private static final Logger logger = LoggerFactory.getLogger(LiveDiscussionController.class); 
	
	@RequestMapping(value = "/live-discussion/get-discussion/{liveDiscussionId}/course-session/{courseSessionId}", method = RequestMethod.GET)
	public @ResponseBody LiveDiscussion GetLiveDiscussion(@PathVariable int liveDiscussionId, @PathVariable int courseSessionId)
	{
		LiveDiscussion discussion = liveDiscussionService.GetLiveDiscussion(liveDiscussionId, courseSessionId); 
		return discussion; 
	}
	
	@RequestMapping(value = "/live-discussion/create-discussion/{courseSessionId}", method = RequestMethod.GET)
	public @ResponseBody int CreateLiveDiscussion(@RequestBody LiveDiscussion discussion, int courseSessionId)
	{
		int id = liveDiscussionService.CreateLiveDiscussion(courseSessionId, discussion); 
		return id;
	}
	
	@RequestMapping(value="/live-discussion/delete-live-discussion/{liveDiscussionId}/course-session/{courseSessionId}", method=RequestMethod.GET)
	public @ResponseBody boolean DeleteLiveDiscussion(@PathVariable int liveDiscussionId, @PathVariable int courseSessionId)
	{
		return liveDiscussionService.DeleteLiveDiscussion(liveDiscussionId, courseSessionId);  
	}
}

