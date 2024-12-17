package com.healthhubapi.api.entity;

import javax.persistence.*;

@Entity
@Table(name = "antra_appointmentAvailability")
public class AppointmentAvailabilityEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "availability_id", nullable = false)
	private int availabilityId;

	@Column(name = "provider_id", nullable = false)
	private int providerId;
	
	@Column(name = "available_date", nullable = false)
	private String availableDate;
	
	@Column(name = "start_time", nullable = false)
	private String startTime;
	
	@Column(name = "end_time", nullable = false)
	private String endTime;
	
	@Column(name = "is_booked", nullable = false)
	private boolean isBooked;

	public int getAvailabilityId() {
		return availabilityId;
	}

	public void setAvailabilityId(int availabilityId) {
		this.availabilityId = availabilityId;
	}

	public int getProviderId() {
		return providerId;
	}

	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}

	public String getAvailableDate() {
		return availableDate;
	}

	public void setAvailableDate(String availableDate) {
		this.availableDate = availableDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	public boolean getIsBooked() {
		return isBooked;
	}

	public void setIsBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}

}
