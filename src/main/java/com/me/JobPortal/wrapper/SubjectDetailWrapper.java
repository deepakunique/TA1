package com.me.JobPortal.wrapper;

public class SubjectDetailWrapper {
	
	private String subjectName;
	private int subjectId;
	private String subjectLevel;
	
	
	public SubjectDetailWrapper() {
		// TODO Auto-generated constructor stub
	}
	
	
	public SubjectDetailWrapper(String subjectName, int subjectId, String subjectLevel) {
		super();
		this.subjectName = subjectName;
		this.subjectId = subjectId;
		this.subjectLevel = subjectLevel;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectLevel() {
		return subjectLevel;
	}
	public void setSubjectLevel(String subjectLevel) {
		this.subjectLevel = subjectLevel;
	}

	
	
}
