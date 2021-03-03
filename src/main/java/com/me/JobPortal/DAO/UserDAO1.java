package com.me.JobPortal.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.me.JobPortal.exception.UserException;
import com.me.JobPortal.pojo.Conversation;
import com.me.JobPortal.pojo.EducationDetail;
import com.me.JobPortal.pojo.JobPost;
import com.me.JobPortal.pojo.SubjectDetail;
import com.me.JobPortal.pojo.User1;
import com.me.JobPortal.utility.Utility;
import com.me.JobPortal.wrapper.ConversationWrapper;
import com.me.JobPortal.wrapper.SubjectDetailWrapper;
import com.me.JobPortal.wrapper.SubjectUIWrapper;

public class UserDAO1 extends DAO {

	public UserDAO1() {
	}   
	
	
	
	public Boolean verifyEmail(String authtoken) throws UserException {
		try {
			Transaction t = getSession().beginTransaction();
			String qryString = "update com.me.JobPortal.pojo.User1 u set u.isVerified=1, u.updatedAt = :updatedOn where u.authToken=:token and u.isVerified=0";
	        Query query3 = getSession().createQuery(qryString);
	        query3.setParameter("token", authtoken);
	        query3.setParameter("updatedOn", Utility.getCurrentDateTime());
	        int count = query3.executeUpdate();
	       
	        t.commit();
	        if(count==1) {
	        	return true;
	        }else
	        	return false;
	       
	        
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user:: authtoken::  " + authtoken, e);
		}
	}
	
	public List<JobPost> list() throws UserException {
	    try {
	        begin();
	        Query q = getSession().createQuery("from JobPost");
	        
	        List<JobPost> list = q.list();
	        commit();
	        return list;
	    } catch (HibernateException e) {
	        rollback();
	        throw new UserException("Could not list the Jobs", e);
	    }
	}
	
	public User1 get(String username, String password) throws UserException {
		try {
			Transaction transaction = null;
			 transaction = getSession().beginTransaction();
			Query q = getSession().createQuery("from com.me.JobPortal.pojo.User1 where email = :username and password = :password");
			q.setString("username", username);
			q.setString("password", password);
			
			if(q.uniqueResult()!=null) {
				User1 user = (User1) q.uniqueResult();
				transaction.commit();
				return user;
			}
			else {
				transaction.commit();
				return null;
			}
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user " + username, e);
		}
	}
	
	
	public ConversationWrapper getConversationWrapper(long userId, Integer jobPostId) throws UserException {
		try {
			Transaction transaction = null;
			Session s = getSession();
			 transaction = s.beginTransaction();
			 
			 Query query = s.createSQLQuery(
					 "select c.fromId, c.toId,c.message,j.title,j.userId, j.userName from Conversation c join JobPost j on c.jobPostId=j.jobId where "
					 + " c.jobPostId =:jobPostId and "
					 + " (c.fromId =:userId or "
					 + " c.toId = :userId)")
					 .setParameter("userId", userId)
					 .setParameter("jobPostId", jobPostId);
					 List<Object[]> result = query.list();
					 
					 ConversationWrapper cw = new ConversationWrapper();
					 
			if(result !=null && result.size()>0) {
				for(Object[] row: result) {
					cw.getMessageList().add(new Conversation(Integer.parseInt(row[0].toString()),
							Integer.parseInt(row[1].toString()),
							jobPostId,
							row[2].toString().toString(),
							null));
					
				}
				transaction.commit();
			}
			else {
				transaction.commit();
			}
			return cw;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get job post " + jobPostId, e);
		}
	}
	
	
	public SubjectUIWrapper getSubjectWrapperForTeacher(long userId) throws UserException {
		try {
			Transaction transaction = null;
			Session s = getSession();
			 transaction = s.beginTransaction();
			 
			 Query query = s.createSQLQuery(
					 "select s.id, s.name, sb.level  from subject s join subjectdetail sb on s.id=sb.subjectId"
					 + " where userid = :userId ")
					 .setParameter("userId", userId);
					 List<Object[]> result = query.list();
					 
					 SubjectUIWrapper sbw = new SubjectUIWrapper();
					 sbw.setUserId(userId);
			if(result !=null && result.size()>0) {
				for(Object[] row: result) {
					sbw.getSubjectList().add(new SubjectDetailWrapper(row[1].toString(), 
						Integer.parseInt(row[0].toString()),
							row[2].toString()));
				}
				transaction.commit();
			}
			else {
				transaction.commit();
			}
			return sbw;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user " + userId, e);
		}
	}
	
