package com.healthhubapi.api.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.healthhubapi.api.entity.PractitionerEntity;
import com.healthhubapi.api.model.PractitionerIdRequest;
import com.healthhubapi.api.model.PractitionerPojo;
import com.healthhubapi.api.model.PractitionerRequestBody; 
import com.healthhubapi.api.repositories.PractitionerRepository;

import java.io.StringWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 

@Service
public class PractitionerService  {

	@Autowired
	private PractitionerRepository PractitionerRepository;

	

	public PractitionerEntity createPractitioner(PractitionerRequestBody practitionerRequestBodyObj) {

		PractitionerEntity newPractitioner = new PractitionerEntity();
		newPractitioner.setFirstName(practitionerRequestBodyObj.getFirstName());
		newPractitioner.setLastName(practitionerRequestBodyObj.getLastName());
		newPractitioner.setPhoneNumber(practitionerRequestBodyObj.getPhoneNumber());
		newPractitioner.setEmailId(practitionerRequestBodyObj.getEmailId());
		newPractitioner.setSpecialty(practitionerRequestBodyObj.getSpecialty());
		newPractitioner.setYearsOfExperience(practitionerRequestBodyObj.getYearsOfExperience());
		newPractitioner.setHospitalId(practitionerRequestBodyObj.getHospitalId());
		return PractitionerRepository.save(newPractitioner);		 
	}

	public PractitionerEntity updatePractitioner(PractitionerRequestBody practitionerRequestBodyObj) {
		PractitionerEntity newPractitioner = new PractitionerEntity();
		newPractitioner.setDoctorId(practitionerRequestBodyObj.getDoctorId() );
		newPractitioner.setFirstName(practitionerRequestBodyObj.getFirstName());
		newPractitioner.setLastName(practitionerRequestBodyObj.getLastName());
		newPractitioner.setPhoneNumber(practitionerRequestBodyObj.getPhoneNumber());
		newPractitioner.setEmailId(practitionerRequestBodyObj.getEmailId());
		newPractitioner.setSpecialty(practitionerRequestBodyObj.getSpecialty());
		newPractitioner.setYearsOfExperience(practitionerRequestBodyObj.getYearsOfExperience());
		newPractitioner.setHospitalId(practitionerRequestBodyObj.getHospitalId());
		return PractitionerRepository.save(newPractitioner);		 
	}

	public Page<PractitionerEntity> listallusersfromdb(int pageNumber, int size) {
		Pageable pageable = PageRequest.of(pageNumber, size);
		return PractitionerRepository.listallusersfromdb(pageable);
	}
 
	public String deletePractitioner( int id) {
		 
		PractitionerRepository.deleteById(id);
		return "Practitioner Deleted";
	}

	public String countNumberOfPractitioners() {
		
		return PractitionerRepository.countNumberOfPractitioners();
	}

	 
 
	public List getPractitionerById(int id) throws Exception {
		StringWriter sw = new StringWriter();
		ObjectMapper mapper = new ObjectMapper();
		List list = PractitionerRepository.findPractitionerEntityBydoctorId(id); 
	//List list = PractitionerRepository.getPractitionerById(id); 
		PractitionerPojo practitionerPojo = new PractitionerPojo();
		practitionerPojo.setPractitionerList(list);
		practitionerPojo.setTotalRecords(1);
		mapper.writeValue(sw, practitionerPojo);
		return PractitionerRepository.findPractitionerEntityBydoctorId(id);		
	}

	public List getAllPractitioners() {
		// TODO Auto-generated method stub
		return PractitionerRepository.getAllPractitioners( );
	} 
}
