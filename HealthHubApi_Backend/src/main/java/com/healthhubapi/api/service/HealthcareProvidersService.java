
package com.healthhubapi.api.service;

import com.healthhubapi.api.entity.HealthcareProvidersEntity;
import com.healthhubapi.api.model.HealthcareProvidersIdRequest;
import com.healthhubapi.api.model.HealthcareProvidersRequestBody; 
import com.healthhubapi.api.repositories.HealthcareProvidersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

@Service
public class HealthcareProvidersService  {

	@Autowired
	private HealthcareProvidersRepository HealthcareProvidersRepository;

	

	public HealthcareProvidersEntity createHealthcareProviders(HealthcareProvidersRequestBody HealthcareProvidersRequestBodyObj) {

		HealthcareProvidersEntity newHealthcareProviders = new HealthcareProvidersEntity();
		newHealthcareProviders.setProviderId(HealthcareProvidersRequestBodyObj.getProviderId());
		newHealthcareProviders.setClinicAddress(HealthcareProvidersRequestBodyObj.getClinicAddress());
		newHealthcareProviders.setExperienceYears(HealthcareProvidersRequestBodyObj.getExperienceYears());
		newHealthcareProviders.setClinicName(HealthcareProvidersRequestBodyObj.getClinicName());
		newHealthcareProviders.setSpecialty(HealthcareProvidersRequestBodyObj.getSpecialty());
		newHealthcareProviders.setClinicAddress(HealthcareProvidersRequestBodyObj.getClinicAddress());
		return HealthcareProvidersRepository.save(newHealthcareProviders);		 
	}

	public HealthcareProvidersEntity updateHealthcareProviders(HealthcareProvidersRequestBody HealthcareProvidersRequestBodyObj) {
		HealthcareProvidersEntity newHealthcareProviders = new HealthcareProvidersEntity();
		newHealthcareProviders.setProviderId(HealthcareProvidersRequestBodyObj.getProviderId());
		newHealthcareProviders.setClinicAddress(HealthcareProvidersRequestBodyObj.getClinicAddress());
		newHealthcareProviders.setExperienceYears(HealthcareProvidersRequestBodyObj.getExperienceYears());
		newHealthcareProviders.setClinicName(HealthcareProvidersRequestBodyObj.getClinicName());
		newHealthcareProviders.setSpecialty(HealthcareProvidersRequestBodyObj.getSpecialty());
		newHealthcareProviders.setClinicAddress(HealthcareProvidersRequestBodyObj.getClinicAddress());
		return HealthcareProvidersRepository.save(newHealthcareProviders);		 
	}

	public Page<HealthcareProvidersEntity> listallusersfromdb(int pageNumber, int size) {
		Pageable pageable = PageRequest.of(pageNumber, size);
		return HealthcareProvidersRepository.listallusersfromdb(pageable);
	}
 
	public String deleteHealthcareProviders(HealthcareProvidersIdRequest user) {
		int HealthcareProvidersId= user.getProviderId();
		HealthcareProvidersRepository.deleteById(HealthcareProvidersId);
		return "HealthcareProviders Deleted";
	}

	public String countNumberOfHealthcareProviderss() {

		return HealthcareProvidersRepository.countNumberOfHealthcareProviderss();
	}

}
