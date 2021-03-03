package com.me.JobPortal.DAO;

import org.hibernate.HibernateException;

import com.me.JobPortal.exception.UserException;
import com.me.JobPortal.pojo.SubjectDetail;


public class SubjectDetailDAO extends DAO {

	public SubjectDetailDAO() {
	}

	public SubjectDetail registerBasicDetails(SubjectDetail u)
			throws UserException {
		try {
			begin();
			System.out.println("inside DAO");
			getSession().saveOrUpdate(u);
			commit();
			return u;

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating user: "+ u+"   ::::" + e.getMessage() );
		}
	}
	


}