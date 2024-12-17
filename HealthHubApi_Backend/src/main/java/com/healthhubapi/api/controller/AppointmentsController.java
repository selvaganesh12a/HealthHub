//AppointmentsController class takes requests from the client (like from a browser or another app) and then uses the 
//AppointmentsService to process these requests, which may involve making changes in the database through AppointmentsRepository.

package com.healthhubapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.healthhubapi.api.model.AppointmentsRequestBody;
import com.healthhubapi.api.model.AppointmentsIdRequest;
import com.healthhubapi.api.service.AppointmentsService;
  
@RestController
@CrossOrigin
public class AppointmentsController {
	
	@Autowired
	private AppointmentsService AppointmentsService;	
	
	@RequestMapping(value = "/createAppointments", method = RequestMethod.POST)
	public ResponseEntity<?> createAppointments(@RequestBody AppointmentsRequestBody AppointmentsReqBody) throws Exception {
		return ResponseEntity.ok(AppointmentsService.createAppointments(AppointmentsReqBody));
	}
	
	@RequestMapping(value = "/updateAppointments", method = RequestMethod.PUT)
	public ResponseEntity<?> updateAppointments(@RequestBody AppointmentsRequestBody AppointmentsReqBody) throws Exception {
		return ResponseEntity.ok(AppointmentsService.updateAppointments(AppointmentsReqBody));
	}		
	
	@RequestMapping(value = "/listAllAppointmentss", method = RequestMethod.GET)
	public ResponseEntity<?> listAllAppointmentss(@RequestParam(defaultValue = "0") final Integer pageNumber,
			@RequestParam(defaultValue = "10") final Integer size) throws Exception {
		return ResponseEntity.ok(AppointmentsService.listallusersfromdb(pageNumber, size));
	}		
	
	@RequestMapping(value = "/deleteAppointments/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteAppointments(@PathVariable int id) throws Exception {
		return ResponseEntity.ok(AppointmentsService.deleteAppointments(id));
	}		
	
	@RequestMapping(value = "/Appointmentsscount", method = RequestMethod.GET)
	public ResponseEntity<?> countNumberOfAppointmentss() throws Exception {
		return ResponseEntity.ok((AppointmentsService.countNumberOfAppointmentss()));
	}
	
}
