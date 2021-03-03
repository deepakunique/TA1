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
@Table(name = "user")
//@PrimaryKeyJoinColumn(name = "userId")
//@Inheritance(strategy=InheritanceType.JOINED)
public class User1 {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "userId", unique=true, nullable = false)
	private long userId;
	
	 private boolean isVerified;
	 private String role;
	 private String email;
	 private String name;
	 private String username;
	 private String password;
	 private String phoneCode ;
	 private Boolean isPhoneVerified ;
	 private String phoneCountryCode; ;
	 private String phoneNo ;
	 private String googleId;
	 private String signupType;
	 private String authToken;
	 
	 private Timestamp createdAt;
	 private Timestamp updatedAt;
	 private String dob;
	 private String gender;
	 private Integer profileCompletion;
	 private String userType;
	 private String avatar;
	 

	 
	 // Teacher Details
	 private String frequency;
	 private String minimumFee;
	 private String maximumFee;
	 private String feeDescription;
	 private String totalExp;
	 private String teachingExp;
	 private String onlineTeachingExp;
	 private boolean travel;
	 private String travelDistance;
	 private boolean onlineTeaching;
	 private boolean digitalPen;
	 private boolean homeworkHelp;
	 private boolean employed;
	 private String oppertunities;
	 
	 ArrayList<SubjectDetail> subjectDetails = new ArrayList < SubjectDetail > ();
	 ArrayList < EducationDetail > education = new ArrayList < EducationDetail > ();
	 private String description;
	 private String speciality;
	 private String pincode;
	 private String pinCountryCode;
	 
	 private Double lat;
	 private Double lng;
	 private String fullAddress;
	 private String country;
	 private String countryCode;
	 private String state;
	 private String district;
	 private String street = null;
	 private String locality;
	 private String placeId;
	 private String locationJson;
	 private String locationType;
	 
	 
	 
	 
	 
	public String getAuthToken() {
		return authToken;
	}
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public boolean isVerified() {
		return isVerified;
	}
	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneCode() {
		return phoneCode;
	}
	public void setPhoneCode(String phoneCode) {
		this.phoneCode = phoneCode;
	}
	public Boolean getIsPhoneVerified() {
		return isPhoneVerified;
	}
	public void setIsPhoneVerified(Boolean isPhoneVerified) {
		this.isPhoneVerified = isPhoneVerified;
	}
	public String getPhoneCountryCode() {
		return phoneCountryCode;
	}
	public void setPhoneCountryCode(String phoneCountryCode) {
		this.phoneCountryCode = phoneCountryCode;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getGoogleId() {
		return googleId;
	}
	public void setGoogleId(String googleId) {
		this.googleId = googleId;
	}
	public String getSignupType() {
		return signupType;
	}
	public void setSignupType(String signupType) {
		this.signupType = signupType;
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
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getProfileCompletion() {
		return profileCompletion;
	}
	public void setProfileCompletion(Integer profileCompletion) {
		this.profileCompletion = profileCompletion;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public String getMinimumFee() {
		return minimumFee;
	}
	public void setMinimumFee(String minimumFee) {
		this.minimumFee = minimumFee;
	}
	public String getMaximumFee() {
		return maximumFee;
	}
	public void setMaximumFee(String maximumFee) {
		this.maximumFee = maximumFee;
	}
	public String getFeeDescription() {
		return feeDescription;
	}
	public void setFeeDescription(String feeDescription) {
		this.feeDescription = feeDescription;
	}
	public String getTotalExp() {
		return totalExp;
	}
	public void setTotalExp(String totalExp) {
		this.totalExp = totalExp;
	}
	public String getTeachingExp() {
		return teachingExp;
	}
	public void setTeachingExp(String teachingExp) {
		this.teachingExp = teachingExp;
	}
	public String getOnlineTeachingExp() {
		return onlineTeachingExp;
	}
	public void setOnlineTeachingExp(String onlineTeachingExp) {
		this.onlineTeachingExp = onlineTeachingExp;
	}
	public boolean isTravel() {
		return travel;
	}
	public void setTravel(boolean travel) {
		this.travel = travel;
	}
	public String getTravelDistance() {
		return travelDistance;
	}
	public void setTravelDistance(String travelDistance) {
		this.travelDistance = travelDistance;
	}
	public boolean isOnlineTeaching() {
		return onlineTeaching;
	}
	public void setOnlineTeaching(boolean onlineTeaching) {
		this.onlineTeaching = onlineTeaching;
	}
	public boolean isDigitalPen() {
		return digitalPen;
	}
	public void setDigitalPen(boolean digitalPen) {
		this.digitalPen = digitalPen;
	}
	public boolean isHomeworkHelp() {
		return homeworkHelp;
	}
	public void setHomeworkHelp(boolean homeworkHelp) {
		this.homeworkHelp = homeworkHelp;
	}
	public boolean isEmployed() {
		return employed;
	}
	public void setEmployed(boolean employed) {
		this.employed = employed;
	}
	public String getOppertunities() {
		return oppertunities;
	}
	public void setOppertunities(String oppertunities) {
		this.oppertunities = oppertunities;
	}
	public ArrayList<SubjectDetail> getSubjectDetails() {
		return subjectDetails;
	}
	public void setSubjectDetails(ArrayList<SubjectDetail> subjectDetails) {
		this.subjectDetails = subjectDetails;
	}
	public ArrayList<EducationDetail> getEducation() {
		return education;
	}
	public void setEducation(ArrayList<EducationDetail> education) {
		this.education = education;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getPinCountryCode() {
		return pinCountryCode;
	}
	public void setPinCountryCode(String pinCountryCode) {
		this.pinCountryCode = pinCountryCode;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getLng() {
		return lng;
	}
	public void setLng(Double lng) {
		this.lng = lng;
	}
	public String getFullAddress() {
		return fullAddress;
	}
	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getPlaceId() {
		return placeId;
	}
	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}
	public String getLocationJson() {
		return locationJson;
	}
	public void setLocationJson(String locationJson) {
		this.locationJson = locationJson;
	}
	public String getLocationType() {
		return locationType;
	}
	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}
	 
	 
	 
	 
	
	}

	

	