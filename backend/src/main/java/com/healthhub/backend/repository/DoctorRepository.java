package com.healthhub.backend.repository;

import com.healthhub.backend.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
