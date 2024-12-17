package com.healthhubapi.api.repositories;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.healthhubapi.api.model.CCPUserDetailsResponse;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

@Repository
public class LoginRepository {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	private SessionFactory sessionFactory;
	final Logger logger = Logger.getLogger(LoginRepository.class);

	public String ValidateUser(String mobileNumber, String prnNumber) throws Exception {
		logger.info("Inside listUniversities");
		Session session = this.sessionFactory.openSession();
		StringWriter sw = new StringWriter();

		try {
			Base64.Decoder decoder = Base64.getDecoder();
			String emailIdAvailable = "false";
			String yesFlag = "Y";
			String userFound = "false";
			String passwordString = "";
			// emailIdAvailable = (checkForUniqueemailId(emailId)) ;

			// if (emailIdAvailable == "false") {
			// passwordString = getUserPassword(emailId);

			// if (passwordString != "" || passwordString !="null" ) {

			// System.out.println("passwordString 2 " + passwordString);
			Query query = session.createQuery(
					"from LoginUserDetails as o where o.mobileNumber= :mobileNumber  and o.prnNumber=:prnNumber and o.isAprroved=:yesFlag");
			query.setString("mobileNumber", mobileNumber);
			query.setString("prnNumber", prnNumber);
			query.setString("yesFlag", yesFlag);

			List list = query.list();

			if ((list != null) && (list.size() > 0)) {
				Session session11 = this.sessionFactory.openSession();
				userFound = "true";
				// System.out.println("userFound true " );
				Query query11 = session11.createQuery("from LoginUserDetails as o where o.mobileNumber=:mobileNumber");
				query11.setString("mobileNumber", mobileNumber);

				List list11 = query11.list();

				// System.out.println("userFound next " );
				ObjectMapper mapper = new ObjectMapper();
				mapper.writeValue(sw, list11);
			} else {
				throw new Exception("This Email /PRN does not match in our records. Please Sign Up");

			}
			// }

		} catch (Exception e) {
			// e.printStackTrace();
			logger.error("Exception in listUniversities " + e.getMessage());
		}

		logger.info("returning listUniversities with DATA " + sw.toString());
		return sw.toString();
	}

	public String getUserPassword(String emailId) throws Exception {
		// System.out.println("getUserPassword -- " + emailId);
		Session session = this.sessionFactory.openSession();
		String userPassword = "";
		try {
			String hql = "SELECT password  FROM LoginUserDetails u WHERE u.emailId=:emailId";

			Query query = session.createQuery(hql);
			query.setString("emailId", emailId);
			List list = query.list();

			if ((list != null) && (list.size() > 0)) {
				userPassword = (String) query.list().get(0);
				// System.out.println(" Password fetched - - "+userPassword);
			} else {
				// System.out.println(" Password fetched - - null ");
				userPassword = "null";
			}

		} catch (Exception e) {
			logger.error("getUserPassword Exception");
			throw e;
		}

		return userPassword;
	}

	public CCPUserDetailsResponse loadCCPUserDetails(String mobileNumber) throws Exception {
		logger.info("Inside loadCCPUserDetails");
		Session session = this.sessionFactory.openSession();
		StringWriter sw = new StringWriter();
		Session session11 = this.sessionFactory.openSession();
		// System.out.println("userFound true " );

		CCPUserDetailsResponse cCPUserDetailsResponseobj = new CCPUserDetailsResponse();
		try {
			Query query11 = session11.createQuery("from LoginUserDetails as o where o.mobileNumber=:mobileNumber");

			query11.setString("mobileNumber", mobileNumber);

			List<CCPUserDetailsResponse> list = (List<CCPUserDetailsResponse>) query11.list();

		} catch (Exception e) {

		}

		logger.info("returning   with DATA " + sw.toString());
		return cCPUserDetailsResponseobj;

	}

}
