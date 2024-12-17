package com.healthhubapi.api.entity;

import javax.persistence.*;

@Entity
@Table(name = "antra_healthcareProviders")
public class HealthcareProvidersEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "provider_id", nullable = false)
	private int ProviderId;

	@Column(name = "user_id", nullable = false)
	private int userId;
	
	@Column(name = "specialty", nullable = false)
	private String specialty;
	
	@Column(name = "experience_years", nullable = false)
	private int experienceYears;
	
	@Column(name = "clinic_name", nullable = false)
	private String clinicName;
 
	@Column(name = "clinic_address", nullable = false)
	private String clinicAddress;

	public String getClinicAddress() {
		return clinicAddress;
	}

	public void setClinicAddress(String clinicAddress) {
		this.clinicAddress = clinicAddress;
	}

	public int getProviderId() {
		return ProviderId;
	}

	public void setProviderId(int ProviderId) {
		this.ProviderId = ProviderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public int getExperienceYears() {
		return experienceYears;
	}

	public void setExperienceYears(int experienceYears) {
		this.experienceYears = experienceYears;
	}
	
	public String getClinicName() {
		return clinicName;
	}

	public void setClinicName(String clinicName) {
		this.clinicName = clinicName;
	}

}
