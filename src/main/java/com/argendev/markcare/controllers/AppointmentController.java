package com.argendev.markcare.controllers;

import com.argendev.markcare.dtos.AppointmentDTO;
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
        return new ResponseEntity<>(appointmentService.save(appointment), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Appointment> deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<List<AppointmentDTO>> listAppointmentsByUserId(@PathVariable Long id) {
        return new ResponseEntity<>(appointmentService.getAllAppointmentsByCustomerId(id), HttpStatus.OK);
    }

}
