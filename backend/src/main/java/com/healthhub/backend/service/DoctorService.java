package com.healthhub.backend.service;

import com.healthhub.backend.entity.Doctor;
import com.healthhub.backend.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctor(Long id, Doctor doctorDetails) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        doctor.setName(doctorDetails.getName());
        doctor.setSpecialization(doctorDetails.getSpecialization());
        doctor.setExperience(doctorDetails.getExperience());
        doctor.setConsultationFee(doctorDetails.getConsultationFee());
        doctor.setAvailableDays(doctorDetails.getAvailableDays());

        return doctorRepository.save(doctor);
    }

    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
}
