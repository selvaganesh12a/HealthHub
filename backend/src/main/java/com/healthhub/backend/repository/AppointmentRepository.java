package com.healthhub.backend.repository;

import com.healthhub.backend.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByPatientId(Long patientId);

    boolean existsByDoctorIdAndAppointmentDateAndAppointmentTimeAndStatus(
            Long doctorId, LocalDate appointmentDate, LocalTime appointmentTime, Appointment.Status status);
}
