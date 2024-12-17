package com.healthhubapi.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthhubapi.api.model.CCPUserDetailsResponse;
import com.healthhubapi.api.repositories.LoginRepository;
 
@Service("CCPUserService")
public class CCPUserService {

	@Autowired
LoginRepository userDAO;
	
	
	@Transactional
	public String ValidateUser(String userName, String password) throws Exception {
		return userDAO.ValidateUser(userName, password);
	}
	  
	
	@Transactional
	public CCPUserDetailsResponse  loadCCPUserDetails(String userName) throws Exception {
 		return userDAO.loadCCPUserDetails(userName);
	}
}
