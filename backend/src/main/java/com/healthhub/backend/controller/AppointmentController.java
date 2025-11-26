package com.healthhub.backend.controller;

import com.healthhub.backend.entity.Appointment;
import com.healthhub.backend.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin(origins = "http://localhost:5173")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<Appointment> bookAppointment(@RequestBody Appointment appointment) {
        return ResponseEntity.ok(appointmentService.bookAppointment(appointment));
    }

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/patient/{patientId}")
    public List<Appointment> getAppointmentsByPatient(@PathVariable Long patientId) {
        return appointmentService.getAppointmentsByPatient(patientId);
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<Appointment> cancelAppointment(@PathVariable Long id) {
        return ResponseEntity.ok(appointmentService.cancelAppointment(id));
    }
}
