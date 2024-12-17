//HealthcareProvidersController class takes requests from the client (like from a browser or another app) and then uses the 
//HealthcareProvidersService to process these requests, which may involve making changes in the database through HealthcareProvidersRepository.

package com.healthhubapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.healthhubapi.api.model.HealthcareProvidersRequestBody;
import com.healthhubapi.api.model.HealthcareProvidersIdRequest;
import com.healthhubapi.api.service.HealthcareProvidersService;
  
@RestController
@CrossOrigin
public class HealthcareProvidersController {
	
	@Autowired
	private HealthcareProvidersService HealthcareProvidersService;	
	
	@RequestMapping(value = "/createHealthcareProviders", method = RequestMethod.POST)
	public ResponseEntity<?> createHealthcareProviders(@RequestBody HealthcareProvidersRequestBody HealthcareProvidersReqBody) throws Exception {
		return ResponseEntity.ok(HealthcareProvidersService.createHealthcareProviders(HealthcareProvidersReqBody));
	}
	
	@RequestMapping(value = "/updateHealthcareProviders", method = RequestMethod.PUT)
	public ResponseEntity<?> updateHealthcareProviders(@RequestBody HealthcareProvidersRequestBody HealthcareProvidersReqBody) throws Exception {
		return ResponseEntity.ok(HealthcareProvidersService.updateHealthcareProviders(HealthcareProvidersReqBody));
	}		
	
	@RequestMapping(value = "/listAllHealthcareProviderss", method = RequestMethod.GET)
	public ResponseEntity<?> listAllHealthcareProviderss(@RequestParam(defaultValue = "0") final Integer pageNumber,
			@RequestParam(defaultValue = "10") final Integer size) throws Exception {
		return ResponseEntity.ok(HealthcareProvidersService.listallusersfromdb(pageNumber, size));
	}		
	
	@RequestMapping(value = "/deleteHealthcareProviders", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteHealthcareProviders(@RequestBody HealthcareProvidersIdRequest user) throws Exception {
		return ResponseEntity.ok(HealthcareProvidersService.deleteHealthcareProviders(user));
	}		
	
	@RequestMapping(value = "/HealthcareProvidersscount", method = RequestMethod.GET)
	public ResponseEntity<?> countNumberOfHealthcareProviderss() throws Exception {
		return ResponseEntity.ok((HealthcareProvidersService.countNumberOfHealthcareProviderss()));
	}
	
}
