package com.healthhubapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.healthhubapi.api.model.AppointmentAvailabilityRequestBody;
import com.healthhubapi.api.model.AppointmentAvailabilityIdRequest;
import com.healthhubapi.api.service.AppointmentAvailabilityService;
  
@RestController
@CrossOrigin
public class AppointmentAvailabilityController {
	
	@Autowired
	private AppointmentAvailabilityService AppointmentAvailabilityService;	
	
	@RequestMapping(value = "/createAppointmentAvailability", method = RequestMethod.POST)
	public ResponseEntity<?> createAppointmentAvailability(@RequestBody AppointmentAvailabilityRequestBody AppointmentAvailabilityReqBody) throws Exception {
		return ResponseEntity.ok(AppointmentAvailabilityService.createAppointmentAvailability(AppointmentAvailabilityReqBody));
	}
	
	@RequestMapping(value = "/updateAppointmentAvailability", method = RequestMethod.PUT)
	public ResponseEntity<?> updateAppointmentAvailability(@RequestBody AppointmentAvailabilityRequestBody AppointmentAvailabilityReqBody) throws Exception {
		return ResponseEntity.ok(AppointmentAvailabilityService.updateAppointmentAvailability(AppointmentAvailabilityReqBody));
	}		
	
	@RequestMapping(value = "/listAllAppointmentAvailabilitys", method = RequestMethod.GET)
	public ResponseEntity<?> listAllAppointmentAvailabilitys(@RequestParam(defaultValue = "0") final Integer pageNumber,
			@RequestParam(defaultValue = "10") final Integer size) throws Exception {
		return ResponseEntity.ok(AppointmentAvailabilityService.listallusersfromdb(pageNumber, size));
	}		
	
	@RequestMapping(value = "/deleteAppointmentAvailability", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteAppointmentAvailability(@RequestBody AppointmentAvailabilityIdRequest user) throws Exception {
		return ResponseEntity.ok(AppointmentAvailabilityService.deleteAppointmentAvailability(user));
	}		
	
	@RequestMapping(value = "/AppointmentAvailabilityscount", method = RequestMethod.GET)
	public ResponseEntity<?> countNumberOfAppointmentAvailabilitys() throws Exception {
		return ResponseEntity.ok((AppointmentAvailabilityService.countNumberOfAppointmentAvailabilitys()));
	}
	
}
