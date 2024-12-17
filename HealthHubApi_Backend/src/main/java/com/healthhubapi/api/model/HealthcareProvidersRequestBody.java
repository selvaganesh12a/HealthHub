package com.healthhubapi.api.model;

public class HealthcareProvidersRequestBody {
 	
	private int ProviderId;
	private int userId;
	private String specialty;
	private int experienceYears;
	private String clinicName;
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
