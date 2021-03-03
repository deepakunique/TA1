package com.me.JobPortal.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "educationDetails")
public class EducationDetail {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique=true, nullable = false)
    	private Integer id; 
    	private String institution;
		private String degreeType; 
		private String degreeName; 
		private Integer startMonth; 
		private Integer endMonth; 
		private Integer startYear; 
		private Integer endYear; 
		private String association;
		private String speciality ;
		private Double score ;
		private Integer userId;
		
		
		public EducationDetail() {
			// TODO Auto-generated constructor stub
		}
		
		public EducationDetail(int userId) {
			this.userId = userId;
		}
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getInstitution() {
			return institution;
		}
		public void setInstitution(String institution) {
			this.institution = institution;
		}
		public String getDegreeType() {
			return degreeType;
		}
		public void setDegreeType(String degreeType) {
			this.degreeType = degreeType;
		}
		public String getDegreeName() {
			return degreeName;
		}
		public void setDegreeName(String degreeName) {
			this.degreeName = degreeName;
		}
		public Integer getStartMonth() {
			return startMonth;
		}
		public void setStartMonth(Integer startMonth) {
			this.startMonth = startMonth;
		}
		public Integer getEndMonth() {
			return endMonth;
		}
		public void setEndMonth(Integer endMonth) {
			this.endMonth = endMonth;
		}
		public Integer getStartYear() {
			return startYear;
		}
		public void setStartYear(Integer startYear) {
			this.startYear = startYear;
		}
		public Integer getEndYear() {
			return endYear;
		}
		public void setEndYear(Integer endYear) {
			this.endYear = endYear;
		}
		public String getAssociation() {
			return association;
		}
		public void setAssociation(String association) {
			this.association = association;
		}
		public String getSpeciality() {
			return speciality;
		}
		public void setSpeciality(String speciality) {
			this.speciality = speciality;
		}
		public Double getScore() {
			return score;
		}
		public void setScore(Double score) {
			this.score = score;
		}
		public Integer getUserId() {
			return userId;
		}
		public void setUserId(Integer userId) {
			this.userId = userId;
		}
		
		
    	
}
