package com.healthhubapi.api.entity;


import javax.persistence.*;

@Entity
@Table(name = "antra_appointments")
public class AppointmentsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "AppointmentID", nullable = false)
	private int appointmentId;

	@Column(name = "PatientID", nullable = false)
	private int patientId;
	
	@Column(name = "DoctorID", nullable = false)
	private int doctorId;
	
	@Column(name = "AppointmentDate", nullable = false)
	private String appointmentDate;
	
	@Column(name = "AppointmentTime", nullable = false)
	private String appointmentTime;
	
	@Column(name = "Status", nullable = false)
	private String status;
	
	@Column(name = "ReasonForVisit", nullable = false)
	private String reasonForVisit;
	
	@Column(name = "CreatedAt", nullable = false)
	private String createdAt;

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReasonForVisit() {
		return reasonForVisit;
	}

	public void setReasonForVisit(String reasonForVisit) {
		this.reasonForVisit = reasonForVisit;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

}
