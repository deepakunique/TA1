package com.me.JobPortal.wrapper;

import java.util.ArrayList;
import java.util.List;

import com.me.JobPortal.pojo.Conversation;

public class ConversationWrapper {
	
	private long jobPostId;
	private String jobTitle;
	private String fromName;
	private String toName;
	private List<Conversation> messageList = new ArrayList<Conversation>();
	
	
	public long getJobPostId() {
		return jobPostId;
	}
	public void setJobPostId(long jobPostId) {
		this.jobPostId = jobPostId;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getFromName() {
		return fromName;
	}
	public void setFromName(String fromName) {
		this.fromName = fromName;
	}
	public String getToName() {
		return toName;
	}
	public void setToName(String toName) {
		this.toName = toName;
	}
	public List<Conversation> getMessageList() {
		return messageList;
	}
	public void setMessageList(List<Conversation> messageList) {
		this.messageList = messageList;
	}
	
	
}
