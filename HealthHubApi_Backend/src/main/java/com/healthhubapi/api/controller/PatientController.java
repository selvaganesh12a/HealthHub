//PatientController class takes requests from the client (like from a browser or another app) and then uses the 
//PatientService to process these requests, which may involve making changes in the database through PatientRepository.

package com.healthhubapi.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.healthhubapi.api.model.PatientRequestBody;
import com.healthhubapi.api.model.PatientIdRequest;
import com.healthhubapi.api.service.PatientService;
  
@RestController
@CrossOrigin
public class PatientController {
	
	@Autowired
	private PatientService PatientService;	
	
	@RequestMapping(value = "/createPatient", method = RequestMethod.POST)
	public ResponseEntity<?> createPatient(@RequestBody PatientRequestBody PatientReqBody) throws Exception {
		return ResponseEntity.ok(PatientService.createPatient(PatientReqBody));
	}
	
	@RequestMapping(value = "/updatePatient", method = RequestMethod.PUT)
	public ResponseEntity<?> updatePatient(@RequestBody PatientRequestBody PatientReqBody) throws Exception {
		return ResponseEntity.ok(PatientService.updatePatient(PatientReqBody));
	}		
	
	@RequestMapping(value = "/listAllPatients", method = RequestMethod.GET)
	public ResponseEntity<?> listAllPatients(@RequestParam(defaultValue = "0") final Integer pageNumber,
			@RequestParam(defaultValue = "10") final Integer size) throws Exception {
		return ResponseEntity.ok(PatientService.listallusersfromdb(pageNumber, size));
	}		
	
	@RequestMapping(value = "/deletePatient/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletePatient(@PathVariable int id) throws Exception {
		return ResponseEntity.ok(PatientService.deletePatient(id));
	}		
	
	@RequestMapping(value = "/Patientscount", method = RequestMethod.GET)
	public ResponseEntity<?> countNumberOfPatients() throws Exception {
		return ResponseEntity.ok((PatientService.countNumberOfPatients()));
	}
	
	//http://localhost:8181/healthhubapi/getPractitionerById/1
		@RequestMapping(value = "/getPatientById/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
		public ResponseEntity<List> getPatientById(@PathVariable int id)  throws Exception  {
			List item = null;
			try {			 
			 	item = PatientService.getPatientById(id);		 
			} catch (Exception e) {
				System.out.println("Unable to get values");
			     }
			//return ResponseEntity.status(HttpStatus.OK).body(((String) item).getBytes("UTF-8"));		
			return ResponseEntity.ok(PatientService.getPatientById(id));
			}
		@RequestMapping(value = "/getAllPatients", method = RequestMethod.GET)
		public ResponseEntity<?> getAllPatients( ) throws Exception {
			return ResponseEntity.ok(PatientService.getAllPatients( ));
		}
	
}
