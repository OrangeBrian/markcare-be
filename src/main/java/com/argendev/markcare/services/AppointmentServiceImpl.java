package com.argendev.markcare.services;

import com.argendev.markcare.dtos.AppointmentDTO;
import com.argendev.markcare.models.Appointment;
import com.argendev.markcare.repositories.AppointmentRepository;
import com.argendev.markcare.services.interfaces.AppointmentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final ModelMapper mapper;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, ModelMapper mapper) {
        this.appointmentRepository = appointmentRepository;
        this.mapper = mapper;
    }

    @Override
    public AppointmentDTO save(Appointment appointment) {
        return mapper.map(appointmentRepository.save(appointment), AppointmentDTO.class);
    }

    @Override
    public void deleteById(Long id) {
        appointmentRepository.deleteById(id);
    }

    @Override
    public List<AppointmentDTO> getAllAppointmentsByCustomerId(Long id) {
        List<Appointment> appointments = appointmentRepository.findAllByCustomerId(id);
        List<AppointmentDTO> appointmentDTOS = new ArrayList<>();
        for (Appointment appointment : appointments) {
            appointmentDTOS.add(mapper.map(appointment, AppointmentDTO.class));
        }
        return appointmentDTOS;
    }

}