	public JobPost addJobPost(JobPost u)
			throws UserException {
		try {
			Session session = getSession();
			Transaction t = session.beginTransaction();
			System.out.println("inside addJobPost DAO");
			u.setCreatedAt(Utility.getCurrentDateTime());
			session.saveOrUpdate(u);
			t.commit();
			return u;

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while posting the job: "+ u+"   ::::" + e.getMessage() );
		}
	}
	

	public EducationDetail registerEducationDetails(EducationDetail u)
			throws UserException {
		try {
			Session s = getSession();
			Transaction t = s.beginTransaction();
			System.out.println("inside DAO");
			s.saveOrUpdate(u);
			t.commit();
			return u;

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating EducationDetail: "+ u+"   ::::" + e.getMessage() );
		}
	}
	
	
	public User1 registerUser(User1 u)
			throws UserException {
		try {
			Session s = getSession();
			Transaction t = s.beginTransaction();
			System.out.println("inside DAO");
			u.setCreatedAt(Utility.getCurrentDateTime());
			s.saveOrUpdate(u);
			t.commit();
			return u;

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating user: "+ u+"   ::::" + e.getMessage() );
		}
	}
	
	public Conversation addMessage(Conversation u)
			throws UserException {
		try {
			Session s = getSession();
			Transaction t = s.beginTransaction();
			System.out.println("inside DAO");
			u.setCreatedAt(Utility.getCurrentDateTime());
			s.saveOrUpdate(u);
			t.commit();
			return u;

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating user: "+ u+"   ::::" + e.getMessage() );
		}
	}
	

	public User1 registerBasicDetails(User1 u)
			throws UserException {
		try {
			Session s =getSession();
			
			Transaction t = getSession().beginTransaction();
			System.out.println("inside DAO");
			//u.setUpdatedAt(Utility.getCurrentDateTime());
			//u.setProfileCompletion(1);
			
			String qryString = "update com.me.JobPortal.pojo.User1 u set u.userType=:userType,"
					+ "u.gender = :gender,u.speciality = :speciality, u.dob =:dob, u.description =:description,"
					+ " u.updatedAt = :updatedOn, u.profileCompletion =:profileCompletion where u.userId=:userId";
	        Query query3 = getSession().createQuery(qryString);
	        query3.setParameter("userType", u.getUserType());
	        query3.setParameter("gender", u.getGender());
	        query3.setParameter("dob", u.getDob());
	        query3.setParameter("speciality", u.getSpeciality());
	        query3.setParameter("description", u.getDescription());
	        query3.setParameter("updatedOn", Utility.getCurrentDateTime());
	        query3.setParameter("userId", u.getUserId());
	        query3.setParameter("profileCompletion", new Integer(1));
	        int count = query3.executeUpdate();
	        query3 = s.createQuery("from com.me.JobPortal.pojo.User1 where userId = :userId");
	        query3.setParameter("userId", u.getUserId());
	        u =  (User1) query3.uniqueResult();
			t.commit();
			return u;

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating user: "+ u+"   ::::" + e.getMessage() );
		}
	}
	
	
	public User1 registerStudentBasicDetails(User1 u)
			throws UserException {
		try {
			Session s =getSession();
			
			Transaction t = getSession().beginTransaction();
			System.out.println("inside DAO");
			//u.setUpdatedAt(Utility.getCurrentDateTime());
			//u.setProfileCompletion(1);
			
			String qryString = "update com.me.JobPortal.pojo.User1 u set u.userType=:userType,"
					+ "u.gender = :gender,u.speciality = :speciality, u.dob =:dob, u.description =:description,"
					+ " u.updatedAt = :updatedOn, u.profileCompletion =:profileCompletion where u.userId=:userId";
	        Query query3 = getSession().createQuery(qryString);
	        query3.setParameter("userType", u.getUserType());
	        query3.setParameter("gender", u.getGender());
	        query3.setParameter("dob", u.getDob());
	        query3.setParameter("speciality", u.getSpeciality());
	        query3.setParameter("description", u.getDescription());
	        query3.setParameter("updatedOn", Utility.getCurrentDateTime());
	        query3.setParameter("userId", u.getUserId());
	        query3.setParameter("profileCompletion", new Integer(1));
	        int count = query3.executeUpdate();
	        query3 = s.createQuery("from com.me.JobPortal.pojo.User1 where userId = :userId");
	        query3.setParameter("userId", u.getUserId());
	        u =  (User1) query3.uniqueResult();
			t.commit();
			return u;

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating user: "+ u+"   ::::" + e.getMessage() );
		}
	}
	
