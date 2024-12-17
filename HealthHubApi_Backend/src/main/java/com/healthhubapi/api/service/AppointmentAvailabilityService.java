
package com.healthhubapi.api.service;

import com.healthhubapi.api.entity.AppointmentAvailabilityEntity;
import com.healthhubapi.api.model.AppointmentAvailabilityIdRequest;
import com.healthhubapi.api.model.AppointmentAvailabilityRequestBody; 
import com.healthhubapi.api.repositories.AppointmentAvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

@Service
public class AppointmentAvailabilityService  {

	@Autowired
	private AppointmentAvailabilityRepository AppointmentAvailabilityRepository;

	

	public AppointmentAvailabilityEntity createAppointmentAvailability(AppointmentAvailabilityRequestBody AppointmentAvailabilityRequestBodyObj) {

		AppointmentAvailabilityEntity newAppointmentAvailability = new AppointmentAvailabilityEntity();
		newAppointmentAvailability.setAvailabilityId(AppointmentAvailabilityRequestBodyObj.getAvailabilityId());
		newAppointmentAvailability.setProviderId(AppointmentAvailabilityRequestBodyObj.getProviderId());
		newAppointmentAvailability.setAvailableDate(AppointmentAvailabilityRequestBodyObj.getAvailableDate());
		newAppointmentAvailability.setStartTime(AppointmentAvailabilityRequestBodyObj.getStartTime());
		newAppointmentAvailability.setEndTime(AppointmentAvailabilityRequestBodyObj.getEndTime());
		newAppointmentAvailability.setIsBooked(AppointmentAvailabilityRequestBodyObj.getIsBooked());
		return AppointmentAvailabilityRepository.save(newAppointmentAvailability);		 
	}

	public AppointmentAvailabilityEntity updateAppointmentAvailability(AppointmentAvailabilityRequestBody AppointmentAvailabilityRequestBodyObj) {
		AppointmentAvailabilityEntity newAppointmentAvailability = new AppointmentAvailabilityEntity();
		newAppointmentAvailability.setAvailabilityId(AppointmentAvailabilityRequestBodyObj.getAvailabilityId());
		newAppointmentAvailability.setProviderId(AppointmentAvailabilityRequestBodyObj.getProviderId());
		newAppointmentAvailability.setAvailableDate(AppointmentAvailabilityRequestBodyObj.getAvailableDate());
		newAppointmentAvailability.setStartTime(AppointmentAvailabilityRequestBodyObj.getStartTime());
		newAppointmentAvailability.setEndTime(AppointmentAvailabilityRequestBodyObj.getEndTime());
		newAppointmentAvailability.setIsBooked(AppointmentAvailabilityRequestBodyObj.getIsBooked());
		return AppointmentAvailabilityRepository.save(newAppointmentAvailability);		 
	}

	public Page<AppointmentAvailabilityEntity> listallusersfromdb(int pageNumber, int size) {
		Pageable pageable = PageRequest.of(pageNumber, size);
		return AppointmentAvailabilityRepository.listallusersfromdb(pageable);
	}
 
	public String deleteAppointmentAvailability(AppointmentAvailabilityIdRequest user) {
		int AppointmentAvailabilityId= user.getAvailabilityId();
		AppointmentAvailabilityRepository.deleteById(AppointmentAvailabilityId);
		return "AppointmentAvailability Deleted";
	}

	public String countNumberOfAppointmentAvailabilitys() {

		return AppointmentAvailabilityRepository.countNumberOfAppointmentAvailabilitys();
	}

}
