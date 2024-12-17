//AppointmentsService class is responsible for creating, updating, listing, deleting, and counting Appointmentss. 
//It’s the central place for handling business logic before interacting with the database. creation of database is done here

package com.healthhubapi.api.service;

import com.healthhubapi.api.entity.AppointmentsEntity;
import com.healthhubapi.api.model.AppointmentsIdRequest;
import com.healthhubapi.api.model.AppointmentsRequestBody; 
import com.healthhubapi.api.repositories.AppointmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

@Service
public class AppointmentsService  {

	@Autowired
	private AppointmentsRepository AppointmentsRepository;

	

	public AppointmentsEntity createAppointments(AppointmentsRequestBody AppointmentsRequestBodyObj) {

		AppointmentsEntity newAppointments = new AppointmentsEntity();
		newAppointments.setAppointmentId(AppointmentsRequestBodyObj.getAppointmentId());
		newAppointments.setPatientId(AppointmentsRequestBodyObj.getPatientId());
		newAppointments.setDoctorId(AppointmentsRequestBodyObj.getDoctorId());
		newAppointments.setAppointmentDate(AppointmentsRequestBodyObj.getAppointmentDate());
		newAppointments.setAppointmentTime(AppointmentsRequestBodyObj.getAppointmentTime());
		newAppointments.setStatus(AppointmentsRequestBodyObj.getStatus());
		newAppointments.setReasonForVisit(AppointmentsRequestBodyObj.getReasonForVisit());
		newAppointments.setCreatedAt(AppointmentsRequestBodyObj.getCreatedAt());	
		return AppointmentsRepository.save(newAppointments);		 
	} 

	public AppointmentsEntity updateAppointments(AppointmentsRequestBody AppointmentsRequestBodyObj) {
		AppointmentsEntity newAppointments = new AppointmentsEntity();
		newAppointments.setAppointmentId(AppointmentsRequestBodyObj.getAppointmentId());
		newAppointments.setPatientId(AppointmentsRequestBodyObj.getPatientId());
		newAppointments.setDoctorId(AppointmentsRequestBodyObj.getDoctorId());
		newAppointments.setAppointmentDate(AppointmentsRequestBodyObj.getAppointmentDate());
		newAppointments.setAppointmentTime(AppointmentsRequestBodyObj.getAppointmentTime());
		newAppointments.setStatus(AppointmentsRequestBodyObj.getStatus());
		newAppointments.setReasonForVisit(AppointmentsRequestBodyObj.getReasonForVisit());
		newAppointments.setCreatedAt(AppointmentsRequestBodyObj.getCreatedAt());	
		return AppointmentsRepository.save(newAppointments);		 
	}

	public Page<AppointmentsEntity> listallusersfromdb(int pageNumber, int size) {
		Pageable pageable = PageRequest.of(pageNumber, size);
		return AppointmentsRepository.listallusersfromdb(pageable);
	}
 
	public String deleteAppointments(int id) {
		AppointmentsRepository.deleteById(id);
		return "Appointments Deleted";
	}

	public String countNumberOfAppointmentss() {

		return AppointmentsRepository.countNumberOfAppointmentss();
	}

}
