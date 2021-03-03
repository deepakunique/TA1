package com.me.JobPortal.pojo;

import java.sql.Timestamp;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jobpost")
public class JobPost {
	 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "jobId", unique=true, nullable = false)
	private int jobId;
	ArrayList < Subject > subject = new ArrayList < Subject > ();
	 private String status;
	 private boolean isVerified;
	 private String helpType;
	 private String description;
	 private String association;
	 private String genderPreference;
	 private String dueDate = null;
	 private String distance = null;
	 private String level;
	 private float budget;
	 private String budgetCurency;
	 private String frequency;
	 private String tutorCount;
	 private String visibility;
	 private String postedBy;
	 private String address;
	 private boolean onlineHelp;
	 private String title;
	 private String phone;
	 private Timestamp createdAt;
	 private Timestamp updatedAt;
	 private boolean isOnline;
	 private boolean isOffline;
	 private String subjectTemp;
	 private long userId;
	 private String userName;
	 
	 
	 
	 
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public ArrayList<Subject> getSubject() {
		return subject;
	}
	public void setSubject(ArrayList<Subject> subject) {
		this.subject = subject;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean isVerified() {
		return isVerified;
	}
	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}
	public String getHelpType() {
		return helpType;
	}
	public void setHelpType(String helpType) {
		this.helpType = helpType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAssociation() {
		return association;
	}
	public void setAssociation(String association) {
		this.association = association;
	}
	public String getGenderPreference() {
		return genderPreference;
	}
	public void setGenderPreference(String genderPreference) {
		this.genderPreference = genderPreference;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public float getBudget() {
		return budget;
	}
	public void setBudget(float budget) {
		this.budget = budget;
	}
	public String getBudgetCurency() {
		return budgetCurency;
	}
	public void setBudgetCurency(String budgetCurency) {
		this.budgetCurency = budgetCurency;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public String getTutorCount() {
		return tutorCount;
	}
	public void setTutorCount(String tutorCount) {
		this.tutorCount = tutorCount;
	}
	public String getVisibility() {
		return visibility;
	}
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
	public String getPostedBy() {
		return postedBy;
	}
	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isOnlineHelp() {
		return onlineHelp;
	}
	public void setOnlineHelp(boolean onlineHelp) {
		this.onlineHelp = onlineHelp;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	public boolean isOnline() {
		return isOnline;
	}
	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}
	public boolean isOffline() {
		return isOffline;
	}
	public void setOffline(boolean isOffline) {
		this.isOffline = isOffline;
	}
	public String getSubjectTemp() {
		return subjectTemp;
	}
	public void setSubjectTemp(String subjectTemp) {
		this.subjectTemp = subjectTemp;
	}


	 
	}