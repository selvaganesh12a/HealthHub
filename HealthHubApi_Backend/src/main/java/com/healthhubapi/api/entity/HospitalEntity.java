package com.healthhubapi.api.entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "antra_hospital")

public class HospitalEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hospital_id", nullable = false)
	private int hospitalId;
	@Column(name = "hospital_name", nullable = false)
	private String hospitalName;
	@Column(name = "hospital_address", nullable = false)
	private String hospitalAddress;
	@Column(name = "hospital_contact", nullable = false)
	private String hospitalContact;
	
	public int getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}
	
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	
	public String getHospitalAddress() {
		return hospitalAddress;
	}
	public void setHospitalAddress(String hospitalAddress) {
		this.hospitalAddress = hospitalAddress;
	}
	
	public String getHospitalContact() {
		return hospitalContact;
	}
	public void setHospitalContact(String hospitalContact) {
		this.hospitalContact = hospitalContact;
	}
	
	
	
	
}
