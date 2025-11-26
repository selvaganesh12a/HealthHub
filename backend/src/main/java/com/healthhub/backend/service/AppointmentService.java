package com.healthhub.backend.service;

import com.healthhub.backend.entity.Appointment;
import com.healthhub.backend.entity.Doctor;
import com.healthhub.backend.entity.User;
import com.healthhub.backend.exception.AppointmentConflictException;
import com.healthhub.backend.repository.AppointmentRepository;
import com.healthhub.backend.repository.DoctorRepository;
import com.healthhub.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private UserRepository userRepository;

    public Appointment bookAppointment(Appointment appointment) {
        // Validate Doctor
        Doctor doctor = doctorRepository.findById(appointment.getDoctor().getId())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
        appointment.setDoctor(doctor);

        // Validate Patient
        User patient = userRepository.findById(appointment.getPatient().getId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        appointment.setPatient(patient);

        // Check for conflict
        if (appointmentRepository.existsByDoctorIdAndAppointmentDateAndAppointmentTimeAndStatus(
                doctor.getId(), appointment.getAppointmentDate(), appointment.getAppointmentTime(),
                Appointment.Status.BOOKED)) {
            throw new AppointmentConflictException("Doctor is already booked at this time.");
        }

        appointment.setStatus(Appointment.Status.BOOKED);
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAppointmentsByPatient(Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment cancelAppointment(Long id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
        appointment.setStatus(Appointment.Status.CANCELLED);
        return appointmentRepository.save(appointment);
    }
}
