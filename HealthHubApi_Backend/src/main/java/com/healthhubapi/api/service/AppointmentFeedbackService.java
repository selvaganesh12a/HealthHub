
package com.healthhubapi.api.service;

import com.healthhubapi.api.entity.AppointmentFeedbackEntity;
import com.healthhubapi.api.model.AppointmentFeedbackIdRequest;
import com.healthhubapi.api.model.AppointmentFeedbackRequestBody; 
import com.healthhubapi.api.repositories.AppointmentFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

@Service
public class AppointmentFeedbackService  {

	@Autowired
	private AppointmentFeedbackRepository AppointmentFeedbackRepository;

	

	public AppointmentFeedbackEntity createAppointmentFeedback(AppointmentFeedbackRequestBody AppointmentFeedbackRequestBodyObj) {

		AppointmentFeedbackEntity newAppointmentFeedback = new AppointmentFeedbackEntity();
		newAppointmentFeedback.setAppointmentId(AppointmentFeedbackRequestBodyObj.getAppointmentId());
		newAppointmentFeedback.setFeedbackId(AppointmentFeedbackRequestBodyObj.getFeedbackId());
		newAppointmentFeedback.setRating(AppointmentFeedbackRequestBodyObj.getRating());
		newAppointmentFeedback.setComments(AppointmentFeedbackRequestBodyObj.getComments());
		newAppointmentFeedback.setCreatedAt(AppointmentFeedbackRequestBodyObj.getCreatedAt());
		return AppointmentFeedbackRepository.save(newAppointmentFeedback);		 
	}

	public AppointmentFeedbackEntity updateAppointmentFeedback(AppointmentFeedbackRequestBody AppointmentFeedbackRequestBodyObj) {
		AppointmentFeedbackEntity newAppointmentFeedback = new AppointmentFeedbackEntity();
		newAppointmentFeedback.setAppointmentId(AppointmentFeedbackRequestBodyObj.getAppointmentId());
		newAppointmentFeedback.setFeedbackId(AppointmentFeedbackRequestBodyObj.getFeedbackId());
		newAppointmentFeedback.setRating(AppointmentFeedbackRequestBodyObj.getRating());
		newAppointmentFeedback.setComments(AppointmentFeedbackRequestBodyObj.getComments());
		newAppointmentFeedback.setCreatedAt(AppointmentFeedbackRequestBodyObj.getCreatedAt());
		return AppointmentFeedbackRepository.save(newAppointmentFeedback);		 
	}

	public Page<AppointmentFeedbackEntity> listallusersfromdb(int pageNumber, int size) {
		Pageable pageable = PageRequest.of(pageNumber, size);
		return AppointmentFeedbackRepository.listallusersfromdb(pageable);
	}
 
	public String deleteAppointmentFeedback(AppointmentFeedbackIdRequest user) {
		int AppointmentFeedbackId= user.getAppointmentId();
		AppointmentFeedbackRepository.deleteById(AppointmentFeedbackId);
		return "AppointmentFeedback Deleted";
	}

	public String countNumberOfAppointmentFeedbacks() {

		return AppointmentFeedbackRepository.countNumberOfAppointmentFeedbacks();
	}

}
