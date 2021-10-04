package com.argendev.markcare.controllers;

import com.argendev.markcare.dtos.AppointmentDTO;
import com.argendev.markcare.exceptions.AppointmentException;
import com.argendev.markcare.models.Appointment;
import com.argendev.markcare.services.interfaces.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointment")
@CrossOrigin(origins = "*")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/save")
    public ResponseEntity<AppointmentDTO> createAppointment(@RequestBody Appointment appointment) {
        try {
            return new ResponseEntity<>(appointmentService.save(appointment), HttpStatus.OK);
        } catch (Exception e) {
            throw new AppointmentException("CREATE appointment failed: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Appointment> deleteAppointment(@PathVariable Long id) {
        try {
            appointmentService.deleteById(id);
        } catch (Exception e) {
            throw new AppointmentException("DELETE appointment " + id + " failed: " + e.getMessage());
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<List<AppointmentDTO>> listAppointmentsByUserId(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(appointmentService.getAllAppointmentsByCustomerId(id), HttpStatus.OK);
        } catch (Exception e) {
            throw new AppointmentException("GET appointment list by user with id " + id + " failed: " + e.getMessage());
        }
    }
}
