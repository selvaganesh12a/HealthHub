package com.healthhubapi.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.healthhubapi.api.model.PractitionerRequestBody;
import com.healthhubapi.api.model.PractitionerIdRequest;
import com.healthhubapi.api.service.PractitionerService;
  
@RestController
@CrossOrigin("*")
public class PractitionerController {
	
	@Autowired
	private PractitionerService PractitionerService;	
	
	//http://localhost:8181/healthhubapi/getPractitionerById/1
	@RequestMapping(value = "/getPractitionerById/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List> getPractitionerById(@PathVariable int id)  throws Exception  {
		List item = null;
		try {			 
		 	item = PractitionerService.getPractitionerById(id);		 
		} catch (Exception e) {
			System.out.println("Unable to get values");
		     }
		//return ResponseEntity.status(HttpStatus.OK).body(((String) item).getBytes("UTF-8"));		
		return ResponseEntity.ok(PractitionerService.getPractitionerById(id));
		}
		
	@RequestMapping(value = "/createPractitioner", method = RequestMethod.POST)
	public ResponseEntity<?> createPractitioner(@RequestBody PractitionerRequestBody PractitionerReqBody) throws Exception {
		return ResponseEntity.ok(PractitionerService.createPractitioner(PractitionerReqBody));
	}
	
	@RequestMapping(value = "/updatePractitioner", method = RequestMethod.PUT)
	public ResponseEntity<?> updatePractitioner(@RequestBody PractitionerRequestBody PractitionerReqBody) throws Exception {
		return ResponseEntity.ok(PractitionerService.updatePractitioner(PractitionerReqBody));
	}		
	
	@RequestMapping(value = "/listAllPractitioners", method = RequestMethod.GET)
	public ResponseEntity<?> listAllPractitioners(@RequestParam(defaultValue = "0") final Integer pageNumber,
			@RequestParam(defaultValue = "10") final Integer size) throws Exception {
		return ResponseEntity.ok(PractitionerService.listallusersfromdb(pageNumber, size));
	}		
	
	@RequestMapping(value = "/deletePractitioner/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletePractitioner(@PathVariable int id) throws Exception {
		return ResponseEntity.ok(PractitionerService.deletePractitioner(id));
	}		
	
	@RequestMapping(value = "/Practitionerscount", method = RequestMethod.GET)
	public ResponseEntity<?> countNumberOfPractitioners() throws Exception {
		return ResponseEntity.ok((PractitionerService.countNumberOfPractitioners()));
	}
	
	@RequestMapping(value = "/getAllPractitioners", method = RequestMethod.GET)
	public ResponseEntity<?> getAllPractitioners( ) throws Exception {
		return ResponseEntity.ok(PractitionerService.getAllPractitioners( ));
	}
	
}
