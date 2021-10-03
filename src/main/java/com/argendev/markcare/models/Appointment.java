package com.argendev.markcare.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "branch_office_id")
    private BranchOffice branchOffice;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateAppointment;

    @JoinTable(name = "status", joinColumns = @JoinColumn(name = "appointmentId"))
    @Column(name = "state", nullable = false)
    private State status = State.PENDING;
}
