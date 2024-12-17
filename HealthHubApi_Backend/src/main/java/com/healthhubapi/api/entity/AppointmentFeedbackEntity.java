package com.healthhubapi.api.entity;

import javax.persistence.*;

@Entity
@Table(name = "antra_appointmentFeedback")
public class AppointmentFeedbackEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "appointment_id", nullable = false)
	private int appointmentId;

	@Column(name = "feedback_id", nullable = false)
	private int feedbackId;
	
	@Column(name = "rating", nullable = false)
	private int rating;
	
	@Column(name = "comments", nullable = false)
	private String comments;
	
	@Column(name = "created_at", nullable = false)
	private String createdAt;

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

}
