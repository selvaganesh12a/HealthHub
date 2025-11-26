package com.healthhub.backend.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "doctors")
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String specialization;

    @Column(nullable = false)
    private Integer experience;

    @Column(name = "consultation_fee", nullable = false)
    private Double consultationFee;

    @Column(name = "available_days", nullable = false)
    private String availableDays;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public Integer getExperience() { return experience; }
    public void setExperience(Integer experience) { this.experience = experience; }

    public Double getConsultationFee() { return consultationFee; }
    public void setConsultationFee(Double consultationFee) { this.consultationFee = consultationFee; }

    public String getAvailableDays() { return availableDays; }
    public void setAvailableDays(String availableDays) { this.availableDays = availableDays; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
