package com.healthhubapi.api.service;

import com.healthhubapi.api.entity.PatientEntity;
import com.healthhubapi.api.model.PatientIdRequest;
import com.healthhubapi.api.model.PatientRequestBody; 
import com.healthhubapi.api.repositories.PatientRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

@Service
public class PatientService  {

	@Autowired
	private PatientRepository PatientRepository;


	public PatientEntity createPatient(PatientRequestBody PatientRequestBodyObj) {

		PatientEntity newPatient = new PatientEntity();
		newPatient.setFirstName(PatientRequestBodyObj.getFirstName());
		newPatient.setFirstName(PatientRequestBodyObj.getLastName());
		newPatient.setPhoneNumber(PatientRequestBodyObj.getPhoneNumber());
		newPatient.setPatientId(PatientRequestBodyObj.getPatientId());
		newPatient.setDateOfBirth(PatientRequestBodyObj.getDateOfBirth());
		newPatient.setGender(PatientRequestBodyObj.getGender());
		newPatient.setAddress(PatientRequestBodyObj.getAddress());
		newPatient.setEmail(PatientRequestBodyObj.getEmail());
		return PatientRepository.save(newPatient);		 
	}

	public PatientEntity updatePatient(PatientRequestBody PatientRequestBodyObj) {
		PatientEntity newPatient = new PatientEntity();
		newPatient.setPatientId(PatientRequestBodyObj.getPatientId() ); 
		newPatient.setFirstName(PatientRequestBodyObj.getFirstName());
		newPatient.setFirstName(PatientRequestBodyObj.getLastName());
		newPatient.setPhoneNumber(PatientRequestBodyObj.getPhoneNumber());
		newPatient.setDateOfBirth(PatientRequestBodyObj.getDateOfBirth());
		newPatient.setGender(PatientRequestBodyObj.getGender());
		newPatient.setAddress(PatientRequestBodyObj.getAddress());
		newPatient.setEmail(PatientRequestBodyObj.getEmail());
		
		return PatientRepository.save(newPatient);		 
	}

	public Page<PatientEntity> listallusersfromdb(int pageNumber, int size) {
		Pageable pageable = PageRequest.of(pageNumber, size);
		return PatientRepository.listallusersfromdb(pageable);
	}
 
	public String deletePatient(int id) {
 
		PatientRepository.deleteById(id);
		return "Patient Deleted";
	}

	public String countNumberOfPatients() {

		return PatientRepository.countNumberOfPatients();
	}

	public List getPatientById(int id) {
		// TODO Auto-generated method stub
		return PatientRepository.findPatientEntityBypatientId(id);	
	}

	public List  getAllPatients() {
		// TODO Auto-generated method stub
		return PatientRepository.getAllPractitioners( );
	}

}
