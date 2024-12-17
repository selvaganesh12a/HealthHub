package com.healthhubapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.healthhubapi.api.model.AppointmentFeedbackRequestBody;
import com.healthhubapi.api.model.AppointmentFeedbackIdRequest;
import com.healthhubapi.api.service.AppointmentFeedbackService;
  
@RestController
@CrossOrigin
public class AppointmentFeedbackController {
	
	@Autowired
	private AppointmentFeedbackService AppointmentFeedbackService;	
	
	@RequestMapping(value = "/createAppointmentFeedback", method = RequestMethod.POST)
	public ResponseEntity<?> createAppointmentFeedback(@RequestBody AppointmentFeedbackRequestBody AppointmentFeedbackReqBody) throws Exception {
		return ResponseEntity.ok(AppointmentFeedbackService.createAppointmentFeedback(AppointmentFeedbackReqBody));
	}
	
	@RequestMapping(value = "/updateAppointmentFeedback", method = RequestMethod.PUT)
	public ResponseEntity<?> updateAppointmentFeedback(@RequestBody AppointmentFeedbackRequestBody AppointmentFeedbackReqBody) throws Exception {
		return ResponseEntity.ok(AppointmentFeedbackService.updateAppointmentFeedback(AppointmentFeedbackReqBody));
	}		
	
	@RequestMapping(value = "/listAllAppointmentFeedbacks", method = RequestMethod.GET)
	public ResponseEntity<?> listAllAppointmentFeedbacks(@RequestParam(defaultValue = "0") final Integer pageNumber,
			@RequestParam(defaultValue = "10") final Integer size) throws Exception {
		return ResponseEntity.ok(AppointmentFeedbackService.listallusersfromdb(pageNumber, size));
	}		
	
	@RequestMapping(value = "/deleteAppointmentFeedback", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteAppointmentFeedback(@RequestBody AppointmentFeedbackIdRequest user) throws Exception {
		return ResponseEntity.ok(AppointmentFeedbackService.deleteAppointmentFeedback(user));
	}		
	
	@RequestMapping(value = "/AppointmentFeedbackscount", method = RequestMethod.GET)
	public ResponseEntity<?> countNumberOfAppointmentFeedbacks() throws Exception {
		return ResponseEntity.ok((AppointmentFeedbackService.countNumberOfAppointmentFeedbacks()));
	}
	
}
