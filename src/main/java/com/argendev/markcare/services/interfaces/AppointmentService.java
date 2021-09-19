package com.argendev.markcare.services.interfaces;

import com.argendev.markcare.dtos.AppointmentDTO;
import com.argendev.markcare.models.Appointment;

import java.util.List;

public interface AppointmentService {
    AppointmentDTO save(Appointment appointment);
    void deleteById(Long id);
    List<AppointmentDTO> getAllAppointmentsByCustomerId(Long id);
}
