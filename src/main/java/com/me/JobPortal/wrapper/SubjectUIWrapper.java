package com.me.JobPortal.wrapper;

import java.util.ArrayList;
import java.util.List;

import com.me.JobPortal.pojo.Subject;

public class SubjectUIWrapper {
	
	long userId;
	List<SubjectDetailWrapper> subjectList = new ArrayList<SubjectDetailWrapper>();
	
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public List<SubjectDetailWrapper> getSubjectList() {
		return subjectList;
	}
	public void setSubjectList(List<SubjectDetailWrapper> subjectList) {
		this.subjectList = subjectList;
	}
	
	
	

}
