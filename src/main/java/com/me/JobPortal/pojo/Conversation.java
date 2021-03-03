package com.me.JobPortal.pojo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "conversation")
public class Conversation {

		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique=true, nullable = false)
	 	private long id;
	
	    private long fromId;
	    private long toId;
	    private long jobPostId;
	    private String message;
	    private boolean seen;
	    private Timestamp createdAt;
		private Timestamp updatedAt;
		private String jobPostTitle;
		
		
		
		
		public String getJobPostTitle() {
			return jobPostTitle;
		}

		public void setJobPostTitle(String jobPostTitle) {
			this.jobPostTitle = jobPostTitle;
		}

		public Conversation() {
			
		}
		
		public Conversation(long jobPostId) {
			this.jobPostId = jobPostId;
			
		}


		public Conversation(long from, long to, long jobPostId, String message, Timestamp createdAt) {
			super();
			this.fromId = from;
			this.toId = to;
			this.jobPostId = jobPostId;
			this.message = message;
			this.createdAt = createdAt;
		}
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		
		public long getFromId() {
			return fromId;
		}

		public void setFromId(long fromId) {
			this.fromId = fromId;
		}

		public long getToId() {
			return toId;
		}

		public void setToId(long toId) {
			this.toId = toId;
		}

		public long getJobPostId() {
			return jobPostId;
		}
		public void setJobPostId(long jobPostId) {
			this.jobPostId = jobPostId;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public boolean isSeen() {
			return seen;
		}
		public void setSeen(boolean read) {
			this.seen = read;
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
		
		
		
}
