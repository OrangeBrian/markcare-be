package com.argendev.markcare.dtos;

import com.argendev.markcare.models.State;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class AppointmentDTO {

    private long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateAppointment;

    private BranchOfficeDTO branchOffice;
    private List<State> status;
}