	public User1 registerSubjectSkillsDetails(SubjectDetail sb, User1 u)
			throws UserException {
		try {
			Session s= getSession();
			Transaction t = s.beginTransaction();
			System.out.println("inside DAO");
			
			u.setUpdatedAt(Utility.getCurrentDateTime());
			u.setProfileCompletion(2);
			s.saveOrUpdate(sb);
			s.saveOrUpdate(u);
			t.commit();
			return u;

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating user: "+ u+"   ::::" + e.getMessage() );
		}
	}
	
	public User1 registerEducationCertificationDetails(User1 u)
			throws UserException {
		try {
			Transaction t = getSession().beginTransaction();
			System.out.println("inside DAO");
			u.setUpdatedAt(Utility.getCurrentDateTime());
			u.setProfileCompletion(3);
			getSession().saveOrUpdate(u);
			t.commit();
			return u;

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating user: "+ u+"   ::::" + e.getMessage() );
		}
	}
	
	public User1 registerTeachingDetails(User1 u)
			throws UserException {
		try {
			

			Session s =getSession();
			
			Transaction t = getSession().beginTransaction();
			System.out.println("inside DAO");
			//u.setUpdatedAt(Utility.getCurrentDateTime());
			//u.setProfileCompletion(1);
			
			String qryString = "update com.me.JobPortal.pojo.User1 u set u.frequency=:frequency,"
					+ " u.minimumFee = :minimumFee,u.maximumFee = :maximumFee, u.feeDescription =:feeDescription, u.totalExp =:totalExp,"
					+" u.teachingExp =:teachingExp, u.onlineTeachingExp =:onlineTeachingExp, u.travel =:travel ,"
					+ " u.onlineTeaching = :onlineTeaching , u.digitalPen = :digitalPen , u.homeworkHelp =:homeworkHelp , "
					+ " u.employed = :employed, u.oppertunities =:oppertunities,  "
					+ " u.updatedAt = :updatedOn, u.profileCompletion =:profileCompletion where u.userId=:userId";
	        Query query3 = getSession().createQuery(qryString);
	        query3.setParameter("frequency", u.getFrequency());
	        query3.setParameter("minimumFee", u.getMinimumFee());
	        query3.setParameter("maximumFee", u.getMaximumFee()); 
	        query3.setParameter("feeDescription", u.getFeeDescription());
	        query3.setParameter("totalExp", u.getTotalExp());
	        
	        query3.setParameter("teachingExp", u.getTeachingExp());
	        query3.setParameter("onlineTeachingExp", u.getOnlineTeachingExp());
	        query3.setParameter("travel", u.isTravel());
	        query3.setParameter("onlineTeaching", u.isOnlineTeaching());
	        query3.setParameter("digitalPen", u.isDigitalPen());
	        
	        
	        query3.setParameter("homeworkHelp", u.isHomeworkHelp());
	        query3.setParameter("employed", u.isEmployed());
	        query3.setParameter("oppertunities", u.getOppertunities());
	        
	        query3.setParameter("updatedOn", Utility.getCurrentDateTime());
	        query3.setParameter("userId", u.getUserId());
	        query3.setParameter("profileCompletion", new Integer(4));
	        int count = query3.executeUpdate();
	        
	        query3 = s.createQuery("from com.me.JobPortal.pojo.User1 where userId = :userId");
	        query3.setParameter("userId", u.getUserId());
	        u =  (User1) query3.uniqueResult();
			t.commit();
			return u;

			
			
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating user: "+ u+"   ::::" + e.getMessage() );
		}
	}
	
	
}